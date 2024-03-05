package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Appointments{
	
	// id = primary key for Patients table.
	private int id ;
	
	//Hastayı referans edecek.(foreign key)
	//Randevu verilme esnasında ,önceden randevusu bulunmayan bir hastaya randevu verildiğinde 
	//randevu verilme işleminden önce hasta Hastalar tablosuna kayıt edilecek.
	private int patientId ;
	
	//Randevu tarihi.
	private LocalDate appointmentDate ; 
	
	//Randevu verilme tarihi.
	private LocalDate appointmentDateWasMade;
	
	//Randevuyu veren personelin id'si.(foreign key)
	private int personelId;
	
	private String process;
	
	//DATABASE İŞLEMLERİ İÇİN GEREKLİ DEĞİŞKENLER
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public Appointments(int id, int patientId, LocalDate appointmentDate, LocalDate appointmentDateWasMade,
						int personelId, String process) 
	{
		this.id = id;
		this.patientId = patientId;
		this.appointmentDate = appointmentDate;
		this.appointmentDateWasMade = appointmentDateWasMade;
		this.personelId = personelId;
		this.process = process;
	}
	
	public Appointments() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalDate getAppointmentDateWasMade() {
		return appointmentDateWasMade;
	}

	public void setAppointmentDateWasMade(LocalDate appointmentDateWasMade) {
		this.appointmentDateWasMade = appointmentDateWasMade;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}
	
	
	
	
	
	 
	
	
	
}
