package packageHabitosAlimentares;

import java.util.ArrayList;

public class Refeicao {
	private String tipo;
	private String hora;
	private ArrayList<String> alimentos = null;
	private ArrayList<String> alimentosAjustados = null;
	
	public Refeicao(String tip, String dat, ArrayList<String> ali) {
		alimentos = new ArrayList<String>();
		alimentosAjustados = new ArrayList<String>();
		setTipo(tip);
		setHora(dat);
		setAlimentos(ali);
	}
	
	public void setAlimentos(ArrayList<String> a) {
		alimentos = a;
	}
	
	public ArrayList<String> getAlimentos() {
		return this.alimentos;
	}
	
	public void setAlimentosAjustados(ArrayList<String> a) {
		alimentosAjustados = a;
	}
	
	public ArrayList<String> getAlimentosAjustados() {
		return this.alimentosAjustados;
	}


	public String getHora() {
		return this.hora;
	}

	public void setHora(String d) {
		this.hora = d;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String t) {
		this.tipo = t;
	}
	
	public void printRefeicao() {
		System.out.println("\n" + this.tipo + " : " + this.hora + "\n\n");
		for(int i = 0 ; i < alimentos.size(); i++) {
			if(i%2 == 0) {
				System.out.print("\n" + alimentos.get(i) + " - ");
			} else {
				System.out.println(alimentos.get(i));
			}
		}
		
		if(!alimentosAjustados.isEmpty()) {
			System.out.println("\n\nNovo plano Alimentar: ");
			for(int i = 0 ; i < alimentosAjustados.size(); i++) {
				if(i%2 == 0) {
					System.out.print("\n" + alimentosAjustados.get(i) + " - ");
				} else {
					System.out.println(alimentosAjustados.get(i));
				}
			}
		}
	}
	
}
