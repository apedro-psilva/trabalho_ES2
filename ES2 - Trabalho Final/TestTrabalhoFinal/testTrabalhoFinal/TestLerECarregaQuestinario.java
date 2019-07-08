package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestor.Leitor;

public class TestLerECarregaQuestinario {

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
	public void testLeQuestionarioValido() throws IOException {
		//src/FicheirosTestesQuestionario/Q_Valido.csv
		Leitor L = Leitor.iniLeitor();
		assertEquals("Sucesso a ler Questionario",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _Valido.csv"));
		
	}
	//-----------------------------------------------------------------------------------------
	//-----------------------------NOME------------------------------------------------------------
	@Test
	public void testLeQuestionarioNomeInvalido() throws IOException {
		//src/FicheirosTestesQuestionario/Q_Valido.csv
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Nome\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _NomeInvalido.csv"));
		
	}
	@Test
	public void testLeQuestionarioNomeVazio() throws IOException {
		//src/FicheirosTestesQuestionario/Q_Valido.csv
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Nome\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _NomeVazio.csv"));
		
	}
	
	
	//-----------------------------------------------------------------------------------------
		//-----------------------------Sexo------------------------------------------------------------
		@Test
		public void testLeQuestionarioSexoInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Sexo\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _SexoInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioSexoVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Sexo\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _SexoVazio.csv"));
			
		}

//-----------------------------------------------------------------------------------------
		//-----------------------------Idade------------------------------------------------------------
		@Test
		public void testLeQuestionarioIdadeInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Idade\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _IdadeInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioIdadeVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Idade\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _IdadeVazio.csv"));
			
		}
//-----------------------------Profissao------------------------------------------------------------
		@Test
		public void testLeQuestionarioProfissaoInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Profissão\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProfissaoInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioProfissaoVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Profissão\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProfissaoVazio.csv"));
			
		}
		

//-----------------------------Motivo da Consulta------------------------------------------------------------
		@Test
		public void testLeQuestionarioMotivoInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Motivo da Consulta\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MotivoInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioMotivoVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Motivo da Consulta\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MotivoVazio.csv"));
			
		}
		
		
		//-----------------------------Objetivos------------------------------------------------------------
		@Test
		public void testLeQuestionarioObjectivoInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Objectivo\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ObjetivoInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioObjectivoVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Objectivo\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ObjetivoVazio.csv"));
			
		}
		
		
		
//------------------------Patologias-----------------------------------------------------------
		@Test
		public void testLeQuestionarioPatologiasInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Patologias\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _PatologiaInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioPatologiasVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Patologias\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _PatologiaVazio.csv"));
			
		}
		//------------------------Medicação-----------------------------------------------------------
		
		@Test
		public void testLeQuestionarioMedicacaoInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Medicação\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MedicacaoInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioMedicacaoVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Medicação\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MedicacaoVazio.csv"));
			
		}
		
	//------------------------Atecedestes Familiares-----------------------------------------------------------
		
		@Test
		public void testLeQuestionarioAntecedentesInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Antecedentes Familiares\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _AntecedentesFamiliaresInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioAntecedentesVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Antecedentes Familiares\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _AntecedentesFamiliaresVazio.csv"));
			
		}
			
//------------------------Funcao intestinal-----------------------------------------------------------

		@Test
		public void testLeQuestionarioFIntestinalInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Função Intestinal\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _FuncaoIntestinalInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioFIntestinalVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Função Intestinal\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _FuncaoIntestinalVazio.csv"));
			
		}
		
		//------------------------Consumo de Água-----------------------------------------------------------

		
		@Test
		public void testLeQuestionarioConsumoAguaInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Consumo de Água\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ConsumoAguaInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioConsumoAguaVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Consumo de Água\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ConsumoAguaVazio.csv"));
			
		}
		
		//------------------------Colesterol-----------------------------------------------------------
	
		@Test
		public void testLeQuestionarioColesterolInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Colesterol\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ColesterolInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioColesterolVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Colesterol\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ColesterolVazio.csv"));
			
		}
		
		//------------------------Glicémia-----------------------------------------------------------	
		
		
		@Test
		public void testLeQuestionarioGlicemiaInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Glicémia\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _GlicemiaInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioGlicemiaVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Glicémia\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _GlicemiaVazio.csv"));
		}
			
		
		//------------------------Ureia-----------------------------------------------------------	

		
		@Test
		public void testLeQuestionarioUreiaInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Ureia\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _UreiaInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioUreiaVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Ureia\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _UreiaVazio.csv"));
		}
		
		
		//------------------------Creatinina-----------------------------------------------------------	
	
		
		@Test
		public void testLeQuestionarioCreatininaInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Creatinina\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _CreatininaInvalido.csv"));
			
		}
		@Test
		public void testLeQuestionarioCreatininaVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Creatinina\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _CreatininaVazio.csv"));
		}
		
		
			
		//------------------------Prob. C reativa-----------------------------------------------------------	

		
		@Test
		public void testLeQuestionarioProbCReativaInvalido() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Prob. C reativa\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProbCReativaInvalido.csv"));
			
		}
		
		@Test
		public void testLeQuestionarioProbCReativaVazio() throws IOException {
			//src/FicheirosTestesQuestionario/Q_Valido.csv
			Leitor L = Leitor.iniLeitor();
			assertEquals("Nome do Campo \"Prob. C reativa\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProbCReativaVazio.csv"));
		}
			
		
		
		
		
}
