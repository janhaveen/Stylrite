package com.inventory.warehouse;

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
import com.general.system.GetSystemDetails;

/**
 * Servlet implementation class ModifyBranch
 */
@WebServlet("/ModifyWarehouse")
public class ModifyWarehouse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		Warehouse i=new Warehouse();
		i.setWarehouseId(request.getParameter("WarehouseId"));
		i.setName(request.getParameter("Name"));
		i.setLocation(request.getParameter("Location"));
		i.setAddress(request.getParameter("Address"));
		i.setAddress1(request.getParameter("Address2"));
		i.setAreaAddress(request.getParameter("AreaAddress"));
		i.setCity(request.getParameter("city"));
		i.setPincode(request.getParameter("pin"));
		i.setState(request.getParameter("state"));
		i.setTypeOfBr(request.getParameter("typeOfBr"));
		i.setBranchManager(request.getParameter("branchManager"));
		i.setGSTNumber(request.getParameter("GSTNumber"));
		try{
			i.setArea(Float.parseFloat(request.getParameter("Area")));
		}catch (Exception e) {
			i.setArea(Float.parseFloat("0"));
		}
		i.setSystemMac(GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
		i.setSystemIp(GetSystemDetails.getIp());
		i.setSystemName(GetSystemDetails.getSystemName());
		i.setCreatedBy(session.getAttribute("userId").toString());
		
		if(i.Warehouse_action(request.getParameter("action"))) {
			out.println("1");
		}else {
			out.println("0");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM stylrite_inventory.d_warehouse where rowId ='"+ request.getParameter("id") +"';");
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
