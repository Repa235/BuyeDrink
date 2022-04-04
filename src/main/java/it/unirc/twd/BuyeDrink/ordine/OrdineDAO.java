package it.unirc.twd.BuyeDrink.ordine;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import buyEdrink.dao.utils.DBmanager;
import it.unirc.twd.BuyeDrink.cliente.Cliente;
import it.unirc.twd.BuyeDrink.prodotto.Prodotto;


public class OrdineDAO {
	



private Connection conn;
	
	public boolean salvaOrdine(Ordine ordine ) {
		
		String query="INSERT INTO ORDINA VALUES (?,?,?,?,?,?) ";
		boolean esito=false;
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		
		try {
			
			ps=conn.prepareStatement(query);
			ps.setString(2,ordine.getId_Cliente());
			ps.setInt(3,ordine.getCodice_ordine());
			ps.setInt(1, ordine.getCodice_prodotto());
			ps.setInt(4,ordine.getQuantita_richiesta());
			ps.setDouble(5,ordine.getPrezzo_totale());
			
			ps.setDate(6, ordine.getData_stats());

		
		int tmp=ps.executeUpdate();
		if(tmp==1)
			esito=true;
		}
	catch(SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return esito;
	}

public Ordine getOrdine(Ordine ordine ) {
	
	String query="SELECT * FROM ORDINE WHERE CODICE_ORDINE=?";
	PreparedStatement ps;
	conn=DBmanager.startConnection();

try {
	ps=conn.prepareStatement(query);
	ps.setInt(1, ordine.getCodice_ordine());
	ResultSet rs=ps.executeQuery();
	
	if(rs.next()) {
		
		ordine.setId_Cliente(rs.getString("id_cliente"));
		ordine.setCodice_ordine(rs.getInt("codice_ordine"));
		ordine.setCodice_prodotto(rs.getInt("codice_prodotto"));
		ordine.setQuantita_richiesta(rs.getInt("quantita_richiesta"));
		ordine.setPrezzo_totale(rs.getDouble("prezzo_totale"));
		
		ordine.setData_stats(rs.getDate("data_stats"));
		
		
	}
}
catch(SQLException e) {
	e.printStackTrace();
}
DBmanager.closeConnection();
return ordine ;
}

public Vector<Ordine>getOrdine(){
	String query = "SELECT * FROM ORDINA ORDER BY CODICE_ORDINE";
	Vector<Ordine> res = new Vector<Ordine>();
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Ordine ordine=recordToOrdine(rs);
			res.add(ordine);
		
		
		
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return res;
}
private Ordine recordToOrdine(ResultSet rs) throws SQLException {
	Ordine ordine=new Ordine();
	
	ordine.setId_Cliente(rs.getString("id_cliente"));
	ordine.setCodice_ordine(rs.getInt("codice_ordine"));
	ordine.setCodice_prodotto(rs.getInt("CODICE_PRODOTTO"));
	ordine.setQuantita_richiesta(rs.getInt("quantita_richiesta"));
	ordine.setPrezzo_totale(rs.getDouble("prezzo_totale"));
	
	ordine.setData_stats(rs.getDate("data_stats"));
	
	return ordine;


}

public Vector<Ordine>getOrdiniByCod(Ordine ordine){
	String query = "SELECT * FROM ORDINA WHERE CODICE_ORDINE=?";
	Vector<Ordine> res = new Vector<Ordine>();
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		ps.setInt(1, ordine.getCodice_ordine());
		
        ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
	        ordine=recordToOrdine(rs);
			res.add(ordine);
		
		
		
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return res;
}
public Vector<Ordine>getOrdiniMensili(){
	String query = "select DISTINCT CODICE_ORDINE,ID_CLIENTE,DATA_STATS FROM ORDINA WHERE ROWNUM<=5 order by extract (month from DATA_STATS),extract(year from DATA_STATS)";
	Vector<Ordine> res = new Vector<Ordine>();
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		
		
        ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			Ordine ordine=new Ordine();
			ordine.setCodice_ordine(rs.getInt("codice_ordine"));
			ordine.setId_Cliente(rs.getString("id_cliente"));
			ordine.setData_stats(rs.getDate("data_stats"));
	       
			res.add(ordine);
		
		
		
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return res;



}}







