package com.data.MySql;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MySqlConnect {

	public static String connector = "com.mysql.jdbc.Driver";
	//public static String dataBase = "jdbc:mysql://localhost/";
	public static String dataBase = "jdbc:mysql://192.168.0.14:3306/";
	public static String dbUser = "root";
	public static String dbPassword = "Aditya@6511";
	
	public static Connection DBConnection() {
		try{
			Class.forName(connector);
			Connection conn = DriverManager.getConnection(dataBase,dbUser,dbPassword);
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String args[]) {
		convertToSqlTimeStamp("16 August, 2018 00:00 am");
		
	}


	public static java.sql.Timestamp convertToTimestamp(String date){
		Timestamp ts = Timestamp.valueOf(date);
	    return ts;
	}

	public static Date convertToSqlDate(String strDate) {
		java.util.Date date;
		Date sqlDate;
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
		
		try {
			date = sdf.parse(strDate);
			sqlDate = new Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sqlDate =null;
		}
		
		return sqlDate;
	}
	
	public static Time convertToSqlTime(String myTime ) {
    
	 SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
	 Time t;
	 long ms;
	 try {
	  ms = sdf.parse(myTime).getTime();
	  t = new Time(ms);
	 } catch (ParseException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  t=null;
	 }
	 return t;
	}

	public static String convertToSqlTimeStamp(String myTime1) { System.out.println(myTime1);
		String ts = null;
		 SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy hh:mm a");
		 java.util.Date date; Date sqlDate; Time t; long ms;
		 try {
			 date = sdf.parse(myTime1);
			 sqlDate = new Date(date.getTime());
			 ms = sdf.parse(myTime1).getTime();
			 t = new Time(ms);// System.out.println(sqlDate+"sddsdscdcds"+t);
			 String s=sqlDate.toString()+" " +t.toString();
			 ts=sqlDate.toString()+" " +t.toString();
		 } catch (ParseException e) {
		  // TODO Auto-generated catch block
			  e.printStackTrace();
		 }
		 return ts;
	}
	
}


