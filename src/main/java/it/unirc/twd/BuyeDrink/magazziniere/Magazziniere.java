package it.unirc.twd.BuyeDrink.magazziniere;

import java.util.Date;

public class Magazziniere {

	private int idMagazziniere;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int idTit;
	private Date dataAssunzione;
	
	public Magazziniere(int idMagazziniere, String nome, String cognome, String email, String password, int idTit,
			Date dataAssunzione) {
		super();
		this.idMagazziniere = idMagazziniere;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.idTit = idTit;
		this.dataAssunzione = dataAssunzione;
	}

	public Magazziniere() {
		super();
	}

	public int getIdMagazziniere() {
		return idMagazziniere;
	}

	public void setIdMagazziniere(int idMagazziniere) {
		this.idMagazziniere = idMagazziniere;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdTit() {
		return idTit;
	}

	public void setIdTit(int idTit) {
		this.idTit = idTit;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataAssunzione == null) ? 0 : dataAssunzione.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idMagazziniere;
		result = prime * result + idTit;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Magazziniere other = (Magazziniere) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataAssunzione == null) {
			if (other.dataAssunzione != null)
				return false;
		} else if (!dataAssunzione.equals(other.dataAssunzione))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idMagazziniere != other.idMagazziniere)
			return false;
		if (idTit != other.idTit)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Magazziniere [idMagazziniere=" + idMagazziniere + ", nome=" + nome + ", cognome=" + cognome + ", email="
				+ email + ", password=" + password + ", idTit=" + idTit + ", dataAssunzione=" + dataAssunzione + "]";
	}
	
	

	
	
}