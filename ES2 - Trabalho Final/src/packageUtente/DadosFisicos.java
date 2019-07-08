package packageUtente;

import java.util.HashMap;

import packageRepositorios.RepositorioDados;

public class DadosFisicos {
	private String peso = null;
	private String altura = null;
	private String imc = null;
	private String bf = null;
	private String gorduraVisceral = null;
	private String musculo = null;
	private String h2o = null;
	private String osso = null; 
	private String idadeMetabolica = null;
	private String metabolismoBasal = null;
	private String FA = null;
	private String FL = null;
	private String FT = null;
	
	

	public DadosFisicos() {}
	
	public String novoDadosFisicos(HashMap<String,String> dados) {

		
		if(!setPeso(dados.get("Peso")))
			return "Peso Inválido";
		setPeso(dados.get("Peso"));
		
		if(Integer.parseInt(dados.get("Altura")) < 0 || Integer.parseInt(dados.get("Altura")) >= 300)
			return "Altura Inválida";
		setAltura(dados.get("Altura"));
		
		if(Integer.parseInt(dados.get("IMC")) < 0 || Integer.parseInt(dados.get("IMC")) >= 40)
			return "IMC Inválido";
		setImc(dados.get("IMC"));
		
		if(Integer.parseInt(dados.get("B.F")) < 0 || Integer.parseInt(dados.get("B.F")) >= 80)
			return "B.F Inválido";
		setBf(dados.get("B.F"));
		
		if(Integer.parseInt(dados.get("Gordura visceral")) < 0 || Integer.parseInt(dados.get("Gordura visceral")) >= 60)
			return "Gordura Visceral Inválida";
		setGorduraVisceral(dados.get("Gordura visceral"));
		
		if(Integer.parseInt(dados.get("Musculo")) < 0 || Integer.parseInt(dados.get("Musculo")) >= 100)
			return "Musculo Inválido";
		setMusculo(dados.get("Musculo"));
		
		if(Integer.parseInt(dados.get("H2O")) < 0 || Integer.parseInt(dados.get("H2O")) >= 40)
			return "H2O Inválido";
		setH2o(dados.get("H2O"));
		
		if(Integer.parseInt(dados.get("Osso")) < 0 || Integer.parseInt(dados.get("Osso")) >= 4)
			return "Osso Inválido";
		setOsso(dados.get("Osso"));
		
		if(Integer.parseInt(dados.get("Idade Metabolica")) < 0 || Integer.parseInt(dados.get("Idade Metabolica")) >= 70)
			return "Idade Metabolica Inválida";
		setIdadeMetabolica(dados.get("Idade Metabolica"));
		
		if(Integer.parseInt(dados.get("Metabolismo Basal")) < 0 || Integer.parseInt(dados.get("Metabolismo Basal")) >= 50)
			return "Metabolismo Basal Inválido";
		setMetabolismoBasal(dados.get("Metabolismo Basal"));
		
		if(Double.parseDouble(dados.get("Fator Atividade")) < 1.2 || Double.parseDouble(dados.get("Fator Atividade")) > 1.3)
			return "Fator Atividade Inválido";
		setFatorAtividade(dados.get("Fator Atividade"));
		
		if(Double.parseDouble(dados.get("Fator Lesão")) < 1 || Double.parseDouble(dados.get("Fator Lesão")) > 2)
			return "Fator Lesão Inválido";
		setFatorLesao(dados.get("Fator Lesão"));
		
		if(Double.parseDouble(dados.get("Fator Térmico")) < 1.1 || Double.parseDouble(dados.get("Fator Térmico")) > 1.4)
			return "Fator Térmico Inválido";
		setFatorTermico(dados.get("Fator Térmico"));
		
		return "Sucesso a carregar os Dados Fisicos";
	}

	public String getPeso() {
		return peso;
	}
	
	public boolean setPeso(String peso) {
		if(Integer.parseInt(peso) < 10 || Integer.parseInt(peso) >= 400)
			return false;
		
		this.peso = peso;
		return true;
	}
	
	public String getAltura() {
		return altura;
	}
	
	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	public String getImc() {
		return imc;
	}
	
	public void setImc(String imc) {
		this.imc = imc;
	}
	
	public String getBf() {
		return bf;
	}
	
	public void setBf(String bf) {
		this.bf = bf;
	}
	
	public String getGorduraVisceral() {
		return gorduraVisceral;
	}
	
	public void setGorduraVisceral(String gorduraVisceral) {
		this.gorduraVisceral = gorduraVisceral;
	}
	
	public String getMusculo() {
		return musculo;
	}
	
	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}
	
	public String getH20() {
		return h2o;
	}
	
	public void setH2o(String h2o) {
		this.h2o = h2o;
	}
	
	public String getOsso() {
		return osso;
	}
	public void setOsso(String osso) {
		this.osso = osso;
	}
	
	public String getIdadeMetabolica() {
		return idadeMetabolica;
	}
	
	public void setIdadeMetabolica(String idadeMetabolica) {
		this.idadeMetabolica = idadeMetabolica;
	}
	
	public String getMetabolismoBasal() {
		return metabolismoBasal;
	}
	
	public void setMetabolismoBasal(String metabolismoBasal) {
		this.metabolismoBasal = metabolismoBasal;
	}
	
	public String getFatorAtividade() {
		return this.FA;
	}
	
	public void setFatorAtividade(String fa) {
		this.FA = fa;
	}
	
	public String getFatorLesao() {
		return this.FL;
	}
	
	public void setFatorLesao(String fl) {
		this.FL = fl;
	}
	
	public String getFatorTermico() {
		return this.FT;
	}
	
	public void setFatorTermico(String ft) {
		this.FT = ft;
	}
}
