package com.admin.vendor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class VendorContactPerson extends Vendor {
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private String contactPId;
    private String firstName;
    private String lastName;
    private String location;
    private Long contactNo;
    private Long altContactNo;
    private Date birthdate;
    private String emailId;
    private String department;
    private String designation;
    private String isDefault;
    private String createdByCP;
    private String updatedByCP;
    
	public String getContactPId() {
		return contactPId;
	}
	public void setContactPId(String contactPId) {
		this.contactPId = contactPId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Long getAltContactNo() {
		return altContactNo;
	}
	public void setAltContactNo(Long altContactNo) {
		this.altContactNo = altContactNo;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getCreatedByCP() {
		return createdByCP;
	}
	public void setCreatedByCP(String createdByCP) {
		this.createdByCP = createdByCP;
	}
	public String getUpdatedByCP() {
		return updatedByCP;
	}
	public void setUpdatedByCP(String updatedByCP) {
		this.updatedByCP = updatedByCP;
	}
	
	public boolean newContactPerson() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_general.d_vendor_contactperson "
					+ "(rowId, vendorId, firstName, lastName, location,"
					+ " contactNo, altContactNo, birthdate, emailId,"
					+ " department, designation, isDefault,"
					+ " createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, contactPId);
	        stmt.setString(2, super.getVendorId());
	        stmt.setString(3, firstName);
	        stmt.setString(4, lastName);
	        stmt.setString(5, location);
	        stmt.setLong(6, contactNo);
	        stmt.setLong(7, altContactNo);
	        stmt.setDate(8, birthdate);
	        stmt.setString(9, emailId);
	        stmt.setString(10, department);
	        stmt.setString(11, designation);
	        stmt.setString(12, isDefault);
	        stmt.setTimestamp(13, timestamp);
	        stmt.setTimestamp(14, timestamp);
	        stmt.setString(15, createdByCP);
	        stmt.setString(16, updatedByCP);
	        
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
	
	public boolean updateContactPerson()
	{
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
		try
		{
			String sql = "update stylrite_general.d_vendor_contactperson set"
					+ " firstName=?, lastName=?, location=?, contactNo=?, altContactNo=?,"
					+ " birthdate=?, emailId=?, department=?, designation=?, isDefault=?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, firstName);
	        stmt.setString(2, lastName);
	        stmt.setString(3, location);
	        stmt.setLong(4, contactNo);
	        stmt.setLong(5, altContactNo);
	        stmt.setDate(6, birthdate);
	        stmt.setString(7, emailId);
	        stmt.setString(8, department);
	        stmt.setString(9, designation);
	        stmt.setString(10, isDefault);
	        stmt.setString(11, updatedByCP);
	        stmt.setTimestamp(12, timestamp);
	        stmt.setString(13, contactPId);
	        
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
