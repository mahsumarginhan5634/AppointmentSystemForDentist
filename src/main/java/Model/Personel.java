package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Personel {
	
	
	//id = primary key for Personel table.
	private int id;
	
	private String name;
	private String password;

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	
	public Personel() {
		
	}
	
	public Personel(String name) {
		this.name = name;
	}
	public Personel(String name , String password) {
		this.name = name;
		this.password = password;
	}
	public Personel(String name , String password , int id) {
		this.name = name;
		this.password = password;
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
	public int getId() {
		return this.id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
