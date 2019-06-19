package packageHabitosAlimentares;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Refeicao {
	private String tipo;
	private String hora;
	private ArrayList<Produto> produtos = null;
	
	public Refeicao() {};
	
	public String novaRefeicao(String tip, String hor, ArrayList<Produto> pro) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		
		if(pro.isEmpty())
			return "Refeição " + tipo + " não tem produtos. Ignorado.";
		
		setProdutos(pro);
	
		setTipo(tip);
		
		try {			
			if(hor.length()== 4)
				hor = "0" + hor;
			
			Date dat = timeFormat.parse(hor);
			setHora(timeFormat.format(dat));
		}
		catch(Exception e) {
			return "Hora da refeição " + tipo + " não está no formato HH:MM. Ignorado.";
		}
			
		return "Sucesso a criar refeição";
	}
	
	public void setProdutos(ArrayList<Produto> p) {
		produtos = new ArrayList<Produto>(p);
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
	
	public ArrayList<Double> somaNutrientesRefeicao(){
		ArrayList<Double> resultado = null;
		
		for(Produto p: produtos) {
			if(resultado == null) 
				resultado = new ArrayList<Double>(p.nutrientesProduto());
			else {
				for(int i = 0; i < resultado.size(); i++)
					resultado.set(i, resultado.get(i) + p.nutrientesProduto().get(i));		
			}		
		}
		
		return resultado;
	}
}
