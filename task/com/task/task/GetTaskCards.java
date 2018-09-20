package com.task.task;

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

import com.data.MySql.MySqlConnect;

@WebServlet("/GetTaskCards")
public class GetTaskCards extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        conn= MySqlConnect.DBConnection();
        String deptDiv="", outstr="";
        String sql = "SELECT * FROM stylrite_general.tasklist where 1=1 ";
        if(request.getParameter("ProjectId")!=null) {
        	sql+=" AND ProjectId='"+request.getParameter("ProjectId")+"'";
		}
        if(request.getParameter("status")!=null) {
        	if(request.getParameter("status").equals("cmp")) {
        		sql+=" AND status_txt='Completed'";
        		outstr+="<h6>Done</h6>";
        	}else if(request.getParameter("status").equals("ip")) {
        		sql+=" AND status_txt='In Process'";
        		outstr+="<h6>In Process</h6>";
        	}else if(request.getParameter("status").equals("td")) {
        		sql+=" AND status_txt='Pending'";
        		outstr+="<h6>To Do</h6>";
			}
        }
       
        try {
        	stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {			
				outstr+="<div class='card'>" + 
						"<div class='card-body'>" + 
						rs.getString("taskName") + 
						"</div>" + 
						"</div>";
			}
			out.println(outstr+"<br>");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            out.close();  // Always close the output writer
        }
	}
	
}
