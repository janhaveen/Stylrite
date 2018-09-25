package com.inventory.barcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class ChildBarcodeLog {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private String ChildBarcodeLogId; 
	private String productid; 
	private String barcode; 
	private String stockId; 
	private String stockActionType; 
	private String issuesTo; 
	private String refNo; 
	private String reason; 
	private String createdBy;
	public String getChildBarcodeLogId() {
		return ChildBarcodeLogId;
	}
	public void setChildBarcodeLogId(String childBarcodeLogId) {
		ChildBarcodeLogId = childBarcodeLogId;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getStockActionType() {
		return stockActionType;
	}
	public void setStockActionType(String stockActionType) {
		this.stockActionType = stockActionType;
	}
	public String getIssuesTo() {
		return issuesTo;
	}
	public void setIssuesTo(String issuesTo) {
		this.issuesTo = issuesTo;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	} 
	
	public boolean newChildBarcodeLog()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_inventory.d_childbarcode_log "
					+ "(rowId, productid, barcode, stockId, stockActionType, "
					+ "issuesTo, refNo, reason, createdBy, createdOn) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, ChildBarcodeLogId);
	        stmt.setString(2, productid);
	        stmt.setString(3, barcode);
	        stmt.setString(4, stockId);
	        stmt.setString(5, stockActionType);
	        stmt.setString(6, issuesTo);
	        stmt.setString(7, refNo);
	        stmt.setString(8, reason);
	        stmt.setString(9, createdBy);
	        stmt.setTimestamp(10, timestamp);	        
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
