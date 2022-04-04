package it.unirc.twd.BuyeDrink.titolare;

public class Titolare {

	private int idTit;
	private String nome;
	private String cognome;
	private String email;
	private String partitaIva;
	private String codiceFiscale;
	private String password;
	
	
	public Titolare(int idTit, String nome, String cognome, String email, String partitaIva, String codiceFiscale, String password) {
		super();
		this.idTit = idTit;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.partitaIva = partitaIva;
		this.codiceFiscale = codiceFiscale;
		this.password=password;
	}


	public Titolare() {
		// TODO Auto-generated constructor stub
	}


	public int getIdTit() {
		return idTit;
	}


	public void setIdTit(int idTit) {
		this.idTit = idTit;
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


	public String getPartitaIva() {
		return partitaIva;
	}


	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idTit;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((partitaIva == null) ? 0 : partitaIva.hashCode());
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
		Titolare other = (Titolare) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idTit != other.idTit)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (partitaIva == null) {
			if (other.partitaIva != null)
				return false;
		} else if (!partitaIva.equals(other.partitaIva))
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
		return "Titolare [idTit=" + idTit + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", partitaIva=" + partitaIva + ", codiceFiscale=" + codiceFiscale + ", password=" + password + "]";
	}
	
	
	
	
	
}
