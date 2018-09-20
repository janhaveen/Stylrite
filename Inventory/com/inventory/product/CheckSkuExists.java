package com.inventory.product;

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

/**
 * Servlet implementation class CheckSkuExists
 */
@WebServlet("/CheckSkuExists")
public class CheckSkuExists extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		int i=0;
		String sql="SELECT * FROM stylrite_inventory.d_product "
				+ "where 1=1 AND brand ='"+ request.getParameter("brand") +"'"
				+ " AND modelNo='"+ request.getParameter("model") +"'"
				+ " AND color='"+ request.getParameter("color") +"'"
				+ " AND size='"+ request.getParameter("size") +"'";
		System.out.println(sql);
		try {
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				i++;
			}
			if(i>0) {
				out.println("0");
			}else {
				out.println("1");
			}
		}catch (SQLException e) {
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