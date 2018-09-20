package com.inventory.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class RequisitionItem extends Requisition{
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String requisitionItemId;
    private String productId;
    private String requisitionItemStatus;
    private String requisitionItemCreatedBy;
    private String requisitionItemUpdatedBy;
    
	public String getRequisitionItemId() {
		return requisitionItemId;
	}
	public void setRequisitionItemId(String requisitionItemId) {
		this.requisitionItemId = requisitionItemId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getRequisitionItemStatus() {
		return requisitionItemStatus;
	}
	public void setRequisitionItemStatus(String requisitionItemStatus) {
		this.requisitionItemStatus = requisitionItemStatus;
	}
	public String getRequisitionItemCreatedBy() {
		return requisitionItemCreatedBy;
	}
	public void setRequisitionItemCreatedBy(String requisitionItemCreatedBy) {
		this.requisitionItemCreatedBy = requisitionItemCreatedBy;
	}
	public String getRequisitionItemUpdatedBy() {
		return requisitionItemUpdatedBy;
	}
	public void setRequisitionItemUpdatedBy(String requisitionItemUpdatedBy) {
		this.requisitionItemUpdatedBy = requisitionItemUpdatedBy;
	}
	
	public boolean newRequisitionItem()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_inventory.d_requisition_items "
					+ "(rowId, requisitionId, productId, status,"
					+ " createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, requisitionItemId);
	        stmt.setString(2, super.getRequisitionId());
	        stmt.setString(3, productId);
	        stmt.setString(4, requisitionItemStatus);
	        stmt.setTimestamp(5, timestamp);
	        stmt.setTimestamp(6, timestamp);
	        stmt.setString(7, requisitionItemCreatedBy);
	        stmt.setString(8, requisitionItemUpdatedBy);
	        
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
	
	public boolean updateStatus()
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
	}
	
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
