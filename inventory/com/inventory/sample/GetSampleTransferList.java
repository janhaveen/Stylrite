package com.inventory.sample;

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
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class GetSampleTransferList
 */
@WebServlet("/GetSampleTransferList")
public class GetSampleTransferList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    HttpSession session=request.getSession();
	    String count=" ,0 as total", groupBy="", where="";

	    if(request.getParameter("listFor")!=null) {
	    	if(request.getParameter("listFor").equals("sp")) {
	    		count= ", count(requisitionid) as total";
	    		groupBy=" group by issuesTo, requisitionid";
	    	}
	    	if(request.getParameter("listFor").equals("sampleForSP")) {
	    		where +=" AND issuesTo='"+request.getParameter("spid")+"'";
	    		//groupBy=" group by requisitionid";
	    	}
	    }
	    String sql = "SELECT * "+count+" FROM stylrite_inventory.sampletransferlist where 1=1 "+where+groupBy;
	    
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
				 arrayObj.put("productid", rs.getString("productid")==null?"":rs.getString("productid"));
				 arrayObj.put("barcode", rs.getString("barcode")==null?"":rs.getString("barcode"));
				 arrayObj.put("issuesTo_name", rs.getString("issuesTo_name")==null?"":rs.getString("issuesTo_name"));
				 arrayObj.put("total", rs.getString("total")==null?"":rs.getString("total"));
				 arrayObj.put("issuesTo", rs.getString("issuesTo")==null?"":rs.getString("issuesTo"));
				 arrayObj.put("requisitionid", rs.getString("requisitionid")==null?"":rs.getString("requisitionid"));
				 arrayObj.put("requisitionDate", rs.getString("requisitionDate")==null?"":rs.getString("requisitionDate"));
				 arrayObj.put("status_txt", rs.getString("status_txt")==null?"":rs.getString("status_txt"));
				 arrayObj.put("modeofDelivery_txt", rs.getString("modeofDelivery_txt")==null?"":rs.getString("modeofDelivery_txt"));
				 arrayObj.put("productInfo", rs.getString("productInfo")==null?"":rs.getString("productInfo"));
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
				e.printStackTrace();
			}
		}
	}

}
