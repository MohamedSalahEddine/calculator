package Etudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion  {
	
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306";
	
	static final String USERNAME="root";
	static final String PASS="";
	static Statement st=null;
	static Connection con =null;
	
	public static Connection ConnexionDB()  {
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASS);
			
			//creating db 
			Statement st=con.createStatement();
			
			String query="CREATE DATABASE IF NOT EXISTS ETUDIANTS ";
			String query1="USE ETUDIANTS";
			String queryy="CREATE TABLE IF NOT EXISTS HAYCHMAYCH(id INT(12), userName VARCHAR(30),"
					 +"passeWord VARCHAR(30));";
			String queryy2="CREATE TABLE IF NOT EXISTS Utilisateur(id INT(12), userNameUti VARCHAR(30),"
					 +"passeWordUti VARCHAR(30));";
		
			st.executeUpdate(query);
			st.executeQuery(query1);
			st.executeUpdate(queryy);
			st.executeUpdate(queryy2);
			return con;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
		return null;
	}

}
