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
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();	  
        String sql = "SELECT * FROM stylrite_general.tasklist where 1=1 ";
        if(request.getParameter("ProjectId")!=null) {
        	sql+=" AND ProjectId='"+request.getParameter("ProjectId")+"'";
		}
        if(request.getParameter("viewOnly")!=null) {
	    	if(request.getParameter("viewOnly").equals("m"))
	    		sql +=" AND cpc='"+session.getAttribute("userId")+"'";
	    	else 
	    		sql +=" AND epc='"+session.getAttribute("userId")+"'";
	    }
        if(request.getParameter("status")!=null) {
        	if(request.getParameter("status").equals("cmp")) {
        		sql+=" AND status_txt='Completed'";
        		outstr+="<div class='card-header h6 bg-success text-center'>Done</div>";
        		
        	}else if(request.getParameter("status").equals("ip")) {
        		sql+=" AND status_txt='In Process'";
        		outstr+="<div class='card-header h6 bg-primary text-center'>In Process</div>";
        	}else if(request.getParameter("status").equals("td")) {
        		sql+=" AND status_txt='Pending'";
        		outstr+="<div class='card-header h6 bg-warning text-center'>To Do</div>";
			}
        	if (!session.getAttribute("departmentTxt").equals("IT")) {
        		sql+=" AND isDeleted!=1";
    		}
        }
       System.out.println(sql);
        try {
        	stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {			
				outstr+= "<div class='card mb-3 ' >"
					  +"<div class='row'  style='padding: 5px;'>"
					  +"<div class='col-md-8' style='font-size:115%'>"+rs.getString("taskName") +"</div>"
					  +"<div class='col-md-4'>"
					  +"<i style='font-size:130%; padding:2px;' class='fa fa-pencil-alt  pull-right' onClick='EditTask( \"" + rs.getString("rowId") + "\")'></i>"
					  +"<i style='font-size:130%; padding:2px;' class='fa fa-trash-alt pull-right' onClick='DeleteTask(\"" +rs.getString("rowId")+"\")' aria-hidden='true'></i>"
					  +"</div>"
					  +rs.getString("endText") 
					  + "</div>"
					  + "</div>" 
					  + "</div>";
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
