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
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		
		if(rep.getHeader().isEmpty())
			assertEquals("Header guardado", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("Código","PRODUTO","Energia (kcal)","Energia (kJ)","Água (g)","Proteína (g)","Gordura total (g)","Total HC disponíveis (g)","Total HC expresso em monossacáridos (g)","Mono + dissacáridos (g)","Ácidos orgânicos (g)","Álcool (g)","Amido (g)","Oligossacáridos (g)","Fibra alimentar (g)","Ácidos gordos saturados (g)","Ácidos gordos monoinsaturados (g)","Ácidos gordos polinsaturados  (g)","Ácidos gordos trans (g)","Ácido linoleico (g)","Colesterol (mg)","Retinol (vit. A total) (mg)","Vit A total (equivalentes retinol) (mg)","Caroteno (mg)","vit. D (µg)","a-tocoferol (mg)","Tiamina (mg)","Riboflavina (mg)","Equivalentes de niacina (mg)","Niacina (mg)","Triptofano/60 (mg)","vit B6 (mg)","Vit. B12 (µg)","vit. C (mg)","Folatos (µg)","Cinza (g)","Na (mg)","K    (mg)","Ca (mg)","P (mg)","Mg (mg)","Fe (mg)","Zn (mg)"))));
		
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
		Leitor l = Leitor.iniLeitor();
		assertEquals("Tabela Nutricional Carregada com Sucesso", l.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt"));
	}
	
	@Test
	public void testeTabelaNutricionalNull() throws IOException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Não foi fornecido nenhum ficheiro", l.tabelaNutricional(null));
	}
	
	@Test
	public void testeTabelaNutricionalFicheiroInexistente() throws IOException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("O ficheiro que tentou abrir não existe", l.tabelaNutricional("src/Auxiliares/NaoExiste.txt"));
	}
	
	// testes aos valores de cada linha
	@Test
	public void testeGuardarLinhaTabelaNutricionalHeaderValida(){
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		
		assertEquals("Header guardado", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("Código","PRODUTO","Energia (kcal)","Energia (kJ)","Água (g)","Proteína (g)","Gordura total (g)","Total HC disponíveis (g)","Total HC expresso em monossacáridos (g)","Mono + dissacáridos (g)","Ácidos orgânicos (g)","Álcool (g)","Amido (g)","Oligossacáridos (g)","Fibra alimentar (g)","Ácidos gordos saturados (g)","Ácidos gordos monoinsaturados (g)","Ácidos gordos polinsaturados  (g)","Ácidos gordos trans (g)","Ácido linoleico (g)","Colesterol (mg)","Retinol (vit. A total) (mg)","Vit A total (equivalentes retinol) (mg)","Caroteno (mg)","vit. D (µg)","a-tocoferol (mg)","Tiamina (mg)","Riboflavina (mg)","Equivalentes de niacina (mg)","Niacina (mg)","Triptofano/60 (mg)","vit B6 (mg)","Vit. B12 (µg)","vit. C (mg)","Folatos (µg)","Cinza (g)","Na (mg)","K    (mg)","Ca (mg)","P (mg)","Mg (mg)","Fe (mg)","Zn (mg)"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalValida(){
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS033","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalNull(){
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Linha null", rep.setLinhaTabela(null));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalVazia(){
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Linha vazia", rep.setLinhaTabela(new ArrayList<String>()));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoVazio() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoInvalido() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código não contem IS", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("NJ122","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoValidoInferior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS001","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoValidoSuperior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS999","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalCodigoInvalidoInferior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS000","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalCodigoInvalidoSuperior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Código acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS1000","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalNCamposInvalidaInferior(){
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Numero de campos abaixo do valor válido", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS1000","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	@Test
	public void testeGuardarLinhaTabelaNutricionalNCamposInvalidaSuperior(){
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();

		assertEquals("Numero de campos acima do valor válido", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("teste","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
	}
	
	 //----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testeGuardarLinhaTabelaNutricionalZnNull() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Zn (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3",""))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalZnValidoInferior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0"))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalZnValidoSuperior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000"))));
	}

	@Test 
	public void testeGuardarLinhaTabelaNutricionalZnInvalidoInferior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Zn (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1"))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalZnInvalidoSuperior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Zn (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001"))));
	}
	
	 //----------------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------------------
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalFeNull() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Fe (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3"))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalFeValidoInferior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3"))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalFeValidoSuperior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3"))));
	}

	@Test 
	public void testeGuardarLinhaTabelaNutricionalFeInvalidoInferior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Fe (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3"))));
	}
	
	@Test 
	public void testeGuardarLinhaTabelaNutricionalFeInvalidoSuperior() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		assertEquals("Fe (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3"))));
	}
	

	 //----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalMgNull() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Mg (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalMgValidoInferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalMgValidoSuperior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalMgInvalidoInferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Mg (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalMgInvalidoSuperior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Mg (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalPNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("P (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalPValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalPValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalPInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("P (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalPInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("P (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalCaNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ca (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCaValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCaValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCaInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ca (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCaInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ca (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalKNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("K    (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalKValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalKValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalKInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("K    (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalKInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("K    (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalNaNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Na (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNaValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNaValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNaInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Na (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNaInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Na (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalCinzaNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Cinza (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCinzaValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCinzaValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCinzaInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Cinza (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCinzaInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Cinza (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3"))));
}



