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

@WebServlet("/GetCommentsHistory")
public class GetCommentsHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        conn= MySqlConnect.DBConnection();
        String sql = "SELECT * FROM stylrite_general.taskloglist where 1=1 ";
        if(request.getParameter("TaskId")!=null) {
        	sql+=" AND TaskId='"+request.getParameter("TaskId")+"'";
		}
       // if(request.getParameter("action")!=null) {
        	sql+=" AND action IN (400000000011, 400000000010)";
		//}
        sql+=" order by createdOn desc";
        if(request.getParameter("start")!=null && request.getParameter("limit")!=null) {
        	sql+=" LIMIT "+request.getParameter("start")+","+request.getParameter("limit")+"";
        }
        String outstr="", liStr="";
        try {
        	stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				outstr+= "<div class='col-md-12'>"
						+"<input type='hidden' id='start' value='"+request.getParameter("start")+"'>"
						+"<div style='display:block;' class='row'>"
            			+"<div class='card z-depth-2 col-md-12' style='float: left;margin-bottom: 2px;background-color: rgba(3, 169, 244, 0.1);padding: 1%;font-family: cursive;'>"
						+"<div style='float: left;font-family: Comic Sans MS;font-size: small;'>"+rs.getString("createdBy_txt")+"</div>"
						+"<div style='float: left;font-family: Comic Sans MS;padding-left: 2%;color: #656565;'>"+rs.getString("remarks")+"</div>"
						+"</div></div>"
						+"</div><br>";/*
						+"<div id='pagination'>" 
						+"<div class='col-md-12'>" 
						+"<ul class='pagination' style='float:  right;'>" 
						+"<li class='page-item'><a class='page-link' href='#'>Previous</a></li>"
						+liStr+"<li class='page-item'><a class='page-link' href='#'>Next</a></li>"
						+"</ul>"
						+"</div>" 
						+"</div>";*/
			}
//			int i=Integer.parseInt(request.getParameter("start"))+5;
//			if(outstr!="")
//			outstr+=
				//outstr+="<a href='../../../GetCommentsHistory?poaId="+request.getParameter("poaId")+"&action=200006&start="+i+"&limit=5'>Load More . . .</a>";
			if(outstr!="")out.println(outstr);
			else out.println("0");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            out.close();  // Always close the output writer
        }
	}

	/*private String getPaginationLi(String poaId) {
		String str="";
        conn= MySqlConnect.DBConnection();
        String sql = "SELECT count(rowid) as total FROM stylrite_general.taskloglist where 1=1 ";
        if(poaId!=null) {
        	sql+=" AND poaId='"+poaId+"'";
		}
        	sql+=" AND action='200006";
        sql+=" order by createdOn desc";
        int k=0;
        try {
        	stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				k=rs.getString("createdBy_txt")?
			}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            //conn.close();  // Always close the output writer
        }
        return str;
	}*/

}
