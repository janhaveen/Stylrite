package com.admin.hsn;

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
 * Servlet implementation class RegisterEmplyee
 */
@WebServlet("/ModifyHsn")
public class ModifyHsn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		HsnId hsn = new HsnId();
		hsn.setRowId(request.getParameter("selectedHSNId"));
		hsn.setHsnId(request.getParameter("hsnId"));
		hsn.setSgst(request.getParameter("sgst"));
		hsn.setCgst(request.getParameter("cgst"));
		hsn.setIgst(request.getParameter("igst"));
		/*hsn.setUgst(request.getParameter("ugst"));*/
		hsn.setUserID(session.getAttribute("userId").toString());
		
		if (hsn.hsnid_action(request.getParameter("action"))) {
			out.println("1");
		} else {
			out.println("0");
		}
			
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM sment_general.d_hsn where rowId ='"+ request.getParameter("DeleteElementId") +"';");
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
