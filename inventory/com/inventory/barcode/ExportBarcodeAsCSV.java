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

/**
 * Servlet implementation class ExportBarcodeAsCSV
 */
@WebServlet("/ExportBarcodeAsCSV")
public class ExportBarcodeAsCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    HttpSession session = request.getSession();
	    
    	String sql = "SELECT * FROM stylrite_inventory.childbarcodelistforcsv where 1=1 ";
	    if(request.getParameter("Barcodes")!=null) {
	    	sql +=" AND rowId In ("+URLDecoder.decode(request.getParameter("Barcodes"), "UTF-8")+")";
	    }
	    conn= MySqlConnect.DBConnection();
		System.out.println(sql);
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
