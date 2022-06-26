package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Conn {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Ecole","root","");  
			
			PreparedStatement state =con.prepareStatement("SELECT espece,nom FROM animal");
			ResultSet res =state.executeQuery();
			ArrayList<String> list =new ArrayList<String>();
			while(res.next()) {
				System.out.println(res.getString("espece"));
				System.out.println(res.getString("nom"));
				
				
		}
			 
			            
		}catch(Exception e) {e.printStackTrace();}

	}
	}

