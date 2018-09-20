package com.requistion.requistion;

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

@WebServlet("/GetRequisitionList")
public class GetRequisitionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
//	    HttpSession session = request.getSession();
	    String sql = "SELECT *, 0 as count FROM stylrite_inventory.detailedrequisitionitem where 1=1 ";
	    
	    if(request.getParameter("list")!=null)
	    {
	    	//for sampleList(the list parameter is sample list)
	    	if(request.getParameter("list").equals("sampleListInvtAccp"))
	    	{
		    	sql ="SELECT *,count(requisitionId) as count FROM stylrite_inventory.detailedrequisitionitem where rqtnStatus = 201 group by requisitionId";
	    	}
	    	else if(request.getParameter("list").equals("sampleListDispatched"))
	    	{
		    	sql ="SELECT *,count(requisitionId) as count FROM stylrite_inventory.detailedrequisitionitem where status = 212 and rqtnStatus = 202 group by requisitionId";
	    	}
	    	else if(request.getParameter("list").equals("sampleListRdyToRcv"))
	    	{
		    	sql ="SELECT *,count(requisitionId) as count FROM stylrite_inventory.detailedrequisitionitem where status = 212 and rqtnStatus = 203 group by requisitionId";
	    	}
	    	else if(request.getParameter("list").equals("sampleListView"))
	    	{
		    	sql ="SELECT *,count(requisitionId) as count FROM stylrite_inventory.detailedrequisitionitem group by requisitionId";
	    	}
	    }
	    else if(request.getParameter("requisitionId")!=null)
	    {
	    	sql +="and requisitionId = '"+request.getParameter("requisitionId")+"'";
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
				 arrayObj.put("requisitionId", rs.getString("requisitionId")==null?"":rs.getString("requisitionId"));
				 arrayObj.put("productId", rs.getString("productId")==null?"":rs.getString("productId"));
				 arrayObj.put("status", rs.getString("status")==null?"":rs.getString("status"));
				 arrayObj.put("EmpName", rs.getString("EmpName")==null?"":rs.getString("EmpName"));
				 arrayObj.put("formattedOrderCreatedOn", rs.getString("formattedOrderCreatedOn")==null?"":rs.getString("formattedOrderCreatedOn"));
				 arrayObj.put("formattedExpectedReceiptDate", rs.getString("formattedExpectedReceiptDate")==null?"":rs.getString("formattedExpectedReceiptDate"));
				 arrayObj.put("formattedDispatchedDate", rs.getString("formattedDispatchedDate")==null?"":rs.getString("formattedDispatchedDate"));
				 arrayObj.put("transportName", rs.getString("transportName")==null?"":rs.getString("transportName"));
				 arrayObj.put("trackingID", rs.getString("trackingID")==null?"":rs.getString("trackingID"));
				 arrayObj.put("eBillNo", rs.getString("eBillNo")==null?"":rs.getString("eBillNo"));
				 arrayObj.put("formattedReceiptDate", rs.getString("formattedReceiptDate")==null?"":rs.getString("formattedReceiptDate"));
				 arrayObj.put("reason_text", rs.getString("reason_text")==null?"":rs.getString("reason_text"));
				 arrayObj.put("rqtnItmstatus_text", rs.getString("rqtnItmstatus_text")==null?"":rs.getString("rqtnItmstatus_text"));
				 arrayObj.put("count", rs.getString("count")==null?"0":rs.getString("count"));
				 arrayObj.put("productInfo", rs.getString("productInfo")==null?"":rs.getString("productInfo"));
				 arrayObj.put("skuid", rs.getString("skuid")==null?"":rs.getString("skuid"));
				 arrayObj.put("class", rs.getString("class")==null?"":rs.getString("class"));
				 arrayObj.put("modeofDelivery_text", rs.getString("modeofDelivery_text")==null?"":rs.getString("modeofDelivery_text"));
				 arrayObj.put("rqtnStatus_text", rs.getString("rqtnStatus_text")==null?"":rs.getString("rqtnStatus_text"));
				 
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
