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

import com.data.MySql.MySqlConnect;

@WebServlet("/GetRequisitionCommentsHistory")
public class GetRequisitionCommentsHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        conn= MySqlConnect.DBConnection();
        String sql = "SELECT * FROM stylrite_inventory.requisitionloglist where 1=1 ";
        if(request.getParameter("requisitionId")!=null) {
        	sql+="AND requisitionId='"+request.getParameter("requisitionId")+"'";
		}
       // if(request.getParameter("action")!=null) {
        	/*sql+=" AND action IN (400000000011, 400000000010)";*/
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
				outstr+= "<div class='row'>"
            			+"<input type='hidden' id='start' value='"+request.getParameter("start")+"'>"
						+rs.getString("createdBy_txt")
						+"<div class='col-md-10'>"+rs.getString("remarks")+"</div>"
						+"</div>";
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
