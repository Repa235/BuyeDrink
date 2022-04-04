package it.unirc.twd.BuyeDrink.retribuisce;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import buyEdrink.dao.utils.DBmanager;
import it.unirc.twd.BuyeDrink.magazziniere.Magazziniere;


public class RetribuisceDAO {
	
private Connection conn;
	
	public boolean salvaPagamento(Retribuisce retribuisce) {
		
		String query="INSERT INTO RETRIBUISCE VALUES(?,?,?,?)";
		boolean esito=false;
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,retribuisce.getIdTitolare());
			ps.setInt(2,retribuisce.getIdMagazziniere());
			ps.setDouble(3,retribuisce.getImporto());
			ps.setDate(4,retribuisce.getDataPagamento());

			
			
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
	
	public boolean eliminaPagamento(Retribuisce retribuisce,Magazziniere magazziniere){
		String query = "DELETE FROM RETRIBUISCE WHERE ID_MAGAZZINIERE=?";
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

	private Retribuisce recordToPagamento(ResultSet rs) throws SQLException {
		Retribuisce retribuisce = new Retribuisce();
		
		retribuisce.setIdTitolare(rs.getInt("id_titolare"));
		retribuisce.setIdMagazziniere(rs.getInt("id_magazziniere"));		
		retribuisce.setImporto(rs.getDouble("importo"));	
		retribuisce.setDataPagamento(rs.getDate("data"));	
		
		return retribuisce;
		
	
		
	}
	

public Vector<Retribuisce> getPagamenti(){
	String query = "SELECT * FROM RETRIBUISCE ORDER BY DATA";
	Vector<Retribuisce> res = new Vector<Retribuisce>();
	PreparedStatement ps;
	Connection conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			Retribuisce r = recordToPagamento(rs);
			res.add(r);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	DBmanager.closeConnection();
	return res;
}

	
}
