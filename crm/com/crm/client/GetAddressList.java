package com.crm.client;

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

@WebServlet("/GetAddressList")
public class GetAddressList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
//	    HttpSession session = request.getSession();
	    String sql = "SELECT * FROM stylrite_general.detailedclientaddress where 1=1 ";
	    if(request.getParameter("clientId")!=null)
	    {
	    	sql+=" AND clientId='"+request.getParameter("clientId")+"'";
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
				 arrayObj.put("clientId", rs.getString("clientId")==null?"":rs.getString("clientId"));
				 arrayObj.put("branchName", rs.getString("branchName")==null?"":rs.getString("branchName"));
				 arrayObj.put("contactNo", rs.getString("contactNo")==null?"":rs.getString("contactNo"));
				 arrayObj.put("addressLine1", rs.getString("addressLine1")==null?"":rs.getString("addressLine1"));
				 arrayObj.put("addressLine2", rs.getString("addressLine2")==null?"":rs.getString("addressLine2"));
				 arrayObj.put("ledgerName", rs.getString("ledgerName")==null?"":rs.getString("ledgerName"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("city", rs.getString("city")==null?"":rs.getString("city"));
				 arrayObj.put("state", rs.getString("state")==null?"":rs.getString("state"));
				 arrayObj.put("gstNo", rs.getString("gstNo")==null?"":rs.getString("gstNo"));
				 arrayObj.put("pincode", rs.getString("pincode")==null?"":rs.getString("pincode"));
				 arrayObj.put("isDefault", rs.getString("isDefault")==null?"":rs.getString("isDefault"));
				 arrayObj.put("state_text", rs.getString("state_text")==null?"":rs.getString("state_text"));
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
