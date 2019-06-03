package packageRepositorios;

import java.util.ArrayList;
import java.util.HashMap;

import packageHabitosAlimentares.HabitosAlimentares;
import packageQuestionario.Questionario;
import packageUtente.DadosFisicos;

public class RepositorioDados {
	private static RepositorioDados instance = null;
	private static HashMap<String, HashMap<String, String>> tabelaNutricional = null;
	private static HashMap<String, String> camposTabela = null; 
	private static ArrayList<String> header = null;
	private static HashMap<String, Questionario> questionarios = null;
	private static HashMap<String, HabitosAlimentares> habitos = null;
	private static HashMap<String, DadosFisicos> dadosFisicos = null;

	public RepositorioDados() {}
	
	// Singleton
	public RepositorioDados iniRepositorioDados() {
		if(instance == null) {
			instance = new RepositorioDados();
			tabelaNutricional = new HashMap<String, HashMap<String, String>>();
			header = new ArrayList<String>();
			questionarios = new HashMap<String, Questionario>();
			habitos = new HashMap<String, HabitosAlimentares>();
			dadosFisicos = new HashMap<String, DadosFisicos>();
		}
		return instance;	
	}

	// Criação e metodos da Tabela Nutricional
	public void setLinhaTabela(ArrayList<String> valores) {
		camposTabela = new HashMap<String, String>();
		String cod = null;
		
		if(!valores.isEmpty()) {			
			for(int i = 0; i < valores.size(); i++) {
				if(valores.get(0).equals("Código")) {
					if(i == 0)
						cod = "Código";
					else
						header.add(valores.get(i));
				} else {
					if(i == 0)
						cod = valores.get(i);
					else
						camposTabela.put(header.get(i-1), valores.get(i));
				}
			}
			if(!cod.equals("Código"))
				tabelaNutricional.put(cod, camposTabela);
		}
	}
	
	public void printTabela() {
		for(String k: tabelaNutricional.keySet()) {
			System.out.println("\n" + k + " :");
			System.out.println(tabelaNutricional.get(k));
		}
	}
	
	public HashMap<String, HashMap<String, String>> getTabela(){
		return tabelaNutricional;
	}
	
	public HashMap<String, String> getAndPrintInfoCodigo(String cod) {
		System.out.println("\n" + cod);
		System.out.println(tabelaNutricional.get(cod) + "\n");
		return tabelaNutricional.get(cod);
	}
	
	public ArrayList<String> getAndPrintCodigosPorProduto(String prod) {
		ArrayList<String> codigos = new ArrayList<String>();
		System.out.print("\n");
		for(String k: tabelaNutricional.keySet()) {
			if(tabelaNutricional.get(k).get("PRODUTO").contains(prod)) {
				System.out.println(k + " -> " + tabelaNutricional.get(k).get("PRODUTO"));
				codigos.add(k);
			}
		}
		return codigos;
	}
	
	public ArrayList<String> getHeader() {
		return header;
	}
	
	public void setHabitoAlimentar(HabitosAlimentares ha) {
		habitos.put(Integer.toString(ha.getUser().getId()), ha);
	}
	
	public void setQuestionario(Questionario q) {
		questionarios.put(Integer.toString(q.getId()), q);
	}
	
	public void setDadosFisicos(String id, DadosFisicos df) {
		dadosFisicos.put(id, df);
	}
	
}
