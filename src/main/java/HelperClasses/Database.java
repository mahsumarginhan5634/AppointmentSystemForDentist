package HelperClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database 
{
	private static String URL = "jdbc:mysql://localhost:3306/";
	private static final String  userName = "root";
	private static final String password = "siirtli56";
	private static final String schemaName = "clinic";
	
	private  static Connection connect = null;
	
	public static Connection connectDatabase()
	{
		
		try
		{
			connect = DriverManager.getConnection(URL + schemaName,userName,password);
			return connect;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return connect;
	}

	public static void createSchemaAndTables() 
	{
		Statement statement = null;
	    String schemaQuery = "CREATE SCHEMA IF NOT EXISTS clinic";

	    String personelQuery = "CREATE TABLE IF NOT EXISTS clinic.personel ("
	            + "id INT AUTO_INCREMENT PRIMARY KEY,"
	            + "name VARCHAR(255) NOT NULL,"
	            + "password VARCHAR(255) NOT NULL)";
	            

	    String[] queries = { schemaQuery, personelQuery };

	    try 
	    {
	        connect = DriverManager.getConnection(URL, userName, password);
	        statement = connect.createStatement();

	        for (int i = 0; i < queries.length; i++) 
	        {
	            statement.executeUpdate(queries[i]);
	        }

	        statement.close();
	        connect.close();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	
	    finally
	    {
	    	try
	    	{
	    		if(statement != null)
	    			statement.close();
	    		if(connect != null)
	    			connect.close();
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	
	    
	}

	
	
	
	
	
	
}
