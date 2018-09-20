package com.inventory.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class ModifyProduct
 */
@WebServlet("/ModifyProduct")
public class ModifyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String sku=request.getParameter("brandAbbr")+"-"+request.getParameter("modelNo")+"-"+request.getParameter("color");
		Product p=new Product();
		p.setProductId(request.getParameter("ProductId"));
		p.setBrand(request.getParameter("brand"));
		p.setModelNo(request.getParameter("modelNo"));
		p.setColor(request.getParameter("color"));
		p.setSize(request.getParameter("size"));
		p.setPrice(Float.parseFloat(request.getParameter("price")));
		p.setHsnId(request.getParameter("hsnId"));
		p.setTags(request.getParameter("tag"));
		p.setDescription(request.getParameter("Description"));
		p.setCreatedBy(session.getAttribute("userId").toString());
		p.setSku(sku);
		
		if(p.modify_product(request.getParameter("action")))
			out.println("1");
		else
			out.println("0");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM stylrite_inventory.d_product where rowId ='"+ request.getParameter("id") +"';");
			int i= stmt.executeUpdate();
			if(i > 0){
				out.println("1");
			}else {
				out.println("0");
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
