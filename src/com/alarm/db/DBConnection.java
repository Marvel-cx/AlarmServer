package com.alarm.db;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBConnection {
	private Connection conn;
	
	private final String DRIVER="com.mysql.jdbc.Driver";
	private final String userName="root";
	private final String userPwd="root";
	private final String url="jdbc:mysql://localhost:3306/alarm";	
	public DBConnection(){
		
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(url,userName,userPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public static void main(String[] args) {
		DBConnection db=new DBConnection();
		System.out.println(db.getConnection()==null);   
	}
}
