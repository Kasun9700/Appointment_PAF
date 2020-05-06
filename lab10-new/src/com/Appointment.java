package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Appointment {

	
	private Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

		
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useTimezone=true&serverTimezone=UTC", "root", "");
		}
		catch (Exception e)
		{e.printStackTrace();}
		return con;
	} 
	

	
	public String readAppointments()
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
		
			output = "<table border='1'><tr><th>Appointment No</th> <th>Appointment Name</th><th>Appointment Time</th>"+ "<th>Appointment Date</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from appointments";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		
			while (rs.next())
			{
				String appointmentID = Integer.toString(rs.getInt("appointmentID"));
				String appointmentNo = rs.getString("appointmentNo");
				String appointmentName = rs.getString("appointmentName");
				String appointmentTime = Double.toString(rs.getDouble("appointmentTime"));
				String appointmentDate = rs.getString("appointmentDate"); 

			
				output += "<tr><td><input id='hidAppointmentIDUpdate'name='hidAppointmentIDUpdate' type='hidden'value='" + appointmentID + "'>" + 
				appointmentNo + "</td>";
				output += "<td>" + appointmentName + "</td>";
				output += "<td>" + appointmentTime + "</td>";
				output += "<td>" + appointmentDate + "</td>";
			
				output += "<td><input name='btnUpdate' type='button'"
				+ "value='Update'"+"class='btnUpdate btn btn-secondary'></td>"
				+"<td><input name='btnRemove' type='button'"
				+" value='Remove'"+"class='btnRemove btn btn-danger' data-appointmentid='"+ appointmentID + "'>" + "</td></tr>";
			}
			con.close();
		
			output += "</table>";
		}
		catch (Exception e)
		{
			output = "Error while reading the appointments.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	

	public String insertAppointment(String no, String name,String time, String date)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
			}
			
			String query = " insert into appointments(`appointmentID`,`appointmentNo`,`appointmentName`,`appointmentTime`,`appointmentDate`)"+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, no);
			preparedStmt.setString(3, name);
			preparedStmt.setDouble(4, Double.parseDouble(time));
			preparedStmt.setString(5, date);
			
			preparedStmt.execute();
			
			 System.out.print("successfuly inserted");
			 
			con.close();
			String newAppointments = readAppointments();
			output = "{\"status\":\"success\", \"data\": \"" + newAppointments + "\"}";
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the appointment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	public String updateAppointment(String ID, String no, String name,String time, String date)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for updating.";
			}
			
			String query = "UPDATE appointments SET appointmentNo=?,appointmentName=?,appointmentTime=?,appointmentDate=? WHERE appointmentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setString(1, no);
			preparedStmt.setString(2, name);
			preparedStmt.setDouble(3, Double.parseDouble(time));
			preparedStmt.setString(4, date);
			preparedStmt.setInt(5, Integer.parseInt(ID));
		
			preparedStmt.execute();
			con.close();
			String newAppointments = readAppointments();
			output = "{\"status\":\"success\", \"data\": \"" + newAppointments + "\"}";
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\":\"Error while updating the appointment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	

	public String deleteAppointment(String appointmentID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
		
			String query = "delete from appointments where appointmentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, Integer.parseInt(appointmentID));
		
			preparedStmt.execute();
			con.close();
			
			String newAppointments = readAppointments();
			output = "{\"status\":\"success\", \"data\": \"" + newAppointments + "\"}";
		} catch (Exception e) {
			
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the appointment.\"}";
			
			System.err.println(e.getMessage());
		}
		return output;
	}
}
