package com.HelthCare.Service;

import java.util.ArrayList;
import java.util.List;

import com.HelthCare.Model.Doctor;

import java.sql.*;
import com.HelthCare.Database.DatabaseClass;
public class DoctorRepository {
	
	
	
	/* public DoctorRepository() {
		
		
		
		String url = "jdbc:mysql://localhost:3306/healthcare";
		String username = "root";
		String password = "";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		} 
	    
		
	}*/	
	
	
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		String sql ="select * from doctors";
		try {
			Statement st = DatabaseClass.getDBconnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Doctor d = new Doctor();
				
				d.setDocID(rs.getString(1));
				d.setDocFname(rs.getString(2));
				d.setDocSname(rs.getString(3));
				d.setDocEmail(rs.getString(4));
				d.setDocMobile(rs.getString(5));
				d.setDocSpecialization(rs.getString(6));
				d.setDocIntime(rs.getString(7));
				d.setDocOutime(rs.getString(8));
				
				doctors.add(d);
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		 return doctors;
		    
	}
	/*
	 * 
List<Doctor> doctors = new ArrayList<Doctor>();
        d1.setDocID("D001");
	    d1.setDocEmail("shantha@gmail.com");
	    d1.setDocFname("Shantha");
	    d1.setDocSname("Perera");
	    d1.setDocMobile("071082131");
	    d1.setDocIntime("08:30AM");
	    d1.setDocOutime("04:30PM");
	    d1.setDocSpecialization("Psychiatrist");
	    
		Doctor d2 = new Doctor();
	    d2.setDocID("D002");
	    d2.setDocEmail("nimal@gmail.com");
	    d2.setDocFname("Nimal");
	    d2.setDocSname("Peris");
	    d2.setDocMobile("075082131");
	    d2.setDocIntime("07:30AM");
	    d2.setDocOutime("03:30PM");
	    d2.setDocSpecialization("Surgeon");
	    
		Doctor d3 = new Doctor();
	    d3.setDocID("D003");
	    d3.setDocEmail("nimali@gmail.com");
	    d3.setDocFname("Nimali");
	    d3.setDocSname("Ranasighe");
	    d3.setDocMobile("077082111");
	    d3.setDocIntime("08:00AM");
	    d3.setDocOutime("05:00PM");
	    d3.setDocSpecialization("Dermatologist");
s
        doctors.add(d1);
	    doctors.add(d2);
	    doctors.add(d3);
	 * 
	 * 
	 * 
	 * 
	public Doctor getDoctor(String did) {
		
		 for(Doctor d : doctors) {
			 
			 if(d.getDocID()==did)
				 return d;
			 System.out.println("sa");
		 }
		
		return null; 
	    
	}


	*/
	public void createDoctor(Doctor d1) {
		
		String sql =  "INSERT INTO doctors VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement st = DatabaseClass.getDBconnection().prepareStatement(sql);
			st.setString(1,d1.getDocID());
			st.setString(2,d1.getDocFname());
			st.setString(3,d1.getDocSname());
			st.setString(4,d1.getDocEmail());
			st.setString(5,d1.getDocMobile());
			st.setString(6,d1.getDocSpecialization());
			st.setString(7,d1.getDocIntime());
			st.setString(8,d1.getDocOutime());
			
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void updateDoctor(Doctor d1) {
		
		String sql =  "UPDATE doctors SET docFname = ?, docSname = ?, docEmail = ?, docMobile = ?, docSpecialization = ?, docIntime = ?, docOutime = ? WHERE docID = ?";
		
		try {
			PreparedStatement st = DatabaseClass.getDBconnection().prepareStatement(sql);
			st.setString(1,d1.getDocFname());
			st.setString(2,d1.getDocSname());
			st.setString(3,d1.getDocEmail());
			st.setString(4,d1.getDocMobile());
			st.setString(5,d1.getDocSpecialization());
			st.setString(6,d1.getDocIntime());
			st.setString(7,d1.getDocOutime());
			st.setString(8,d1.getDocID());
			
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}



	public void deleteDoctor(String docID) {
		
       String sql =  "DELETE FROM doctors WHERE docID = ?";
		
		try {
			PreparedStatement st = DatabaseClass.getDBconnection().prepareStatement(sql);
			st.setString(1,docID);
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		

}
