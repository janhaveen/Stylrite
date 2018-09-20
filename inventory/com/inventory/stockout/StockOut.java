package com.inventory.stockout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class StockOut {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private String  StockOutId; 
	private String  productid; 
	private String  orderitemid; 
	private String  barcode; 
	private String  refRequisition; 
	private String  typeOf; 
	private String  invoiceid; 
	private String  dispatchid; 
	private String  quantity; 
	private String  createdBy;
	
	public String getStockOutId() {
		return StockOutId;
	}
	public void setStockOutId(String stockOutId) {
		StockOutId = stockOutId;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(String orderitemid) {
		this.orderitemid = orderitemid;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getRefRequisition() {
		return refRequisition;
	}
	public void setRefRequisition(String refRequisition) {
		this.refRequisition = refRequisition;
	}
	public String getTypeOf() {
		return typeOf;
	}
	public void setTypeOf(String typeOf) {
		this.typeOf = typeOf;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getDispatchid() {
		return dispatchid;
	}
	public void setDispatchid(String dispatchid) {
		this.dispatchid = dispatchid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	} 
	public boolean newStockOut()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_inventory.d_stock_out "
					+ "(rowId, productid, orderitemid, barcode, refRequisition, "
					+ "typeOf, invoiceid, dispatchid, quantity, "
					+ "createdBy, updatedBy, createdOn, updatedOn) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, StockOutId);
	        stmt.setString(2, productid);
	        stmt.setString(3, orderitemid);
	        stmt.setString(4, barcode);
	        stmt.setString(5, refRequisition);
	        stmt.setString(6, typeOf);
	        stmt.setString(7, invoiceid);
	        stmt.setString(8, dispatchid);
	        stmt.setString(9, quantity);
	        stmt.setString(10, createdBy);
	        stmt.setString(11, createdBy);
	        stmt.setTimestamp(12, timestamp);
	        stmt.setTimestamp(13, timestamp);
	        
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
