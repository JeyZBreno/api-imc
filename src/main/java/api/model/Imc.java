package api.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imc {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float peso;
	private float altura;
	private float imc;
	private String retorno;
	
	public Imc(float peso, float altura) {
		this.imc = (float)Math.round(peso / (Math.pow(altura, altura)));
	}
	
	public String getRetorno() {
		
		if(imc < 18.5) {
			this.retorno = "IMC: " + imc + ". Classificado como abaixo do peso. Risco para sua Saúde Elevado.";
		}else if(imc >= 18.50 && imc < 25.50) {
			this.retorno = "IMC: " + imc + ". Classificado como Peso ideal. Risco para sua Saúde Inexistente.";
		}else if(imc >= 25.00 && imc < 30.00) {
			this.retorno = "IMC: "+ imc +". Classificado com Excesso de Peso. Risco para sua Saúde Elevado.";
		}else if(imc >= 30.00 && imc < 35.00) {
			this.retorno = "IMC: " + imc + ". Classificado Obesidade Grau 1. Risco para sua Saúde Muito Elevado.";
		}else if(imc >= 35.00 && imc < 40.00) {
			this.retorno = "IMC: " + imc + ". Classificado Obseidade Grau 2. Risco para sua Saúde Muitíssimo Elevado.";
		}else if(imc >= 40) {
			this.retorno = "IMC: " + imc + ". Classificado Obesidade Grau 3. Risco para sua Saúde Obesidade Mórbida.";
		}
		return retorno;
	
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getImc() {
		return imc;
	}
	public void setImc(float imc) {
		this.imc = imc;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + Float.floatToIntBits(imc);
		result = prime * result + Float.floatToIntBits(peso);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imc other = (Imc) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (Float.floatToIntBits(imc) != Float.floatToIntBits(other.imc))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		return true;
	}

	
}
