package com.crm.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class ClientAddress extends Client{
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
    private String addressId;
    private String branchName;
    private long contactNo;
    private String addressLine1;
    private String addressLine2;
    private String ledgerName;
    private String locationAdd;
    private String city;
    private String state;
    private String gstNo;
    private int pincode;
    private String isDefault;
    private String createdByAdd;
    private String updatedByAdd;
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLedgerName() {
		return ledgerName;
	}
	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}
	public String getLocationAdd() {
		return locationAdd;
	}
	public void setLocationAdd(String locationAdd) {
		this.locationAdd = locationAdd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getCreatedByAdd() {
		return createdByAdd;
	}
	public void setCreatedByAdd(String createdByAdd) {
		this.createdByAdd = createdByAdd;
	}
	public String getUpdatedByAdd() {
		return updatedByAdd;
	}
	public void setUpdatedByAdd(String updatedByAdd) {
		this.updatedByAdd = updatedByAdd;
	}
	
	public boolean newAddress() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_general.d_clientaddress "
					+ "(rowId, clientId, branchName, contactNo, addressLine1, addressLine2,"
					+ " ledgerName, location, city, state, gstNo, pincode, isDefault,"
					+ " createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, addressId);
	        stmt.setString(2, super.getClientId());
	        stmt.setString(3, branchName);
	        stmt.setLong(4, contactNo);
	        stmt.setString(5, addressLine1);
	        stmt.setString(6, addressLine2);
	        stmt.setString(7, ledgerName);
	        stmt.setString(8, locationAdd);
	        stmt.setString(9, city);
	        stmt.setString(10, state);
	        stmt.setString(11, gstNo);
	        stmt.setInt(12, pincode);
	        stmt.setString(13, isDefault);
	        stmt.setTimestamp(14, timestamp);
	        stmt.setTimestamp(15, timestamp);
	        stmt.setString(16, createdByAdd);
	        stmt.setString(17, updatedByAdd);
	        
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
	
	public boolean updateAddress()
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
	}
}
