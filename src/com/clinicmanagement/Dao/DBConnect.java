package com.clinicmanagement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

	public static final String MySQLDRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    public static final String MySQLURL = "jdbc:mysql://localhost/cms";
    public static final String MySQLUSER = "root";
    public static final String MySQLPASSWORD = "1234";
    
	public static Connection getMySQLConnection()
	{
		Connection mysqlconnection = null;
		try 
		{
		//JDBC STEP 1
           // Load and Register Driver -
		   Class.forName(MySQLDRIVER_CLASS);
	
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		
	    try 
	    {
	       //JDBC STEP 2
	       //	Establish Connection between Java & DB
	       //  	jdbc - main protocol
	       //  	mysql://localhost:3306 - subprotocol
	       //  	jdbcdb - database name
	       //   getconnection internally call Driver.connect() method & establish socket connection
		
	    	mysqlconnection = DriverManager.getConnection(MySQLURL,MySQLUSER,MySQLPASSWORD);
		
	    } catch (SQLException e) {e.printStackTrace();}
	    
	    return mysqlconnection;
	}
	
	public static void closeMySQLConnection(Connection mysqlconnection)
	{
		if(mysqlconnection != null)
		{
			try 
			{
				mysqlconnection.close();
			
			} catch (SQLException e) {e.printStackTrace();}
		}
    }
	
	public static void closeMySQLPreaparedStatementConnection(PreparedStatement pst)
	{
		if(pst != null)
		{
			try 
			{
				pst.close();
			
			} catch (SQLException e) {e.printStackTrace();}
		}
    }
	
	public static void closeMySQLResulsetConnection(ResultSet rs)
	{
		if(rs != null)
		{
			try 
			{
				rs.close();
			
			} catch (SQLException e) {e.printStackTrace();}
		}
    }
}
