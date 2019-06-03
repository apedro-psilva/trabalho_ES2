package packageHabitosAlimentares;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import packageUtente.Utente;

public class HabitosAlimentares {
	private Utente user;
	private String data;
	private String horaLevantar;
	private ArrayList<Refeicao> refeicoes = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public HabitosAlimentares() {}
	
	public String novoHabitoAlimentar(Utente user, String h, ArrayList<Refeicao> r) {
		refeicoes = new ArrayList<Refeicao>();

		setUser(user);

		try {
			Date dat = new Date();
			setData(dateFormat.format(dat));
		}
		catch(Exception e) {
			System.out.println("Data não está no formato DD/MM/YYYY.");
			return "NSucesso";
		}

		try {
			if(h.length()== 4)
				h = "0" + h;
			
			Date dat = timeFormat.parse(h);
			setHoraLevantar(timeFormat.format(dat));
		}
		catch(Exception e) {
			System.out.println("Hora não está no formato HH:MM.");
			return "NSucesso";

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

	public Utente getUser() {
		return this.user;
	}

	private void setUser(Utente u) {
		this.user = u;
	}
}
