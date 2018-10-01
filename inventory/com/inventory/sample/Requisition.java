package com.inventory.sample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Requisition {
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String requisitionId;
    private String reason;
    private Date expectedReceiptDate;
    private String modeofDelivery;
    private Date dispatchedDate;
    private String transportName;
    private String trackingID;
    private String eBillNo;
    private Date receiptDate;
    private String requisitionType;
    private String requisitionStatus;
    private String requisitionCreatedBy;
    private String requisitionUpdatedBy;
    
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getExpectedReceiptDate() {
		return expectedReceiptDate;
	}
	public void setExpectedReceiptDate(Date expectedReceiptDate) {
		this.expectedReceiptDate = expectedReceiptDate;
	}
	public String getModeofDelivery() {
		return modeofDelivery;
	}
	public void setModeofDelivery(String modeofDelivery) {
		this.modeofDelivery = modeofDelivery;
	}
	public Date getDispatchedDate() {
		return dispatchedDate;
	}
	public void setDispatchedDate(Date dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}
	public String getTransportName() {
		return transportName;
	}
	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}
	public String getTrackingID() {
		return trackingID;
	}
	public void setTrackingID(String trackingID) {
		this.trackingID = trackingID;
	}
	public String geteBillNo() {
		return eBillNo;
	}
	public void seteBillNo(String eBillNo) {
		this.eBillNo = eBillNo;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String getRequisitionType() {
		return requisitionType;
	}
	public void setRequisitionType(String requisitionType) {
		this.requisitionType = requisitionType;
	}
	public String getRequisitionStatus() {
		return requisitionStatus;
	}
	public void setRequisitionStatus(String requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}
	public String getRequisitionCreatedBy() {
		return requisitionCreatedBy;
	}
	public void setRequisitionCreatedBy(String requisitionCreatedBy) {
		this.requisitionCreatedBy = requisitionCreatedBy;
	}
	public String getRequisitionUpdatedBy() {
		return requisitionUpdatedBy;
	}
	public void setRequisitionUpdatedBy(String requisitionUpdatedBy) {
		this.requisitionUpdatedBy = requisitionUpdatedBy;
	}
	
	public boolean newRequisition() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_inventory.d_requisition "
					+ "(rowId, reason, expectedReceiptDate, modeofDelivery, dispatchedDate, "
					+ "transportName, trackingID, eBillNo, receiptDate, requisitionType, status, "
					+ "createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, requisitionId);
	        stmt.setString(2, reason);
	        stmt.setDate(3, expectedReceiptDate);
	        stmt.setString(4, modeofDelivery);
	        stmt.setDate(5, dispatchedDate);
	        stmt.setString(6, transportName);
	        stmt.setString(7, trackingID);
	        stmt.setString(8, eBillNo);
	        stmt.setDate(9, receiptDate);
	        stmt.setString(10, requisitionType);
	        stmt.setString(11, requisitionStatus);
	        stmt.setTimestamp(12, timestamp);
	        stmt.setTimestamp(13, timestamp);
	        stmt.setString(14, requisitionCreatedBy);
	        stmt.setString(15, requisitionUpdatedBy);
	        
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
	
	public boolean updateRequisition()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_inventory.d_requisition set"
					+ " reason = ?, expectedReceiptDate=?, modeofDelivery=?, dispatchedDate=?, transportName=?,"
					+ " trackingID=?, eBillNo=?, receiptDate=?, requisitionType=?, status=?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, reason);
	        stmt.setDate(2, expectedReceiptDate);
	        stmt.setString(3, modeofDelivery);
	        stmt.setDate(4, dispatchedDate);
	        stmt.setString(5, transportName);
	        stmt.setString(6, trackingID);
	        stmt.setString(7, eBillNo);
	        stmt.setDate(8, receiptDate);
	        stmt.setString(9, requisitionType);
	        stmt.setString(10, requisitionStatus);
	        stmt.setString(15, requisitionUpdatedBy);
	        stmt.setTimestamp(11, timestamp);
	        stmt.setString(12, requisitionId);
	        
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
	
	public boolean updateStatus()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_inventory.d_requisition set"
					+ " status = ?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			
			stmt = conn.prepareStatement(sql);
			
	        stmt.setString(1, requisitionStatus);
	        stmt.setString(2, requisitionUpdatedBy);
	        stmt.setTimestamp(3, timestamp);
	        stmt.setString(4, requisitionId);
	        
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
	
	public boolean updateRequisitionDispatchDetails()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_inventory.d_requisition set"
					+ " dispatchedDate = ?, transportName = ?,"
					+ " trackingID = ?, eBillNo = ?, status = ?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			
			stmt = conn.prepareStatement(sql);
			
	        stmt.setDate(1, dispatchedDate);
	        stmt.setString(2, transportName);
	        stmt.setString(3, trackingID);
	        stmt.setString(4, eBillNo);
	        stmt.setString(5, requisitionStatus);
	        stmt.setString(6, requisitionUpdatedBy);
	        stmt.setTimestamp(7, timestamp);
	        stmt.setString(8, requisitionId);
	        
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
	
	public boolean updateRequisitionRecievedDetails()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_inventory.d_requisition set"
					+ " receiptDate = ?, status = ?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			
			stmt = conn.prepareStatement(sql);
			
	        stmt.setDate(1, receiptDate);
	        stmt.setString(2, requisitionStatus);
	        stmt.setString(3, requisitionUpdatedBy);
	        stmt.setTimestamp(4, timestamp);
	        stmt.setString(5, requisitionId);
	        
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
}
