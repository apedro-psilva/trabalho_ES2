package gestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import com.opencsv.CSVWriter;

import packageHabitosAlimentares.HabitosAlimentares;
import packageHabitosAlimentares.Produto;
import packageHabitosAlimentares.Refeicao;
import packageRepositorios.RepositorioDados;
import packageRepositorios.RepositorioUtentes;

public class Escritor {
	File f1 = null, f2 = null;
	FileWriter writer = null;
	CSVWriter csvw = null;
	private static Escritor instance = null;

	private Escritor() {}

	public static Escritor iniEscritor() {
		if(instance == null) {
			instance = new Escritor();
		}
		return instance;
	}

	public String geraDados(int tipo, int id, HabitosAlimentares ha, HashMap<Integer, String[]> arr) throws IOException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();

		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();

		Escritor esc = Escritor.iniEscritor();

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
				System.out.println("codigo" + p.getCodigo());
				System.out.println(rep.getTabela().get(p.getCodigo()));
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
			temp.add(" "); temp.add(" ");
			for(String s: rep.getHeader().subList(2, rep.getHeader().size()))
				temp.add(s);
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(" "); temp.add(" ");
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
		temp.add("Totais"); temp.add(" ");
		for(String s: rep.getHeader().subList(2, rep.getHeader().size()))
			temp.add(s);
		arr.put(c, temp.toArray(new String[0]));

		c++;
		temp.clear();
		temp.add(" "); temp.add(" ");
		for(Double d: ha.nutrientesDia())
			temp.add(Double.toString(d));
		arr.put(c, temp.toArray(new String[0]));

		if(tipo == 0) {
			c++;
			temp.clear();
			temp.add(" ");
			arr.put(c, temp.toArray(new String[0]));
			
			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Harris-Benedict");
			temp.add(Double.toString(ha.getUser().getHarrisBenedict()));
			temp.add("Kcal");
			arr.put(c, temp.toArray(new String[0]));
			
			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Total Calórico");
			temp.add(Double.toString(ha.nutrientesDia().get(0)));
			temp.add("Kcal");
			arr.put(c, temp.toArray(new String[0]));
			
			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Racio Calórico");
			temp.add(Double.toString(ha.nutrientesDia().get(0)/ha.getUser().getHarrisBenedict()*100));
			temp.add("%");
			arr.put(c, temp.toArray(new String[0]));
			temp.clear();
		}
		
		if(tipo == 1) {
			c++;
			temp.clear();
			temp.add(" ");
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Harris-Benedict");
			temp.add(Double.toString(repU.checkUtenteID(id).getHarrisBenedict()));
			temp.add("Kcal");
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Total Calórico Hábito Alimentar");
			temp.add(Double.toString(rep.getHabitosAlimentares(id).nutrientesDia().get(0)));
			temp.add("Kcal");
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Total Calórico Objetivo");
			temp.add(Double.toString(ha.nutrientesDia().get(0)));
			temp.add("Kcal");
			arr.put(c, temp.toArray(new String[0]));

			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Racio Calórico Hábito Alimentar");
			temp.add(Double.toString(rep.getHabitosAlimentares(id).nutrientesDia().get(0)/repU.checkUtenteID(id).getHarrisBenedict()*100));
			temp.add("%");
			arr.put(c, temp.toArray(new String[0]));
			temp.clear();

			c++;
			temp.clear();
			temp.add(" ");
			temp.add("Racio Calórico Objetivo");
			temp.add(Double.toString(ha.nutrientesDia().get(0)/repU.checkUtenteID(id).getHarrisBenedict()*100));
			temp.add("%");
			arr.put(c, temp.toArray(new String[0]));
			temp.clear();
		}

		if(tipo == 0) {
			temp.clear();
			temp.add("Plano Alimentar Atual");
			return escreveFicheiro("HA", id, temp, arr);
		} else {
			temp.clear();
			temp.add("Plano Alimentar Prescrito");
			return escreveFicheiro("PP", id, temp, arr);
		}

	}


	public String escreveFicheiro(String tipo, int id, ArrayList<String> header, HashMap<Integer, String[]> dados) throws IOException {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm"); 
		if(id < 0)
			return "Id Inválido";

		Date d = new Date();

		try {
			if(tipo.length() == 0)
				return "Tipo vazio";

			if(!tipo.equals("HA") && !tipo.equals("PP"))
				return "Tipo Inválido";
			
			if(id < 0)
				return "Id inválido";

			if(header.isEmpty()) 
				return "Header vazio";

			if(!header.get(0).equals("Plano Alimentar Atual") && !header.get(0).equals("Plano Alimentar Prescrito"))
				return "Header Inválido";


			if(dados.isEmpty())
				return "Dados vazios";

			f1 = new File("src/Outputs/"+ tipo +"_" + id + "_" + df.format(d) + ".csv");
			BufferedWriter writer = new BufferedWriter(new FileWriter(f1));
			writer.write(header.get(0));

			for(String[] s1: dados.values()) {
				writer.newLine();
				for(int i = 0; i < s1.length; i++) {
					if(i == 0)
						writer.append(s1[i]);
					else 
						writer.append("," + s1[i]);
				}
			}
			writer.close();
		}
		catch(IOException e) {
			System.out.println("Erro a escrever para ficheiro: " + e);
			return "Erro a escrever para ficheiro";
		}
		return "Sucesso a escrever para o ficheiro src/Outputs/"+ tipo +"_" + id + "_" + df.format(d) + ".csv";
	}
}
