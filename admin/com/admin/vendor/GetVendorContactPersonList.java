package com.admin.vendor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

@WebServlet("/GetVendorContactPersonList")
public class GetVendorContactPersonList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
//	    HttpSession session = request.getSession();
	    String sql = "SELECT * FROM stylrite_general.detailedvendorcontactperson where 1=1 ";
	    if(request.getParameter("vendorId")!=null)
	    {
	    	sql+=" AND vendorId='"+request.getParameter("vendorId")+"'";
	    }
	    /*if(request.getParameter("dr")!=null)
	    {
	    	sql+=" AND statustext='Active'";
	    }*/
	    if(request.getParameter("forDup")!=null)
	    {
	    	if (request.getParameter("mobile")!=null)
	    	{
	    		sql +=" AND contactNo='"+request.getParameter("mobile")+"'";
			}
	    	if (request.getParameter("usrid")!=null)
	    	{
	    		sql +=" AND userId='"+request.getParameter("usrid")+"'";
			}
	    	if(request.getParameter("selectedEmployeeId")!=null)
	    		sql +=" AND rowId!='"+request.getParameter("selectedEmployeeId")+"'";
	    }
	    System.out.println(sql);
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
				 
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("vendorId", rs.getString("vendorId")==null?"":rs.getString("vendorId"));
				 arrayObj.put("name", rs.getString("name")==null?"":rs.getString("name"));
				 arrayObj.put("firstName", rs.getString("firstName")==null?"":rs.getString("firstName"));
				 arrayObj.put("lastName", rs.getString("lastName")==null?"":rs.getString("lastName"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("contactNo", rs.getString("contactNo")==null?"":rs.getString("contactNo"));
				 arrayObj.put("altContactNo", rs.getString("altContactNo")==null?"":rs.getString("altContactNo"));
				 arrayObj.put("birthdate", rs.getString("birthdate")==null?"":rs.getString("birthdate"));
				 arrayObj.put("emailId", rs.getString("emailId")==null?"":rs.getString("emailId"));
				 arrayObj.put("department", rs.getString("department")==null?"":rs.getString("department"));
				 arrayObj.put("designation", rs.getString("designation")==null?"":rs.getString("designation"));
				 arrayObj.put("isDefault", rs.getString("isDefault")==null?"":rs.getString("isDefault"));
				 arrayObj.put("department_text", rs.getString("department_text")==null?"":rs.getString("department_text"));
				 arrayObj.put("designation_text", rs.getString("designation_text")==null?"":rs.getString("designation_text"));
				 arrayObj.put("formattedBirthdate", rs.getString("formattedBirthdate")==null?"":rs.getString("formattedBirthdate"));
				 
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
