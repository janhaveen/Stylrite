package com.inventory.barcode;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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

@WebServlet("/GetBoxBarcodeList")
public class GetBoxBarcodeList extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int k=0;
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    HttpSession session = request.getSession();
	    
	    String sql = "SELECT * FROM stylrite_inventory.boxbarcodelist where 1=1 ";
	    if(request.getParameter("location")!=null) {
	    	sql +=" AND location In ("+URLDecoder.decode(request.getParameter("location"), "UTF-8")+")";
	    }
	    if(request.getParameter("type")!=null) {
	    	if(request.getParameter("type").equals("empty")){
	    		sql+="	AND remQty=capacity AND  isPresent!=1";
	    	}else if(request.getParameter("type").equals("absent")){
	    		sql+="	AND isPresent=1";
	    	}
	    }
	    if(request.getParameter("start")!=null && request.getParameter("limit")!=null) {
	    	sql +=" LIMIT "+ request.getParameter("start")+", "+request.getParameter("limit");
	    }
	    System.out.println(sql);
	    
	    String sql1 = "SELECT count(location) as total FROM stylrite_inventory.boxbarcodelist where 1=1 ";
	    if(request.getParameter("type")!=null) {
	    	if(request.getParameter("type").equals("empty")){
	    		sql1+="	AND remQty=capacity AND  isPresent!=1";
	    	}else if(request.getParameter("type").equals("absent")){
	    		sql1+="	AND isPresent=1";
	    	}
	    } System.out.println(sql1);
	    conn= MySqlConnect.DBConnection();
		
		while (jArray.length()>0) {
			jArray.remove(0);
		}
		
		try
		{
			stmt1 = conn.prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery();
			while (rs1.next()) {
				k=Integer.parseInt(rs1.getString("total"));
			} 
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();
				 arrayObj.put("floor", rs.getString("floor")==null?"":rs.getString("floor"));
				 arrayObj.put("aisle", rs.getString("aisle")==null?"":rs.getString("aisle"));
				 arrayObj.put("rack", rs.getString("rack")==null?"":rs.getString("rack"));
				 arrayObj.put("section", rs.getString("section")==null?"":rs.getString("section"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 
				 if(request.getParameter("for")==null) {
					 arrayObj.put("rowNo", rs.getString("rowNo")==null?"":rs.getString("rowNo"));
					 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
					 arrayObj.put("remQty", rs.getString("remQty")==null?"":rs.getString("remQty"));
					 arrayObj.put("capacity", rs.getString("capacity")==null?"":rs.getString("capacity"));
					 arrayObj.put("quantity", rs.getString("quantity")==null?"":rs.getString("quantity"));
				 }
				 jArray.put(arrayObj);
			}
			JSONObject jsonFinal = new JSONObject();
			jsonFinal.putOnce("data", jArray);
			jsonFinal.putOnce("total", k);
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
