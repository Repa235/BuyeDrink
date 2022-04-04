package it.unirc.twd.BuyeDrink.magazziniere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import buyEdrink.dao.utils.DBmanager;


public class MagazziniereDAO {

	private Connection conn;
	
	public boolean salvaMagazziniere(Magazziniere magazziniere) {
		
		String query="INSERT INTO MAGAZZINIERE VALUES(?,?,?,?,?,?,?)";
		boolean esito=false;
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,magazziniere.getIdMagazziniere());
			ps.setString(2,magazziniere.getNome());
			ps.setString(3,magazziniere.getCognome());
			ps.setInt(4,magazziniere.getIdTit());
			ps.setString(5,magazziniere.getEmail());
			ps.setString(6,magazziniere.getPassword());
			ps.setDate(7,(Date) magazziniere.getDataAssunzione());
			
			
			int tmp=ps.executeUpdate();
			if(tmp==1)
				esito=true;
		}
			catch(SQLException e){
				e.printStackTrace();
			}
			DBmanager.closeConnection();
			return esito;
			}
	
	
public Magazziniere getMagazziniere(Magazziniere magazziniere) {
		
		String query="SELECT * FROM MAGAZZINIERE WHERE EMAIL=?";
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1,magazziniere.getEmail());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				magazziniere.setIdMagazziniere(rs.getInt("id_magazziniere"));
				magazziniere.setNome(rs.getString("nome"));
				magazziniere.setCognome(rs.getString("cognome"));			
				magazziniere.setEmail(rs.getString("email"));
				magazziniere.setPassword(rs.getString("password"));
				magazziniere.setIdTit(rs.getInt("id_Titolare"));
				magazziniere.setDataAssunzione(rs.getDate("data_assunzione"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	DBmanager.closeConnection();
	return magazziniere;
	}
	
	
public boolean modificaMagazziniere(Magazziniere magazziniere) {
	String query="UPDATE MAGAZZINIERE SET NOME=?,COGNOME=?,EMAIL=?,PASSWORD=? WHERE ID_MAGAZZINIERE=?";
	boolean esito=false;
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps=conn.prepareStatement(query);
		ps.setString(1,magazziniere.getNome());
		ps.setString(2,magazziniere.getCognome());
		ps.setString(3,magazziniere.getEmail());
		ps.setString(4,magazziniere.getPassword());
		ps.setInt(5,magazziniere.getIdMagazziniere());

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
	
	
public boolean eliminaMagazziniere(Magazziniere magazziniere){
	String query = "DELETE FROM MAGAZZINIERE WHERE ID_MAGAZZINIERE=?";
	boolean esito=false;
	PreparedStatement ps;
	Connection conn=DBmanager.startConnection();
	try {
	ps = conn.prepareStatement(query);
	ps.setInt(1,magazziniere.getIdMagazziniere());
	int tmp=ps.executeUpdate();
	if (tmp==1)
	esito=true;
	} catch (SQLException e) {
	e.printStackTrace();
	}
	DBmanager.closeConnection();
	return esito;

	}


private Magazziniere recordToMagazziniere(ResultSet rs) throws SQLException {
	Magazziniere magazziniere= new Magazziniere();
	magazziniere.setIdMagazziniere(rs.getInt("id_magazziniere"));
	magazziniere.setNome(rs.getString("nome"));
	magazziniere.setCognome(rs.getString("cognome"));			
	magazziniere.setEmail(rs.getString("email"));
	magazziniere.setPassword(rs.getString("password"));
	magazziniere.setIdTit(rs.getInt("id_Titolare"));
	magazziniere.setDataAssunzione(rs.getDate("data_assunzione"));
    
	return magazziniere ;
	
}

public Vector<Magazziniere> getMagazzinieri(){
	String query = "SELECT * FROM MAGAZZINIERE ORDER BY ID_MAGAZZINIERE";
	Vector<Magazziniere> res = new Vector<Magazziniere>();
	PreparedStatement ps;
	Connection conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			Magazziniere magazziniere = recordToMagazziniere(rs);
			res.add(magazziniere);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	DBmanager.closeConnection();
	return res;
}



public Magazziniere  accesso(Magazziniere magazziniere) {
	String query = "SELECT * FROM MAGAZZINIERE WHERE EMAIL = ? AND PASSWORD = ?";

	Magazziniere res = null;
	
	PreparedStatement ps;
	conn = DBmanager.startConnection(); 
	
	try {
		ps = conn.prepareStatement(query);
		ps.setString(1, magazziniere.getEmail()); 
		ps.setString(2, magazziniere.getPassword()); 
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			res=new Magazziniere();
			res.setEmail( rs.getString("email"));
			res.setPassword( rs.getString("password"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	
	DBmanager.closeConnection();
	return res;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






