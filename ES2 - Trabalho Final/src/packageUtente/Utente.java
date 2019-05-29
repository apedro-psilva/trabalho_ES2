package packageUtente;

import java.util.ArrayList;
import java.util.Scanner;

import packageHabitosAlimentares.HabitosAlimentares;
import packageQuestionario.Questionario;
import packageRepositorios.RepositorioUtentes;

public class Utente {
	private int id;
	private String nome;
	private int idade;
	private int altura;
	private String profissao;
	private RepositorioUtentes repUtentes = new RepositorioUtentes();
	private ArrayList<Questionario> listaQuestionarios = null;
	private ArrayList<DadosFisicos> listaDadosFisicos = null;
	private ArrayList<HabitosAlimentares> listaHabitosAlimentares = null;
	private ArrayList<PlanoAlimentar> listaPlanosAlimentares = null;
	
	Scanner input = new Scanner(System.in);
	
	String regexNome = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$"; 
	String res;
	
	public Utente() {}
	
	public String novoUtente() {
		repUtentes.iniRepositorioUtentes();
		
		for(int i = 0; i < repUtentes.getUtentes().size(); i++) {
			System.out.println(repUtentes.getUtentes().get(i).getNome());
		}
		
		System.out.println("\nNovo Utente");
		setId(repUtentes.getUtentes().size() + 1);
		
		System.out.println(repUtentes.getUtentes().size());
		
		System.out.print("\nNome :");
		setNome(input.nextLine());
		
		if(repUtentes.checkUtente(nome) != null) {
			return "Utente já existe.";
		}
		
		if(!nome.matches(regexNome)) {
			return "Nome Inválido";
		}
		
		System.out.print("\nIdade :");
		setIdade(Integer.parseInt(input.nextLine()));
		
		if(idade < 0 || idade > 120) {
			return "Idade Inválida";
		}
		
		System.out.print("\nAltura :");
		setAltura(Integer.parseInt(input.nextLine()));
		
		if(altura < 0 || altura > 220) {
			return "Altura Inválida";
		}
		
		System.out.print("\nProfissão :");
		setProfissao(input.nextLine());
		
		if(!profissao.matches(regexNome)) {
			return "Profissão Inválida";
		}
		repUtentes.addUtente(this);
		return "Sucesso.";
	}

	public int getId() {
		return this.id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String n) {
		this.nome = n;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int i) {
		this.idade = i;
	}

	public int getAltura() {
		return this.altura;
	}

	public void setAltura(int a) {
		this.altura = a;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String p) {
		this.profissao = p;
	}

	public ArrayList<HabitosAlimentares> getListaHabitosAlimentares() {
		return this.listaHabitosAlimentares;
	}

	public void addToListaHabitosAlimentares(HabitosAlimentares a) {
		if(listaHabitosAlimentares == null) {
			listaHabitosAlimentares = new ArrayList<HabitosAlimentares>();
		}
		this.listaHabitosAlimentares.add(a);
	}
}
