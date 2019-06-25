package packageUtente;

import packageRepositorios.RepositorioDados;
import packageRepositorios.RepositorioUtentes;

public class Utente {
	private int id;
	private String nome;
	private String sexo;
	private int idade;
	private String profissao;
	private RepositorioUtentes repUtentes = new RepositorioUtentes();
	
	String regexNome = "^[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˙ÁÒ¡¿¬√…»Õœ”‘’÷⁄«—'\\s]+$";
	
	public Utente() {}
	
	public String novoUtente(int id, String nome, String sexo, int idade, String profissao) {
		repUtentes.iniRepositorioUtentes();
		
		if(repUtentes.checkUtenteID(id) != null) 
			return "Utente j· existe";
		
		if(!setId(id)) 
			return "ID Inv·lido";
		
		if(!setNome(nome)) 
			return "Nome Inv·lido";
		
		
		if(!setSexo(sexo))
			return "Sexo Inv·lido";
		
		
		if(!setIdade(idade)) 
			return "Idade Inv·lida";
		

		if(!setProfissao(profissao)) 
			return "Profiss„o Inv·lida";
		
		
		if(!repUtentes.addUtente(this))
			return "Erro a adicionar Utente ao RepositÛrio de Utentes";
		
		return "Sucesso a criar o Utente";
	}

	public int getId() {
		return this.id;
	}

	public boolean setId(int i) {
		if(i < 1) 
			return false;
			
		this.id = i;
		return true;		
	}

	public String getNome() {
		return this.nome;
	}

	public boolean setNome(String n) {
		if(!n.matches(regexNome)) 
			return false;
		
		this.nome = n;
		return true;
	}
	
	public String getSexo() {
		return sexo;
	}

	public boolean setSexo(String s) {
		if(!s.equals("Masculino") && !s.equals("Feminino"))
			return false;

		this.sexo = s;
		return true;
	}

	public int getIdade() {
		return this.idade;
	}

	public boolean setIdade(int i) {
		if(i < 1 || i > 120) 
			return false;
		
		this.idade = i;
		return true;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public boolean setProfissao(String p) {
		if(!p.matches(regexNome)) 
			return false;
		
		this.profissao = p;
		return true;
	}
	
	public double getTMB(){
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		double resultado = 0;
		double pe = Double.parseDouble((rep.getDadosFisicos(this.getId()).getPeso()));
		double al = Double.parseDouble((rep.getDadosFisicos(this.getId()).getAltura()));
		
		if (this.getSexo().equals("Feminino"))
			resultado = 655.1 + (9.5 * pe) + (1.8 * al) + (4.7 * this.getIdade());
		else 
			resultado = 66.5 + (13.8 * pe) + (5 * al) + (6.8 * this.getIdade());
		
		return resultado;
	}
	
	public double getHarrisBenedict() {
		RepositorioDados rep = new RepositorioDados();
		rep.iniRepositorioDados();
		
		return getTMB() * Double.parseDouble(rep.getDadosFisicos(this.getId()).getFatorAtividade()) * Double.parseDouble(rep.getDadosFisicos(this.getId()).getFatorLesao()) * Double.parseDouble(rep.getDadosFisicos(this.getId()).getFatorTermico());
	}
	
}
