package testPackageUtente;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import packageUtente.Utente;

public class TestUtente {

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

	@Test
	public void testSetIdValido() {
		Utente u = new Utente();
		assertTrue(u.setId(2));
	}
	
	@Test
	public void testSetIdInvalido() {
		Utente u = new Utente();
		assertFalse(u.setId(-1));
	}
	
	@Test
	public void testGetIdValido() {
		Utente u = new Utente();
		u.setId(2);
		assertEquals(2, u.getId());
	}
	
	@Test
	public void testGetIdInvalido() {
		Utente u = new Utente();
		u.setId(-1);
		assertEquals(0, u.getId());
	}
	
	@Test
	public void testSetNomeValido() {
		Utente u = new Utente();
		assertTrue(u.setNome("António Silva"));
	}
	
	@Test
	public void testSetNomeInvalido() {
		Utente u = new Utente();
		assertFalse(u.setNome("23António Silva"));
	}
	
	@Test
	public void testGetNomeValido() {
		Utente u = new Utente();
		u.setNome("António Silva");
		assertEquals("António Silva", u.getNome());
	}
	
	@Test
	public void testGetNomeInvalido() {
		Utente u = new Utente();
		u.setNome("23António Silva");
		assertEquals(null, u.getNome());
	}
	
	@Test
	public void testSetSexoValido1() {
		Utente u = new Utente();
		assertTrue(u.setSexo("Masculino"));
	}
	
	@Test
	public void testSetSexoValido2() {
		Utente u = new Utente();
		assertTrue(u.setSexo("Feminino"));
	}
	
	@Test
	public void testSetSexoInvalido() {
		Utente u = new Utente();
		assertFalse(u.setSexo("23Masculino"));
	}
	
	@Test
	public void testGetSexoValido() {
		Utente u = new Utente();
		u.setSexo("Masculino");
		assertEquals("Masculino", u.getSexo());
	}
	
	@Test
	public void testGetSexoInvalido() {
		Utente u = new Utente();
		u.setSexo("23Masculino");
		assertEquals(null, u.getSexo());
	}
	
	@Test
	public void testSetIdadeValido() {
		Utente u = new Utente();
		assertTrue(u.setIdade(28));
	}
	
	@Test
	public void testSetIdadeInvalido1() {
		Utente u = new Utente();
		assertFalse(u.setIdade(0));
		
	}
	
	@Test
	public void testSetIdadeInvalido2() {
		Utente u = new Utente();
		assertFalse(u.setIdade(121));
		
	}
	
	@Test
	public void testGetIdadeValido() {
		Utente u = new Utente();
		u.setIdade(30);
		assertEquals(30, u.getIdade());
	}
	
	@Test
	public void testGetIdadeInvalido() {
		Utente u = new Utente();
		u.setIdade(130);
		assertEquals(0, u.getIdade());
	}
	
	@Test
	public void testSetProfissaoValido() {
		Utente u = new Utente();
		assertTrue(u.setProfissao("Carpinteiro"));
	}
	
	@Test
	public void testSetProfissaoInvalido() {
		Utente u = new Utente();
		assertFalse(u.setProfissao("23Carpinteiro"));
		
	}
	
	@Test
	public void testGetProfissaoValido() {
		Utente u = new Utente();
		u.setProfissao("Carpinteiro");
		assertEquals("Carpinteiro", u.getProfissao());
	}
	
	@Test
	public void testGetProfissaoInvalido() {
		Utente u = new Utente();
		u.setProfissao("23Carpinteiro");
		assertEquals(null, u.getProfissao());
	}

}
