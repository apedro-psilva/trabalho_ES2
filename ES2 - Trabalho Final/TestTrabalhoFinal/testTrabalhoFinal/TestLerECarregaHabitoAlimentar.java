package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestor.Leitor;
import packageHabitosAlimentares.HabitosAlimentares;
import packageHabitosAlimentares.Produto;
import packageHabitosAlimentares.Refeicao;
import packageUtente.Utente;

public class TestLerECarregaHabitoAlimentar {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Leitor L = Leitor.iniLeitor();
		L.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt");
		L.leQuestionario("src/Inputs_Q_DF_HA_PP/Q_02_01_06_2019_16_02.csv");
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

	//-----------------------------------------------------------------------------------------
	//-----------------------------Produtos----------------------------------------------------
	
	//-----------------------------Codigo----------------------------------------------------
	@Test
	public void testProdutoCodigoValidoInferior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Sucesso a criar produto",p.novoProduto("IS001","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoValidoSuperior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Sucesso a criar produto",p.novoProduto("IS945","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalidoInferior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("C�digo do produto IS000 inv�lido.",p.novoProduto("IS000","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalidoSuperior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("C�digo do produto IS946 inv�lido.",p.novoProduto("IS946","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalido() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("C�digo do produto 940 inv�lido.",p.novoProduto("940","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoNull() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Codigo \"\" invalido",p.novoProduto("","12" ,"g"));	
	}
	
	//-----------------------------Quantidade----------------------------------------------------
	
	@Test
	public void testProdutoQuantidadeValidoInferior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Sucesso a criar produto",p.novoProduto("IS001","1" ,"g"));	
	}

	@Test
	public void testProdutoQuantidadeInvalidoInferior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Quantidade do produto IS001 inv�lida.",p.novoProduto("IS001","0" ,"g"));	
	}
	
	@Test
	public void testProdutoQuantidadeVazia() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Quantidade do produto IS001 inv�lida.",p.novoProduto("IS001","" ,"g"));	
	}
	
	//-----------------------------Unidade----------------------------------------------------
	
		@Test
		public void testProdutoUnidadeValida() throws IOException{
			
			Produto p = new Produto();
			
			assertEquals("Sucesso a criar produto",p.novoProduto("IS001","1" ,"g"));	
		}
		
		@Test
		public void testProdutoUnidadeInvalida() throws IOException{
			
			Produto p = new Produto();
			
			assertEquals("Unidade do produto IS001 inv�lida.",p.novoProduto("IS001","1" ,"z"));	
		}
		
		//-----------------------------------------------------------------------------------------
		//-----------------------------Refei�oes----------------------------------------------------
		

		@Test
		public void testRefeicaoValida() throws IOException{
			Refeicao r = new Refeicao();
			
			Produto p = new Produto();
			p.novoProduto("IS001", "2", "g");
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
			
			pro.add(p);
			
			assertEquals("Sucesso a criar refei��o",r.novaRefeicao("Almo�o", "13:00", pro));	
		}
		
		@Test
		public void testRefeicaoProdutosNull() throws IOException{
			Refeicao r = new Refeicao();
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
						
			assertEquals("Refei��o \"Almo�o\" n�o tem produtos.",r.novaRefeicao("Almo�o", "13:00", pro));	
		}
		
		@Test
		public void testRefeicaoHoraInvalida() throws IOException{
			Refeicao r = new Refeicao();
			
			Produto p = new Produto();
			p.novoProduto("IS001", "2", "g");
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
			pro.add(p);
						
			assertEquals("Hora da refei��o \"Almo�o\" n�o est� no formato HH:MM.",r.novaRefeicao("Almo�o", "aa:aa", pro));	
		}
		
		// ------------------------Testar no leitor o tipo invalido e vazio
//		@Test
//		public void testRefeicaoTipoInvalido() throws IOException{
//			Refeicao r = new Refeicao();
//			
//			Produto p = new Produto();
//			p.novoProduto("IS001", "2", "g");
//			
//			ArrayList<Produto> pro = new ArrayList<Produto>();
//			pro.add(p);
//						
//			assertEquals("Hora da refei��o \"Almo�o\" n�o est� no formato HH:MM.",r.novaRefeicao("Almo�o2", "13:00", pro));	
//		}
//		

		
		//-----------------------------------------------------------------------------------------
		//-----------------------------Habitos Alimentares-----------------------------------------
		
		@Test
		public void testLeHabitoHAlientarValido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Sucesso a ler Habitos Alimentares",L.leHabitoAlimentar("src/Inputs_Q_DF_HA_PP/HA_02_01_06_2019_12_25 .csv"));
		}
		
		
		@Test
		public void testLeHabitoHAlientarUtilizadorVazio() throws IOException {

			HabitosAlimentares ha = new HabitosAlimentares();
			
			Utente u = new Utente();			
			
			Refeicao r = new Refeicao();
			
			Produto p = new Produto();
			p.novoProduto("IS001", "2", "g");
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
			pro.add(p);
			
			r.novaRefeicao("Almoco", "13:00", pro);
			ArrayList<Refeicao> ref = new ArrayList<Refeicao>();
			ref.add(r);
			r.novaRefeicao("Jantar", "20:00", pro);
			
			ref.add(r);
			
			assertEquals("H�bito Alimentar para o Utente null do dia 2 n�o existe.",ha.novoHabitoAlimentar(u, "2", "09:00", ref));
			
		}
		
		
}