//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalFolatosNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Folatos (µg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalFolatosValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalFolatosValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalFolatosInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Folatos (µg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalFolatosInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Folatos (µg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalvitCNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit. C (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalvitCValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalvitCValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalvitCInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit. C (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalvitCInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit. C (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB12Null() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Vit. B12 (µg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB12ValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB12ValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB12InvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Vit. B12 (µg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB12InvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Vit. B12 (µg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB6Null() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit B6 (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB6ValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB6ValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB6InvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit B6 (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitB6InvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit B6 (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalTriptofano60Null() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Triptofano/60 (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTriptofano60ValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTriptofano60ValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTriptofano60InvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Triptofano/60 (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTriptofano60InvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Triptofano/60 (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3"))));
}



//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalNiacinaNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Niacina (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNiacinaValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNiacinaValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNiacinaInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Niacina (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalNiacinaInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Niacina (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalEquivalentesNiacinaNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Equivalentes de niacina (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalEquivalentesNiacinaValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalEquivalentesNiacinaValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalEquivalentesNiacinaInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Equivalentes de niacina (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalEquivalentesNiacinaInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Equivalentes de niacina (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalRiboflavinaNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Riboflavina (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRiboflavinaValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRiboflavinaValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRiboflavinaInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Riboflavina (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRiboflavinaInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Riboflavina (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalTiaminaNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Tiamina (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTiaminaValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTiaminaValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTiaminaInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Tiamina (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalTiaminaInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Tiamina (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//------------------------------------ATocoferol----------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalATocoferolNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("a-tocoferol (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalATocoferolValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalATocoferolValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalATocoferolInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("a-tocoferol (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalATocoferolInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("a-tocoferol (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------VitD-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalVitDNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit. D (µg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitDValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitDValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitDInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit. D (µg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitDInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("vit. D (µg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------VitD-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalCarotenoNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Caroteno (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCarotenoValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCarotenoValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCarotenoInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Caroteno (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalCarotenoInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Caroteno (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------VitATotal-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalVitATotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Vit A total (equivalentes retinol) (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitATotalValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitATotalValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitATotalInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Vit A total (equivalentes retinol) (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalVitATotalInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Vit A total (equivalentes retinol) (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------RetinolVitATotal (vit. A total) (mg)-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalRetinolVitATotalTotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Retinol (vit. A total) (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRetinolVitATotalValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRetinolVitATotalValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRetinolVitATotalInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Retinol (vit. A total) (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalRetinolVitATotalInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Retinol (vit. A total) (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------Colesterol (mg)-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalColesterolTotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Colesterol (mg) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalColesterolValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalColesterolValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalColesterolInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Colesterol (mg) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalColesterolInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Colesterol (mg) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------AcidoLinoleico (g)-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidoLinoleicoTotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácido linoleico (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidoLinoleicoValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidoLinoleicoValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidoLinoleicoInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácido linoleico (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidoLinoleicoInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácido linoleico (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------AcidosGordosTrans (g)-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosTransTotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos trans (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosTransValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosTransValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosTransInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos trans (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosTransInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos trans (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//---------------------------------------------AcidosGordosPolinsaturados (g)-------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosPolinsaturadosTotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos polinsaturados  (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosPolinsaturadosValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosPolinsaturadosValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosPolinsaturadosInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos polinsaturados  (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosPolinsaturadosInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos polinsaturados  (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//----------------------------------------AcidosGordosMonoinsaturados (g)------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosMonoinsaturadosTotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos monoinsaturados (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosMonoinsaturadosValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosMonoinsaturadosValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosMonoinsaturadosInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos monoinsaturados (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosMonoinsaturadosInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos monoinsaturados (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}



