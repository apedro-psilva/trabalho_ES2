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
		HashMap<String, String> dadosQuiBio = new HashMap<String, String>();
		
		String regexNome = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$"; 
		af.add("Sedentário"); af.add("Moderadamente Ativo"); af.add("Ativo"); af.add("Muito Ativo");
		fi.add("Normal"); fi.add("Obstipado"); fi.add("Diarreias");
		ca.add("Menos de 0.5L"); ca.add("0.5L a 1L"); ca.add("1.5L a 2L"); ca.add("Mais de 2L");
		
		setId(id);
		
		if(dados.get("Nome").length() == 0)
			return "Nome do Utente vazio";
		
		if(!dados.get("Nome").matches(regexNome))
			return "Nome do Utente Inválido";
		
		setNome(dados.get("Nome"));
		
		if(dados.get("Sexo").length() == 0)
			return "Sexo do Utente vazio";
		
		if(!dados.get("Sexo").equals("Masculino") && !dados.get("Sexo").equals("Feminino"))
			return "Sexo do Utente Inválido";
		
		setSexo(dados.get("Sexo"));
		
		
		if(dados.get("Idade").length() == 0)
			return "Idade do Utente vazia";
		
		try {
			if(Integer.parseInt(dados.get("Idade")) < 0) {
				return "Idade do Utente abaixo dos valores válidos";
			}
			
			if(Integer.parseInt(dados.get("Idade")) >= 150)
				return "Idade do Utente acima dos valores válidos";
			
			setIdade(dados.get("Idade"));
		}
		catch(NumberFormatException e) {
			return "Idade do Utente Inválida";
		}
			
		if(dados.get("Profissão").length() == 0)
			return "Profissão do Utente vazia";
		
		if(!dados.get("Profissão").matches(regexNome))
			return "Profissão do Utente Inválida";
		
		setProfissao(dados.get("Profissão"));
		 
		if(dados.get("Motivo da Consulta").length() == 0)
			return "Motivo da Consulta do Utente vazio";
		
		if(dados.get("Motivo da Consulta").length() > 100)
			return "Motivo da Consulta do Utente com mais de 100 caracteres";
		
		setMotivo(dados.get("Motivo da Consulta"));
		
		if(dados.get("Objectivo").length() == 0)
			return "Objectivo do Utente vazio";
		
		if(dados.get("Objectivo").length() > 100)
			return "Objectivo do Utente com mais de 100 caracteres";
		
		setObjetivos(dados.get("Objectivo"));
		
		if(dados.get("Patologias").length() == 0)
			return "Patologias do Utente vazias";
		
		if(dados.get("Patologias").length() > 100)
			return "Patologias do Utente com mais de 100 caracteres";
		
		setPatologias(dados.get("Patologias"));
		
		if(dados.get("Medicação").length() == 0)
			return "Medicação do Utente vazia";
		
		if(dados.get("Medicação").length() > 100)
			return "Medicação do Utente com mais de 100 caracteres";
		
		setMedicacao(dados.get("Medicação"));
		
		if(dados.get("Antecedentes Familiares").length() == 0)
			return "Antecedentes Familiares do Utente vazios";
		
		if(dados.get("Antecedentes Familiares").length() > 100)
			return "Antecedentes Familiares do Utente com mais de 100 caracteres";
		
		setAntecedentesFamiliares(dados.get("Antecedentes Familiares"));
		
		if(!af.contains(dados.get("Atividade Fisica")))
			return "Atividade Fisica do Utente Inválida";
		
		setAtividadeFisica(dados.get("Atividade Fisica"));

		if(!fi.contains(dados.get("Função Intestinal")))
			return "Função Intestinal do Utente Inválida";
		
		setFuncaoIntestinal(dados.get("Função Intestinal"));

		if(!ca.contains(dados.get("Consumo de Água")))
			return "Consumo de Água do Utente Inválido";
		
		setConsumoAgua(dados.get("Consumo de Água"));

		if(dados.get("Colesterol").length() == 0)
			return "Colesterol do Utente vazio";
		
		try {
			if(Double.parseDouble(dados.get("Colesterol")) < 0)
				return "Colesterol do Utente abaixo dos valores válidos";
			
			if(Double.parseDouble(dados.get("Colesterol")) >= 23)
				return "Colesterol do Utente acima dos valores válidos";
			
			dadosQuiBio.put("Colesterol", dados.get("Colesterol"));
		}
		catch(NumberFormatException e) {
			return "Colesterol do Utente Inválido";
		}
		
		if(dados.get("Creatinina").length() == 0)
			return "Creatinina do Utente vazio";
		
		try {
			if(Double.parseDouble(dados.get("Creatinina")) < 0)
				return "Creatinina do Utente abaixo dos valores válidos";
			
			if(Double.parseDouble(dados.get("Creatinina")) >= 23)
				return "Creatinina do Utente acima dos valores válidos";
			
			dadosQuiBio.put("Creatinina", dados.get("Creatinina"));
		}
		catch(NumberFormatException e) {
			return "Creatinina do Utente Inválida";
		}
		

		if(dados.get("Glicémia").length() == 0)
			return "Glicémia do Utente vazio";
		
		try {
			if(Double.parseDouble(dados.get("Glicémia")) < 0)
				return "Glicémia do Utente abaixo dos valores válidos";
			
			if(Double.parseDouble(dados.get("Glicémia")) >= 23)
				return "Glicémia do Utente acima dos valores válidos";
			
			dadosQuiBio.put("Glicémia", dados.get("Glicémia"));
		}
		catch(NumberFormatException e) {
			return "Glicémia do Utente Inválida";
		}
		

		if(dados.get("Ureia").length() == 0)
			return "Ureia do Utente vazia";
		
		try {
			if(Double.parseDouble(dados.get("Ureia")) < 0)
				return "Ureia do Utente abaixo dos valores válidos";
			
			if(Double.parseDouble(dados.get("Ureia")) >= 23)
				return "Ureia do Utente acima dos valores válidos";
			
			dadosQuiBio.put("Ureia", dados.get("Ureia"));
		}
		catch(NumberFormatException e) {
			return "Ureia do Utente Inválida";
		}
		

		if(dados.get("Prob. C reativa").length() == 0)
			return "Prob. C reativa do Utente vazia";
		
		try {
			if(Double.parseDouble(dados.get("Prob. C reativa")) < 0)
				return "Prob. C reativa do Utente abaixo dos valores válidos";
			
			if(Double.parseDouble(dados.get("Prob. C reativa")) >= 30)
				return "Prob. C reativa do Utente acima dos valores válidos";
			
			dadosQuiBio.put("Prob. C reativa", dados.get("Prob. C reativa"));
		}
		catch(NumberFormatException e) {
			return "Prob. C reativa do Utente Inválida";
		}

		setDadosQuimicosBiologicos(dadosQuiBio);
		
		return "Sucesso a carregar o Questionário";
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
