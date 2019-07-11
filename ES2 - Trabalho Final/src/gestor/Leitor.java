package gestor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

	private Leitor() {}

	public static Leitor iniLeitor() {
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
			RepositorioDados rep = RepositorioDados.iniRepositorioDados();

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
			return "O ficheiro que tentou abrir n�o existe";
		}
		catch (NullPointerException e) {
			return "N�o foi fornecido nenhum ficheiro";
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
					if(leQuestionario(pasta+"/"+fileQ).equals("Sucesso a ler Questionario"))
						if(leDadosFisicos(pasta+"/"+fileDF).equals("Sucesso a ler Dados F�sicos"))
							if(leHabitoAlimentar(pasta+"/"+fileHA).equals("Sucesso a ler Habitos Alimentares"))
								if(leHabitoAlimentar(pasta+"/"+filePP).equals("Sucesso a ler Plano Prescrito"))
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
			System.out.println("N�o foi fornecido nenhuma diretoria: " + e);
			return "N�o foi fornecida diretoria/diretoria n�o existe";
		}
		catch (IOException e) {
			System.out.println("Erro a ler a diretoria: " + e);
			return "Erro a ler a diretoria";
		}
	}

	public String leHabitoAlimentar(String fileName) throws IOException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		
		HabitosAlimentares ha = new HabitosAlimentares();
		String linha = null;
		String hora = null;
		String data = null;
		Produto p = null;
		Refeicao r = null;
		ArrayList<Refeicao> refeicoes = new ArrayList<Refeicao>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<String> header = new ArrayList<String>(Arrays.asList("Levantar","Pequeno Almoco","Meio da Manha","Almoco","Meio da Tarde","Jantar","Ceia"));
		ArrayList<String> headertemp = (ArrayList<String>) header.clone();	
		

		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();

		Utente u = new Utente();

		try {
			System.out.println("A ler o ficheiro " + fileName + " ...");
			f = new File(fileName);
			u = repU.checkUtenteID(Integer.parseInt(fileName.split("_")[5]));

			data = fileName.split("_")[6] + "/" + fileName.split("_")[7] + "/" + fileName.split("_")[8];

			String ref = null;
			String horaRef = null;

			buff = new BufferedReader(new FileReader(f));

			while((linha = buff.readLine())!= null) {				
				String[] campo = linha.split(",");

				if(campo.length != 0) {
					if(campo[0].equals("Levantar"))
						hora = campo[1];
					
					if(!campo[0].equals("Levantar") && !campo[0].equals("") && !campo[0].equals("Descri��o")){
						if(!produtos.isEmpty()) {
							r = new Refeicao();
							if(r.novaRefeicao(ref, horaRef, produtos).equals("Sucesso a criar refei��o")) {
								refeicoes.add(r);
								produtos.clear();
							} else {
								return r.novaRefeicao(ref, horaRef, produtos);
							}

						}
						if(headertemp.contains(campo[0]))
						{
							ref = campo[0];
							if(campo[0].equals("Pequeno Almoco") || campo[0].equals("Levantar") || campo[0].equals("Almoco") || campo[0].equals("Jantar"))
								headertemp.remove(campo[0]);
						}
						else
						{
							return "Refei��o " + campo[0] + " inv�lida";
						}
							
						horaRef = campo[1];
					}

					try {
						if(!campo[2].equals("C�digo") && !campo[2].equals("")) {
							p = new Produto();
							if(p.novoProduto(campo[2], campo[3], campo[4]).equals("Sucesso a criar produto"))
								produtos.add(p);
							else {
								return p.novoProduto(campo[2], campo[3], campo[4]);
							}

						}
					} catch(IndexOutOfBoundsException e) {}
				}	
			}

			if(!produtos.isEmpty()) {
				r = new Refeicao();
				if(r.novaRefeicao(ref, horaRef, produtos).equals("Sucesso a criar refei��o")) {
					refeicoes.add(r);
					produtos.clear();
				} else 
					return r.novaRefeicao(ref, horaRef, produtos);

			}
			buff.close();
		}
		
		catch (FileNotFoundException e) {
			return "O ficheiro que tentou abrir n�o existe: " + e;
		}
		catch (NullPointerException e) {
			return "N�o foi fornecido nenhum ficheiro de Habito Alimentar: " + e;
		}
		catch (IOException e) {
			return "Erro a ler o ficheiro: " + e;
		}

		if(ha.novoHabitoAlimentar(u, data, hora, refeicoes).equals("Sucesso a criar o Habito Alimentar")) {
			if(fileName.split("/")[2].split("_")[0].equals("PP")) 
				rep.setPlanoPrescrito(ha);

			else if(fileName.split("/")[2].split("_")[0].equals("HA")) 
				rep.setHabitoAlimentar(ha);

		} else {
			return ha.novoHabitoAlimentar(u, data, hora, refeicoes);
		}
		if(fileName.split("/")[2].split("_")[0].equals("PP"))
			return "Sucesso a ler Plano Prescrito\n";
		else //if(fileName.split("/")[2].split("_")[0].equals("HA")) 
			return "Sucesso a ler Habitos Alimentares";
		//return "Sucesso";
	}

	public String leQuestionario(String fileName) throws IOException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		HashMap<String, String> dados = new HashMap<String,String>();
		ArrayList<String> header = new ArrayList<String>(Arrays.asList("Nome","Sexo","Idade","Profiss�o","Motivo da Consulta","Objectivo","Patologias","Medica��o","Antecedentes Familiares","Atividade Fisica","Fun��o Intestinal","Consumo de �gua","Colesterol","Glic�mia","Ureia","Creatinina","Prob. C reativa"));
		ArrayList<String> headertemp = (ArrayList<String>) header.clone();	
		

		Questionario q = new Questionario();
		

		String linha = null;

		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();

		try {	
			f = new File(fileName);
			System.out.println("A ler o ficheiro " + fileName + " ...");

			buff = new BufferedReader(new FileReader(f));
			int x =0;
			
			while((linha = buff.readLine())!= null) {
				if(linha.split(",").length != 2)
					return "Numero de parametros invalido para a linha : "+linha;
				else
				{
					if(linha.split(",")[0].length()==0)
						return "Nome do Campo \"" + header.get(x) + "\" vazio";
					
					if(headertemp.contains(linha.split(",")[0]))
					{
						dados.put(linha.split(",")[0], linha.split(",")[1]);
						headertemp.remove(linha.split(",")[0]);
					}
					else
					{
						return "Nome do Campo \"" + header.get(x) + "\" invalido";
					}
				}
				
				x++;	
			}
			buff.close();
		}
		catch (FileNotFoundException e) {
			
			return "O ficheiro que tentou abrir n�o existe: " + e;
		}
		catch (IOException e) {
			
			return "Erro a ler o ficheiro: " + e;
		}

		if(q.novoQuestionario(Integer.parseInt(fileName.split("_")[5]), dados).equals("Sucesso a carregar o Question�rio"))
		{
			Utente u = new Utente();
			if(!u.novoUtente(Integer.parseInt(fileName.split("_")[5]), q.getNome(), q.getSexo(), Integer.parseInt(q.getIdade()), q.getProfissao()).equals("Sucesso a criar o Utente")) {
				
				return u.novoUtente(Integer.parseInt(fileName.split("_")[5]), q.getNome(), q.getSexo(), Integer.parseInt(q.getIdade()), q.getProfissao());
			}

		} else {
 			return q.novoQuestionario(Integer.parseInt(fileName.split("_")[5]),dados);
			
		}

		rep.setQuestionario(q);
		return "Sucesso a ler Questionario";
		
	}

	public String leDadosFisicos(String fileName) throws IOException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();

		DadosFisicos df = new DadosFisicos();

		String linha = null;
		HashMap<String, String> dados = new HashMap<String,String>();
		ArrayList<String> header = new ArrayList<String>(Arrays.asList("Peso","Altura","IMC","B.F","Gordura visceral","Musculo","H2O","Osso","Idade Metabolica","Metabolismo Basal","Fator Atividade","Fator Les�o","Fator T�rmico"));
		ArrayList<String> headertemp = (ArrayList<String>) header.clone();	
		
		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();

		try {	
			System.out.println("A ler o ficheiro " + fileName + " ...");

			f = new File(fileName);

			buff = new BufferedReader(new FileReader(f));
			int x = 0;
			while((linha = buff.readLine())!= null) {
				if(linha.split(",").length != 2)
					return linha.split(",")[0] + " vazio";
				else
				{
					if(linha.split(",")[0].length()==0)
						return "Nome do Campo \"" + header.get(x) + "\" vazio";
					
					if(headertemp.contains(linha.split(",")[0]))
					{
						dados.put(linha.split(",")[0], linha.split(",")[1]);
						headertemp.remove(linha.split(",")[0]);
					}
					else
					{
						return "Nome do Campo \"" + header.get(x) + "\" invalido";
					}
				}
				
				x++;	
			}		
			buff.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("O ficheiro que tentou abrir n�o existe: " + e);
			buff.close();
		}
		catch (IOException e) {
			System.out.println("Erro a ler o ficheiro: " + e);
			buff.close();
		}

		if(df.novoDadosFisicos(dados).equals("Sucesso a carregar dados f�sicos"))
		{
			rep.setDadosFisicos(Integer.parseInt(fileName.split("_")[5]), df);
			return "Sucesso a ler Dados F�sicos";
		}
		else
			return df.novoDadosFisicos(dados);
	}
}
