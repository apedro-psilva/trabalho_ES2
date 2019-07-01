package gestor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import packageRepositorios.RepositorioDados;
import packageRepositorios.RepositorioUtentes;
import packageUtente.DadosFisicos;
import packageUtente.Utente;
import packageHabitosAlimentares.*;
import packageQuestionario.Questionario;
import exceptions.*;

public class Leitor {
	private File f = null;
	private BufferedReader buff = null;
	private static Leitor instance = null;
	Scanner input = new Scanner(System.in);

	public Leitor() {}

	public Leitor iniLeitor() {
		if(instance == null) {
			instance = new Leitor();
		}
		return instance;
	}

	public String tabelaNutricional(String tabelaNutricional) throws IOException {
		String linha = null;
		
		try {
			System.out.println("A ler " + tabelaNutricional);
			f = new File(tabelaNutricional);
			RepositorioDados rep = new RepositorioDados();
			rep.iniRepositorioDados();

			buff = new BufferedReader(new FileReader(f));

			while((linha = buff.readLine())!= null) {
				int ignora = 0;
				ArrayList<String> l = new ArrayList<String>();

				for(String c: linha.split("\t")) {
					if(c.equals("") || c.length() == 0) {
						ignora = 1;
						break;
					}
					else
						l.add(c);
				}
				if(ignora == 0) 
					rep.setLinhaTabela(l);
					
			}
			buff.close();
			return "Tabela Nutricional Carregada com Sucesso";
		}
		catch (FileNotFoundException e) {
			return "O ficheiro que tentou abrir não existe";
		}
		catch (NullPointerException e) {
			return "Não foi fornecido nenhum ficheiro";
		}
		catch (IOException e) {
			return "Erro a ler o ficheiro";
		}
	}

	public String lePasta(String pasta) throws IOException, EmptyFolderException, MissingFilesException {
		String fileQ = null, fileHA = null, fileDF = null, filePP = null;
		System.out.println("A ler pasta " + pasta);

		try {
			File folder = new File(pasta);
			File[] list = folder.listFiles();
			if(list.length > 0) {
				// Verifica se os ficheiro necessario estao presentes na pasta
				for(int i = 0; i < list.length; i++) {

					if(list[i].getName().split("_")[0].equals("DF")) 
						fileDF = list[i].getName();

					if(list[i].getName().split("_")[0].equals("HA"))
						fileHA = list[i].getName();

					if(list[i].getName().split("_")[0].equals("Q")) 
						fileQ = list[i].getName();	

					if(list[i].getName().split("_")[0].equals("PP"))
						filePP = list[i].getName();
				}
				
				if(fileQ != null && fileHA != null && fileDF != null && filePP != null) {
					if(leQuestionario("src/Inputs/" + fileQ))
						if(leDadosFisicos("src/Inputs/" + fileDF))
							if(leHabitoAlimentar("src/Inputs/" + fileHA))
								if(leHabitoAlimentar("src/Inputs/" + filePP))
									fileQ = null; fileHA = null; fileDF = null; filePP = null;
									
				} else 
					throw new MissingFilesException(fileQ, fileHA, fileDF, filePP);
				
				return "Ficheiros CSV carregados com sucesso da diretoria.";
			}
			else {
				throw new EmptyFolderException();
			}
		}
		catch (EmptyFolderException e) {
			return e.mensagem;
		}
		catch (MissingFilesException e) {
			return e.mensagem;
		}
		catch (NullPointerException e) {
			System.out.println("Não foi fornecido nenhuma diretoria: " + e);
			return "Não foi fornecida diretoria/diretoria não existe";
		}
		catch (IOException e) {
			System.out.println("Erro a ler a diretoria: " + e);
			return "Erro a ler a diretoria";
		}
	}

	public boolean leHabitoAlimentar(String fileName) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		HabitosAlimentares ha = new HabitosAlimentares();
		String linha = null;
		String hora = null;
		String data = null;
		Produto p = null;
		Refeicao r = null;
		ArrayList<Refeicao> refeicoes = new ArrayList<Refeicao>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();

		RepositorioUtentes repU = new RepositorioUtentes();
		repU.iniRepositorioUtentes();

		Utente u = new Utente();

		try {
			System.out.println("A ler o ficheiro " + fileName + " ...");
			f = new File(fileName);
			u = repU.checkUtenteID(Integer.parseInt(fileName.split("_")[1]));

			data = fileName.split("_")[2] + "/" + fileName.split("_")[3] + "/" + fileName.split("_")[4];

			String ref = null;
			String horaRef = null;

			buff = new BufferedReader(new FileReader(f));

			while((linha = buff.readLine())!= null) {				
				String[] campo = linha.split(",");

				if(campo.length != 0) {
					if(campo[0].equals("Levantar"))
						hora = campo[1];

					if(!campo[0].equals("Levantar") && !campo[0].equals("") && !campo[0].equals("Descrição")){
						if(!produtos.isEmpty()) {
							r = new Refeicao();
							if(r.novaRefeicao(ref, horaRef, produtos).equals("Sucesso a criar refeição")) {
								refeicoes.add(r);
								produtos.clear();
							} else {
								System.out.println(r.novaRefeicao(ref, horaRef, produtos));
							}

						}
						ref = campo[0];
						horaRef = campo[1];
					}

					try {
						if(!campo[2].equals("Código") && !campo[2].equals("")) {
							p = new Produto();
							if(p.novoProduto(campo[2], campo[3], campo[4]).equals("Sucesso a criar produto"))
								produtos.add(p);
							else {
								System.out.println(p.novoProduto(campo[2], campo[3], campo[4]));
							}

						}
					} catch(IndexOutOfBoundsException e) {}
				}	
			}

			if(!produtos.isEmpty()) {
				r = new Refeicao();
				if(r.novaRefeicao(ref, horaRef, produtos).equals("Sucesso a criar refeição")) {
					refeicoes.add(r);
					produtos.clear();
				} else 
					System.out.println(r.novaRefeicao(ref, horaRef, produtos));

			}
			buff.close();
		}
		
