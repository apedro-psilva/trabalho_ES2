package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.EmptyFolderException;
import exceptions.MissingFilesException;
import gestor.Leitor;

public class TestLerPastaDeInputs {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Leitor l = Leitor.iniLeitor();
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

	@Test
	public void testLerPastaDesInputsValida() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Ficheiros CSV carregados com sucesso da diretoria.", l.lePasta("src/PastasTestesInputs/Inputs_Q_DF_HA_PP"));
	}
	
	@Test
	public void testLerPastaDesInputsNull() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();;
		assertEquals("Não foi fornecida diretoria/diretoria não existe", l.lePasta(null));
	}
	
	@Test
	public void testLerPastaDesInputsNaoExiste() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Não foi fornecida diretoria/diretoria não existe", l.lePasta("src/Nao_Existe"));
	}
	
	
	// white box
	@Test
	public void testLerPastaDesInputs_0_0_0_0() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Não foi fornecida diretoria/diretoria não existe", l.lePasta("src/PastasTestesInputs/Inputs_0_0_0_0"));
	}
	
	@Test
	public void testLerPastaDesInputs_0_0_0_PP() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Questionário Dados Fisicos Hábitos Alimentares não existem", l.lePasta("src/PastasTestesInputs/Inputs_0_0_0_PP"));
	}
	
	@Test
	public void testLerPastaDesInputs_0_0_HA_0() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Questionário Dados Fisicos Plano Prescrito não existem", l.lePasta("src/PastasTestesInputs/Inputs_0_0_HA_0"));
	}
	
	@Test
	public void testLerPastaDesInputs_0_0_HA_PP() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Questionário Dados Fisicos não existem", l.lePasta("src/PastasTestesInputs/Inputs_0_0_HA_PP"));
	}
	
	@Test
	public void testLerPastaDesInputs_0_DF_0_0() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Questionário Hábitos Alimentares Plano Prescrito não existem", l.lePasta("src/PastasTestesInputs/Inputs_0_DF_0_0"));
	}
	
	@Test
	public void testLerPastaDesInputs_0_DF_0_PP() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Questionário Hábitos Alimentares não existem", l.lePasta("src/PastasTestesInputs/Inputs_0_DF_0_PP"));
	}
	
	@Test
	public void testLerPastaDesInputs_0_DF_HA_PP() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Questionário não existe", l.lePasta("src/PastasTestesInputs/Inputs_0_DF_HA_PP"));
	}
	
	@Test
	public void testLerPastaDesInputs_Q_0_0_0() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Dados Fisicos Hábitos Alimentares Plano Prescrito não existem", l.lePasta("src/PastasTestesInputs/Inputs_Q_0_0_0"));
	}
	
	@Test
	public void testLerPastaDesInputs_Q_0_0_PP() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Dados Fisicos Hábitos Alimentares não existem", l.lePasta("src/PastasTestesInputs/Inputs_Q_0_0_PP"));
	}
	
	@Test
	public void testLerPastaDesInputs_Q_0_HA_0() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Dados Fisicos Plano Prescrito não existem", l.lePasta("src/PastasTestesInputs/Inputs_Q_0_HA_0"));
	}
	
	@Test
	public void testLerPastaDesInputs_Q_0_HA_PP() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Dados Fisicos não existe", l.lePasta("src/PastasTestesInputs/Inputs_Q_0_HA_PP"));
	}
	
	@Test
	public void testLerPastaDesInputs_Q_DF_0_0() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Hábitos Alimentares Plano Prescrito não existem", l.lePasta("src/PastasTestesInputs/Inputs_Q_DF_0_0"));
	}
	
	@Test
	public void testLerPastaDesInputs_Q_DF_0_PP() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Hábitos Alimentares não existe", l.lePasta("src/PastasTestesInputs/Inputs_Q_DF_0_PP"));
	}
	
	@Test
	public void testLerPastaDesInputs_Q_DF_HA_0() throws IOException, EmptyFolderException, MissingFilesException {
		Leitor l = Leitor.iniLeitor();
		assertEquals("Plano Prescrito não existe", l.lePasta("src/PastasTestesInputs/Inputs_Q_DF_HA_0"));
	}
	

	
}
