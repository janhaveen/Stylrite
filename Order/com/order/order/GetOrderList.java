package com.order.order;

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

@WebServlet("/GetOrderList")
public class GetOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    
	    String sql = "SELECT *, 0 as count FROM stylrite_sales.detailedorderitem where 1=1 ";
	    if(request.getParameter("for")!=null)
	    {
	    	if(request.getParameter("for").equals("StockOut"))
		    {
	    		sql = "SELECT *,count(orderId) as count FROM stylrite_sales.detailedorderitem where 1=1  AND orderStatus = 941 group by orderId";
		    }
	    	else if(request.getParameter("for").equals("StockOutItem"))
		    {
	    		sql += "AND orderId = '"+request.getParameter("orderId")+"'";
		    }
	    }
	    /*if(request.getParameter("dr")!=null)
	    {
	    	sql+=" AND statustext='Active'";
	    }
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
	    }*/
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
				 arrayObj.put("orderId", rs.getString("orderId")==null?"":rs.getString("orderId"));
				 arrayObj.put("productId", rs.getString("productId")==null?"":rs.getString("productId"));
				 arrayObj.put("quantity", rs.getString("quantity")==null?"":rs.getString("quantity"));
				 arrayObj.put("rate", rs.getString("rate")==null?"":rs.getString("rate"));
				 arrayObj.put("discount", rs.getString("discount")==null?"":rs.getString("discount"));
				 arrayObj.put("hsnId", rs.getString("hsnId")==null?"":rs.getString("hsnId"));
				 arrayObj.put("igst", rs.getString("igst")==null?"":rs.getString("igst"));
				 arrayObj.put("orderItemstatus", rs.getString("orderItemstatus")==null?"":rs.getString("orderItemstatus"));
				 arrayObj.put("orderStatus", rs.getString("orderStatus")==null?"":rs.getString("orderStatus"));
				 arrayObj.put("productInfo", rs.getString("productInfo")==null?"":rs.getString("productInfo"));
				 arrayObj.put("availableStock", rs.getString("availableStock")==null?"":rs.getString("availableStock"));
				 arrayObj.put("count", rs.getString("count")==null?"":rs.getString("count"));
				 
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
