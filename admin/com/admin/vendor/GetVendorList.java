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

@WebServlet("/GetVendorList")
public class GetVendorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
//	    HttpSession session = request.getSession();
	    String sql = "SELECT * FROM stylrite_general.detailedvendorinfo where 1=1 ";
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
				 arrayObj.put("vendorName", rs.getString("vendorName")==null?"":rs.getString("vendorName"));
				 arrayObj.put("vendorType", rs.getString("vendorType")==null?"":rs.getString("vendorType"));
				 arrayObj.put("email", rs.getString("email")==null?"":rs.getString("email"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("creditTime", rs.getString("creditTime")==null?"":rs.getString("creditTime"));
				 arrayObj.put("creditLimit", rs.getString("creditLimit")==null?"":rs.getString("creditLimit"));
				 arrayObj.put("website", rs.getString("website")==null?"":rs.getString("website"));
				 arrayObj.put("landlineNo", rs.getString("landlineNo")==null?"":rs.getString("landlineNo"));
				 arrayObj.put("industryType", rs.getString("industryType")==null?"":rs.getString("industryType"));
				 arrayObj.put("source", rs.getString("source")==null?"":rs.getString("source"));
				 arrayObj.put("referenceBy", rs.getString("referenceBy")==null?"":rs.getString("referenceBy"));
				 arrayObj.put("categories", rs.getString("categories")==null?"":rs.getString("categories"));
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
				 arrayObj.put("source_text", rs.getString("source_text")==null?"":rs.getString("source_text"));
				 arrayObj.put("vendorType_txt", rs.getString("vendorType_txt")==null?"":rs.getString("vendorType_txt"));
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
