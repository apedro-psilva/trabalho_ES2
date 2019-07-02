package packageUtente;

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
	
	public String novoDadosFisicos(String peso, String altura, String imc, String bf, String gorduraVisceral, String musculo,
			String h2o, String osso, String idadeMetabolica, String metabolismoBasal, String fa, String fl, String ft) {

		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		rep.iniRepositorioDados();
		
		if(!setPeso(peso))
			return "Peso Inv�lido";
		
		
		if(Integer.parseInt(altura) < 0 || Integer.parseInt(altura) >= 300)
			return "Altura Inv�lida";
		setAltura(altura);
		
		if(Integer.parseInt(imc) < 0 || Integer.parseInt(imc) >= 40)
			return "IMC Inv�lido";
		setImc(imc);
		
		if(Integer.parseInt(bf) < 0 || Integer.parseInt(bf) >= 80)
			return "BF Inv�lido";
		setBf(bf);
		
		if(Integer.parseInt(gorduraVisceral) < 0 || Integer.parseInt(gorduraVisceral) >= 60)
			return "Gordura Visceral Inv�lida";
		setGorduraVisceral(gorduraVisceral);
		
		if(Integer.parseInt(musculo) < 0 || Integer.parseInt(musculo) >= 100)
			return "Musculo Inv�lido";
		setMusculo(musculo);
		
		if(Integer.parseInt(h2o) < 0 || Integer.parseInt(h2o) >= 40)
			return "H2O Inv�lido";
		setH2o(h2o);
		
		if(Integer.parseInt(osso) < 0 || Integer.parseInt(osso) >= 4)
			return "Osso Inv�lido";
		setOsso(osso);
		
		if(Integer.parseInt(idadeMetabolica) < 0 || Integer.parseInt(idadeMetabolica) >= 70)
			return "Idade Metabolica Inv�lida";
		setIdadeMetabolica(idadeMetabolica);
		
		if(Integer.parseInt(metabolismoBasal) < 0 || Integer.parseInt(metabolismoBasal) >= 50)
			return "Metabolismo Basal Inv�lido";
		setMetabolismoBasal(metabolismoBasal);
		
		if(Double.parseDouble(fa) < 1.2 || Double.parseDouble(fa) > 1.3)
			return "Fator Atividade Inv�lido";
		setFatorAtividade(fa);
		
		if(Double.parseDouble(fl) < 1 || Double.parseDouble(fl) > 2)
			return "Fator Les�o Inv�lido";
		setFatorLesao(fl);
		
		if(Double.parseDouble(ft) < 1.1 || Double.parseDouble(ft) > 1.4)
			return "Fator T�rmico Inv�lido";
		setFatorTermico(ft);
		
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
