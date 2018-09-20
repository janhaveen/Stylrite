package com.admin.hsn;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet("/GetHsnId")
public class GetHsnId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    
	    String sql = "SELECT *, upper(Hsnid) as HsnCode FROM stylrite_inventory.d_hsn where 1=1";	
	    if(request.getParameter("tax")!=null) {
	    	sql +=" and upper(Hsnid)='SERVICE TAX'";
	    }else {
	    	sql +=" and upper(Hsnid)!='SERVICE TAX'";
	    }
	    conn = MySqlConnect.DBConnection();
		
		while (jArray.length()>0) {
			jArray.remove(0);
		}	
		try{
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();
				 arrayObj.put("rowId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("Hsnid", rs.getString("HsnCode")==null?"":rs.getString("HsnCode"));
				 arrayObj.put("Sgst", rs.getString("Sgst")==null?"":rs.getString("Sgst"));
				 arrayObj.put("Cgst", rs.getString("Cgst")==null?"":rs.getString("Cgst"));
				 arrayObj.put("Igst", rs.getString("Igst")==null?"":rs.getString("Igst"));
				 arrayObj.put("Ugst", rs.getString("Ugst")==null?"":rs.getString("Ugst"));				 
				 arrayObj.put("SgstPer", rs.getString("Sgst")==null?"":rs.getString("Sgst")+"%");
				 arrayObj.put("CgstPer", rs.getString("Cgst")==null?"":rs.getString("Cgst")+"%");
				 arrayObj.put("IgstPer", rs.getString("Igst")==null?"":rs.getString("Igst")+"%");
				 arrayObj.put("UgstPer", rs.getString("Ugst")==null?"":rs.getString("Ugst")+"%");
				 //arrayObj.put("CreatedBy", rs.getString("Created_By")==null?"":rs.getString("Created_By"));
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
