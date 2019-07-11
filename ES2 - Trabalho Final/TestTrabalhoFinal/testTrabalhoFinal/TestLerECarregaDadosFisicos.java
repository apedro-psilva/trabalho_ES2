package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestor.Leitor;
import packageHabitosAlimentares.HabitosAlimentares;
import packageHabitosAlimentares.Produto;

public class TestLerECarregaDadosFisicos {
	
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
	public void testLeDadosFisicosValido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Sucesso a carregar os Dados Fisicos",L.leDadosFisicos("src/Inputs_Q_DF_HA_PP/DF_02_03_06_2019_21_32 .csv"));
		
  }
	//-----------------------------------------------------------------------------------------
	//-----------------------------PESO------------------------------------------------------------
	@Test
	public void testLeDadosFisicosPesoInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Peso\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_PesoInvalido.csv"));
		
	}
	@Test
	public void testLeDadosFisicosPesoVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Peso\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_PesoVazio.csv"));
		
	}
	


	//-----------------------------------------------------------------------------------------
	//-----------------------------ALTURA------------------------------------------------------------
		@Test
		public void testLeDadosFisicosAlturaInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Altura\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_AlturaInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicosAlturaVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Altura\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_AlturaVazia.csv"));
			
		}

	//-----------------------------------------------------------------------------------------
	//-----------------------------IMC------------------------------------------------------------
		@Test
		public void testLeDadosFisicosIMCInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"IMC\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_IMCInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicosIMCVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"IMC\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_IMCVazia.csv"));
			
		}


	//-----------------------------------------------------------------------------------------
	//-----------------------------B.F------------------------------------------------------------
		@Test
		public void testLeDadosFisicosBFInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"B.F\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_BFInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicosBFCVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"B.F\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_BFVazio.csv"));
			
		}



	//-----------------------------------------------------------------------------------------
	//-----------------------------GORDURA_VISCERAL------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_GORDURA_VISCERALInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Gordura visceral\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_GORDURA_VISCERALInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_GORDURA_VISCERALVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Gordura visceral\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_GORDURA_VISCERALVazio.csv"));
			
		}



	//-----------------------------------------------------------------------------------------
	//-----------------------------MUSCULO------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_MusculoInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Musculo\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_MusculoInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_MusculoVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Musculo\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_MusculoVazio.csv"));
			
		}


	//-----------------------------------------------------------------------------------------
	//-----------------------------H2O------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_H2OInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"H2O\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_H2OInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_H2OVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"H2O\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_H2OVazio.csv"));
			
		}



	//-----------------------------------------------------------------------------------------
	//-----------------------------OSSO------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_OSSOInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Osso\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_OssoInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_OSSOVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Osso\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_OssoVazio.csv"));
			
		}


	//-----------------------------------------------------------------------------------------
	//-----------------------------Idade Metabolica------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_Idade_MetabolicaInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Idade Metabolica\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Idade_MetabolicaInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_Idade_MetabolicaVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Idade Metabolica\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Idade_MetabolicaVazio.csv"));
			
		}

	//-----------------------------------------------------------------------------------------
	//-----------------------------Metabolismo_Basal------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_Metabolismo_BasalInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Metabolismo Basal\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Metabolismo_BasalInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_Metabolismo_BasalVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Metabolismo Basal\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Metabolismo_BasalVazio.csv"));
			
		}



	//-----------------------------------------------------------------------------------------
	//-----------------------------Fator_Atividade------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_Fator_AtividadeInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Fator Atividade\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Fator_AtividadeInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_Fator_AtividadeVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Fator Atividade\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Fator_AtividadeVazio.csv"));
			
		}

	//-----------------------------------------------------------------------------------------
	//-----------------------------Fator Lesão------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_Fator_LesãoInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Fator Lesão\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Fator_LesãoInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_Fator_LesãoVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Fator Lesão\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Fator_LesãoVazio.csv"));
			
		}

	//-----------------------------------------------------------------------------------------
	//-----------------------------Fator Térmico------------------------------------------------------------
		@Test
		public void testLeDadosFisicos_Fator_TérmicoInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Fator Térmico\" invalido",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Fator_TérmicoInvalido.csv"));
			
		}
		@Test
		public void testLeDadosFisicos_Fator_TérmicoVazio() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Fator Térmico\" vazio",L.leDadosFisicos("src/FicheirosTestesDadosFisicos/DF_02_03_06_2019_21_32_Fator_TérmicoVazio.csv"));
			
		}
	
}