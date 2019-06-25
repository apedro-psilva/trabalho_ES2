import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import exceptions.EmptyFolderException;
import exceptions.MissingFilesException;
import gestor.*;
import packageHabitosAlimentares.HabitosAlimentares;
import packageHabitosAlimentares.Produto;
import packageHabitosAlimentares.Refeicao;
import packageRepositorios.*;
import packageUtente.Utente;

public class Cliente {
	public static void main(String args[]) throws IOException, EmptyFolderException, MissingFilesException{
		RepositorioDados rep = new RepositorioDados();
		RepositorioUtentes repU = new RepositorioUtentes();
		rep.iniRepositorioDados();
		repU.iniRepositorioUtentes();

		Escritor esc = new Escritor();
		esc.iniEscritor();

		Leitor l = new Leitor();
		l.iniLeitor();

		System.out.println(l.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt"));

		//rep.printTabela();
		//HashMap<String, String> info = rep.getAndPrintInfoCodigo("IS795");

		l.lePasta("src/Inputs");

		for(Utente u: repU.getUtentes()) {
			HashMap<Integer, String[]> dadosHAOutput = new HashMap<Integer, String[]>();
			HashMap<Integer, String[]> dadosPPOutput = new HashMap<Integer, String[]>();
			
			if(rep.getHabitosAlimentares(u.getId()) != null && rep.getPlanosAlimentares(u.getId()) != null) {
				geraDados(0, u.getId(), rep.getHabitosAlimentares(u.getId()), dadosHAOutput);
				geraDados(1, u.getId(), rep.getPlanosAlimentares(u.getId()), dadosPPOutput);
			}
		}
	} 


	public static void geraDados(int tipo, int id, HabitosAlimentares ha, HashMap<Integer, String[]> arr) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		
		RepositorioUtentes repU = new RepositorioUtentes();
		repU.iniRepositorioUtentes();
		
		Escritor esc = new Escritor();
		esc.iniEscritor();

		ArrayList<String> temp = new ArrayList<String>();
		Integer c = 0;

		temp.add(" ");
		arr.put(c, temp.toArray(new String[0]));

		c++;
		temp.clear();
		temp.add("Levantar"); 
		temp.add(ha.getHoraLevantar());
		arr.put(c, temp.toArray(new String[0]));

		for(Refeicao r: ha.getRefeicoes()) {
			c++;
			temp.clear();
			temp.add(" ");
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(r.getTipo()); temp.add(r.getHora());
			arr.put(c, temp.toArray(new String[0]));

			for(Produto p: r.getProdutos()) {
				c++;
				temp.clear();
				temp.add(" "); temp.add(" "); 
				temp.add(rep.getTabela().get(p.getCodigo()).get("PRODUTO"));
				temp.add(p.getQuantidade());
				temp.add(p.getUnidade());
				arr.put(c, temp.toArray(new String[0]));
			}
			c++;
			temp.clear();
			temp.add(" ");
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(" "); temp.add(" "); temp.add(" ");
			for(String s: rep.getHeader().subList(1, rep.getHeader().size()))
				temp.add(s);
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(" "); temp.add(" "); temp.add(" ");
			for(Double d: r.somaNutrientesRefeicao())
				temp.add(Double.toString(d));
			arr.put(c, temp.toArray(new String[0]));
		}
		c++;
		temp.clear();
		temp.add(" ");
		arr.put(c, temp.toArray(new String[0]));

		c++;
		temp.clear();
		temp.add("Totais"); temp.add(" "); temp.add(" ");
		for(String s: rep.getHeader().subList(1, rep.getHeader().size()))
			temp.add(s);
		arr.put(c, temp.toArray(new String[0]));

		c++;
		temp.clear();
		temp.add(" "); temp.add(" "); temp.add(" ");
		for(Double d: ha.nutrientesDia())
			temp.add(Double.toString(d));
		arr.put(c, temp.toArray(new String[0]));
		
		if(tipo == 1) {
			c++;
			temp.clear();
			temp.add(" ");
			arr.put(c, temp.toArray(new String[0]));
			
			c++;
			temp.clear();
			temp.add(" "); temp.add(" ");
			temp.add("Harris-Benedict Atual");
			temp.add(Double.toString(repU.checkUtenteID(id).getHarrisBenedict()));
			temp.add("Kcal");
			arr.put(c, temp.toArray(new String[0]));
			
			c++;
			temp.clear();
			temp.add(" "); temp.add(" ");
			temp.add("Total Calórico Atual");
			temp.add(Double.toString(ha.nutrientesDia().get(0)));
			temp.add("Kcal");
			arr.put(c, temp.toArray(new String[0]));
			
			c++;
			temp.clear();
			temp.add(" "); temp.add(" ");
			temp.add("Racio Calórico Atual");
			temp.add(Double.toString(ha.nutrientesDia().get(0)/repU.checkUtenteID(id).getHarrisBenedict()*100));
			temp.add("%");
			arr.put(c, temp.toArray(new String[0]));
			temp.clear();
		}
		

		if(tipo == 0) {
			temp.clear();
			temp.add("Plano Alimentar Atual");
			esc.escreveFicheiro("HA", id, temp, arr);
		} else {
			temp.clear();
			temp.add("Plano Alimentar Prescrito");
			esc.escreveFicheiro("PP", id, temp, arr);
		}
		
	}
}
