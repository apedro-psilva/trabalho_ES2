package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.EmptyFolderException;
import exceptions.MissingFilesException;
import gestor.Escritor;
import gestor.Leitor;
import packageRepositorios.RepositorioDados;
import packageRepositorios.RepositorioUtentes;
import packageUtente.Utente;

public class TestOutputs {

	public String confirmaEscrita(String fileName, String header, HashMap<Integer, String[]> dados) {
		try {
			File f2 = new File(fileName);
			System.out.println("\n> A confirmar Output do ficheiro " + fileName);

			BufferedReader buff = new BufferedReader(new FileReader(f2));
			String linha = null; 

			String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
			int x = 0;
			while((linha = buff.readLine())!= null) {
				if(x == 0) {
					if(!linha.equals(header))
						return "Ficheiro Criado não coincide com os dados enviados para escrita";
				}
				else {
					if(dados.get(x-1).length > 1) {
						for(int j = 0; j < dados.get(x-1).length; j++) {
							if(!linha.split(regex, -1)[j].equals(dados.get(x-1)[j]))
								return "Ficheiro Criado não coincide com os dados enviados para escrita";
						}
					} 
					else {
						if(!linha.split(regex, -1)[0].equals(dados.get(x-1)[0]))
							return "Ficheiro Criado não coincide com os dados enviados para escrita";
					}
				}
				x++;
			}
			buff.close();
			return "Sucesso a confirmar a escrita para ficheiro";
		}
		catch (IOException e) {
			return "Erro a ler ficheiro para confirmação dos dados escritos";
		}
		catch (Exception e) {
			return "Ficheiro Criado não coincide com os dados enviados para escrita";
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Leitor l = Leitor.iniLeitor();
		l.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt");
		l.lePasta("src/PastasTestesInputs/Inputs_Q_DF_HA_PP");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// ----------------------- testes do Escritor ------------------------------------------------
	@Test
	public void testEscritorValido() throws IOException{
		Escritor e = Escritor.iniEscritor();
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		HashMap<Integer, String[]> dados = new HashMap<Integer, String[]>();
		Integer i = 0;
		String[] temp = {"teste1", "teste2", "teste3", "teste4"};
		dados.put(i, temp);
		dados.put(i+1, temp);
		dados.put(i+2, temp);
		dados.put(i+3, temp);
		
		Date d = new Date();
		String tipo = "HA";
		int id = 30;
		
		assertEquals("Sucesso a escrever para o ficheiro src/Outputs/"+ tipo +"_" + id + "_" + df.format(d) + ".csv", e.escreveFicheiro(tipo, id, new ArrayList<String>(Arrays.asList("Plano Alimentar Atual")), dados));
	}
	
	@Test
	public void testEscritorTipoVazio() throws IOException{
		Escritor e = Escritor.iniEscritor();
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		HashMap<Integer, String[]> dados = new HashMap<Integer, String[]>();
		Integer i = 0;
		String[] temp = {"teste1", "teste2", "teste3", "teste4"};
		dados.put(i, temp);
		dados.put(i+1, temp);
		dados.put(i+2, temp);
		dados.put(i+3, temp);
		
		Date d = new Date();
		String tipo = "";
		int id = 30;
		
		assertEquals("Tipo vazio", e.escreveFicheiro(tipo, id, new ArrayList<String>(Arrays.asList("Plano Alimentar Atual")), dados));
	}
	
	@Test
	public void testEscritorTipoInvalido() throws IOException{
		Escritor e = Escritor.iniEscritor();
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		HashMap<Integer, String[]> dados = new HashMap<Integer, String[]>();
		Integer i = 0;
		String[] temp = {"teste1", "teste2", "teste3", "teste4"};
		dados.put(i, temp);
		dados.put(i+1, temp);
		dados.put(i+2, temp);
		dados.put(i+3, temp);
		
		Date d = new Date();
		String tipo = "teste";
		int id = 30;
		
		assertEquals("Tipo Inválido", e.escreveFicheiro(tipo, id, new ArrayList<String>(Arrays.asList("Plano Alimentar Atual")), dados));
	}
	
	@Test
	public void testEscritorIdInválido() throws IOException{
		Escritor e = Escritor.iniEscritor();
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		HashMap<Integer, String[]> dados = new HashMap<Integer, String[]>();
		Integer i = 0;
		String[] temp = {"teste1", "teste2", "teste3", "teste4"};
		dados.put(i, temp);
		dados.put(i+1, temp);
		dados.put(i+2, temp);
		dados.put(i+3, temp);
		
		Date d = new Date();
		String tipo = "HA";
		int id = -1;
		
		assertEquals("Id Inválido", e.escreveFicheiro(tipo, id, new ArrayList<String>(Arrays.asList("Plano Alimentar Atual")), dados));
	}
	
	@Test
	public void testEscritorHeaderVazio() throws IOException{
		Escritor e = Escritor.iniEscritor();
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		HashMap<Integer, String[]> dados = new HashMap<Integer, String[]>();
		Integer i = 0;
		String[] temp = {"teste1", "teste2", "teste3", "teste4"};
		dados.put(i, temp);
		dados.put(i+1, temp);
		dados.put(i+2, temp);
		dados.put(i+3, temp);
		
		Date d = new Date();
		String tipo = "HA";
		int id = 30;
		
		assertEquals("Header vazio", e.escreveFicheiro(tipo, id, new ArrayList<String>(), dados));
	}
	
	@Test
	public void testEscritorHeaderInvalido() throws IOException{
		Escritor e = Escritor.iniEscritor();
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		HashMap<Integer, String[]> dados = new HashMap<Integer, String[]>();
		Integer i = 0;
		String[] temp = {"teste1", "teste2", "teste3", "teste4"};
		dados.put(i, temp);
		dados.put(i+1, temp);
		dados.put(i+2, temp);
		dados.put(i+3, temp);
		
		Date d = new Date();
		String tipo = "HA";
		int id = 30;
		
		assertEquals("Header Inválido", e.escreveFicheiro(tipo, id, new ArrayList<String>(Arrays.asList("teste")), dados));
	}
	
	@Test
	public void testEscritorDadosVazios() throws IOException{
		Escritor e = Escritor.iniEscritor();
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		HashMap<Integer, String[]> dados = new HashMap<Integer, String[]>();
		
		Date d = new Date();
		String tipo = "HA";
		int id = 30;
		
		assertEquals("Dados vazios", e.escreveFicheiro(tipo, id, new ArrayList<String>(Arrays.asList("Plano Alimentar Atual")), dados));
	}
	
	
	
	// ----------------------- teste de verificação de output -----------------------------------------------
	@Test
	public void testEscritorHabitoAlimentarValido() throws IOException, EmptyFolderException, MissingFilesException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
		
		String fileNameHA = null;
		HashMap<Integer, String[]> dadosHAOutput = null;
		Escritor esc = Escritor.iniEscritor();
		Utente u = repU.checkUtenteID(2);
		dadosHAOutput = new HashMap<Integer, String[]>();


		fileNameHA = esc.geraDados(0, u.getId(), rep.getHabitosAlimentares(u.getId()), dadosHAOutput).split(" ficheiro ")[1];

		assertEquals("Sucesso a confirmar a escrita para ficheiro", confirmaEscrita(fileNameHA, "Plano Alimentar Atual", dadosHAOutput));
	}
	
	@Test
	public void testEscritorHabitoAlimentarInvalido() throws IOException, EmptyFolderException, MissingFilesException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();

		Escritor esc = Escritor.iniEscritor();
		String fileNameHA = null;
		HashMap<Integer, String[]> dadosHAOutput = null;

		Utente u = repU.checkUtenteID(2);
		dadosHAOutput = new HashMap<Integer, String[]>();


		fileNameHA = esc.geraDados(0, u.getId(), rep.getHabitosAlimentares(u.getId()), dadosHAOutput).split(" ficheiro ")[1];

		Integer x = 3;
		String[] y = {"teste1", "teste2", "teste3"};
		dadosHAOutput.replace(x, y);
		
		assertEquals("Ficheiro Criado não coincide com os dados enviados para escrita", confirmaEscrita(fileNameHA, "Plano Alimentar Atual", dadosHAOutput));
	}
	
	@Test
	public void testEscritorHabitoAlimentarInvalido2() throws IOException, EmptyFolderException, MissingFilesException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
		Escritor esc = Escritor.iniEscritor();

		String fileNameHA = null;
		HashMap<Integer, String[]> dadosHAOutput = null;

		Utente u = repU.checkUtenteID(2);
		dadosHAOutput = new HashMap<Integer, String[]>();


		fileNameHA = esc.geraDados(0, u.getId(), rep.getHabitosAlimentares(u.getId()), dadosHAOutput).split(" ficheiro ")[1];

		Integer x = 3;
		String[] y = {"teste1", "teste2", "teste3"};
		dadosHAOutput.replace(x, y);
		
		assertEquals("Erro a ler ficheiro para confirmação dos dados escritos", confirmaEscrita("teste.csv", "Plano Alimentar Atual", dadosHAOutput));
	}

}
