package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestor.Leitor;
import packageRepositorios.RepositorioDados;

public class TestLerECarregarTabelaNutricional {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	// testes ao ficheiro
	@Test
	public void testeTabelaNutricionalValido() throws IOException {
		Leitor l = new Leitor();
		assertEquals("Tabela Nutricional Carregada com Sucesso", l.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt"));
	}
	
	@Test
	public void testeTabelaNutricionalNull() throws IOException {
		Leitor l = new Leitor();
		assertEquals("Não foi fornecido nenhum ficheiro", l.tabelaNutricional(null));
	}
	
	@Test
	public void testeTabelaNutricionalFicheiroInexistente() throws IOException {
		Leitor l = new Leitor();
		assertEquals("O ficheiro que tentou abrir não existe", l.tabelaNutricional("src/Auxiliares/NaoExiste.txt"));
	}
	
	// testes aos valores de cada linha
	@Test
	public void testeGuardarLinhaTabelaNutricionalHeaderValida(){
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		
		assertEquals("Header guardado", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("Código","PRODUTO","Energia (kcal)","Energia (kJ)","Água (g)","Proteína (g)","Gordura total (g)","Total HC disponíveis (g)","Total HC expresso em monossacáridos (g)","Mono + dissacáridos (g)","Ácidos orgânicos (g)","Álcool (g)","Amido (g)","Oligossacáridos (g)","Fibra alimentar (g)","Ácidos gordos saturados (g)","Ácidos gordos monoinsaturados (g)","Ácidos gordos polinsaturados  (g)","Ácidos gordos trans (g)","Ácido linoleico (g)","Colesterol (mg)","Retinol (vit. A total) (mg)","Vit A total (equivalentes retinol) (mg)","Caroteno (mg)","vit. D (µg)","a-tocoferol (mg)","Tiamina (mg)","Riboflavina (mg)","Equivalentes de niacina (mg)","Niacina (mg)","Triptofano/60 (mg)","vit B6 (mg)","Vit. B12 (µg)","vit. C (mg)","Folatos (µg)","Cinza (g)","Na (mg)","K    (mg)","Ca (mg)","P (mg)","Mg (mg)","Fe (mg)","Zn (mg)"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalValida(){
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS033","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalNull(){
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Linha null", rep.setLinhaTabela(null));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalVazia(){
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Linha vazia", rep.setLinhaTabela(new ArrayList<String>()));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoVazio() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoInvalido() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código não contem IS", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("NJ122","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoValidoInferior() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS001","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoValidoSuperior() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS999","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoInvalidoInferior() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS000","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalCodigoInvalidoSuperior() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS1000","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalNCamposInvalidaInferior(){
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Numero de campos abaixo do valor válido", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS1000","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalNCamposInvalidaSuperior(){
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Numero de campos acima do valor válido", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("teste","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	
	
	

}
