package com.order.order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Order {
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String orderId;
    private String clientId;
    private String contactPersonId;
    private String billingAddressId;
    private String deliveryAddressId;
    private String salesPerson;
    private String invoiceType;
    private String modeOfPayment;
    private Date expectedDeilvery;
    private String orderStatus;
    private String orderCreatedBy;
    private String orderUpdatedBy;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getContactPersonId() {
		return contactPersonId;
	}
	public void setContactPersonId(String contactPersonId) {
		this.contactPersonId = contactPersonId;
	}
	public String getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public String getDeliveryAddressId() {
		return deliveryAddressId;
	}
	public void setDeliveryAddressId(String deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public Date getExpectedDeilvery() {
		return expectedDeilvery;
	}
	public void setExpectedDeilvery(Date expectedDeilvery) {
		this.expectedDeilvery = expectedDeilvery;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderCreatedBy() {
		return orderCreatedBy;
	}
	public void setOrderCreatedBy(String orderCreatedBy) {
		this.orderCreatedBy = orderCreatedBy;
	}
	public String getOrderUpdatedBy() {
		return orderUpdatedBy;
	}
	public void setOrderUpdatedBy(String orderUpdatedBy) {
		this.orderUpdatedBy = orderUpdatedBy;
	}
	
	public boolean newOrder() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_sales.d_order "
					+ "(rowId, clientId, contactPersonId, billingAddressId, deliveryAddressId, "
					+ "salesPerson, invoiceType, modeOfPayment, expectedDeilvery, status, "
					+ "createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, orderId);
	        stmt.setString(2, clientId);
	        stmt.setString(3, contactPersonId);
	        stmt.setString(4, billingAddressId);
	        stmt.setString(5, deliveryAddressId);
	        stmt.setString(6, salesPerson);
	        stmt.setString(7, invoiceType);
	        stmt.setString(8, modeOfPayment);
	        stmt.setDate(9, expectedDeilvery);
	        stmt.setString(10, orderStatus);
	        stmt.setTimestamp(11, timestamp);
	        stmt.setTimestamp(12, timestamp);
	        stmt.setString(13, orderCreatedBy);
	        stmt.setString(14, orderUpdatedBy);
	        
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
	
	/*public boolean updateRequisition()
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
	}*/
}
