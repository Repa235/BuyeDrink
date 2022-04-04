package it.unirc.twd.BuyeDrink.titolare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import buyEdrink.dao.utils.DBmanager;






public class TitolareDAO {
	
	private Connection conn;
	
	public boolean salvaTitolare(Titolare titolare) {
		
		String query="INSERT INTO TITOLARE VALUES(?,?,?,?,?,?)";
		boolean esito=false;
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,titolare.getIdTit());
			ps.setString(2,titolare.getNome());
			ps.setString(3,titolare.getCognome());
			ps.setString(4,titolare.getEmail());
			ps.setString(5,titolare.getPartitaIva());
			ps.setString(6,titolare.getCodiceFiscale());
			ps.setString(7,titolare.getPassword());
			
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
	
public Titolare getTitolare(Titolare titolare) {
		
		String query="SELECT * FROM TITOLARE WHERE E_MAIL=?";
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1,titolare.getEmail());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				titolare.setIdTit(rs.getInt("id_titolare"));
				titolare.setNome(rs.getString("nome"));
				titolare.setCognome(rs.getString("cognome"));			
				titolare.setEmail(rs.getString("e_mail"));
				titolare.setPartitaIva(rs.getString("partita_iva"));
				titolare.setCodiceFiscale(rs.getString("codice_fiscale"));
				titolare.setPassword(rs.getString("password"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	DBmanager.closeConnection();
	return titolare;
	}
	
	
	
	
	public boolean modificaTitolare(Titolare titolare) {
		String query="UPDATE TITOLARE SET NOME=?,COGNOME=?,E_MAIL=?,PARTITA_IVA=?,CODICE_FISCALE=?, PASSWORD=? WHERE E_MAIL=?";
		boolean esito=false;
		PreparedStatement ps;
		conn=DBmanager.startConnection();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1,titolare.getIdTit());
			ps.setString(2,titolare.getNome());
			ps.setString(3,titolare.getCognome());
			ps.setString(4,titolare.getEmail());
			ps.setString(5,titolare.getPartitaIva());
			ps.setString(6,titolare.getCodiceFiscale());
			ps.setString(7,titolare.getPassword());
			
			
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
		
	public boolean eliminaTitolare(Titolare titolare){
		String query = "DELETE FROM TITOLARE WHERE E_MAIL= ?";
		boolean esito=false;
		PreparedStatement ps;
		Connection conn=DBmanager.startConnection();
		try {
		ps = conn.prepareStatement(query);
		ps.setInt(1,titolare.getIdTit());
		ps.setString(2,titolare.getNome());
		ps.setString(3,titolare.getCognome());
		ps.setString(4,titolare.getEmail());
		ps.setString(5,titolare.getPartitaIva());
		ps.setString(6,titolare.getCodiceFiscale());
		ps.setString(7,titolare.getPassword());
		

		int tmp=ps.executeUpdate();
		if (tmp==1)
		esito=true;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		DBmanager.closeConnection();
		return esito;
	
		}
	
	
	private Titolare recordToTitolare(ResultSet rs) throws SQLException {
		Titolare titolare  = new Titolare();
		titolare.setIdTit(rs.getInt("id_titolare"));
		titolare.setNome(rs.getString("nome"));
		titolare.setCognome(rs.getString("Cognome"));
		titolare.setPartitaIva(rs.getString("partita_iva"));
		titolare.setEmail(rs.getString("e_mail"));
		titolare.setCodiceFiscale(rs.getString("codice_fiscale"));
		titolare.setPassword(rs.getString("password"));
		return titolare ;
	}

	public Vector<Titolare> getTitolre(){
		String query = "SELECT * FROM TITOLARE order by ID_TITOLARE";
		Vector<Titolare> res = new Vector<Titolare>();
		PreparedStatement ps;
		Connection conn=DBmanager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Titolare titolare = recordToTitolare(rs);
				res.add(titolare);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBmanager.closeConnection();
		return res;
	}

	
	
	public Titolare  accesso(Titolare titolare) {
		String query = "SELECT * FROM TITOLARE WHERE E_MAIL = ? AND PASSWORD = ?";

		Titolare res = null;
		
		PreparedStatement ps;
		conn = DBmanager.startConnection(); 
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, titolare.getEmail()); 
			ps.setString(2, titolare.getPassword()); 
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				res=new Titolare();
				res.setEmail( rs.getString("e_mail"));
				res.setPassword( rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		DBmanager.closeConnection();
		return res;
	}
}
	
	

		
		


		



