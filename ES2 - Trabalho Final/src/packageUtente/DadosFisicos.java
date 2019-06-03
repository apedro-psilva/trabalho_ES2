package packageUtente;

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
	

	public DadosFisicos() {}
	
	public String novoDadosFisicos(String peso, String altura, String imc, String bf, String gorduraVisceral, String musculo,
			String h2o, String osso, String idadeMetabolica, String metabolismoBasal) {

		setPeso(peso);
		setAltura(altura);
		setImc(imc);
		setBf(bf);
		setGorduraVisceral(gorduraVisceral);
		setMusculo(musculo);
		setH2o(h2o);
		setOsso(osso);
		setIdadeMetabolica(idadeMetabolica);
		setMetabolismoBasal(metabolismoBasal);
		
		return "Sucesso";
	}

	public String getPeso() {
		return peso;
	}
	
	private void setPeso(String peso) {
		this.peso = peso;
	}
	
	public String getAltura() {
		return altura;
	}
	
	private void setAltura(String altura) {
		this.altura = altura;
	}
	
	public String getImc() {
		return imc;
	}
	
	private void setImc(String imc) {
		this.imc = imc;
	}
	
	public String getBf() {
		return bf;
	}
	
	private void setBf(String bf) {
		this.bf = bf;
	}
	
	public String getGorduraVisceral() {
		return gorduraVisceral;
	}
	
	private void setGorduraVisceral(String gorduraVisceral) {
		this.gorduraVisceral = gorduraVisceral;
	}
	
	public String getMusculo() {
		return musculo;
	}
	
	private void setMusculo(String musculo) {
		this.musculo = musculo;
	}
	
	public String getH20() {
		return h2o;
	}
	
	private void setH2o(String h2o) {
		this.h2o = h2o;
	}
	
	public String getOsso() {
		return osso;
	}
	private void setOsso(String osso) {
		this.osso = osso;
	}
	
	public String getIdadeMetabolica() {
		return idadeMetabolica;
	}
	
	private void setIdadeMetabolica(String idadeMetabolica) {
		this.idadeMetabolica = idadeMetabolica;
	}
	
	public String getMetabolismoBasal() {
		return metabolismoBasal;
	}
	
	private void setMetabolismoBasal(String metabolismoBasal) {
		this.metabolismoBasal = metabolismoBasal;
	}
}
