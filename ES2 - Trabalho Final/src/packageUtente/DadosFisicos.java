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
			return "Peso Inv�lido";
		setPeso(dados.get("Peso"));
		
		if(Integer.parseInt(dados.get("Altura")) < 0 || Integer.parseInt(dados.get("Altura")) >= 300)
			return "Altura Inv�lida";
		setAltura(dados.get("Altura"));
		
		if(Integer.parseInt(dados.get("IMC")) < 0 || Integer.parseInt(dados.get("IMC")) >= 40)
			return "IMC Inv�lido";
		setImc(dados.get("IMC"));
		
		if(Integer.parseInt(dados.get("B.F")) < 0 || Integer.parseInt(dados.get("B.F")) >= 80)
			return "B.F Inv�lido";
		setBf(dados.get("B.F"));
		
		if(Integer.parseInt(dados.get("Gordura visceral")) < 0 || Integer.parseInt(dados.get("Gordura visceral")) >= 60)
			return "Gordura Visceral Inv�lida";
		setGorduraVisceral(dados.get("Gordura visceral"));
		
		if(Integer.parseInt(dados.get("Musculo")) < 0 || Integer.parseInt(dados.get("Musculo")) >= 100)
			return "Musculo Inv�lido";
		setMusculo(dados.get("Musculo"));
		
		if(Integer.parseInt(dados.get("H2O")) < 0 || Integer.parseInt(dados.get("H2O")) >= 40)
			return "H2O Inv�lido";
		setH2o(dados.get("H2O"));
		
		if(Integer.parseInt(dados.get("Osso")) < 0 || Integer.parseInt(dados.get("Osso")) >= 4)
			return "Osso Inv�lido";
		setOsso(dados.get("Osso"));
		
		if(Integer.parseInt(dados.get("Idade Metabolica")) < 0 || Integer.parseInt(dados.get("Idade Metabolica")) >= 70)
			return "Idade Metabolica Inv�lida";
		setIdadeMetabolica(dados.get("Idade Metabolica"));
		
		if(Integer.parseInt(dados.get("Metabolismo Basal")) < 0 || Integer.parseInt(dados.get("Metabolismo Basal")) >= 50)
			return "Metabolismo Basal Inv�lido";
		setMetabolismoBasal(dados.get("Metabolismo Basal"));
		
		if(Double.parseDouble(dados.get("Fator Atividade")) < 1.2 || Double.parseDouble(dados.get("Fator Atividade")) > 1.3)
			return "Fator Atividade Inv�lido";
		setFatorAtividade(dados.get("Fator Atividade"));
		
		if(Double.parseDouble(dados.get("Fator Les�o")) < 1 || Double.parseDouble(dados.get("Fator Les�o")) > 2)
			return "Fator Les�o Inv�lido";
		setFatorLesao(dados.get("Fator Les�o"));
		
		if(Double.parseDouble(dados.get("Fator T�rmico")) < 1.1 || Double.parseDouble(dados.get("Fator T�rmico")) > 1.4)
			return "Fator T�rmico Inv�lido";
		setFatorTermico(dados.get("Fator T�rmico"));
		
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
