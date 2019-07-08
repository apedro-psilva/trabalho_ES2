package packageQuestionario;

import java.util.ArrayList;
import java.util.HashMap;

public class Questionario {
	private int id;
	private String nome = null;
	private String sexo = null;
	private String idade = null;
	private String profissao = null;
	private String motivo = null;
	private String objetivos = null;
	private String patologias = null;
	private String medicacao = null;
	private String antecedentesFamiliares = null;
	private String atividadeFisica = null;
	private String funcaoIntestinal = null;
	private String consumoAgua = null;
	private HashMap<String, String> dadosQuimicosBiologicos = null;
	
	ArrayList<String> af = new ArrayList<String>();
	ArrayList<String> fi = new ArrayList<String>();
	ArrayList<String> ca = new ArrayList<String>();
	
	
	public Questionario() {};

	public String novoQuestionario(int id,HashMap<String, String> dados) {
		
		String regexNome = "^[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˙ÁÒ¡¿¬√…»Õœ”‘’÷⁄«—'\\s]+$"; 
		af.add("Sedent·rio");af.add("Moderadamente Ativo");af.add("Ativo");af.add("Muito Ativo");
		fi.add("Normal");fi.add("Obstipado");fi.add("Diarreias");
		ca.add("Menos de 0.5L");ca.add("0.5L a 1L");ca.add("1.5L a 2L");ca.add("Mais de 2L");
		
		setId(id);

		if(!dados.get("Nome").matches(regexNome))
			return "Nome do Utente " + dados.get("Nome") + " Inv·lido";
		setNome(dados.get("Nome"));
		
		
		if(!dados.get("Sexo").equals("Masculino") && !dados.get("Sexo").equals("Feminino"))
			return "Sexo do Utente " + dados.get("Nome") + " inv·lido";
		setSexo(dados.get("Sexo"));
		
		
		if(Integer.parseInt(dados.get("Idade")) < 0 || Integer.parseInt(dados.get("Idade")) >= 150)
			return "Idade do utente " + dados.get("Idade");
		setIdade(dados.get("Idade"));
		
		
		if(!dados.get("Profiss„o").matches(regexNome))
			return "Profiss„o do Utente " + dados.get("Nome") + " Inv·lido";
		setProfissao(dados.get("Profiss„o"));
		
		setMotivo(dados.get("Motivo"));
		
		setObjetivos(dados.get("Objectivo"));
		
		setPatologias(dados.get("Patologias"));
		
		setMedicacao(dados.get("MedicaÁ„o"));
		
		setAntecedentesFamiliares(dados.get("Antecedentes Familiares"));
		
		
		if(!af.contains(dados.get("Atividade Fisica")))
			return "Atividade fisica do Utente " + dados.get("Nome") + " Inv·lida";
		setAtividadeFisica(dados.get("Atividade Fisica"));


		if(!fi.contains(dados.get("FunÁ„o Intestinal")))
			return "FunÁ„o Intestinal do Utente " + dados.get("Nome") + " inv·lida";
		setFuncaoIntestinal(dados.get("FunÁ„o Intestinal"));


		if(!ca.contains(dados.get("Consumo de ¡gua")))
			return "Consumo de ¡gua do Utente " + dados.get("Nome") + " inv·lida";
		setConsumoAgua(dados.get("Consumo de ¡gua"));


		if(Double.parseDouble(dados.get("Colesterol")) < 0 || Double.parseDouble(dados.get("Colesterol")) >= 23)
			return "Colesterol do Utente " + dados.get("Nome") + " inv·lido";
		

		if(Double.parseDouble(dados.get("Creatinina")) < 0 || Double.parseDouble(dados.get("Creatinina")) >= 23)
			return "Creatinina do Utente " + dados.get("Nome") + " inv·lido";


		if(Double.parseDouble(dados.get("GlicÈmia")) < 0 || Double.parseDouble(dados.get("GlicÈmia")) >= 23)
			return "GlicÈmia do Utente " + dados.get("Nome") + " inv·lido";


		if(Double.parseDouble(dados.get("Ureia")) < 0 || Double.parseDouble(dados.get("Ureia")) >= 23)
			return "Ureia do Utente " + dados.get("Nome") + " inv·lido";


		if(Double.parseDouble(dados.get("Prob. C reativa")) < 0 || Double.parseDouble(dados.get("Prob. C reativa")) >= 33)
			return "Prob. C reativa do Utente " + dados.get("Nome") + " inv·lido";
		
		setDadosQuimicosBiologicos(dados);
		return "Sucesso a carregar o Question·rio";
	}
	
	private void setId(int i) {
		id = i;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}

	private void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIdade() {
		return idade;
	}

	private void setIdade(String idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	private void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getMotivo() {
		return motivo;
	}

	private void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObjetivos() {
		return objetivos;
	}

	private void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getPatologias() {
		return patologias;
	}

	private void setPatologias(String patologias) {
		this.patologias = patologias;
	}

	public String getMedicacao() {
		return medicacao;
	}

	private void setMedicacao(String medicacao) {
		this.medicacao = medicacao;
	}

	public String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}

	private void setAntecedentesFamiliares(String antecedentesFamiliares) {
		this.antecedentesFamiliares = antecedentesFamiliares;
	}

	public String getAtividadeFisica() {
		return atividadeFisica;
	}

	private void setAtividadeFisica(String atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}

	public String getFuncaoIntestinal() {
		return funcaoIntestinal;
	}

	private void setFuncaoIntestinal(String funcaoIntestinal) {
		this.funcaoIntestinal = funcaoIntestinal;
	}

	public String getConsumoAgua() {
		return consumoAgua;
	}

	private void setConsumoAgua(String consumoAgua) {
		this.consumoAgua = consumoAgua;
	}

	public HashMap<String, String> getDadosQuimicosBiologicos() {
		return dadosQuimicosBiologicos;
	}

	private void setDadosQuimicosBiologicos(HashMap<String, String> dadosQuimicosBiologicos) {
		this.dadosQuimicosBiologicos = dadosQuimicosBiologicos;
	}
	
	public void printQ() {
		System.out.println(nome);
		System.out.println(idade);
		System.out.println(profissao);
		System.out.println(motivo);
		System.out.println(objetivos);
		System.out.println(patologias);
		System.out.println(medicacao);
		System.out.println(antecedentesFamiliares);
		System.out.println(atividadeFisica);
		System.out.println(funcaoIntestinal);
		System.out.println(consumoAgua);
		
		for(String k: dadosQuimicosBiologicos.keySet()) {
			System.out.println(k + ": " + dadosQuimicosBiologicos.get(k));
		}
	}

}
