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
		
		String regexNome = "^[A-Za-z�������������������������������'\\s]+$"; 
		af.add("Sedent�rio"); af.add("Moderadamente Ativo"); af.add("Ativo"); af.add("Muito Ativo");
		fi.add("Normal"); fi.add("Obstipado"); fi.add("Diarreias");
		ca.add("Menos de 0.5L"); ca.add("0.5L a 1L"); ca.add("1.5L a 2L"); ca.add("Mais de 2L");
		
		setId(id);
		
		if(dados.get("Nome").length() == 0)
			return "Nome do Utente vazio";
		
		if(!dados.get("Nome").matches(regexNome))
			return "Nome do Utente Inv�lido";
		
		setNome(dados.get("Nome"));
		
		if(dados.get("Sexo").length() == 0)
			return "Sexo do Utente vazio";
		
		if(!dados.get("Sexo").equals("Masculino") && !dados.get("Sexo").equals("Feminino"))
			return "Sexo do Utente Inv�lido";
		
		setSexo(dados.get("Sexo"));
		
		
		if(dados.get("Idade").length() == 0)
			return "Idade do Utente vazia";
		
		try {
			if(Integer.parseInt(dados.get("Idade")) < 0) {
				return "Idade do Utente abaixo dos valores v�lidos";
			}
			
			if(Integer.parseInt(dados.get("Idade")) >= 150)
				return "Idade do Utente acima dos valores v�lidos";
			
			setIdade(dados.get("Idade"));
		}
		catch(NumberFormatException e) {
			return "Idade do Utente Inv�lida";
		}
			
		if(dados.get("Profiss�o").length() == 0)
			return "Profiss�o do Utente vazia";
		
		if(!dados.get("Profiss�o").matches(regexNome))
			return "Profiss�o do Utente Inv�lida";
		
		setProfissao(dados.get("Profiss�o"));
		 
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
		
		if(dados.get("Medica��o").length() == 0)
			return "Medica��o do Utente vazia";
		
		if(dados.get("Medica��o").length() > 100)
			return "Medica��o do Utente com mais de 100 caracteres";
		
		setMedicacao(dados.get("Medica��o"));
		
		if(dados.get("Antecedentes Familiares").length() == 0)
			return "Antecedentes Familiares do Utente vazios";
		
		if(dados.get("Antecedentes Familiares").length() > 100)
			return "Antecedentes Familiares do Utente com mais de 100 caracteres";
		
		setAntecedentesFamiliares(dados.get("Antecedentes Familiares"));
		
		if(!af.contains(dados.get("Atividade Fisica")))
			return "Atividade Fisica do Utente Inv�lida";
		
		setAtividadeFisica(dados.get("Atividade Fisica"));

		if(!fi.contains(dados.get("Fun��o Intestinal")))
			return "Fun��o Intestinal do Utente Inv�lida";
		
		setFuncaoIntestinal(dados.get("Fun��o Intestinal"));

		if(!ca.contains(dados.get("Consumo de �gua")))
			return "Consumo de �gua do Utente Inv�lido";
		
		setConsumoAgua(dados.get("Consumo de �gua"));

		if(dados.get("Colesterol").length() == 0)
			return "Colesterol do Utente vazio";
		
		try {
			if(Double.parseDouble(dados.get("Colesterol")) < 0)
				return "Colesterol do Utente abaixo dos valores v�lidos";
			
			if(Double.parseDouble(dados.get("Colesterol")) >= 23)
				return "Colesterol do Utente acima dos valores v�lidos";
			
			dadosQuiBio.put("Colesterol", dados.get("Colesterol"));
		}
		catch(NumberFormatException e) {
			return "Colesterol do Utente Inv�lido";
		}
		
		if(dados.get("Creatinina").length() == 0)
			return "Creatinina do Utente vazio";
		
		try {
			if(Double.parseDouble(dados.get("Creatinina")) < 0)
				return "Creatinina do Utente abaixo dos valores v�lidos";
			
			if(Double.parseDouble(dados.get("Creatinina")) >= 23)
				return "Creatinina do Utente acima dos valores v�lidos";
			
			dadosQuiBio.put("Creatinina", dados.get("Creatinina"));
		}
		catch(NumberFormatException e) {
			return "Creatinina do Utente Inv�lida";
		}
		

		if(dados.get("Glic�mia").length() == 0)
			return "Glic�mia do Utente vazio";
		
		try {
			if(Double.parseDouble(dados.get("Glic�mia")) < 0)
				return "Glic�mia do Utente abaixo dos valores v�lidos";
			
			if(Double.parseDouble(dados.get("Glic�mia")) >= 23)
				return "Glic�mia do Utente acima dos valores v�lidos";
			
			dadosQuiBio.put("Glic�mia", dados.get("Glic�mia"));
		}
		catch(NumberFormatException e) {
			return "Glic�mia do Utente Inv�lida";
		}
		

		if(dados.get("Ureia").length() == 0)
			return "Ureia do Utente vazia";
		
		try {
			if(Double.parseDouble(dados.get("Ureia")) < 0)
				return "Ureia do Utente abaixo dos valores v�lidos";
			
			if(Double.parseDouble(dados.get("Ureia")) >= 23)
				return "Ureia do Utente acima dos valores v�lidos";
			
			dadosQuiBio.put("Ureia", dados.get("Ureia"));
		}
		catch(NumberFormatException e) {
			return "Ureia do Utente Inv�lida";
		}
		

		if(dados.get("Prob. C reativa").length() == 0)
			return "Prob. C reativa do Utente vazia";
		
		try {
			if(Double.parseDouble(dados.get("Prob. C reativa")) < 0)
				return "Prob. C reativa do Utente abaixo dos valores v�lidos";
			
			if(Double.parseDouble(dados.get("Prob. C reativa")) >= 30)
				return "Prob. C reativa do Utente acima dos valores v�lidos";
			
			dadosQuiBio.put("Prob. C reativa", dados.get("Prob. C reativa"));
		}
		catch(NumberFormatException e) {
			return "Prob. C reativa do Utente Inv�lida";
		}

		setDadosQuimicosBiologicos(dadosQuiBio);
		
		return "Sucesso a carregar o Question�rio";
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
