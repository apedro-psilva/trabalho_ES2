package packageQuestionario;

import java.util.HashMap;

public class Questionario {
	private int id;
	private String nome = null;
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
	
	public Questionario() {};

	public String novoQuestionario(int id, String nome, String idade, String profissao, String motivo, String objetivos, String patologias,
			String medicacao, String antecedentesFamiliares, String atividadeFisica, String funcaoIntestinal,
			String consumoAgua, HashMap<String, String> dadosQuimicosBiologicos) {
		setId(id);
		setNome(nome);
		setIdade(idade);
		setProfissao(profissao);
		setMotivo(motivo);
		setObjetivos(objetivos);
		setPatologias(patologias);
		setMedicacao(medicacao);
		setAntecedentesFamiliares(antecedentesFamiliares);
		setAtividadeFisica(atividadeFisica);
		setFuncaoIntestinal(funcaoIntestinal);
		setConsumoAgua(consumoAgua);
		setDadosQuimicosBiologicos(dadosQuimicosBiologicos);
		
		return "Sucesso";
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
