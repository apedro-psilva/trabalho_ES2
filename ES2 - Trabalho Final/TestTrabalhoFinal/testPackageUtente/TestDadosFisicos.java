package testPackageUtente;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import packageUtente.DadosFisicos;

public class TestDadosFisicos {

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
	public void testSetPesoValido() {
		DadosFisicos d = new DadosFisicos();
		assertTrue(d.setPeso("40"));
	}
	
	@Test
	public void testSetPesoInvalido1() {
		DadosFisicos d = new DadosFisicos();
		assertFalse(d.setPeso("9"));
	}
	
	@Test
	public void testSetPesoInvalido2() {
		DadosFisicos d = new DadosFisicos();
		assertFalse(d.setPeso("401"));
	}

}
