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
import packageRepositorios.RepositorioDados;
import packageRepositorios.RepositorioUtentes;
import packageUtente.Utente;

public class TestFormulas {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Leitor l = Leitor.iniLeitor();
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
	
	@Test
	public void testGetTMB() throws IOException, EmptyFolderException, MissingFilesException {
		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
		
		System.out.println("TMB");		

		Utente u = repU.checkUtenteID(2);
		
		assertTrue(2420.1 == u.getTMB());
		
	}
	
	@Test
	public void testGetHarrisB() throws IOException, EmptyFolderException, MissingFilesException {
		
		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
		
		System.out.println("HarrisB");
				
		Utente u = repU.checkUtenteID(2);
		
		assertTrue(6292.26 == u.getHarrisBenedict());
		
	}
			
		
		
		
		
}
