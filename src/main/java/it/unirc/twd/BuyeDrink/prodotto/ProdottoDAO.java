package it.unirc.twd.BuyeDrink.prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

import buyEdrink.dao.utils.DBmanager;




public class ProdottoDAO {

	
	private Connection conn;
	
	public boolean salvaProdotto(Prodotto prodotto) {
		
		String query="INSERT INTO PRODOTTO VALUES (?,?,?,?,?)";
		boolean esito=false;
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		
		try {
			
			ps=conn.prepareStatement(query);
			ps.setInt(1,prodotto.getCodice());
			ps.setInt(2,prodotto.getQuantitá());
			ps.setString(3, prodotto.getNome());
			ps.setString(4,prodotto.getMarca());
			ps.setDouble(5,prodotto.getPrezzo());
		    
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

public Prodotto getProdotto(Prodotto prodotto) {
	
	String query="SELECT * FROM PRODOTTO WHERE CODICE=?";
	PreparedStatement ps;
	conn=DBmanager.startConnection();

try {
	ps=conn.prepareStatement(query);
	ps.setInt(1, prodotto.getCodice());
	ResultSet rs=ps.executeQuery();
	
	if(rs.next()) {
		
		prodotto.setCodice(rs.getInt("codice"));
		prodotto.setMarca(rs.getString("marca"));
		prodotto.setNome(rs.getString("nome"));
		prodotto.setQuantitá(rs.getInt("quantitá"));
		prodotto.setPrezzo(rs.getDouble("prezzo"));
		
		
		
	}
}
catch(SQLException e) {
	e.printStackTrace();
}
DBmanager.closeConnection();
return prodotto;
}


public boolean eliminaProdotto(Prodotto prodotto) {
	
	String query="DELETE FROM PRODOTTO WHERE CODICE=?";
	boolean esito=false;
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	
	try {
		ps=conn.prepareStatement(query);
		ps.setInt(1, prodotto.getCodice());
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



public Vector<Prodotto>getProdotti(){
	String query = "SELECT * FROM PRODOTTO ORDER BY CODICE";
	Vector<Prodotto> res = new Vector<Prodotto>();
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Prodotto prodotto=recordToProdotto(rs);
			res.add(prodotto);
		}	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return res;
}

public boolean modificaProdotto(Prodotto prodotto) {
	String query="UPDATE PRODOTTO SET QUANTITÁ=?,PREZZO=?,NOME=?,MARCA=? WHERE CODICE=?";
	PreparedStatement ps;
	boolean esito=false;
	conn=DBmanager.startConnection();
	try {
		ps=conn.prepareStatement(query);
		
		ps.setInt(1,prodotto.getQuantitá());
		ps.setDouble(2,prodotto.getPrezzo());
		ps.setString(3, prodotto.getNome());
		ps.setString(4, prodotto.getMarca());
		ps.setInt(5, prodotto.getCodice());

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


private Prodotto recordToProdotto(ResultSet rs) throws SQLException {
	Prodotto prodotto=new Prodotto();


	prodotto.setCodice(rs.getInt("CODICE"));
	prodotto.setQuantitá(rs.getInt("QUANTITÁ"));
	prodotto.setNome(rs.getString("NOME"));
	prodotto.setMarca(rs.getString("MARCA"));
	prodotto.setPrezzo(rs.getDouble("PREZZO"));
	
	
	return prodotto;


}


public Prodotto RicercaProdotto(Prodotto prodotto) {
	String query="SELECT * FROM PRODOTTO WHERE MARCA=?";
	PreparedStatement ps;
	
	conn=DBmanager.startConnection();

try {
	ps=conn.prepareStatement(query);
	ps.setString(1, prodotto.getMarca());
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		prodotto.setCodice(rs.getInt("CODICE"));
		prodotto.setQuantitá(rs.getInt("QUANTITÁ"));
		prodotto.setNome(rs.getString("NOME"));
		prodotto.setMarca(rs.getString("MARCA"));
		prodotto.setPrezzo(rs.getDouble("PREZZO"));
	}
	
}
catch(SQLException e) {
e.printStackTrace();
}
DBmanager.closeConnection();
return prodotto;

	
}



public Vector<Prodotto>getProdottiCercati(){
	String query = "SELECT * FROM PRODOTTO WHERE MARCA=?";
	Vector<Prodotto>res=new Vector<Prodotto>();
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Prodotto prodotto=recordToProdotto(rs);
			
			res.add(prodotto);
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return res;
}



public boolean modificaQuantProdotti(Prodotto prodotto) {
	String query="UPDATE PRODOTTO SET QUANTITÁ=? WHERE CODICE=?";
	PreparedStatement ps;
	boolean esito=false;
	conn=DBmanager.startConnection();
	try {
		ps=conn.prepareStatement(query);
		ps.setInt(1, prodotto.getQuantitá());
		ps.setInt(2, prodotto.getCodice());
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			esito = true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return esito;
}



	








}














