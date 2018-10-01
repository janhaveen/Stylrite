package com.admin.legend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;


@WebServlet("/ModifyLegend")

public class ModifyLegend extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		HttpSession session = request.getSession();
		Legend lgnd = new Legend();
		
		lgnd.setRowId(request.getParameter("selectedLegendId"));
		lgnd.setProjectId(request.getParameter("ProjectId"));
		lgnd.setLegendGroup(request.getParameter("legendGroup"));
		lgnd.setCategory(request.getParameter("category"));
		lgnd.setSubCategory(request.getParameter("subCategory"));
		lgnd.setDescription(request.getParameter("description"));
		
		if (lgnd.legend_action(request.getParameter("action"))) {
			out.println("1");
		} else {
			out.println("0");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			PrintWriter out = response.getWriter();
			
			Connection conn = MySqlConnect.DBConnection();;
			PreparedStatement stmt;
			HttpSession session=request.getSession();
			String sql="";
			if (session.getAttribute("departmentTxt").equals("IT")) {
				 sql = "DELETE FROM propel_legend.d_project_general_legend where rowId ='"+ request.getParameter("id") +"'";
			}else {
				sql="UPDATE propel_legend.d_project_general_legend SET isDeleted=1 where rowId ='"+ request.getParameter("id") +"'";
			}
			
			try {
				stmt = conn.prepareStatement(sql);
				int i= stmt.executeUpdate();
				if(i > 0)
				{
					
					out.println("1");
				}
				else 
				{
					out.println("0");
					
				}
				
			} catch (SQLException e) {
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
