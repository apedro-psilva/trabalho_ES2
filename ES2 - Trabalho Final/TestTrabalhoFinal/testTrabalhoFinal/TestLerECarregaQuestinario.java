package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestor.Leitor;
import packageQuestionario.Questionario;

public class TestLerECarregaQuestinario {
	static HashMap<String, String> valoresReferencia = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		valoresReferencia = new HashMap<String, String>();
		valoresReferencia.put("Nome", "António Pedro");
		valoresReferencia.put("Sexo", "Masculino");
		valoresReferencia.put("Idade", "28");
		valoresReferencia.put("Profissão", "Estudante");
		valoresReferencia.put("Motivo da Consulta", "Preocupações de Saude");
		valoresReferencia.put("Objectivo", "Emagrecer");
		valoresReferencia.put("Patologias", "Tensão Baixa");
		valoresReferencia.put("Medicação", "Sem medicação");
		valoresReferencia.put("Antecedentes Familiares", "Hipertenção");
		valoresReferencia.put("Atividade Fisica", "Moderadamente Ativo");
		valoresReferencia.put("Função Intestinal", "Normal");
		valoresReferencia.put("Consumo de Água", "0.5L a 1L");
		valoresReferencia.put("Colesterol", "12");
		valoresReferencia.put("Glicémia", "3");
		valoresReferencia.put("Ureia", "5");
		valoresReferencia.put("Creatinina", "0.58");
		valoresReferencia.put("Prob. C reativa", "19");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////// Verificação do header //////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testLeQuestionarioValido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Sucesso a ler Questionario",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _Valido.csv"));
	}

	
	//-----------------------------NOME------------------------------------------------------------
	@Test
	public void testLeQuestionarioNomeInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Nome\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _NomeInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioNomeVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Nome\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _NomeVazio.csv"));
	}


	//-----------------------------Sexo------------------------------------------------------------
	@Test
	public void testLeQuestionarioSexoInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Sexo\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _SexoInvalido.csv"));	
	}
	
	@Test
	public void testLeQuestionarioSexoVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Sexo\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _SexoVazio.csv"));
	}


	//-----------------------------Idade------------------------------------------------------------
	@Test
	public void testLeQuestionarioIdadeInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Idade\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _IdadeInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioIdadeVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Idade\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _IdadeVazio.csv"));
	}
	
	
	//-----------------------------Profissao------------------------------------------------------------
	@Test
	public void testLeQuestionarioProfissaoInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Profissão\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProfissaoInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioProfissaoVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Profissão\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProfissaoVazio.csv"));
	}
	

	//-----------------------------Motivo da Consulta------------------------------------------------------------
	@Test
	public void testLeQuestionarioMotivoInvalido() throws IOException {
		
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Motivo da Consulta\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MotivoInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioMotivoVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Motivo da Consulta\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MotivoVazio.csv"));
	}
	
	
	//-----------------------------Objetivos------------------------------------------------------------
	@Test
	public void testLeQuestionarioObjectivoInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Objectivo\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ObjetivoInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioObjectivoVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Objectivo\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ObjetivoVazio.csv"));
	}

	
	//------------------------Patologias-----------------------------------------------------------
	@Test
	public void testLeQuestionarioPatologiasInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Patologias\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _PatologiaInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioPatologiasVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Patologias\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _PatologiaVazio.csv"));
	}
	
	
	//------------------------Medicação-----------------------------------------------------------
	@Test
	public void testLeQuestionarioMedicacaoInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Medicação\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MedicacaoInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioMedicacaoVazio() throws IOException {	
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Medicação\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _MedicacaoVazio.csv"));
	}
	
	
	//------------------------Atecedestes Familiares-----------------------------------------------------------
	@Test
	public void testLeQuestionarioAntecedentesInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Antecedentes Familiares\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _AntecedentesFamiliaresInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioAntecedentesVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Antecedentes Familiares\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _AntecedentesFamiliaresVazio.csv"));
	}
		
	
	//------------------------Funcao intestinal-----------------------------------------------------------
	@Test
	public void testLeQuestionarioFIntestinalInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Função Intestinal\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _FuncaoIntestinalInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioFIntestinalVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Função Intestinal\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _FuncaoIntestinalVazio.csv"));
	}
	
	
	//------------------------Consumo de Água-----------------------------------------------------------
	@Test
	public void testLeQuestionarioConsumoAguaInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Consumo de Água\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ConsumoAguaInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioConsumoAguaVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Consumo de Água\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ConsumoAguaVazio.csv"));
	}
	
	
	//------------------------Colesterol-----------------------------------------------------------
	@Test
	public void testLeQuestionarioColesterolInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Colesterol\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ColesterolInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioColesterolVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Colesterol\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ColesterolVazio.csv"));
	}
	
	
	//------------------------Glicémia-----------------------------------------------------------	
	@Test
	public void testLeQuestionarioGlicemiaInvalido() throws IOException {	
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Glicémia\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _GlicemiaInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioGlicemiaVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Glicémia\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _GlicemiaVazio.csv"));
	}
		
	
	//------------------------Ureia-----------------------------------------------------------	
	@Test
	public void testLeQuestionarioUreiaInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Ureia\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _UreiaInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioUreiaVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Ureia\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _UreiaVazio.csv"));
	}
	
	
	//------------------------Creatinina-----------------------------------------------------------	
	@Test
	public void testLeQuestionarioCreatininaInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Creatinina\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _CreatininaInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioCreatininaVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Creatinina\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _CreatininaVazio.csv"));
	}

	
	//------------------------Prob. C reativa-----------------------------------------------------------	
	@Test
	public void testLeQuestionarioProbCReativaInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Prob. C reativa\" invalido",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProbCReativaInvalido.csv"));
	}
	
	@Test
	public void testLeQuestionarioProbCReativaVazio() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Nome do Campo \"Prob. C reativa\" vazio",L.leQuestionario("src/FicheirosTestesQuestionario/Q_02_01_06_2019_16_02 _ProbCReativaVazio.csv"));
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////// Verificação dos dados //////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	public void testNovoQuestionarioValido() {
		Questionario q = new Questionario();
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	//------------------------Nome-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioNomeVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Nome", "");
		assertEquals("Nome do Utente vazio", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioNomeInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Nome", "123sasd");
		assertEquals("Nome do Utente Inválido", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Sexo-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioSexoVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Sexo", "");
		assertEquals("Sexo do Utente vazio", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioSexoInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Sexo", "masculinos");
		assertEquals("Sexo do Utente Inválido", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Idade-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioIdadeVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Idade", "");
		assertEquals("Idade do Utente vazia", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioIdadeInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Idade", "123asd");
		assertEquals("Idade do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioIdadeValidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Idade", "0");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioIdadeValidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Idade", "149");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioIdadeInvalidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Idade", "-1");
		assertEquals("Idade do Utente abaixo dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioIdadeInvalidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Idade", "150");
		assertEquals("Idade do Utente acima dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Profissão-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioProfissaoVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Profissão", "");
		assertEquals("Profissão do Utente vazia", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioProfissaoInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Profissão", "123sasd");
		assertEquals("Profissão do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Motivo da Consulta-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioMotivoDaConsultaVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Motivo da Consulta", "");
		assertEquals("Motivo da Consulta do Utente vazio", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioMotivoDaConsultaInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Motivo da Consulta", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("Motivo da Consulta do Utente com mais de 100 caracteres", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Objectivo-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioObjectivoVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Objectivo", "");
		assertEquals("Objectivo do Utente vazio", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioObjectivoInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Objectivo", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("Objectivo do Utente com mais de 100 caracteres", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Patologias-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioPatologiasVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Patologias", "");
		assertEquals("Patologias do Utente vazias", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioPatologiasInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Patologias", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("Patologias do Utente com mais de 100 caracteres", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Medicação-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioMedicacaoVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Medicação", "");
		assertEquals("Medicação do Utente vazia", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioMedicacaoInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Medicação", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("Medicação do Utente com mais de 100 caracteres", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Antecedentes Familiares-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioAntecedentesFamiliaresVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Antecedentes Familiares", "");
		assertEquals("Antecedentes Familiares do Utente vazios", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioAntecedentesFamiliaresInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Antecedentes Familiares", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals("Antecedentes Familiares do Utente com mais de 100 caracteres", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Atividade Física-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioAtividadeFisicaInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Atividade Fisica", "");
		assertEquals("Atividade Fisica do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Função Intestinal-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioFunçãoIntestinalInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Função Intestinal", "");
		assertEquals("Função Intestinal do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Consumo de Água-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioConsumoDeÁguaInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Consumo de Água", "");
		assertEquals("Consumo de Água do Utente Inválido", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Colesterol-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioColesterolVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Colesterol", "");
		assertEquals("Colesterol do Utente vazio", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioColesterolInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Colesterol", "123asd");
		assertEquals("Colesterol do Utente Inválido", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioColesterolValidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Colesterol", "0");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioColesterolValidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Colesterol", "22");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioColesterolInvalidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Colesterol", "-1");
		assertEquals("Colesterol do Utente abaixo dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioColesterolInvalidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Colesterol", "23");
		assertEquals("Colesterol do Utente acima dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Creatinina-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioCreatininaVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Creatinina", "");
		assertEquals("Creatinina do Utente vazio", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioCreatininaInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Creatinina", "123asd");
		assertEquals("Creatinina do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
			
	@Test
	public void testNovoQuestionarioCreatininaValidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Creatinina", "0");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioCreatininaValidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Creatinina", "22");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioCreatininaInvalidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Creatinina", "-1");
		assertEquals("Creatinina do Utente abaixo dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioCreatininaInvalidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Creatinina", "23");
		assertEquals("Creatinina do Utente acima dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Glicémia-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioGlicémiaVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Glicémia", "");
		assertEquals("Glicémia do Utente vazio", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioGlicémiaInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Glicémia", "123asd");
		assertEquals("Glicémia do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioGlicémiaValidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Glicémia", "0");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioGlicémiaValidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Glicémia", "22");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioGlicémiaInvalidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Glicémia", "-1");
		assertEquals("Glicémia do Utente abaixo dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioGlicémiaInvalidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Glicémia", "23");
		assertEquals("Glicémia do Utente acima dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Ureia-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioUreiaVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Ureia", "");
		assertEquals("Ureia do Utente vazia", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioUreiaInvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Ureia", "123asd");
		assertEquals("Ureia do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioUreiaValidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Ureia", "0");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioUreiaValidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Ureia", "22");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioUreiaInvalidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Ureia", "-1");
		assertEquals("Ureia do Utente abaixo dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioUreiaInvalidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Ureia", "23");
		assertEquals("Ureia do Utente acima dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	
	//------------------------Prob. C reativa-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioProbCreativaVazio() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Prob. C reativa", "");
		assertEquals("Prob. C reativa do Utente vazia", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioProbCreativainvalido() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Prob. C reativa", "123asd");
		assertEquals("Prob. C reativa do Utente Inválida", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioProbCreativaValidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Prob. C reativa", "0");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioProbCreativaValidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Prob. C reativa", "22");
		assertEquals("Sucesso a carregar o Questionário", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioProbCreativaInvalidaInferior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Prob. C reativa", "-1");
		assertEquals("Prob. C reativa do Utente abaixo dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}
	
	@Test
	public void testNovoQuestionarioProbCreativaInvalidaSuperior() {
		Questionario q = new Questionario();
		valoresReferencia.replace("Prob. C reativa", "23");
		assertEquals("Prob. C reativa do Utente acima dos valores válidos", q.novoQuestionario(1, valoresReferencia));
	}	
}
