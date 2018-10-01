package com.inventory.warehouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;
/**
 * Servlet implementation class GetBranchList
 */
@WebServlet("/GetWarehouseList")
public class GetWarehouseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	   
	    conn= MySqlConnect.DBConnection();
	    int k = 0;
	    String where="";
	    if (request.getParameter("type")!=null) {
			where+=" AND wtypeText='Branch'";
		}
	    if(request.getParameter("forDup")!=null) {
	    	if (request.getParameter("gst")!=null) {
	    		where +=" AND GSTNumber='"+request.getParameter("gst")+"'";
			}
	    	if(request.getParameter("BranchId")!=null) where +=" AND rowId!='"+request.getParameter("BranchId")+"'";
	    }
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
		    String[] aColumns = {"","name", "location", "address", "pincode", "state_txt","area"};
		    List<String> search=new ArrayList<String>();
		    search.add("");
		    search.add(request.getParameter("columns[1][search][value]")==null ? "":request.getParameter("columns[1][search][value]"));
		    search.add(request.getParameter("columns[2][search][value]")==null ? "":request.getParameter("columns[2][search][value]"));
		    search.add(request.getParameter("columns[3][search][value]")==null ? "":request.getParameter("columns[3][search][value]"));
		    search.add(request.getParameter("columns[4][search][value]")==null ? "":request.getParameter("columns[4][search][value]"));
		    search.add(request.getParameter("columns[5][search][value]")==null ? "":request.getParameter("columns[5][search][value]"));
		    search.add(request.getParameter("columns[6][search][value]")==null ? "":request.getParameter("columns[6][search][value]"));
		    
			for (int j = 0; j < aColumns.length; j++) {
				if(search.get(j)!="" && search.get(j)!="null" && search.get(j)!=null)
					where +=" AND "+aColumns[j]+" like '%"+search.get(j)+"%'";
			}
	   
		    String sql1 = "SELECT count(*) as total FROM stylrite_inventory.warehouselist where 1=1 "+where;		    
		    try {
				stmt1 = conn.prepareStatement(sql1);
				ResultSet rs1 = stmt1.executeQuery();
				while (rs1.next()) {
					k=Integer.parseInt(rs1.getString("total"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}
	    String sql = "SELECT * FROM stylrite_inventory.warehouselist where 1=1 "+where;
	    if(request.getParameter("start")!=null && request.getParameter("length")!=null) {
	    	sql +=" LIMIT "+ request.getParameter("start")+", "+request.getParameter("length");
	    }
	    System.out.println(sql+" nnmjmm");
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
				 arrayObj.put("name", rs.getString("name")==null?"":rs.getString("name"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("address", rs.getString("address")==null?"":rs.getString("address"));
				 arrayObj.put("address1", rs.getString("address1")==null?"":rs.getString("address1"));
				 arrayObj.put("areaAddress", rs.getString("areaAddress")==null?"":rs.getString("areaAddress"));
				 arrayObj.put("pincode", rs.getString("pincode")==null?"":rs.getString("pincode"));
				 arrayObj.put("state_txt", rs.getString("state_txt")==null?"":rs.getString("state_txt"));
				 arrayObj.put("city", rs.getString("city")==null?"":rs.getString("city"));
				 arrayObj.put("area", rs.getString("area")==null?"":rs.getString("area"));
				 arrayObj.put("state", rs.getString("state")==null?"":rs.getString("state"));
				 arrayObj.put("areaCity", rs.getString("areaCity")==null?"":rs.getString("areaCity"));
				 arrayObj.put("statePin", rs.getString("statePin")==null?"":rs.getString("statePin"));
				 arrayObj.put("wtype", rs.getString("wtype")==null?"":rs.getString("wtype"));
				 arrayObj.put("branchManager", rs.getString("branchManager")==null?"":rs.getString("branchManager"));
				 arrayObj.put("wtypeText", rs.getString("wtypeText")==null?"":rs.getString("wtypeText"));
				 arrayObj.put("GSTNumber", rs.getString("GSTNumber")==null?"":rs.getString("GSTNumber"));
				 arrayObj.put("createdBy_txt", rs.getString("createdBy_txt")==null?"":rs.getString("createdBy_txt"));
				 jArray.put(arrayObj);
			}
			JSONObject jsonFinal = new JSONObject();
			jsonFinal.putOnce("data", jArray);
			jsonFinal.putOnce("iTotalRecords", k);
			jsonFinal.putOnce("iTotalDisplayRecords", k);
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