		catch (FileNotFoundException e) {
			System.out.println("O ficheiro que tentou abrir não existe: " + e);
			return false;
		}
		catch (NullPointerException e) {
			System.out.println("Não foi fornecido nenhum ficheiro de Habito Alimentar: " + e);
			return false;
		}
		catch (IOException e) {
			System.out.println("Erro a ler o ficheiro: " + e);
			return false;
		}

		if(ha.novoHabitoAlimentar(u, data, hora, refeicoes).equals("Sucesso a criar o Habito Alimentar")) {
			if(fileName.split("/")[2].split("_")[0].equals("PP")) 
				rep.setPlanoPrescrito(ha);

			else if(fileName.split("/")[2].split("_")[0].equals("HA")) 
				rep.setHabitoAlimentar(ha);

		} else {
			System.out.println(ha.novoHabitoAlimentar(u, data, hora, refeicoes));
			return false;
		}
		if(fileName.split("/")[2].split("_")[0].equals("PP"))
			System.out.println("Sucesso a ler Plano Prescrito\n");
		else if(fileName.split("/")[2].split("_")[0].equals("HA")) 
			System.out.println("Sucesso a ler Habitos Alimentares\n");
		
		return true;
	}

	public boolean leQuestionario(String fileName) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		Questionario q = new Questionario();
		String linha = null;
		ArrayList<String> valores = new ArrayList<String>();

		RepositorioUtentes repU = new RepositorioUtentes();
		repU.iniRepositorioUtentes();

		HashMap<String, String> dados = new HashMap<String, String>();
		try {	
			f = new File(fileName);
			System.out.println("A ler o ficheiro " + fileName + " ...");

			buff = new BufferedReader(new FileReader(f));
			String[] d = {"Colesterol","Glicémia","Ureia","Creatinina","Prob. C reativa"};
			int skip = 0;

			while((linha = buff.readLine())!= null) {
				skip = 0;
				for(String s: d) {
					if(linha.split(",")[0].equals(s)) {
						skip = 1;
						dados.put(s, linha.split(",")[1]);
					}
				}
				if(skip == 0) 
					valores.add(linha.split(",")[1]);
			}			
			buff.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("O ficheiro que tentou abrir não existe: " + e);
			buff.close();
		}
		catch (IOException e) {
			System.out.println("Erro a ler o ficheiro: " + e);
			buff.close();
		}

		if(q.novoQuestionario(Integer.parseInt(fileName.split("_")[1]), valores.get(0), valores.get(1), valores.get(2), valores.get(3), valores.get(4), valores.get(5), valores.get(6), valores.get(7), valores.get(8), valores.get(9), valores.get(10), valores.get(11), dados).equals("Sucesso a carregar o Questionário")){
			Utente u = new Utente();
			if(!u.novoUtente(Integer.parseInt(fileName.split("_")[1]), q.getNome(), q.getSexo(), Integer.parseInt(q.getIdade()), q.getProfissao()).equals("Sucesso a criar o Utente")) {
				System.out.println(u.novoUtente(Integer.parseInt(fileName.split("_")[1]), q.getNome(), q.getSexo(), Integer.parseInt(q.getIdade()), q.getProfissao()));
				return false;
			}

		} else {
			System.out.println(q.novoQuestionario(Integer.parseInt(fileName.split("_")[1]), valores.get(0), valores.get(1), valores.get(2), valores.get(3), valores.get(4), valores.get(5), valores.get(6), valores.get(7), valores.get(8), valores.get(9), valores.get(10), valores.get(11), dados));
			return false;
		}

		rep.setQuestionario(q);
		System.out.println("Sucesso a ler Questionario\n");
		return true;
	}

	public boolean leDadosFisicos(String fileName) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		DadosFisicos df = new DadosFisicos();

		String linha = null;
		ArrayList<String> valores = new ArrayList<String>();

		RepositorioUtentes repU = new RepositorioUtentes();
		repU.iniRepositorioUtentes();

		try {	
			System.out.println("A ler o ficheiro " + fileName + " ...");

			f = new File(fileName);

			buff = new BufferedReader(new FileReader(f));

			while((linha = buff.readLine())!= null) { 
				valores.add(linha.split(",")[1]);
			}			
			buff.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("O ficheiro que tentou abrir não existe: " + e);
			buff.close();
		}
		catch (IOException e) {
			System.out.println("Erro a ler o ficheiro: " + e);
			buff.close();
		}

		if(!df.novoDadosFisicos(valores.get(0), valores.get(1), valores.get(2), valores.get(3), valores.get(4), valores.get(5), valores.get(6), valores.get(7), valores.get(8), valores.get(9), valores.get(10), valores.get(11), valores.get(12)).equals("Sucesso a carregar os Dados Fisicos")) {
			System.out.println(df.novoDadosFisicos(valores.get(0), valores.get(1), valores.get(2), valores.get(3), valores.get(4), valores.get(5), valores.get(6), valores.get(7), valores.get(8), valores.get(9), valores.get(10), valores.get(11), valores.get(12)) + "\n");
			return false;
		}

		rep.setDadosFisicos(Integer.parseInt(fileName.split("_")[1]), df);
		System.out.println("Sucesso a ler Dados Fisicos\n");
		return true;
	}
}
