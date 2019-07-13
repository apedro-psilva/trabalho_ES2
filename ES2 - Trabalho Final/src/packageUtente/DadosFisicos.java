package packageUtente;

import java.util.ArrayList;
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

	ArrayList<Double> fa = new ArrayList<Double>();
	ArrayList<Double> fl = new ArrayList<Double>();
	ArrayList<Double> ft = new ArrayList<Double>();



	public DadosFisicos() {}

	public String novoDadosFisicos(HashMap<String,String> dados) {
		fa.add(1.2); fa.add(1.25); fa.add(1.3);
		fl.add(1.0); fl.add(1.1); fl.add(1.2); fl.add(1.3); fl.add(1.4); fl.add(1.5); fl.add(1.6); fl.add(1.7); fl.add(1.8); fl.add(2.0);
		ft.add(1.1); ft.add(1.2); ft.add(1.3); ft.add(1.4);

		try {
			if(dados.get("Peso").length() == 0)
				return "Peso vazio";

			if(Integer.parseInt(dados.get("Peso")) < 10)
				return "Peso abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("Peso")) >= 400)
				return "Peso acima dos valores v�lidos";

			setPeso(dados.get("Peso"));
		}
		catch(NumberFormatException e) {
			return "Peso Inv�lido";
		}


		try {
			if(dados.get("Altura").length() == 0)
				return "Altura vazia";

			if(Integer.parseInt(dados.get("Altura")) < 10)
				return "Altura abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("Altura")) >= 300)
				return "Altura acima dos valores v�lidos";

			setAltura(dados.get("Altura"));
		}
		catch(NumberFormatException e) {
			return "Altura Inv�lida";
		}

		try {
			if(dados.get("IMC").length() == 0)
				return "IMC vazio";

			if(Integer.parseInt(dados.get("IMC")) < 0)
				return "IMC abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("IMC")) >= 40)
				return "IMC acima dos valores v�lidos";

			setImc(dados.get("IMC"));
		}
		catch(NumberFormatException e) {
			return "IMC Inv�lido";
		};

		try {
			if(dados.get("B.F").length() == 0)
				return "B.F vazio";

			if(Integer.parseInt(dados.get("B.F")) < 0)
				return "B.F abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("B.F")) >= 80)
				return "B.F acima dos valores v�lidos";

			setBf(dados.get("B.F"));
		}
		catch(NumberFormatException e) {
			return "B.F Inv�lido";
		};

		try {
			if(dados.get("Gordura visceral").length() == 0)
				return "Gordura visceral vazia";

			if(Integer.parseInt(dados.get("Gordura visceral")) < 0)
				return "Gordura visceral abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("Gordura visceral")) >= 60)
				return "Gordura visceral acima dos valores v�lidos";

			setGorduraVisceral(dados.get("Gordura visceral"));
		}
		catch(NumberFormatException e) {
			return "Gordura visceral Inv�lida";
		};

		try {
			if(dados.get("Musculo").length() == 0)
				return "Musculo vazio";

			if(Integer.parseInt(dados.get("Musculo")) < 0)
				return "Musculo abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("Musculo")) >= 100)
				return "Musculo acima dos valores v�lidos";

			setMusculo(dados.get("Musculo"));
		}
		catch(NumberFormatException e) {
			return "Musculo Inv�lido";
		};

		try {
			if(dados.get("H2O").length() == 0)
				return "H2O vazio";

			if(Integer.parseInt(dados.get("H2O")) < 0)
				return "H2O abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("H2O")) >= 40)
				return "H2O acima dos valores v�lidos";

			setH2o(dados.get("H2O"));
		}
		catch(NumberFormatException e) {
			return "H2O Inv�lido";
		};

		try {
			if(dados.get("Osso").length() == 0)
				return "Osso vazio";

			if(Integer.parseInt(dados.get("Osso")) < 0)
				return "Osso abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("Osso")) >= 4)
				return "Osso acima dos valores v�lidos";

			setOsso(dados.get("Osso"));
		}
		catch(NumberFormatException e) {
			return "Osso Inv�lido";
		};

		try {
			if(dados.get("Idade Metabolica").length() == 0)
				return "Idade Metabolica vazia";

			if(Integer.parseInt(dados.get("Idade Metabolica")) < 0)
				return "Idade Metabolica abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("Idade Metabolica")) >= 70)
				return "Idade Metabolica acima dos valores v�lidos";

			setIdadeMetabolica(dados.get("Osso"));
		}
		catch(NumberFormatException e) {
			return "Idade Metabolica Inv�lida";
		};

		try {
			if(dados.get("Metabolismo Basal").length() == 0)
				return "Metabolismo Basal vazio";

			if(Integer.parseInt(dados.get("Metabolismo Basal")) < 0)
				return "Metabolismo Basal abaixo dos valores v�lidos";

			if(Integer.parseInt(dados.get("Metabolismo Basal")) >= 50)
				return "Metabolismo Basal acima dos valores v�lidos";

			setMetabolismoBasal(dados.get("Metabolismo Basal"));
		}
		catch(NumberFormatException e) {
			return "Metabolismo Basal Inv�lido";
		};

		try {
			if(!fa.contains(Double.parseDouble(dados.get("Fator Atividade"))))
				return "Fator Atividade Inv�lido";

			setFatorAtividade(dados.get("Fator Atividade"));

		}
		catch (NumberFormatException e) {
			return "Fator Atividade Inv�lido";
		}

		try {
			if(!fl.contains(Double.parseDouble(dados.get("Fator Les�o"))))
				return "Fator Les�o Inv�lido";

			setFatorLesao(dados.get("Fator Les�o"));
		}
		catch (NumberFormatException e) {
			return "Fator Les�o Inv�lido";
		}

		try {
			if(!ft.contains(Double.parseDouble(dados.get("Fator T�rmico"))))
				return "Fator T�rmico Inv�lido";

			setFatorTermico(dados.get("Fator T�rmico"));
		}
		catch (NumberFormatException e) {
			return "Fator T�rmico Inv�lido";
		}

		return "Sucesso a carregar os Dados Fisicos";
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
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
