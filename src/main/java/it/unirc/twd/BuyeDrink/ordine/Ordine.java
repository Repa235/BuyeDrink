package it.unirc.twd.BuyeDrink.ordine;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Ordine {
 
	private String id_Cliente;
	private int codice_prodotto;
	
	private int codice_ordine;
	private double prezzo_totale;
    private int quantita_richiesta;
    private Date Data_stats;
	
    
    public Ordine() {
		super();
	}

    
    public Date data() {
    java.util.Date data = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(data.getTime());
    System.out.println("utilDate:" + data);
    System.out.println("sqlDate:" + sqlDate);
     
    return sqlDate;

    }


	public Ordine(String id_Cliente, int codice_prodotto,  int codice_ordine, double prezzo_totale,
			int quantita_richiesta, Date data_stats) {
		super();
		this.id_Cliente = id_Cliente;
		this.codice_prodotto = codice_prodotto;
		
		this.codice_ordine = codice_ordine;
		this.prezzo_totale = prezzo_totale;
		this.quantita_richiesta = quantita_richiesta;
		Data_stats = data_stats;
	}


	public String getId_Cliente() {
		return id_Cliente;
	}


	public void setId_Cliente(String id_Cliente) {
		this.id_Cliente = id_Cliente;
	}


	public int getCodice_prodotto() {
		return codice_prodotto;
	}


	public void setCodice_prodotto(int codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}


	


	public int getCodice_ordine() {
		return codice_ordine;
	}


	public void setCodice_ordine(int codice_ordine) {
		this.codice_ordine = codice_ordine;
	}


	public double getPrezzo_totale() {
		return prezzo_totale;
	}


	public void setPrezzo_totale(double prezzo_totale) {
		this.prezzo_totale = prezzo_totale;
	}


	public int getQuantita_richiesta() {
		return quantita_richiesta;
	}


	public void setQuantita_richiesta(int quantita_richiesta) {
		this.quantita_richiesta = quantita_richiesta;
	}


	public Date getData_stats() {
		return Data_stats;
	}


	public void setData_stats(Date data_stats) {
		Data_stats = data_stats;
	}


	@Override
	public String toString() {
		return "Ordine [id_Cliente=" + id_Cliente + ", codice_prodotto=" + codice_prodotto + ", codice_ordine="
				+ codice_ordine + ", prezzo_totale=" + prezzo_totale + ", quantita_richiesta=" + quantita_richiesta
				+ ", Data_stats=" + Data_stats + "]";
	}
    
    
    

	}