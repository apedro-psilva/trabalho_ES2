package packageRepositorios;

import java.util.ArrayList;
import packageUtente.Utente;

public class RepositorioUtentes {
	static ArrayList<Utente> utentes = null;
	static RepositorioUtentes instance = null;
	
	public RepositorioUtentes() {}
	
	public RepositorioUtentes iniRepositorioUtentes() {
		if(instance == null) {
			instance = new RepositorioUtentes();
			utentes = new ArrayList<Utente>();
		}
		return instance;
	}

	public Utente checkUtente(String nome) {		
		for(int i = 0; i < getUtentes().size(); i++) {
			if(getUtentes().get(i).getNome().equals(nome)) {
				System.out.println(getUtentes().get(i));
				return getUtentes().get(i);
			}
		}
		
		return null;
	}
	
	public ArrayList<Utente> getUtentes() {
		return utentes;
	}

	public void addUtente(Utente u) {
		utentes.add(u);
	}
	
	public void printUtente(int id) {
		for(int i = 0; i < utentes.size(); i++) {
			if(utentes.get(i).getId() == id) {
				System.out.print("\nID: " + utentes.get(i).getId());
				System.out.print("\nNome: " + utentes.get(i).getNome());
				System.out.print("\nIdade: " + utentes.get(i).getIdade());
				System.out.print("\nAltura: " + utentes.get(i).getAltura() + "cm");
				System.out.print("\nProfissão: " + utentes.get(i).getProfissao() + "\n");
			}
		}
	}
}
