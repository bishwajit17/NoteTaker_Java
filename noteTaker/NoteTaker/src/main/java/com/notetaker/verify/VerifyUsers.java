package com.notetaker.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyUsers {
	
	public static boolean checkLogin(int accountno,String username,String password) throws Exception{
		boolean status=false;
		Connection con = Connectorfactory.getDBConnection();
		try {
			//PreparedStatement ps=con.prepareStatement("Select * from MAILCASTINGUSER where EMAILADD = ? and PASSWORD =?");
			PreparedStatement ps=con.prepareStatement("Select * from Note where accountno=? and username = ? and password =?");
			ps.setInt(1,accountno);
			ps.setString(2,username);
			ps.setString(3,password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
