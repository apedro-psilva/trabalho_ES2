package packageHabitosAlimentares;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import packageUtente.Utente;

public class HabitosAlimentares {
	private Utente user;
	private String data;
	private String horaLevantar;
	private ArrayList<Refeicao> refeicoes = null;
	String resposta;	
	String[] tiposRefeicoes = {"Pequeno Almoço", "Meio da Manha", "Almoço", "Meio da Tarde", "Jantar", "Ceia"};
	Scanner input = new Scanner(System.in);
	SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ss.SSS-Z");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	DateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public HabitosAlimentares() {}
	
	public String novoHabitosAlimentares(Utente user, String d, String h, Refeicao[] r/*nao devia ser um array de refeiçoes?*/) {
		refeicoes = new ArrayList<Refeicao>();

		System.out.println("A criar Habito Alimentar para o utilizador " + user.getNome());
		
		setUser(user);

		Date dat = new Date(d);

		try {
			setData(dateFormat.format(dat));
			System.out.println(dateFormat.format(dat));
		}
		catch(Exception e) {
			System.out.println("Data não está no formato YYYY/MM/DD.");
			return "NSucesso";
		}

		System.out.print("\nInsira a hora a que acorda :");
		String hora = input.nextLine();

		try {

			Date dat1 = timeFormat.parse(hora);
			setData(hora);
		}
		catch(Exception e) {
			System.out.println("Data não está no formato YYYY/MM/DD.");
			return "NSucesso";

		}
		
		
		return "Sucesso";
	}

	

	public String verificaRefeicoesMinimas() {
		int cont = 0;

		for(int i = 0; i < refeicoes.size(); i++) {
			if(getRefeicoes().get(i).getTipo().equals(tiposRefeicoes[0])) {
				System.out.println(refeicoes.get(i).getTipo() + " \u2713");
				cont++;
			}

			else if(getRefeicoes().get(i).getTipo().equals(tiposRefeicoes[2])) {
				System.out.println(refeicoes.get(i).getTipo() + " \u2713");
				cont++;
			}

			else if(getRefeicoes().get(i).getTipo().equals(tiposRefeicoes[4])) {
				System.out.println(refeicoes.get(i).getTipo() + " \u2713");
				cont++;
			}
			
			else {
				System.out.println(refeicoes.get(i).getTipo());
				
			}
		}
		
		if(cont < 3) {
			return "NSucesso";
		}

		return "Sucesso";

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

	public ArrayList<Refeicao> getRefeicaoPorTipo(String t) {
		ArrayList<Refeicao> r = new ArrayList<Refeicao>();
		for(int i = 0; i < this.refeicoes.size(); i++) {
			if(this.refeicoes.get(i).getTipo().equals(t)) {
				r.add(this.refeicoes.get(i));
			}
		}
		return r;
	}

	private void addRefeicao(Refeicao r) {
		this.refeicoes.add(r);
	}

	public Utente getUser() {
		return this.user;
	}

	private void setUser(Utente u) {
		this.user = u;
	}
}
