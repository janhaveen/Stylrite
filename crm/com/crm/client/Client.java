package com.crm.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Client {
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String clientId;
    private String companyName;
    private String location;
    private String customerType;
    private String source;
    private String referenceBy;
    private String creditTime;
    private String creditLimit;
    private String salesPerson;
    
	private String createdBy;
	private String updatedBy;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getReferenceBy() {
		return referenceBy;
	}
	public void setReferenceBy(String referenceBy) {
		this.referenceBy = referenceBy;
	}
	public String getCreditTime() {
		return creditTime;
	}
	public void setCreditTime(String creditTime) {
		this.creditTime = creditTime;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public boolean newClient() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_general.d_client "
					+ "(rowId, companyName, location, customerType, source, "
					+ "referenceBy, creditTime, creditLimit, salesPerson, "
					+ "createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, clientId);
	        stmt.setString(2, companyName);
	        stmt.setString(3, location);
	        stmt.setString(4, customerType);
	        stmt.setString(5, source);
	        stmt.setString(6, referenceBy);
	        stmt.setString(7, creditTime);
	        stmt.setString(8, creditLimit);
	        stmt.setString(9, salesPerson);
	        stmt.setTimestamp(10, timestamp);
	        stmt.setTimestamp(11, timestamp);
	        stmt.setString(12, createdBy);
	        stmt.setString(13, updatedBy);
	        
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
	
	public boolean updateClient()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_general.d_client  set"
					+ " companyName = ?, location=?,  customerType=?,  source=?,  referenceBy=?,"
					+ " creditTime=?,  creditLimit=?,  salesPerson=?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, companyName);
	        stmt.setString(2, location);
	        stmt.setString(3, customerType);
	        stmt.setString(4, source);
	        stmt.setString(5, referenceBy);
	        stmt.setString(6, creditTime);
	        stmt.setString(7, creditLimit);
	        stmt.setString(8, salesPerson);
	        stmt.setString(9, updatedBy);
	        stmt.setTimestamp(10, timestamp);
	        stmt.setString(11, clientId);
	        
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
	
	public boolean reset_default(String flag) {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
        	String sql;
        	if(flag.equals("contactP"))
        	{
		    	sql = "update stylrite_general.d_clientcontactperson  set"
						+ " isDefault = 0 "
						+ "where clientId = ?";
        	}
        	else
        	{
		    	sql = "update stylrite_general.d_clientaddress set"
						+ " isDefault = 0 "
						+ "where clientId = ?";
        	}
			stmt = conn.prepareStatement(sql);
			
            stmt.setString(1, clientId);
			
	        stmt.executeUpdate();
	        returnVal = true;
			
		}catch (SQLException e) {
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
