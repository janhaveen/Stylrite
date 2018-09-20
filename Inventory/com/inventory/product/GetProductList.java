package com.inventory.product;

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
/*import javax.servlet.http.HttpSession;*/

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;

@WebServlet("/GetProductList")
public class GetProductList extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    /*HttpSession session = request.getSession();*/
	    
	    String sql = "SELECT * FROM stylrite_inventory.productlist where 1=1 ";
	    if(request.getParameter("type")!=null) {
	    	sql+=" AND category='"+request.getParameter("type")+"'";
	    }
	    if(request.getParameter("forDup")!=null) {
	    	if (request.getParameter("modelNo")!=null) {
	    		sql +=" AND modelNo='"+request.getParameter("modelNo")+"'";
			}
	    	if(request.getParameter("ProductId")!=null)
	    		sql +=" AND rowId!='"+request.getParameter("ProductId")+"'";
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
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("brand", rs.getString("brand")==null?"":rs.getString("brand"));
				 arrayObj.put("modelNo", rs.getString("modelNo")==null?"":rs.getString("modelNo"));
				 arrayObj.put("hsnId", rs.getString("hsnId")==null?"":rs.getString("hsnId"));
				 arrayObj.put("color", rs.getString("color")==null?"":rs.getString("color"));
				 arrayObj.put("size", rs.getString("size")==null?"":rs.getString("size"));
				 arrayObj.put("price", rs.getString("price")==null?"":rs.getString("price"));
				 arrayObj.put("Tags", rs.getString("Tags")==null?"":rs.getString("Tags"));
				 arrayObj.put("description", rs.getString("description")==null?"":rs.getString("description"));
				 arrayObj.put("brand_text", rs.getString("brand_text")==null?"":rs.getString("brand_text"));
				 arrayObj.put("hsn_text", rs.getString("hsn_text")==null?"":rs.getString("hsn_text"));				 
				 arrayObj.put("productInfo", rs.getString("productInfo")==null?"":rs.getString("productInfo"));
				 arrayObj.put("brandAbbr", rs.getString("brandAbbr")==null?"":rs.getString("brandAbbr"));
				 arrayObj.put("sku", rs.getString("sku")==null?"":rs.getString("sku"));
				 arrayObj.put("skuid", rs.getString("skuid")==null?"":rs.getString("skuid"));
				 arrayObj.put("availableStock", rs.getString("availableStock")==null?"":rs.getString("availableStock"));
				 arrayObj.put("Igst", rs.getString("Igst")==null?"":rs.getString("Igst"));
				 arrayObj.put("blocked", rs.getString("blocked")==null?"":rs.getString("blocked"));
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