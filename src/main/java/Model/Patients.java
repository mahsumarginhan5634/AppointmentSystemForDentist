package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patients {
	
	//id = primary key for Patients table.
	private int id;
	private String name;
	private String phoneNumber;
	
	
	
	//DATABASE İŞLEMLERİ İÇİN GEREKLİ DEĞİŞKENLER
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;

}
