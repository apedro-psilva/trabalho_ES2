package packageHabitosAlimentares;

public class Produto {
	private String iso;
	private String quantidade;
	private String unidade;
	
	public Produto() {};
	
	public String novoProduto(String i, String q, String u) {
		setIso(i);
		setQuantidade(q);
		setUnidade(u);
		
		return "Sucesso a criar o produto " + i;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
}
