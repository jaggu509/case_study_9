package hello;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class Bill {
	
	Bill(){
		
	}
	
	public ResultSet get_bills() {
		ResultSet rs = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/firstdb");
			
			Statement stmt = con.createStatement();
			String qry = "SELECT * FROM EMPLOYEE";
			rs = stmt.executeQuery(qry);
			
			
		}catch(Exception e) {
			System.out.println("Exception occured: " + e);
		}
		return rs;
	}
}
