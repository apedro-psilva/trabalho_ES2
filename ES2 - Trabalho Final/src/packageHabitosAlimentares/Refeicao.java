package packageHabitosAlimentares;

import java.util.ArrayList;

public class Refeicao {
	private String tipo;
	private String hora;
	private ArrayList<Produto> produtos = null;
	
	public Refeicao() {};
	
	public String novaRefeicao(String tip, String hor, ArrayList<Produto> pro) {
		produtos = new ArrayList<Produto>();
		setTipo(tip);
		setHora(hor);
		setProdutos(pro);
		
		return "Sucesso a criar a refeição " + tip + "\n";
	}
	
	public void setProdutos(ArrayList<Produto> p) {
		produtos = p;
	}
	
	public ArrayList<Produto> getProdutos() {
		return this.produtos;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String h) {
		this.hora = h;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String t) {
		this.tipo = t;
	}	
}
