package com.HelthCare.Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor {
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcaredoctor", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readDoctors() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {

				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed

			output = "<table border='1'><tr><th>Item Code</th>" + "<th>Item Name</th><th>Item Price</th>"
					+ "<th>Item Description</th>" + "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String docID = Integer.toString(rs.getInt("docID"));
				String docSpecialization = rs.getString("docSpecialization");
				String docName = rs.getString("docName");
				String docMobile = Double.toString(rs.getDouble("docMobile"));
				String docEmail = rs.getString("docEmail");
				
				// Add into the html table
				output += "<tr><td><input id='hidItemIDUpdate'" + "name='hidItemIDUpdate'" + "type='hidden' value='"
						+ docID + "'>" + docSpecialization + "</td>";
				
				output += "<td>" + docName + "</td>";
				output += "<td>" + docMobile + "</td>";
				output += "<td>" + docEmail + "</td>";
				// buttons
				output += "<td><input name='btnUpdate'" + "type='button' value='Update'"
						+ "class='btnUpdate btn btn-secondary'></td>" + "<td><input name='btnRemove'"
						+ "type='button' value='Remove'" + "class='btnRemove btn btn-danger'" + "data-itemid='" + docID
						+ "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertDoctor(String Specialization, String Name, String Mobile, String Email) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into doctor(`docID`,`docSpecialization`,`docName`,`docMobile`,`docEmail`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Specialization);
			preparedStmt.setString(3, Name);
			preparedStmt.setDouble(4, Double.parseDouble(Mobile));
			preparedStmt.setString(5, Email);

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newDoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":" + " \"Error while inserting the Doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateItem(String ID, String Specialization, String Name, String Mobile, String Email) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE doctor SET docSpecialization=?,docName=?,docMobile=?,docEmail=? WHERE docID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, Specialization);
			preparedStmt.setString(2, Name);
			preparedStmt.setDouble(3, Double.parseDouble(Mobile));
			preparedStmt.setString(4, Email);
			preparedStmt.setInt(5, Integer.parseInt(ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":" + "\"Error while updating the Doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteDoctor(String docID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from doctor where docID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(docID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newDoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":" + "\"Error while deleting the Doctor.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
