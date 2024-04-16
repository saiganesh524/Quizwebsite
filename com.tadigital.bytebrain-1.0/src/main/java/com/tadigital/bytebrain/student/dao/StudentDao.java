package com.tadigital.bytebrain.student.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tadigital.bytebrain.dao.Dao;
import com.tadigital.bytebrain.student.entity.Student;

public class StudentDao extends Dao{

	public Student logInWithEmailAndPassword(String email, String password) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		Student student = null;

		String query = String.format(sqlProperties.getProperty("sql.logInWithEmailAndPassword"), email, password);
		
		try {
			con = getDataSource().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt(1));
				student.setFirstName(rs.getString(2));
				student.setLastName(rs.getString(3));
				student.setEmailAddress(email);
				student.setPassword(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeSatament(st);
			closeConnection(con);
		}

		return student;
	}
	
	public Student loginWithStudentId(int id) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		Student student = null;

		String query = String.format(sqlProperties.getProperty("sql.loginWithId"), id);
		
		try {
			con = getDataSource().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt(1));
				student.setFirstName(rs.getString(2));
				student.setLastName(rs.getString(3));
				student.setEmailAddress(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeSatament(st);
			closeConnection(con);
		}

		return student;
	}

	public boolean signUpByFillingDetails(String fName, String lName, String email, String password) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		boolean status = false;

		String query = String.format(sqlProperties.getProperty("sql.signUpByFillingDetails"), fName, lName, email, password);
		
		try {
			con = getDataSource().getConnection();
			st = con.createStatement();
			int row = st.executeUpdate(query);
			
			if (row>0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeSatament(st);
			closeConnection(con);
		}

		return status;
	}
}