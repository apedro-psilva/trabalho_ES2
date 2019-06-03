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

	public boolean tabelaNutricional() throws IOException {
		String linha = null;
		f = new File("src/Auxiliares/tabela_nutricional.txt");
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		try {
			buff = new BufferedReader(new FileReader(f));

			while((linha = buff.readLine())!= null) {
				int ignora = 0;
				ArrayList<String> l = new ArrayList<String>();

				for(String c: linha.split("\t")) {
					if(c.equals("")) {
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
			return true;
		}
		catch (FileNotFoundException e) {
			System.out.println("O ficheiro que tentou abrir não existe: " + e);
			buff.close();
			return false;
		}
		catch (IOException e) {
			System.out.println("Erro a ler o ficheiro: " + e);
			buff.close();
			return false;
		}
	}

	public boolean carregaFicheirosCSV() throws IOException {
		File folder = new File("src/Inputs");
		File[] list = folder.listFiles();
		String fileQ = null, fileHA = null, fileDF = null;
		ArrayList<String> users = new ArrayList<String>();

		if(list.length > 0) {
			for(int i = 0; i < list.length; i++) {
				String user = list[i].getName().split("_")[1];
				if(!users.contains(user)) {
					
					try {		
						// verifica se existem os 3 ficheiros necessarios para correr o programa.
						// caso encontre o habito alimentar primeiro
						if(list[i].getName().split("_")[0].equals("HA") && list[i].getName().split("_")[1].equals(user)) {
							fileHA = list[i].getName();

							for(int j = i +1; j< list.length; j++) {
								if(list[j].getName().split("_")[0].equals("Q") && list[j].getName().split("_")[1].equals(user))
									fileQ = list[j].getName();

								if(list[j].getName().split("_")[0].equals("DF") && list[j].getName().split("_")[1].equals(user))
									fileDF = list[j].getName();
							}

							if(fileQ != null && fileHA != null && fileDF != null) {
								if(!leQuestionario("src/Inputs/" + fileQ))
									return false;
								if(!leDadosFisicos("src/Inputs/" + fileDF))
									return false;
								if(!leHabitoAlimentar("src/Inputs/" + fileHA))
									return false;

								fileQ = null;
								fileHA = null;
								fileDF = null;
							} else {
								System.out.println("Faltam ficheiros para executar o programa corretamente para o Utente " + list[i].getName().split("_")[1]);
							}
							users.add(list[i].getName().split("_")[1]);
						}
						// caso encontre o questionario primeiro
						else if(list[i].getName().split("_")[0].equals("Q") && list[i].getName().split("_")[1].equals(user)) {
							fileQ = list[i].getName();
							
							for(int j = i+1; j < list.length; j++) {
								if(list[j].getName().split("_")[0].equals("HA") && list[j].getName().split("_")[1].equals(user))
									fileHA = list[j].getName();

								if(list[j].getName().split("_")[0].equals("DF") && list[j].getName().split("_")[1].equals(user))
									fileDF = list[j].getName();
							}

							if(fileQ != null && fileHA != null && fileDF != null) {
								if(!leQuestionario("src/Inputs/" + fileQ))
									return false;
								if(!leDadosFisicos("src/Inputs/" + fileDF))
									return false;
								if(!leHabitoAlimentar("src/Inputs/" + fileHA))
									return false;

								fileQ = null;
								fileHA = null;
								fileDF = null;
							} else {
								System.out.println("Faltam ficheiros para executar o programa corretamente para o Utente " + list[i].getName().split("_")[1]);
							}
							users.add(list[i].getName().split("_")[1]);
						}
						// caso encontre os dados fisicos primeiro
						else if(list[i].getName().split("_")[0].equals("DF") && list[i].getName().split("_")[1].equals(user)) {
							fileDF = list[i].getName();
							
							for(int j = i+1; j < list.length; j++) {
								if(list[j].getName().split("_")[0].equals("HA") && list[j].getName().split("_")[1].equals(user))
									fileHA = list[j].getName();
									
								if(list[j].getName().split("_")[0].equals("Q") && list[j].getName().split("_")[1].equals(user)) 
									fileQ = list[j].getName();									
							}

							if(fileQ != null && fileHA != null && fileDF != null) {
								if(!leQuestionario("src/Inputs/" + fileQ)) 
									return false;
								if(!leDadosFisicos("src/Inputs/" + fileDF))
									return false;
								if(!leHabitoAlimentar("src/Inputs/" + fileHA))
									return false;
								
								fileQ = null;
								fileHA = null;
								fileDF = null;
							} else {
								System.out.println("Faltam ficheiros para executar o programa corretamente para o Utente " + list[i].getName().split("_")[1]);
							}
							users.add(list[i].getName().split("_")[1]);
						}
					}
					catch(Exception e) {
						System.out.println("Erro a carregar: " + e);
					}
				}
			}
			return true;
		}
		else {
			System.out.println("Não há ficheiros na pasta \"src/Inputs\".");
			return false;
		}
	}

	private boolean leHabitoAlimentar(String fileName) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		HabitosAlimentares ha = new HabitosAlimentares();
		f = new File(fileName);
		String linha = null;
		String hora = null;
		Produto p = null;
		Refeicao r = null;
		ArrayList<Refeicao> refeicoes = new ArrayList<Refeicao>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();

		RepositorioUtentes repU = new RepositorioUtentes();
		repU.iniRepositorioUtentes();

		System.out.println("A ler o ficheiro " + fileName + " ...");

		Utente u = new Utente();
		u = repU.checkUtenteID(Integer.parseInt(fileName.split("_")[1]));

		try {
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
							r.novaRefeicao(ref, horaRef, produtos);
							refeicoes.add(r);
							produtos.clear();
						}
						ref = campo[0];
						horaRef = campo[1];
					}

					try {
						if(!campo[2].equals("Código") && !campo[2].equals("")) {
							p = new Produto();
							p.novoProduto(campo[2], campo[3], campo[4]);
							produtos.add(p);
						}
					} catch(IndexOutOfBoundsException e) {}
				}	
			}

			if(!produtos.isEmpty()) {
				r = new Refeicao();
				r.novaRefeicao(ref, horaRef, produtos);
				refeicoes.add(r);
				produtos.clear();
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

		if(ha.novoHabitoAlimentar(u, hora, refeicoes).equals("Sucesso a criar o Habito Alimentar")) {
			rep.setHabitoAlimentar(ha);
		} else {
			return false;
		}
		System.out.println("Sucesso a ler Habitos Alimentares\n");
		return true;

	}

	private boolean leQuestionario(String fileName) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		Questionario q = new Questionario();
		f = new File(fileName);
		String linha = null;
		ArrayList<String> valores = new ArrayList<String>();

		RepositorioUtentes repU = new RepositorioUtentes();
		repU.iniRepositorioUtentes();

		System.out.println("A ler o ficheiro " + fileName + " ...");


		HashMap<String, String> dados = new HashMap<String, String>();
		try {				
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

		if(q.novoQuestionario(Integer.parseInt(fileName.split("_")[1]), valores.get(0), valores.get(1), valores.get(2), valores.get(3), valores.get(4), valores.get(5), valores.get(6), valores.get(7), valores.get(8), valores.get(9), valores.get(10), dados).equals("Sucesso")){
			Utente u = new Utente();
			if(!u.novoUtente(Integer.parseInt(fileName.split("_")[1]), q.getNome(), Integer.parseInt(q.getIdade()), q.getProfissao()).equals("Sucesso a criar o Utente"))
				return false;
		} else 
			return false;

		rep.setQuestionario(q);
		System.out.println("Sucesso a ler Questionario\n");
		return true;
	}

	private boolean leDadosFisicos(String fileName) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		DadosFisicos df = new DadosFisicos();
		f = new File(fileName);
		String linha = null;
		ArrayList<String> valores = new ArrayList<String>();

		RepositorioUtentes repU = new RepositorioUtentes();
		repU.iniRepositorioUtentes();

		System.out.println("A ler o ficheiro " + fileName + " ...");

		try {				
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

		if(!df.novoDadosFisicos(valores.get(0), valores.get(1), valores.get(2), valores.get(3), valores.get(4), valores.get(5), valores.get(6), valores.get(7), valores.get(8), valores.get(9)).equals("Sucesso")) {
			return false;
		}
		
		rep.setDadosFisicos(fileName.split("_")[1], df);
		System.out.println("Sucesso a ler Dados Fisicos\n");
		return true;
	}
}
