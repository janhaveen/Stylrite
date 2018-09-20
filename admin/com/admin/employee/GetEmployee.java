package com.admin.employee;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.*;

import com.data.MySql.MySqlConnect;


/**
 * Servlet implementation class getClientJson
 */
@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    HttpSession session = request.getSession();
	     /*
		if(session.getAttribute("userName") == null || session.getAttribute("userId") == null )
		{
				response.sendRedirect("index.jsp");
		}
	    */
	    String sql = "SELECT * FROM stylrite_general.employeelist where 1=1";
	    if(request.getParameter("cid")!=null) {
	    	sql+=" AND rowId="+session.getAttribute("userId").toString()+"";
	    }
	    
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
				 
				 arrayObj.put("employeeId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("employeeName", rs.getString("empname")==null?"":rs.getString("empname"));
				 arrayObj.put("firstName", rs.getString("firstName")==null?"":rs.getString("firstName"));
				 arrayObj.put("lastName", rs.getString("lastName")==null?"":rs.getString("lastName"));
				 arrayObj.put("department", rs.getString("department")==null?"":rs.getString("department"));
				 arrayObj.put("designation", rs.getString("designation")==null?"":rs.getString("designation"));
				 arrayObj.put("mobileNo", rs.getString("contactNo")==null?"":rs.getString("contactNo"));
				 arrayObj.put("altContactNo", rs.getString("altContactNo")==null?"":rs.getString("altContactNo"));
				 arrayObj.put("emailId", rs.getString("emailId")==null?"":rs.getString("emailId"));
				 arrayObj.put("userId", rs.getString("userId")==null?"":rs.getString("userId"));
				 arrayObj.put("status", rs.getString("status")==null?"":rs.getString("status"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("reportTo", rs.getString("reportTo")==null?"":rs.getString("reportTo"));
				 arrayObj.put("birthdaydate", rs.getString("DOB")==null?"":rs.getString("DOB"));
				 arrayObj.put("joiningdate", rs.getString("joiningdate")==null?"":rs.getString("joiningdate"));
				 arrayObj.put("empname", rs.getString("empname")==null?"":rs.getString("empname"));
				 arrayObj.put("designation_desc", rs.getString("desigText")==null?"":rs.getString("desigText"));
				 arrayObj.put("department_desc", rs.getString("deptText")==null?"":rs.getString("deptText"));
				 arrayObj.put("reportingTo", rs.getString("reporttext")==null?"":rs.getString("reporttext"));
				 arrayObj.put("status_desc", rs.getString("statustext")==null?"":rs.getString("statustext"));
				 arrayObj.put("permissions", rs.getString("permissions")==null?"":rs.getString("permissions"));
				 
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
