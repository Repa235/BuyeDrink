package it.unirc.twd.BuyeDrink.retribuisce;

import java.sql.Date;

public class Retribuisce {
	
	private int idTitolare;
	private int idMagazziniere;
	private double importo;
	private Date dataPagamento;
	
	
	public Retribuisce(int idTitolare, int idMagazziniere, double importo, Date dataPagamento) {
		super();
		this.idTitolare = idTitolare;
		this.idMagazziniere = idMagazziniere;
		this.importo = importo;
		this.dataPagamento = dataPagamento;
	}


	public Retribuisce() {
		super();
	}


	public int getIdTitolare() {
		return idTitolare;
	}


	public void setIdTitolare(int idTitolare) {
		this.idTitolare = idTitolare;
	}


	public int getIdMagazziniere() {
		return idMagazziniere;
	}


	public void setIdMagazziniere(int idMagazziniere) {
		this.idMagazziniere = idMagazziniere;
	}


	public double getImporto() {
		return importo;
	}


	public void setImporto(double importo) {
		this.importo = importo;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + idMagazziniere;
		result = prime * result + idTitolare;
		long temp;
		temp = Double.doubleToLongBits(importo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Retribuisce other = (Retribuisce) obj;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (idMagazziniere != other.idMagazziniere)
			return false;
		if (idTitolare != other.idTitolare)
			return false;
		if (Double.doubleToLongBits(importo) != Double.doubleToLongBits(other.importo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Retribuisce [idTitolare=" + idTitolare + ", idMagazziniere=" + idMagazziniere + ", importo=" + importo
				+ ", dataPagamento=" + dataPagamento + "]";
	}
	
	
	
	

}
