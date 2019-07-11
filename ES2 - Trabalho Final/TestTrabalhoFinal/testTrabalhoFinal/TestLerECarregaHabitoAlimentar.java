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

	@Test
	public void testLeHabitoHAlientarValido() throws IOException {
		Leitor L = Leitor.iniLeitor();
		assertEquals("Sucesso a ler Habitos Alimentares",L.leHabitoAlimentar("src/Inputs_Q_DF_HA_PP/HA_02_01_06_2019_12_25 .csv"));
		
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
		
		assertEquals("Código do produto IS000 inválido.",p.novoProduto("IS000","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalidoSuperior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Código do produto IS946 inválido.",p.novoProduto("IS946","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalido() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Código do produto 940 inválido.",p.novoProduto("940","12" ,"g"));	
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
		
		assertEquals("Quantidade do produto IS001 inválida.",p.novoProduto("IS001","0" ,"g"));	
	}
	
	@Test
	public void testProdutoQuantidadeVazia() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Quantidade do produto IS001 inválida.",p.novoProduto("IS001","" ,"g"));	
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
			
			assertEquals("Unidade do produto IS001 inválida.",p.novoProduto("IS001","1" ,"z"));	
		}
		
		//-----------------------------------------------------------------------------------------
		//-----------------------------Refeiçoes----------------------------------------------------
		

		@Test
		public void testRefeicaoValida() throws IOException{
			Refeicao r = new Refeicao();
			
			Produto p = new Produto();
			p.novoProduto("IS001", "2", "g");
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
			
			pro.add(p);
			
			assertEquals("Sucesso a criar refeição",r.novaRefeicao("Almoço", "13:00", pro));	
		}
		
		@Test
		public void testRefeicaoProdutosNull() throws IOException{
			Refeicao r = new Refeicao();
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
						
			assertEquals("Refeição \"Almoço\" não tem produtos.",r.novaRefeicao("Almoço", "13:00", pro));	
		}
		
		@Test
		public void testRefeicaoHoraInvalida() throws IOException{
			Refeicao r = new Refeicao();
			
			Produto p = new Produto();
			p.novoProduto("IS001", "2", "g");
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
			pro.add(p);
						
			assertEquals("Hora da refeição \"Almoço\" não está no formato HH:MM.",r.novaRefeicao("Almoço", "aa:aa", pro));	
		}
		
		@Test
		public void testRefeicaoTipoInvalido() throws IOException{
			Refeicao r = new Refeicao();
			
			Produto p = new Produto();
			p.novoProduto("IS001", "2", "g");
			
			ArrayList<Produto> pro = new ArrayList<Produto>();
			pro.add(p);
						
			assertEquals("Hora da refeição \"Almoço\" não está no formato HH:MM.",r.novaRefeicao("Almoço2", "13:00", pro));	
		}
		
}