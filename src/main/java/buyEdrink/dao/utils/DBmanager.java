package buyEdrink.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBmanager {

	
	
	


		private static Connection conn = null;
		private static final String DbDriver = "oracle.jdbc.driver.OracleDriver";
		private static final String DbURL = "jdbc:oracle:thin:@localhost:1521:GlobalDB";
		private static final String username = "hr";
		private static final String password = "hr";
		private DBmanager(){}
		/**
		 * Metododo che restituisce true se la connessione e' aperta.
		 */
		public static boolean isOpen(){
			// if (conn == null) 
			 //return false;
			 
			 //else 
			 //return true;
		
			 return (conn!=null);
		}
		public static Connection startConnection(){
			if ( isOpen() )
				return conn;
			try {
				Class.forName(DbDriver);
				conn = DriverManager.getConnection(DbURL, username, password);
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return conn;
		}
		public static boolean closeConnection(){
			if ( !isOpen() )
				return true;
			try {
				conn.close();
				conn = null;
			}
			catch (SQLException e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}
	

