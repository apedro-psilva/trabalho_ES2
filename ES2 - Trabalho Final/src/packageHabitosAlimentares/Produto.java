package packageHabitosAlimentares;

import java.util.ArrayList;

import packageRepositorios.RepositorioDados;

public class Produto {
	private String codigo;
	private String quantidade;
	private String unidade;
	
	public Produto() {};
	
	public String novoProduto(String c, String q, String u) {
		RepositorioDados rd = new RepositorioDados();
		rd.iniRepositorioDados();
		
		int cod = Integer.parseInt(c.substring(c.length() - 3));

		if(cod > rd.getTabela().size() || cod <= 0)
			return "Código do produto " + c + " inválido.";
			
		setCodigo(c);
		
		if(Integer.parseInt(q) < 0)
			return "Quantidade do produto " + c + " inválida.";
		
		setQuantidade(q);
		
		if(!u.equals("g") && !u.equals("mg") && !u.equals("l") && !u.equals("ml"))
			return "Unidade do produto " + c + " inválida. Produto Ignorado.";
			
		setUnidade(u);
		
		return "Sucesso a criar produto";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	public ArrayList<Double> nutrientesProduto() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		Double r = null;
		
		for(String s: rep.getHeader()) {
			try {
				if(unidade.equals("l")) 
					r = (Double.parseDouble(rep.getTabela().get(codigo).get(s)) * (Double.parseDouble(quantidade) * 1000)) / 100;
				else if(unidade.equals("mg"))
					r = (Double.parseDouble(rep.getTabela().get(codigo).get(s)) * (Double.parseDouble(quantidade) / 1000)) / 100;
				else
					r = (Double.parseDouble(rep.getTabela().get(codigo).get(s)) * Double.parseDouble(quantidade)) / 100;
				
				resultado.add(r);
			}
			catch (NumberFormatException e) {}
			
		}
		return resultado;
	}
}
