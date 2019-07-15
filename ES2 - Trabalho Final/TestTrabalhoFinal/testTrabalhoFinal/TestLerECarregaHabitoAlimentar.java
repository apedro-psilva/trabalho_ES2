package testTrabalhoFinal;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestor.Leitor;
import packageHabitosAlimentares.HabitosAlimentares;
import packageHabitosAlimentares.Produto;
import packageHabitosAlimentares.Refeicao;
import packageRepositorios.RepositorioDados;
import packageRepositorios.RepositorioUtentes;
import packageUtente.Utente;

public class TestLerECarregaHabitoAlimentar {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Leitor l = Leitor.iniLeitor();
		
		l.leQuestionario("src/PastasTestesInputs/Inputs_Q_DF_HA_PP/Q_02_01_06_2019_16_02.csv");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		Leitor l = Leitor.iniLeitor();
		
		if(rep.getTabela().isEmpty())
			l.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt");
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
		
		assertEquals("Sucesso a criar produto",p.novoProduto("IS998","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalidoInferior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Código do produto IS000 abaixo dos valores válidos.",p.novoProduto("IS000","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalidoSuperior() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Código do produto IS999 acima dos valores válidos.",p.novoProduto("IS999","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoInvalido() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Código do produto 940 inválido.",p.novoProduto("940","12" ,"g"));	
	}
	
	@Test
	public void testProdutoCodigoNull() throws IOException{
		
		Produto p = new Produto();
		
		assertEquals("Codigo \"\" vazio.",p.novoProduto("","12" ,"g"));	
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
		
		assertEquals("Quantidade do produto IS001 abaixo dos valores válidos.",p.novoProduto("IS001","0" ,"g"));	
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
		
		
		@Test 
		public void testProdutoCalculoNutrientes() throws IOException {
			
			
			Produto p = new Produto();
			p.novoProduto("IS020", "2", "g");
			ArrayList<Double> res = new ArrayList<Double>(Arrays.asList(1.86, 7.76, 1.7380000000000002, 0.102, 0.124, 0.084, 0.08800000000000001, 0.084, 0.0, 0.0, 0.0, 0.0, 0.0, 0.066, 0.03, 0.004, 0.006, 0.004, 1.1, 0.001, 1.0, 0.0, 0.0034000000000000002, 0.0022, 0.0012, 0.003, 0.022000000000000002, 0.004, 0.018000000000000002, 0.00148, 0.003, 0.1, 0.1, 0.018600000000000002, 0.74, 2.32, 3.8, 2.8, 0.3, 0.004, 0.013999999999999999));
			
			assertTrue(res.containsAll(p.nutrientesProduto()));
		}
		//-----------------------------------------------------------------------------------------
		//-----------------------------Refeiçoes----------------------------------------------------
		@Test
		public void testRefeicaoTipoInvalido() throws IOException{
			Leitor l = Leitor.iniLeitor();
			assertEquals("Refeição Pequenos Almoços inválida", l.leHabitoAlimentar("src/FicheirosTesteHabitosAlimentares/HA_02_01_06_2019_12_25_Refeicao_Invalida.csv"));		
		}
		
		@Test
		public void testRefeicaoTipoVazia() throws IOException{
			Leitor l = Leitor.iniLeitor();
			assertEquals("Refeição vazia", l.leHabitoAlimentar("src/FicheirosTesteHabitosAlimentares/HA_02_01_06_2019_12_25_Refeicao_Vazia.csv"));	
		}
		

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
		public void testRefeicaoCalculoNutrientes() throws IOException {			
			ArrayList<Produto> listp = new ArrayList<Produto>();
			
			Produto p = new Produto();
			p.novoProduto("IS020", "2", "g");
			listp.add(p);
			p.novoProduto("IS040", "2", "g");
			listp.add(p);
			p.novoProduto("IS060", "2", "g");
			listp.add(p);
			
			Refeicao r = new Refeicao();
			r.novaRefeicao("Almoço", "13:00", listp);
			
			ArrayList<Double> res = new ArrayList<Double>(Arrays.asList(3.5999999999999996, 15.0, 5.076, 0.6180000000000001, 0.018000000000000002, 0.24, 0.252, 0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.012, 0.006, 0.0, 0.0, 0.0, 0.42000000000000004, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0018, 0.016800000000000002, 0.21000000000000002, 0.066, 0.14400000000000002, 0.004200000000000001, 0.07800000000000001, 0.0, 0.8400000000000001, 0.048, 2.46, 9.24, 7.199999999999999, 8.94, 0.66, 0.012, 0.041999999999999996));
			assertTrue(res.containsAll(r.somaNutrientesRefeicao()));
		}
		
		

		
		//-----------------------------------------------------------------------------------------
		//-----------------------------Habitos Alimentares-----------------------------------------
		
		@Test
		public void testLeHabitoHAlientarValido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Sucesso a ler Habitos Alimentares",L.leHabitoAlimentar("src/PastasTestesInputs/Inputs_Q_DF_HA_PP/HA_02_01_06_2019_12_25.csv"));
		}
		
		@Test
		public void testLeHabitoHAlientarFicheiroInvalido() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Ficheiro do Habito Alimentar/Plano Prescrito não existe",L.leHabitoAlimentar("src/PastasTestesInputs/NaoExiste.csv"));
		}
		
		@Test
		public void testLeHabitoHAlientarFicheiroNull() throws IOException {
			Leitor L = Leitor.iniLeitor();
			assertEquals("Não foi fornecido nenhum ficheiro de Habito Alimentar/Plano Prescrito",L.leHabitoAlimentar(null));
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
			
			assertEquals("Utente vazio.",ha.novoHabitoAlimentar(u, "2", "09:00", ref));
			
		}
		
		@Test
		public void testLeHabitoHAlientarHoraVazia() throws IOException {

			HabitosAlimentares ha = new HabitosAlimentares();
			RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
			
			Utente u = new Utente();			
			u.setId(2);
			u.setNome("Ricardo");
			
			repU.addUtente(u);
			
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
			
			assertEquals("Hora vazia.",ha.novoHabitoAlimentar(u, "02/06/2019", "", ref));
			
		}
		
		@Test
		public void testLeHabitoHAlientarDataVazia() throws IOException {

			HabitosAlimentares ha = new HabitosAlimentares();
			RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
			
			Utente u = new Utente();			
			u.setId(2);
			u.setNome("Ricardo");
			
			repU.addUtente(u);
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
			
			assertEquals("Data vazia.",ha.novoHabitoAlimentar(u, "", "9:00", ref));
			
		}
		
		@Test
		public void testLeHabitoHAlientarDataInvalido() throws IOException {

			HabitosAlimentares ha = new HabitosAlimentares();
			RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
			
			Utente u = new Utente();			
			u.setId(2);
			u.setNome("Ricardo");
			
			repU.addUtente(u);
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
			
			assertEquals("Data do Hábito Alimentar do Utente Ricardo do dia Invalido não está no formato DD/MM/YYYY.",ha.novoHabitoAlimentar(u, "Invalido", "9:00", ref));
			
		}
		
		@Test
		public void testLeHabitoHAlientarHoraInvalida() throws IOException {

			HabitosAlimentares ha = new HabitosAlimentares();
			RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();
			
			Utente u = new Utente();			
			u.setId(2);
			u.setNome("Ricardo");
			
			repU.addUtente(u);
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
			
			assertEquals("Hora de Levantar do Hábito Alimentar do Utente Ricardo do dia 14/07/2019 nao está no formato HH:MM.",ha.novoHabitoAlimentar(u, "14/07/2019", "Invalida", ref));
			
		}
		
		@Test
		public void testHabitoAlimentarCalculoNutrientes() throws IOException {			
			ArrayList<Produto> listp = new ArrayList<Produto>();
			ArrayList<Refeicao> listr = new ArrayList<Refeicao>();
			
			Produto p = new Produto();
			p.novoProduto("IS020", "2", "g");
			listp.add(p);
			p.novoProduto("IS040", "2", "g");
			listp.add(p);
			p.novoProduto("IS060", "2", "g");
			listp.add(p);
			
			Refeicao r = new Refeicao();
			r.novaRefeicao("Almoço", "13:00", listp);
			listr.add(r);
			r.novaRefeicao("Jantar", "20:00", listp);
			listr.add(r);
			r.novaRefeicao("Ceia", "23:00",  listp);
			listr.add(r);
			
			Utente u = new Utente();
			u.novoUtente(10, "teste", "masculino", 20, "estudante");
			
			HabitosAlimentares ha = new HabitosAlimentares();
			ha.novoHabitoAlimentar(u, "14/07/2019", "12:0", listr);
			
			ArrayList<Double> res = new ArrayList<Double>(Arrays.asList(10.799999999999999, 45.0, 15.227999999999998, 1.8540000000000003, 0.054000000000000006, 0.72, 0.756, 0.72, 0.0, 0.0, 0.0, 0.0, 0.0, 0.036000000000000004, 0.018000000000000002, 0.0, 0.0, 0.0, 1.2600000000000002, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0054, 0.05040000000000001, 0.6300000000000001, 0.198, 0.43200000000000005, 0.012600000000000002, 0.23400000000000004, 0.0, 2.5200000000000005, 0.14400000000000002, 7.38, 27.72, 21.599999999999998, 26.82, 1.98, 0.036000000000000004, 0.126));
			
			assertTrue(res.containsAll(ha.nutrientesDia()));
		}
		
}