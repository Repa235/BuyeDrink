package it.unirc.twd.BuyeDrink.cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import buyEdrink.dao.utils.DBmanager;
import it.unirc.twd.BuyeDrink.Statistiche.Statistiche;






public class ClienteDAO {

	
	private Connection conn;
	
	
	public boolean salvaCliente(Cliente cliente) {
		String query="INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		boolean esito=false;
		conn=DBmanager.startConnection();
		
		try {
			//Date date = Date.valueOf(cliente.getDataDiNascita());
			
			ps=conn.prepareStatement(query);
			ps.setString(1, cliente.getId_Cliente());
			ps.setString(2,cliente.getNome());                                             
			ps.setString(3,cliente.getCognome());
			ps.setString(5,cliente.getE_mail());
			ps.setString(8,cliente.getVia());
			ps.setString(6,cliente.getCodice_Fiscale());
            ps.setString(4,cliente.getPartita_Iva());
            ps.setInt(7,cliente.getFidelity());
            ps.setInt(9,cliente.getNumero_Civico());
		    ps.setString(10,cliente.getPassword());
		   // ps.setDate(11,date);
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

public Cliente getCliente(Cliente cliente) {
	String query="SELECT * FROM CLIENTE WHERE E_MAIL=?";
			PreparedStatement ps;
			conn=DBmanager.startConnection();
			
			try {
				
				
				ps=conn.prepareStatement(query);
				ps.setString(1, cliente.getE_mail());
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					cliente.setId_Cliente(rs.getString("id_cliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCognome(rs.getString("Cognome"));
					cliente.setCodice_Fiscale(rs.getString("Codice_fiscale"));
					cliente.setE_mail(rs.getString("e_mail"));
					cliente.setFidelity(rs.getInt("fidelity"));
					cliente.setPartita_Iva(rs.getString("partita_iva"));
					cliente.setNumero_Civico(rs.getInt("numero_civico"));
					cliente.setVia(rs.getString("via"));
					cliente.setPassword(rs.getString("password"));
					//cliente.setDataDiNascita( rs.getDate("datadinascita").toLocalDate() ); 
				
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}

DBmanager.closeConnection();
return cliente;
}

public boolean eliminaCliente(Cliente cliente) {
	String query="DELETE FROM CLIENTE WHERE ID_CLIENTE=?";
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	boolean esito=false;
	
	try {
		ps=conn.prepareStatement(query);
		
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

public Cliente  accesso(Cliente cliente) {
	String query="SELECT * FROM CLIENTE WHERE E_MAIL=? AND PASSWORD=?";
	PreparedStatement ps;
	Cliente res=null;
	conn=DBmanager.startConnection();
	try {
		
		ps = conn.prepareStatement(query);
		ps.setString(1, cliente.getE_mail());
		ps.setString(2, cliente.getPassword()); 
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			res= recordToCliente(rs);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return res;
	

	
}

public Vector<Cliente> getCliente(){
	String query = "SELECT * FROM Cliente order by ID_CLIENTE";
	Vector<Cliente> res = new Vector<Cliente>();
	PreparedStatement ps;
	Connection conn=DBmanager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Cliente cliente=new Cliente();
			
			cliente.setNome(rs.getString("nome"));
			cliente.setCognome(rs.getString("Cognome"));
			cliente.setCodice_Fiscale(rs.getString("Codice_fiscale"));
			cliente.setE_mail(rs.getString("e_mail"));
			cliente.setFidelity(rs.getInt("fidelity"));
			cliente.setPartita_Iva(rs.getString("partita_iva"));
			cliente.setNumero_Civico(rs.getInt("numero_civico"));
			cliente.setVia(rs.getString("via"));
			cliente.setPassword(rs.getString("password"));
			//cliente.setDataDiNascita( rs.getDate("datadinascita").toLocalDate() ); 
			
			res.add(cliente);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	DBmanager.closeConnection();
	return res;
}
private Cliente recordToCliente(ResultSet rs) throws SQLException {
	Cliente cliente=new Cliente();
	
	
	cliente.setNome(rs.getString("nome"));
	cliente.setCognome(rs.getString("Cognome"));
	cliente.setCodice_Fiscale(rs.getString("Codice_fiscale"));
	cliente.setE_mail(rs.getString("e_mail"));
	cliente.setFidelity(rs.getInt("fidelity"));
	cliente.setPartita_Iva(rs.getString("partita_iva"));
	cliente.setNumero_Civico(rs.getInt("numero_civico"));
	cliente.setVia(rs.getString("via"));
	cliente.setPassword(rs.getString("password"));
	//cliente.setDataDiNascita( rs.getDate("datadinascita").toLocalDate() ); 
	
	return cliente;

}

public boolean ModificaCliente(Cliente cliente) {
	
	String query="UPDATE CLIENTE SET NOME=?,COGNOME=?,E_MAIL=?,VIA=?,NUMERO_CIVICO=?,PASSWORD=? WHERE ID_CLIENTE=?";
	boolean esito=false;
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	
	try {
		

		ps=conn.prepareStatement(query);
		
		ps.setString(1,cliente.getNome());                                             
		ps.setString(2,cliente.getCognome());
		ps.setString(3,cliente.getE_mail());
		ps.setString(4,cliente.getVia());
		ps.setInt(5,cliente.getNumero_Civico());
		
		
	    ps.setString(6,cliente.getPassword());
	    ps.setString(7,cliente.getId_Cliente());
	   
	    
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
	
public int ContaCliente(Cliente cliente) {
	
	int num=0;
	
	String query="SELECT COUNT(*) as uguali from cliente where E_MAIL = ?";

	
	PreparedStatement ps;
	conn=DBmanager.startConnection();
	try {
		ps=conn.prepareStatement(query);
		ps.setString(1, cliente.getE_mail());
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			
				System.out.println("clienti con la stessa mail trovati" + rs.getInt("uguali") );
				num = rs.getInt("uguali") ;
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBmanager.closeConnection();
	return num;

}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




