package com.order.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Stock {
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String orderItemId;
    private int qty;
    private String status;
    private String createdBy;
    
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public boolean newOrderExctn() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_sales.f_order_execution "
					+ "(orderItemId, qty, status,"
					+ " createdOn, createdBy) VALUES "
					+ "( ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, orderItemId);
	        stmt.setInt(2, qty);
	        stmt.setString(3, status);
	        stmt.setTimestamp(4, timestamp);
	        stmt.setString(5, createdBy);
	        
	        System.out.println(stmt);
		    stmt.executeUpdate();
		    returnVal = true;
		    conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return returnVal;
    }
}
