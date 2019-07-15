package packageUtente;

import packageRepositorios.RepositorioDados;
import packageRepositorios.RepositorioUtentes;

public class Utente {
	private int id;
	private String nome;
	private String sexo;
	private int idade;
	private String profissao;
	private RepositorioUtentes repUtentes = RepositorioUtentes.iniRepositorioUtentes();
	
	String regexNome = "^[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˙ÁÒ¡¿¬√…»Õœ”‘’÷⁄«—'\\s]+$";
	
	public Utente() {}
	
	public String novoUtente(int id, String nome, String sexo, int idade, String profissao) {
		repUtentes.iniRepositorioUtentes();
		
		if(repUtentes.checkUtenteID(id) != null) 
			return "Utente j· existe";
		
		setId(id);
		
		setNome(nome);
		
		setSexo(sexo);

		setIdade(idade);

		setProfissao(profissao);
		
		if(!repUtentes.addUtente(this))
			return "Erro a adicionar Utente ao RepositÛrio de Utentes";
		
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
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String s) {
		this.sexo = s;
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
	
	public double getTMB(){
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		double resultado = 0;
		System.out.println(rep.getDadosFisicos(this.getId()));
		double pe = Double.parseDouble((rep.getDadosFisicos(this.getId()).getPeso()));
		double al = Double.parseDouble((rep.getDadosFisicos(this.getId()).getAltura()));
		
		if (this.getSexo().equals("Feminino"))
			resultado = 655.1 + (9.5 * pe) + (1.8 * al) + (4.7 * this.getIdade());
		else 
			resultado = 66.5 + (13.8 * pe) + (5 * al) + (6.8 * this.getIdade());
		
		return resultado;
	}
	
	public double getHarrisBenedict() {
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		
		return this.getTMB() * Double.parseDouble(rep.getDadosFisicos(this.getId()).getFatorAtividade()) * Double.parseDouble(rep.getDadosFisicos(this.getId()).getFatorLesao()) * Double.parseDouble(rep.getDadosFisicos(this.getId()).getFatorTermico());
	}
	
}
