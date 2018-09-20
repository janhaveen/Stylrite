package com.inventory.barcode;

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

import org.json.JSONArray;

import com.data.MySql.MySqlConnect;

/**
 * Servlet implementation class GetLastInsertedChildBarcode
 */
@WebServlet("/GetLastInsertedChildBarcode")
public class GetLastInsertedChildBarcode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		conn = MySqlConnect.DBConnection();
		PrintWriter out=response.getWriter();
        int lastInserted=1;
    	String sql = "SELECT max(rowNo) as total FROM stylrite_inventory.d_child_barcode ORDER BY rowNo DESC LIMIT 1";

		try {
        	System.out.println(sql);
        	stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lastInserted=rs.getString("total")==null?1:rs.getInt("total")+1;
			}
			out.println(lastInserted);
			conn.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            lastInserted = 1;
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
