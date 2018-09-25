package com.data.session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;

import java.sql.*;


@SuppressWarnings("serial")
@WebServlet(description = "UserLogIn", urlPatterns = { "/LogIn" })
public class Login extends HttpServlet {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		conn= MySqlConnect.DBConnection();
		
		PrintWriter out = response.getWriter();
		try
		{
			PreparedStatement stmt = conn.prepareStatement("select * from stylrite_general.employeelist where userId=? and password=?;");
			stmt.setString(1, request.getParameter("userId"));
			stmt.setString(2, request.getParameter("password"));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				session.setAttribute("userName", rs.getString("firstName"));
				session.setAttribute("userId", rs.getString("rowId"));
				session.setAttribute("password", request.getParameter("password"));
				session.setAttribute("Department", rs.getString("department"));
				session.setAttribute("Designation", rs.getString("designation"));
				session.setAttribute("departmentTxt", rs.getString("deptText"));
				session.setAttribute("designationTxt", rs.getString("desigText"));
				/*session.setAttribute("DepartmentDesc", rs.getString("deptText"));
				session.setAttribute("DesignationDesc", rs.getString("desigText"));*/
//				out.println(rs.getString("department"));
				out.println("1");
			}else {
				out.println("0");
			}
			conn.close();
			}
		catch (SQLException ex) {
			ex.printStackTrace();
			out.println(ex.toString());
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.sendRedirect("index.html");
		
	}
}