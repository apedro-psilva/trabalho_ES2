package packageRepositorios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import packageHabitosAlimentares.HabitosAlimentares;
import packageQuestionario.Questionario;
import packageUtente.DadosFisicos;

public class RepositorioDados {
	private static RepositorioDados instance = null;
	private static HashMap<String, HashMap<String, String>> tabelaNutricional = null;
	private static HashMap<String, String> camposTabela = null; 
	private static ArrayList<String> header = null;
	private static HashMap<Integer, Questionario> questionarios = null;
	private static HashMap<Integer, HabitosAlimentares> habitos = null;
	private static HashMap<Integer, HabitosAlimentares> planos = null;
	private static HashMap<Integer, DadosFisicos> dadosFisicos = null;

	LinkedHashMap<String, HashMap<String, String>> valoresRef = new LinkedHashMap<String, HashMap<String,String>>();
	ArrayList<String> temp = new ArrayList<String>(Arrays.asList("Código","PRODUTO","Energia (kcal)","Energia (kJ)","Água (g)","Proteína (g)","Gordura total (g)","Total HC disponíveis (g)","Total HC expresso em monossacáridos (g)","Mono + dissacáridos (g)","Ácidos orgânicos (g)","Álcool (g)","Amido (g)","Oligossacáridos (g)","Fibra alimentar (g)","Ácidos gordos saturados (g)","Ácidos gordos monoinsaturados (g)","Ácidos gordos polinsaturados  (g)","Ácidos gordos trans (g)","Ácido linoleico (g)","Colesterol (mg)","Retinol (vit. A total) (mg)","Vit A total (equivalentes retinol) (mg)","Caroteno (mg)","vit. D (µg)","a-tocoferol (mg)","Tiamina (mg)","Riboflavina (mg)","Equivalentes de niacina (mg)","Niacina (mg)","Triptofano/60 (mg)","vit B6 (mg)","Vit. B12 (µg)","vit. C (mg)","Folatos (µg)","Cinza (g)","Na (mg)","K    (mg)","Ca (mg)","P (mg)","Mg (mg)","Fe (mg)","Zn (mg)"));
	HashMap<String, String> maxMin = null;

	private RepositorioDados() {
		for(String s : temp) {
			maxMin = new HashMap<String,String>(); 
			if(s.equals("Código")) {
				maxMin.put("min", "001");
				maxMin.put("max", "999");
			}
			else if(s.equals("PRODUTO")) {
				maxMin.put("min", "1");
				maxMin.put("max", "100");
			}
			else {
				maxMin.put("min", "0");
				maxMin.put("max", "5000");
			}

			valoresRef.put(s, maxMin);
		}
	}

	// Singleton
	public static RepositorioDados iniRepositorioDados() {
		if(instance == null) {
			instance = new RepositorioDados();
			tabelaNutricional = new HashMap<String, HashMap<String, String>>();
			header = new ArrayList<String>();
			questionarios = new HashMap<Integer, Questionario>();
			habitos = new HashMap<Integer, HabitosAlimentares>();
			planos = new HashMap<Integer, HabitosAlimentares>();
			dadosFisicos = new HashMap<Integer, DadosFisicos>();
		}
		return instance;	
	}

	// Criação e metodos da Tabela Nutricional
	public String setLinhaTabela(ArrayList<String> valores) {		
		camposTabela = new HashMap<String, String>();
		String cod = null;

		try {
			if(!valores.isEmpty()) {
				if(valores.size() == 43) {	
					for(int i = 0; i < valores.size(); i++) {
						if(valoresRef.containsKey(valores.get(i))) {
							header.add(valores.get(i));
						}else {
							if(valores.get(0).equals(""))
								return "Código vazio";
							else if(i == 0 && valores.get(0).substring(0,2).equals("IS")) {
								if(Integer.parseInt(valores.get(0).substring(2)) < Integer.parseInt(valoresRef.get(valoresRef.keySet().toArray()[i]).get("min")))
									return "Código abaixo dos valores válidos";
								else if(Integer.parseInt(valores.get(0).substring(2)) > Integer.parseInt(valoresRef.get(valoresRef.keySet().toArray()[i]).get("max")))
									return "Código acima dos valores válidos";
								
								cod = valores.get(0);
							} 
							else if(i == 0 && !valores.get(0).substring(0,2).equals("IS")) 
								return "Código não contem IS";
							else if(i == 1) {
								if(valores.get(i).length() < Integer.parseInt(valoresRef.get(valoresRef.keySet().toArray()[i]).get("min"))) {
									if(valores.get(i).equals(""))
										return "Produto vazio";
									return "Produto abaixo dos valores válidos";
								}
								else if(valores.get(i).length() > Integer.parseInt(valoresRef.get(valoresRef.keySet().toArray()[i]).get("max"))) {
									if(valores.get(i).equals(""))
										return "Produto vazio";
									return "Produto acima dos valores válidos";
								}
							}
							else if(i > 1) {
								try {
									if(Double.parseDouble(valores.get(i)) < Double.parseDouble(valoresRef.get(valoresRef.keySet().toArray()[i]).get("min")))
										return valoresRef.keySet().toArray()[i] + " abaixo dos valores válidos";
									else if(Double.parseDouble(valores.get(i)) > Double.parseDouble(valoresRef.get(valoresRef.keySet().toArray()[i]).get("max")))
										return valoresRef.keySet().toArray()[i] + " acima dos valores válidos";
								}
								catch(NumberFormatException e) {
									return valoresRef.keySet().toArray()[i] + " vazio";
								}
								
							}
							camposTabela.put(header.get(i), valores.get(i));
						}
						
					}
					if(cod != null) 
						tabelaNutricional.put(cod, camposTabela);
					else 
						return "Header guardado";
				}
				else {
					if(valores.size() < 43)
						return "Numero de campos abaixo do valor válido";
					else if(valores.size() > 43)
						return "Numero de campos acima do valor válido";
				}
			}
			else
				return "Linha vazia";
		}
		catch(NullPointerException e) {
			return "Linha null";
		}
		return "Linha guardada";

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
		habitos.put(ha.getUser().getId(), ha);
	}

	public void setQuestionario(Questionario q) {
		questionarios.put(q.getId(), q);
	}

	public void setDadosFisicos(Integer id, DadosFisicos df) {
		dadosFisicos.put(id, df);
	}

	public DadosFisicos getDadosFisicos(Integer id) {
		return dadosFisicos.get(id);
	}

	public void setPlanoPrescrito(HabitosAlimentares pp) {
		planos.put(pp.getUser().getId(), pp);
	}

	public HabitosAlimentares getHabitosAlimentares(Integer id){
		return habitos.get(id);
	}

	public HabitosAlimentares getPlanosAlimentares(Integer id){
		return planos.get(id);
	}
}
