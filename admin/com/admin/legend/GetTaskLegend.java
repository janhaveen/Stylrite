package com.admin.legend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.data.MySql.MySqlConnect;


/**
 * Servlet implementation class GetTaskLegend
 */
@WebServlet("/GetTaskLegend")
public class GetTaskLegend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
	    conn = MySqlConnect.DBConnection();
	    try {
	        int k = 0;
	        String where = "";
	        if (request.getParameter("type") != null) {
	            where += " AND category='" + request.getParameter("type") + "'";
	        }
	        if (request.getParameter("subCategory") != null) {
	            where += " AND subcategory='" + request.getParameter("subCategory") + "'";
	        }
	        
	        String sql = "SELECT * FROM stylrite_legend.tasklegendlist where 1=1 " + where;

	        PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (jArray.length() > 0) {
	            jArray.remove(0);
	        }

	        while (rs.next()) {
	            JSONObject arrayObj = new JSONObject();

	            arrayObj.put("rowid", rs.getString("rowid") == null ? "" : rs.getString("rowid"));
	            arrayObj.put("legendgroup", rs.getString("legendgroup") == null ? "" : rs.getString("legendgroup"));
	            arrayObj.put("category", rs.getString("category") == null ? "" : rs.getString("category"));
	            arrayObj.put("subcategory", rs.getString("subCategory") == null ? "" : rs.getString("subCategory"));
	            arrayObj.put("description", rs.getString("description") == null ? "" : rs.getString("description"));
	            //arrayObj.put("subcategory_txt", rs.getString("subcategory_txt"));

	            jArray.put(arrayObj);
	        }
	        JSONObject jsonFinal = new JSONObject();
	        jsonFinal.putOnce("data", jArray);
	        out.print(jsonFinal);
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
