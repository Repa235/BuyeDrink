package it.unirc.twd.BuyeDrink.Statistiche;

public class Statistiche {
	
	private int numOrdini;
	private int mese;
	private int anno;
	private double incasso;
	
	
	public Statistiche(int numOrdini, int mese, int anno) {
		super();
		this.numOrdini = numOrdini;
		this.mese = mese;
		this.anno = anno;
		
	}
	
	public Statistiche(double incasso) {
		this.incasso=incasso;
	}


	public Statistiche() {
		super();
	}




	public double getIncasso() {
		return incasso;
	}




	public void setIncasso(double incasso) {
		this.incasso = incasso;
	}




	public int getNumOrdini() {
		return numOrdini;
	}


	public void setNumOrdini(int numOrdini) {
		this.numOrdini = numOrdini;
	}


	public int getMese() {
		return mese;
	}


	public void setMese(int mese) {
		this.mese = mese;
	}


	public int getAnno() {
		return anno;
	}


	public void setAnno(int anno) {
		this.anno = anno;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		long temp;
		temp = Double.doubleToLongBits(incasso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + mese;
		result = prime * result + numOrdini;
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
		Statistiche other = (Statistiche) obj;
		if (anno != other.anno)
			return false;
		if (Double.doubleToLongBits(incasso) != Double.doubleToLongBits(other.incasso))
			return false;
		if (mese != other.mese)
			return false;
		if (numOrdini != other.numOrdini)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Statistiche [numOrdini=" + numOrdini + ", mese=" + mese + ", anno=" + anno + ", incasso=" + incasso
				+ "]";
	}



}
