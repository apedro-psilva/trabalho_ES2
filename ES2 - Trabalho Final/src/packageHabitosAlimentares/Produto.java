package packageHabitosAlimentares;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gestor.Leitor;
import packageRepositorios.RepositorioDados;

public class Produto {
	private String codigo;
	private String quantidade;
	private String unidade;
	
	public Produto() {};
	
	public String novoProduto(String c, String q, String u) {
		RepositorioDados rd = RepositorioDados.iniRepositorioDados();
		
		int cod = 0;
		
		try 
		{
		 cod = Integer.parseInt(c.substring(c.length() - 3));
		}
		catch(StringIndexOutOfBoundsException e) 
		{
			return "Codigo \"" + c + "\" vazio.";
		}
		
		if(!c.contains("IS")) {
			return "C�digo do produto " + c + " inv�lido.";
		}
			
		if(cod > 998){
			return "C�digo do produto " + c + " acima dos valores v�lidos.";
		}
		
		if(cod <= 0)
			return "C�digo do produto " + c + " abaixo dos valores v�lidos.";
		
		setCodigo(c);
		
		try {
			if(Integer.parseInt(q) <= 0)
				return "Quantidade do produto " + c + " abaixo dos valores v�lidos.";
		}
		catch (NumberFormatException e){
			return "Quantidade do produto " + c + " inv�lida.";
		}
		setQuantidade(q);
		
		if(!u.equals("g") && !u.equals("mg") && !u.equals("l") && !u.equals("ml"))
			return "Unidade do produto " + c + " inv�lida.";
			
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
	
	public ArrayList<Double> nutrientesProduto() throws IOException {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		Leitor l = Leitor.iniLeitor();
		
		if(rep.getTabela().isEmpty())
			l.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt");
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		Double r = null;
		
		ArrayList<String> header = (ArrayList<String>) rep.getHeader().clone();
		
		List<String> headerTemp = header.subList(2, header.size());
		
		for(String s: headerTemp) {
			try {
				if(this.unidade.equals("l")) 
					r = (Double.parseDouble(rep.getTabela().get(this.codigo).get(s)) * (Double.parseDouble(this.quantidade) * 1000)) / 100;
				else if(this.unidade.equals("mg"))
					r = (Double.parseDouble(rep.getTabela().get(this.codigo).get(s)) * (Double.parseDouble(this.quantidade) / 1000)) / 100;
				else
					r = (Double.parseDouble(rep.getTabela().get(this.codigo).get(s)) * Double.parseDouble(this.quantidade)) / 100;
				
				resultado.add(r);
			}
			catch (NumberFormatException e) {
				System.out.println(s);
			}
			
		}
		return resultado;
	}
}
