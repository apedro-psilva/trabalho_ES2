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
import packageHabitosAlimentares.HabitosAlimentares;
import packageHabitosAlimentares.Produto;
import packageQuestionario.Questionario;
import packageUtente.DadosFisicos;

public class TestLerECarregaDadosFisicos {
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
		valoresReferencia.put("Peso", "89");
		valoresReferencia.put("Altura", "187");
		valoresReferencia.put("IMC", "24");
		valoresReferencia.put("B.F", "75");
		valoresReferencia.put("Gordura visceral", "10");
		valoresReferencia.put("Musculo", "99");
		valoresReferencia.put("H2O", "25");
		valoresReferencia.put("Osso", "2");
		valoresReferencia.put("Idade Metabolica", "25");
		valoresReferencia.put("Metabolismo Basal", "2");
		valoresReferencia.put("Fator Atividade", "1.25");
		valoresReferencia.put("Fator Lesão", "1.6");
		valoresReferencia.put("Fator Térmico", "1.3");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testLeDadosFisicosFicheiroInvalido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Ficheiro dos Dados Fisicos não existe",L.leDadosFisicos("src/PastasTestesInputs/Inputs_Q_DF_HA_PP/NaoExiste.csv"));
	}
	
	@Test
	public void testLeDadosFisicosFicheiroNull() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Não foi fornecido nenhum ficheiro de Dados Fisicos",L.leDadosFisicos(null));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////// Verificação do header //////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testLeDadosFisicosValido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Sucesso a ler Dados Físicos",L.leDadosFisicos("src/PastasTestesInputs/Inputs_Q_DF_HA_PP/DF_02_03_06_2019_21_32.csv"));
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
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////// Verificação dos valores ////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//------------------------Peso-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosPesoVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Peso", "");
		assertEquals("Peso vazio", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosPesoInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Peso", "123asd");
		assertEquals("Peso Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosPesoValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Peso", "10");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosPesoValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Peso", "399");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosPesoInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Peso", "9");
		assertEquals("Peso abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosPesoInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Peso", "400");
		assertEquals("Peso acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Altura-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosAlturaVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Altura", "");
		assertEquals("Altura vazia", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosAlturaInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Altura", "123asd");
		assertEquals("Altura Inválida", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosAlturaValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Altura", "10");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosAlturaValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Altura", "299");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosAlturaInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Altura", "9");
		assertEquals("Altura abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosAlturaInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Altura", "300");
		assertEquals("Altura acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------IMC-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosIMCVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("IMC", "");
		assertEquals("IMC vazio", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIMCInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("IMC", "123asd");
		assertEquals("IMC Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIMCValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("IMC", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIMCValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("IMC", "39");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIMCInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("IMC", "-1");
		assertEquals("IMC abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIMCInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("IMC", "40");
		assertEquals("IMC acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------B.F-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosBFVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("B.F", "");
		assertEquals("B.F vazio", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosBFInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("B.F", "123asd");
		assertEquals("B.F Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosBFValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("B.F", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosBFValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("B.F", "79");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosBFInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("B.F", "-1");
		assertEquals("B.F abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosBFInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("B.F", "80");
		assertEquals("B.F acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Gordura Visceral-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosGorduraVisceralVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Gordura visceral", "");
		assertEquals("Gordura visceral vazia", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosGorduraVisceralInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Gordura visceral", "123asd");
		assertEquals("Gordura visceral Inválida", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosGorduraVisceralValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Gordura visceral", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosGorduraVisceralValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Gordura visceral", "59");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosGorduraVisceralInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Gordura visceral", "-1");
		assertEquals("Gordura visceral abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosGorduraVisceralInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Gordura visceral", "60");
		assertEquals("Gordura visceral acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Musculo-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosMusculoVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Musculo", "");
		assertEquals("Musculo vazio", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMusculoInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Musculo", "123asd");
		assertEquals("Musculo Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMusculoValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Musculo", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMusculoValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Musculo", "99");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMusculoInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Musculo", "-1");
		assertEquals("Musculo abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMusculoInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Musculo", "100");
		assertEquals("Musculo acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------H2O-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosH2OVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("H2O", "");
		assertEquals("H2O vazio", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosH2OInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("H2O", "123asd");
		assertEquals("H2O Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosH2OValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("H2O", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosH2OValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("H2O", "39");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosH2OInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("H2O", "-1");
		assertEquals("H2O abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosH2OInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("H2O", "40");
		assertEquals("H2O acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Osso-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosOssoVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Osso", "");
		assertEquals("Osso vazio", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosOssoInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Osso", "123asd");
		assertEquals("Osso Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosOssoValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Osso", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosOssoValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Osso", "3");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosOssoInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Osso", "-1");
		assertEquals("Osso abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosOssoInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Osso", "4");
		assertEquals("Osso acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Idade Metabolica-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosIdadeMetabolicaVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Idade Metabolica", "");
		assertEquals("Idade Metabolica vazia", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIdadeMetabolicaInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Idade Metabolica", "123asd");
		assertEquals("Idade Metabolica Inválida", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIdadeMetabolicaValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Idade Metabolica", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIdadeMetabolicaValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Idade Metabolica", "69");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIdadeMetabolicaInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Idade Metabolica", "-1");
		assertEquals("Idade Metabolica abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosIdadeMetabolicaInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Idade Metabolica", "70");
		assertEquals("Idade Metabolica acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Metabolismo Basal-----------------------------------------------------------
	@Test
	public void testNovoDadosFisicosMetabolismoBasalVazio() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Metabolismo Basal", "");
		assertEquals("Metabolismo Basal vazio", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMetabolismoBasalInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Metabolismo Basal", "123asd");
		assertEquals("Metabolismo Basal Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMetabolismoBasalValidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Metabolismo Basal", "0");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMetabolismoBasalValidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Metabolismo Basal", "49");
		assertEquals("Sucesso a carregar os Dados Fisicos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMetabolismoBasalInvalidaInferior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Metabolismo Basal", "-1");
		assertEquals("Metabolismo Basal abaixo dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	@Test
	public void testNovoDadosFisicosMetabolismoBasalInvalidaSuperior() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Metabolismo Basal", "50");
		assertEquals("Metabolismo Basal acima dos valores válidos", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Fator Atividade-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioFatorAtividadeInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Fator Atividade", " ");
		assertEquals("Fator Atividade Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Fator Lesão-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioFatorLesãoInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Fator Lesão", " ");
		assertEquals("Fator Lesão Inválido", d.novoDadosFisicos(valoresReferencia));
	}
	
	
	//------------------------Fator Térmico-----------------------------------------------------------
	@Test
	public void testNovoQuestionarioFatorTérmicoInvalido() {
		DadosFisicos d = new DadosFisicos();
		valoresReferencia.replace("Fator Térmico", " ");
		assertEquals("Fator Térmico Inválido", d.novoDadosFisicos(valoresReferencia));
	}
}