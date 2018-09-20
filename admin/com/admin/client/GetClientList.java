package com.admin.client;

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
//import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

@WebServlet("/GetClientList")
public class GetClientList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
//	    HttpSession session = request.getSession();
	    String sql = "SELECT * FROM stylrite_general.detailedclientinfo where 1=1 ";
	    /*if(request.getParameter("cid")!=null)
	    {
	    	sql+=" AND rowId="+session.getAttribute("userId").toString()+"";
	    }
	    if(request.getParameter("dr")!=null)
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
				 arrayObj.put("companyName", rs.getString("companyName")==null?"":rs.getString("companyName"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("customerType", rs.getString("customerType")==null?"":rs.getString("customerType"));
				 arrayObj.put("source", rs.getString("source")==null?"":rs.getString("source"));
				 arrayObj.put("referenceBy", rs.getString("referenceBy")==null?"":rs.getString("referenceBy"));
				 arrayObj.put("creditTime", rs.getString("creditTime")==null?"":rs.getString("creditTime"));
				 arrayObj.put("creditLimit", rs.getString("creditLimit")==null?"":rs.getString("creditLimit"));
				 arrayObj.put("salesPerson", rs.getString("salesPerson")==null?"":rs.getString("salesPerson"));
				 arrayObj.put("locationadd", rs.getString("locationadd")==null?"":rs.getString("locationadd"));
				 arrayObj.put("addressId", rs.getString("addressId")==null?"":rs.getString("addressId"));
				 arrayObj.put("branchName", rs.getString("branchName")==null?"":rs.getString("branchName"));
				 arrayObj.put("ledgerName", rs.getString("ledgerName")==null?"":rs.getString("ledgerName"));
				 arrayObj.put("addressLine1", rs.getString("addressLine1")==null?"":rs.getString("addressLine1"));
				 arrayObj.put("addressLine2", rs.getString("addressLine2")==null?"":rs.getString("addressLine2"));
				 arrayObj.put("gstNo", rs.getString("gstNo")==null?"":rs.getString("gstNo"));
				 arrayObj.put("state", rs.getString("state")==null?"":rs.getString("state"));
				 arrayObj.put("pincode", rs.getString("pincode")==null?"":rs.getString("pincode"));
				 arrayObj.put("contactPerson", rs.getString("contactPerson")==null?"":rs.getString("contactPerson"));
				 arrayObj.put("CPId", rs.getString("CPId")==null?"":rs.getString("CPId"));
				 arrayObj.put("contactNoCP", rs.getString("contactNoCP")==null?"":rs.getString("contactNoCP"));
				 arrayObj.put("altContactNoCP", rs.getString("altContactNoCP")==null?"":rs.getString("altContactNoCP"));
				 arrayObj.put("emailIdCP", rs.getString("emailIdCP")==null?"":rs.getString("emailIdCP")); 
				 arrayObj.put("state_text", rs.getString("state_text")==null?"":rs.getString("state_text")); 
				 arrayObj.put("salesPerson_text", rs.getString("salesPerson_text")==null?"":rs.getString("salesPerson_text")); 
				 arrayObj.put("designationOfSalesP", rs.getString("designationOfSalesP")==null?"":rs.getString("designationOfSalesP")); 
				 arrayObj.put("reportToOfSalesP", rs.getString("reportToOfSalesP")==null?"":rs.getString("reportToOfSalesP")); 
				 arrayObj.put("source_text", rs.getString("source_text")==null?"":rs.getString("source_text"));
				 arrayObj.put("customerType_txt", rs.getString("customerType_txt")==null?"":rs.getString("customerType_txt"));
				 arrayObj.put("industry_txt", rs.getString("industry_txt")==null?"":rs.getString("industry_txt"));
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
