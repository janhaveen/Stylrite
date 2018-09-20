package com.order.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class OrderItem extends Order{
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String orderItemId;
    private String productId;
    private int quantity;
    private float rate;
    private int discount;
    private String hsnId;
    private int igst;
    private String orderItemStatus;
    private String orderItemCreatedBy;
    private String orderItemUpdatedBy;
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getHsnId() {
		return hsnId;
	}
	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}
	public int getIgst() {
		return igst;
	}
	public void setIgst(int igst) {
		this.igst = igst;
	}
	public String getOrderItemStatus() {
		return orderItemStatus;
	}
	public void setOrderItemStatus(String orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}
	public String getOrderItemCreatedBy() {
		return orderItemCreatedBy;
	}
	public void setOrderItemCreatedBy(String orderItemCreatedBy) {
		this.orderItemCreatedBy = orderItemCreatedBy;
	}
	public String getOrderItemUpdatedBy() {
		return orderItemUpdatedBy;
	}
	public void setOrderItemUpdatedBy(String orderItemUpdatedBy) {
		this.orderItemUpdatedBy = orderItemUpdatedBy;
	}
	
	public boolean newOrderItem()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_sales.d_order_item "
					+ "(rowId, orderId, productId, quantity,"
					+ " rate, discount, hsnId, igst, status,"
					+ " createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, orderItemId);
	        stmt.setString(2, super.getOrderId());
	        stmt.setString(3, productId);
	        stmt.setInt(4, quantity);
	        stmt.setFloat(5, rate);
	        stmt.setInt(6, discount);
	        stmt.setString(7, hsnId);
	        stmt.setInt(8, igst);
	        stmt.setString(9, orderItemStatus);
	        stmt.setTimestamp(10, timestamp);
	        stmt.setTimestamp(11, timestamp);
	        stmt.setString(12, orderItemCreatedBy);
	        stmt.setString(13, orderItemUpdatedBy);
	        
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
	
	/*public boolean updateStatus()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_inventory.d_requisition_items set"
					+ " status = ?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			
			stmt = conn.prepareStatement(sql);
			
	        stmt.setString(1, requisitionItemStatus);
	        stmt.setString(2, requisitionItemUpdatedBy);
	        stmt.setTimestamp(3, timestamp);
	        stmt.setString(4, requisitionItemId);
	        
	        System.out.println(stmt);
		    stmt.executeUpdate(); 
		    returnVal = true;
		    conn.close();
	    }
	    catch (SQLException e)
		{
	        e.printStackTrace();
	    	returnVal = false;
	    }
	    finally
	    {
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	    return returnVal;
	}*/
	
	/*public boolean updateRequisitionItem()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_general.d_clientaddress set"
					+ " branchName=?,  contactNo=?,  addressLine1=?,  addressLine2=?,"
					+ " ledgerName=?,  location=?,  city=?,  state=?,  gstNo=?,  pincode=?,  isDefault=?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, branchName);
	        stmt.setLong(2, contactNo);
	        stmt.setString(3, addressLine1);
	        stmt.setString(4, addressLine2);
	        stmt.setString(5, ledgerName);
	        stmt.setString(6, locationAdd);
	        stmt.setString(7, city);
	        stmt.setString(8, state);
	        stmt.setString(9, gstNo);
	        stmt.setInt(10, pincode);
	        stmt.setString(11, isDefault);
	        stmt.setString(12, updatedByAdd);
	        stmt.setTimestamp(13, timestamp);
	        stmt.setString(14, addressId);
	        
	        System.out.println(stmt);
		    stmt.executeUpdate(); 
		    returnVal = true;
		    conn.close();
	    }
	    catch (SQLException e)
		{
	        e.printStackTrace();
	    	returnVal = false;
	    }
	    finally
	    {
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	    return returnVal;
	}*/

}
