package com.task.task;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@WebServlet("/GetTaskList")
public class GetTaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();	  
	    String sql = "SELECT * FROM stylrite_general.tasklist where 1=1 ";
	    if(request.getParameter("TaskId")!=null) {
	    	sql+=" AND rowId='"+request.getParameter("TaskId")+"'";
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
				 arrayObj.put("TaskId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("taskName", rs.getString("taskName")==null?"":rs.getString("taskName"));
				 arrayObj.put("startDate", rs.getString("startDate")==null?"":rs.getString("startDate"));
				 arrayObj.put("endDate", rs.getString("endDate")==null?"":rs.getString("endDate"));
				 arrayObj.put("assignedTo", rs.getString("assignedTo")==null?"":rs.getString("assignedTo"));
				 arrayObj.put("visibility", rs.getString("visibility")==null?"":rs.getString("visibility"));
				 arrayObj.put("visibleTo", rs.getString("visibleTo")==null?"":rs.getString("visibleTo"));
				 arrayObj.put("priority", rs.getString("priority")==null?"":rs.getString("priority"));
				 arrayObj.put("priority_txt", rs.getString("priority_txt")==null?"":rs.getString("priority_txt"));
				 arrayObj.put("status", rs.getString("status")==null?"":rs.getString("status"));
				 arrayObj.put("status_txt", rs.getString("status_txt")==null?"":rs.getString("status_txt"));
				 arrayObj.put("description", rs.getString("description")==null?"":rs.getString("description"));
				 arrayObj.put("expired", rs.getString("expired")==null?"":rs.getString("expired"));
				 arrayObj.put("assignedTo_txt", rs.getString("assignedTo_txt")==null?"":rs.getString("assignedTo_txt"));
				 arrayObj.put("today", rs.getString("today")==null?"":rs.getString("today"));
				 arrayObj.put("visibility_txt", rs.getString("visibility_txt")==null?"":rs.getString("visibility_txt"));
				 arrayObj.put("desc", "<i class=\"fas fa-2x fa-info-circle\" data-toggle=\"popover\" data-placement=\"top\" title=\"Description\" data-content=\""+rs.getString("description")+"\"></i>");
				 arrayObj.put("StatusBtn", rs.getString("StatusBtn")==null?"":rs.getString("StatusBtn"));
				 arrayObj.put("visibleTo_txt", rs.getString("visibleTo_txt")==null?"":rs.getString("visibleTo_txt"));

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