//----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
//----------------------------------------AcidosGordosSaturados (g)------------------------------------------------------------------------------

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosSaturadosTotalNull() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos saturados (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosSaturadosValidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","1","3","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosSaturadosValidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosSaturadosInvalidoInferior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos saturados (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void testeGuardarLinhaTabelaNutricionalAcidosGordosSaturadosInvalidoSuperior() {
RepositorioDados rep = RepositorioDados.iniRepositorioDados();
rep.iniRepositorioDados();
assertEquals("Ácidos gordos saturados (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


//------------------------------------------------------------------------------
//---------------------------RICARDO DUARTE-------------------------------------


@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKcal_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Energia (kcal) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKcal_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKcal_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKcal_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Energia (kcal) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKcal_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Energia (kcal) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiakJ_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Energia (kJ) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKJ_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKJ_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKJ_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Energia (kJ) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_EnergiaKJ_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Energia (kJ) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Agua_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Água (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Agua_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Agua_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Agua_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Água (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Agua_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Água (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Proteina_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Proteína (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Proteina_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Proteina_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Proteina_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Proteína (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Proteina_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Proteína (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Gordura_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Gordura total (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Gordura_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));	
}
@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Gordura_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Gordura_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Gordura total (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Gordura_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Gordura total (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HC_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Total HC disponíveis (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HC_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));	}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HC_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HC_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Total HC disponíveis (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HC_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Total HC disponíveis (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HCM_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Total HC expresso em monossacáridos (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HCM_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));	}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HCM_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HCM_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Total HC expresso em monossacáridos (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_HCM_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Total HC expresso em monossacáridos (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Mono_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Mono + dissacáridos (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Mono_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));	}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Mono_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Mono_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Mono + dissacáridos (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Mono_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Mono + dissacáridos (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Acidos_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Ácidos orgânicos (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Acidos_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));	}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Acidos_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Acidos_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Ácidos orgânicos (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Acidos_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Ácidos orgânicos (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Alcool_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Álcool (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Alcool_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));	}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Alcool_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Alcool_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Álcool (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Alcool_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Álcool (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Amido_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Amido (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Amido_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));		
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Amido_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Amido_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Amido (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Amido_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Amido (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}


@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Oligossacaridos_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Oligossacáridos (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Oligossacaridos_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));		
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Oligossacaridos_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Oligossacaridos_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Oligossacáridos (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Oligossacaridos_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Oligossacáridos (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Fibra_Null() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Fibra alimentar (g) vazio", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Fibra_Valido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","0","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));		
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Fibra_Valido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Linha guardada", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","5000","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Fibra_Invalido_Inferior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Fibra alimentar (g) abaixo dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","-1","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

@Test 
public void teste_Guardar_Linha_Tabela_Nutricional_Fibra_Invalido_Superior() {
	RepositorioDados rep = RepositorioDados.iniRepositorioDados();
	rep.iniRepositorioDados();
	assertEquals("Fibra alimentar (g) acima dos valores válidos", rep.setLinhaTabela(new ArrayList<String>(Arrays.asList("IS102","ola","3","3","3","3","3","3","3","3","3","3","3","3","5001","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3","3"))));
}

}
