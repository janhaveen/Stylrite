package com.general.state;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

@WebServlet("/GetState")
public class GetState extends HttpServlet{
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	private Connection conn;
	private PreparedStatement stmt;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    String sql = "SELECT * FROM propel_general.d_states";
	    conn= MySqlConnect.DBConnection();		
		while (jArray.length()>0) {
			jArray.remove(0);
		}		
		try
		{ 
			stmt = conn.prepareStatement(sql);			
			ResultSet rs = stmt.executeQuery();		
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject(); 
				 arrayObj.put("rowno", rs.getString("rowno")==null?"":rs.getString("rowno"));
				 arrayObj.put("state", rs.getString("state")==null?"":rs.getString("state"));
				 arrayObj.put("statetype", rs.getString("statetype")==null?"":rs.getString("statetype"));
				 jArray.put(arrayObj);
			}
			JSONObject jsonFinal = new JSONObject();
			jsonFinal.putOnce("data", jArray);
			out.print(jsonFinal);
			conn.close();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
