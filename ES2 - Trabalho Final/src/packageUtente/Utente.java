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
	private String profissao;
	private RepositorioUtentes repUtentes = new RepositorioUtentes();
	
	String regexNome = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$"; 
	String res;
	
	public Utente() {}
	
	public String novoUtente(int id, String nome, int idade, String profissao) {
		repUtentes.iniRepositorioUtentes();
		setId(id);
		setNome(nome);
	
		if(repUtentes.checkUtente(nome) != null) {
			return "Utente já existe.";
		}
		
		if(!nome.matches(regexNome)) {
			return "Nome Inválido";
		}
		
		setIdade(idade);
		
		if(idade < 0 || idade > 120) {
			return "Idade Inválida";
		}

		setProfissao(profissao);
		
		if(!profissao.matches(regexNome)) {
			return "Profissão Inválida";
		}
		repUtentes.addUtente(this);
		return "Sucesso a criar o Utente";
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

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String p) {
		this.profissao = p;
	}
}
