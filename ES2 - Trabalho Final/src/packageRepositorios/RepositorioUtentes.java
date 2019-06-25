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
	
	public Utente checkUtenteID(int id) {		
		for(int i = 0; i < getUtentes().size(); i++) {
			if(getUtentes().get(i).getId() == id) {
				return getUtentes().get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Utente> getUtentes() {
		return utentes;
	}

	public boolean addUtente(Utente u) {
		try {
			utentes.add(u);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void printUtente(int id) {
		for(int i = 0; i < utentes.size(); i++) {
			if(utentes.get(i).getId() == id) {
				System.out.print("\nID: " + utentes.get(i).getId());
				System.out.print("\nNome: " + utentes.get(i).getNome());
				System.out.print("\nSexo: " + utentes.get(i).getSexo());
				System.out.print("\nIdade: " + utentes.get(i).getIdade());
				System.out.print("\nProfissão: " + utentes.get(i).getProfissao() + "\n");
				
			}
		}
	}
}
