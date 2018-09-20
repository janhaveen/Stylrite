package com.inventory.barcode;

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
 * Servlet implementation class GetChildBarcodeList
 */
@WebServlet("/GetChildBarcodeList")
public class GetChildBarcodeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    HttpSession session = request.getSession();
	    
	    String sql = "SELECT * FROM stylrite_inventory.childbarcodelist where 1=1 ";
	    if(request.getParameter("boxbarcodeId")!=null) {
	    	sql+=" AND location='"+request.getParameter("boxbarcodeId")+"'";
	    }
	    if(request.getParameter("unknownLocation")!=null) {
	    	sql="SELECT * FROM stylrite_inventory.childbarcodelistforcsv where 1=1 ";
	    	sql+=" AND location IS NULL";
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
				 arrayObj.put("rowNo", rs.getString("rowNo")==null?"":rs.getString("rowNo"));
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("productId", rs.getString("productId")==null?"":rs.getString("productId"));
				 arrayObj.put("purchaseorderitemid", rs.getString("purchaseorderitemid")==null?"":rs.getString("purchaseorderitemid"));
				 arrayObj.put("rate", rs.getString("rate")==null?"":rs.getString("rate"));
				 arrayObj.put("status", rs.getString("status")==null?"":rs.getString("status"));
				 arrayObj.put("productQty", rs.getString("productQty")==null?"":rs.getString("productQty"));
				 arrayObj.put("productInfo", rs.getString("productInfo")==null?"":rs.getString("productInfo"));
				 arrayObj.put("price", rs.getString("price")==null?"":rs.getString("price"));
				 arrayObj.put("brand_text", rs.getString("brand_text")==null?"":rs.getString("brand_text"));
				 arrayObj.put("modelNo", rs.getString("modelNo")==null?"":rs.getString("modelNo"));
				 arrayObj.put("color", rs.getString("color")==null?"":rs.getString("color"));
				 arrayObj.put("size", rs.getString("size")==null?"":rs.getString("size"));
				 
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
