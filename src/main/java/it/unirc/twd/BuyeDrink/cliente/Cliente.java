package it.unirc.twd.BuyeDrink.cliente;

import java.time.LocalDate;

public class Cliente {


	private String id_Cliente;
	private String nome;
	private String cognome;
	private String partita_Iva;
	private String codice_Fiscale;
	private String e_mail;
	private int fidelity;
	private String via;
	private int numero_Civico;
	private String password;


	public Cliente(String id_Cliente, String nome, String cognome, String partita_Iva, String codice_Fiscale,
			String e_mail, int fidelity, String via, int numero_Civico, String password ) {
		super();
		this.id_Cliente = id_Cliente;
		this.nome = nome;
		this.cognome = cognome;
		this.partita_Iva = partita_Iva;
		this.codice_Fiscale = codice_Fiscale;
		this.e_mail = e_mail;
		this.fidelity = fidelity;
		this.via = via;
		this.numero_Civico = numero_Civico;
		this.password = password;

	}

















	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}






	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getId_Cliente() {
		return id_Cliente;
	}


	public void setId_Cliente(String id_Cliente) {
		this.id_Cliente = id_Cliente;
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


	public String getPartita_Iva() {
		return partita_Iva;
	}


	public void setPartita_Iva(String partita_Iva) {
		this.partita_Iva = partita_Iva;
	}


	public String getCodice_Fiscale() {
		return codice_Fiscale;
	}


	public void setCodice_Fiscale(String codice_Fiscale) {
		this.codice_Fiscale = codice_Fiscale;
	}


	public String getE_mail() {
		return e_mail;
	}


	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}


	public int getFidelity() {
		return fidelity;
	}


	public void setFidelity(int fidelity) {
		this.fidelity = fidelity;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public int getNumero_Civico() {
		return numero_Civico;
	}


	public void setNumero_Civico(int numero_Civico) {
		this.numero_Civico = numero_Civico;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice_Fiscale == null) ? 0 : codice_Fiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());

		result = prime * result + ((e_mail == null) ? 0 : e_mail.hashCode());
		result = prime * result + fidelity;
		result = prime * result + ((id_Cliente == null) ? 0 : id_Cliente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero_Civico;
		result = prime * result + ((partita_Iva == null) ? 0 : partita_Iva.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codice_Fiscale == null) {
			if (other.codice_Fiscale != null)
				return false;
		} else if (!codice_Fiscale.equals(other.codice_Fiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;

		if (e_mail == null) {
			if (other.e_mail != null)
				return false;
		} else if (!e_mail.equals(other.e_mail))
			return false;
		if (fidelity != other.fidelity)
			return false;
		if (id_Cliente == null) {
			if (other.id_Cliente != null)
				return false;
		} else if (!id_Cliente.equals(other.id_Cliente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero_Civico != other.numero_Civico)
			return false;
		if (partita_Iva == null) {
			if (other.partita_Iva != null)
				return false;
		} else if (!partita_Iva.equals(other.partita_Iva))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cliente [id_Cliente=" + id_Cliente + ", nome=" + nome + ", cognome=" + cognome + ", partita_Iva="
				+ partita_Iva + ", codice_Fiscale=" + codice_Fiscale + ", e_mail=" + e_mail + ", fidelity=" + fidelity
				+ ", via=" + via + ", numero_Civico=" + numero_Civico + ", password=" + password + " ]";
	}

	


	 
	public boolean check(String password) {
		
		boolean esito=false;



		if (password.length() >= 8) {
			boolean hasUpper=false;
			boolean hasLower=false;
			boolean hasNumber=false;

			for (int i = 0; i < password.length(); i++) {
				char x = password.charAt(i);

if(Character.isDigit(x)) {
	hasNumber=true;
}
else if(Character.isUpperCase(x)) {
	hasUpper=true;
}
else if(Character.isLowerCase(x)) {
	hasLower=true;
}

	if(hasNumber&&hasLower&&hasUpper) {
		esito=true;
	
			}


		}


	}else {
		esito= false;
	}
		return esito;
		}
	
public boolean controlloPart(String partita_Iva) {
	boolean esito=false;
	if(partita_Iva.length()==11) {
		esito=true;
		
	}else {
		esito=false;
	}
return esito;
}












}
















