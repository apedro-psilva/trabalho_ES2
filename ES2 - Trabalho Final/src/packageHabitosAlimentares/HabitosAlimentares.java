package packageHabitosAlimentares;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import packageRepositorios.RepositorioUtentes;
import packageUtente.Utente;

public class HabitosAlimentares {
	private Utente user;
	private String data;
	private String horaLevantar;
	private ArrayList<Refeicao> refeicoes = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public HabitosAlimentares() {}
	
	public String novoHabitoAlimentar(Utente user, String d, String h, ArrayList<Refeicao> r) {
		RepositorioUtentes ru = RepositorioUtentes.iniRepositorioUtentes();
		
		if(r.isEmpty())
			return "Hábito Alimentar do Utente " + user.getNome() + " do dia " + d + " sem refeições.";
		setRefeicoes(r);

		if(ru.checkUtenteID(user.getId()) == null)
			return "Hábito Alimentar para o Utente " + user.getNome() + " do dia " + d + " não existe.";
		
		setUser(user);

		try {
			Date dat = dateFormat.parse(d);
			setData(dateFormat.format(dat));
		}
		catch(Exception e) {
			return "Data do Hábito Alimentar do Utente " + user.getNome() + " do dia " + d + " não está no formato DD/MM/YYYY.";
		}

		try {
			if(h.length()== 4)
				h = "0" + h;
			
			Date dat = timeFormat.parse(h);
			setHoraLevantar(timeFormat.format(dat));
		}
		catch(Exception e) {
			return "Hora de Levantar do Hábito Alimentar do Utente " + user.getNome() + " do dia " + d + " nao está no formato HH:MM.";

		}
		return "Sucesso a criar o Habito Alimentar";
	}

	public String getHoraLevantar() {
		return this.horaLevantar;
	}

	private void setHoraLevantar(String h) {
		this.horaLevantar = h;
	}

	public String getData() {
		return this.data;
	}

	private void setData(String d) {
		this.data = d;
	}

	public ArrayList<Refeicao> getRefeicoes() {
		return this.refeicoes;
	}
	
	private void setRefeicoes(ArrayList<Refeicao> r) {
		this.refeicoes = new ArrayList<Refeicao>(r);
	}	

	public Utente getUser() {
		return this.user;
	}

	private void setUser(Utente u) {
		this.user = u;
	}
	
	public ArrayList<Double> nutrientesDia(){
		ArrayList<Double> resultado = null;
		
		for(Refeicao r: refeicoes) 
			if(resultado == null)
				resultado = new ArrayList<Double>(r.somaNutrientesRefeicao());
			else {
				for(int i = 0; i < resultado.size(); i++) 
					resultado.set(i, resultado.get(i) + r.somaNutrientesRefeicao().get(i));
			}

		return resultado;
	}
}
