package com.requistion.requistion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class RequisitionLog extends Requisition{
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String requisitionLogId;
    private String productId;
    private String action;
    private String remarks;
    private String requisitionLogStatus;
    private String requisitionLogCreatedBy;
    
	public String getRequisitionLogId() {
		return requisitionLogId;
	}
	public void setRequisitionLogId(String requisitionLogId) {
		this.requisitionLogId = requisitionLogId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRequisitionLogStatus() {
		return requisitionLogStatus;
	}
	public void setRequisitionLogStatus(String requisitionLogStatus) {
		this.requisitionLogStatus = requisitionLogStatus;
	}
	public String getRequisitionLogCreatedBy() {
		return requisitionLogCreatedBy;
	}
	public void setRequisitionLogCreatedBy(String requisitionLogCreatedBy) {
		this.requisitionLogCreatedBy = requisitionLogCreatedBy;
	}
	
	public boolean newRequisitionLog()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_inventory.f_requistion_log "
					+ "(rowId, requisitionId, action, remarks, status,"
					+ " createdOn, createdBy) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, requisitionLogId);
	        stmt.setString(2, super.getRequisitionId());
	        stmt.setString(3, action);
	        stmt.setString(4, remarks);
	        stmt.setString(5, requisitionLogStatus);
	        stmt.setTimestamp(6, timestamp);
	        stmt.setString(7, requisitionLogCreatedBy);
	        
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
