package it.unirc.twd.BuyeDrink.Statistiche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import buyEdrink.dao.utils.DBmanager;

public class StatisticheDAO {
	

private Connection conn;


public Vector<Statistiche> getOrdiniByMonth(){
	String query = "select count (*) , extract (month from DATA_STATS) as mese , extract(year from DATA_STATS) as anno from ordina group by extract (month from DATA_STATS), extract(year from DATA_STATS) order by extract (month from DATA_STATS),extract(year from DATA_STATS)";
	Vector<Statistiche> res = new Vector<Statistiche>();
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps=conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			Statistiche s = new Statistiche();
			s.setNumOrdini(rs.getInt("COUNT(*)"));
			s.setMese(rs.getInt("MESE"));
			s.setAnno(rs.getInt("ANNO"));
			 res.add(s);
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return res;
}

public double IncassoMedio() {
	String query="SELECT INCASSO FROM DUAL";
	double inc=0;
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps=conn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Statistiche s=new Statistiche();
			s.setIncasso(rs.getDouble("INCASSO"));
			inc=s.getIncasso();
		}}
		catch (SQLException e) {
			e.printStackTrace();
		}
		DBmanager.closeConnection();
		return inc;
	}
}


