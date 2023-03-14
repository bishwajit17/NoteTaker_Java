package com.notetaker.verify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Connectorfactory {
	private static Connection con = null;
	
	public static Connection getDBConnection() throws Exception{
		
		if(con == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("com/edureka/jdbc/dbconfig");
			
			String dc = bundle.getString("jdbc.driverclass");
			String url = bundle.getString("jdbc.url");
			String user = bundle.getString("jdbc.username");
			String password = bundle.getString("jdbc.password");
			
			Class.forName(dc);
			con = DriverManager.getConnection(url,user,password);
		}
		return con;
	}

	

}
