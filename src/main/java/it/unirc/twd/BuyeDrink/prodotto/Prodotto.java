package it.unirc.twd.BuyeDrink.prodotto;





public class Prodotto {

	
	private int quantit�;
	private int codice;
	private String marca;
	private String nome;
	private double prezzo;
	
	
	public Prodotto(int quantit�, int codice, String marca, String nome, double prezzo) {
		super();
		this.quantit� = quantit�;
		this.codice = codice;
		this.marca = marca;
		this.nome = nome;
		this.prezzo = prezzo;
	}


	public Prodotto() {
		super();
	}


	public int getQuantit�() {
		return quantit�;
	}


	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}


	public int getCodice() {
		return codice;
	}


	public void setCodice(int codice) {
		this.codice = codice;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantit�;
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
		Prodotto other = (Prodotto) obj;
		if (codice != other.codice)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (quantit� != other.quantit�)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Prodotto [quantit�=" + quantit� + ", codice=" + codice + ", marca=" + marca + ", nome=" + nome
				+ ", prezzo=" + prezzo + "]";
	}
	
	
	
	

	
	
}
