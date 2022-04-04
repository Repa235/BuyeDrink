package it.unirc.twd.BuyeDrink.ordine;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import buyEdrink.dao.utils.DBmanager;

public class IncassoMedio {

	
	private static Connection conn;
	
	public static void main(String[] args) throws Exception{  
		  
		conn=DBmanager.startConnection();
		CallableStatement stmt=conn.prepareCall("{?= call INCASSO(?)}");  
		
		stmt.registerOutParameter(1,Types.INTEGER);  
		stmt.execute();  
		  int res=stmt.getInt(1);
		System.out.println("result is"+res);
		
		stmt.close();
		conn.close();
	}
}
