package com.tadigital.bytebrain.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Dao {
	private static DataSource dataSource;
	private static Connection con;
	private static Properties dbProperties;
	protected static final Properties sqlProperties;//sqlProperties
	
	static {
		InputStream inputStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconfig.properties");
		InputStream inputStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("sql.properties");
		
		dbProperties = new Properties();//dbProperties
		sqlProperties = new Properties();
		
		try {
			dbProperties.load(inputStream1);
			sqlProperties.load(inputStream2);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(dbProperties.getProperty("db.driverclass"));
		basicDataSource.setUrl(dbProperties.getProperty("db.url"));
		basicDataSource.setUsername(dbProperties.getProperty("db.username"));
		basicDataSource.setPassword(dbProperties.getProperty("db.password"));
		
		dataSource = basicDataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void closeBasicDataSource() {
		BasicDataSource basicDataSource = (BasicDataSource) dataSource;
		
		try {
			basicDataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeSatament(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closePreparedSatament(PreparedStatement pst) {
		try {
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
