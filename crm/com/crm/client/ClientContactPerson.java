package com.crm.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class ClientContactPerson extends Client{
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private String contactPId;
    private String firstName;
    private String lastName;
    private Long contactNo;
    private Long altContactNo;
    private String emailId;
    private String department;
    private String designation;
    private Date birthdate;
    private String location;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	    	String sql = "INSERT INTO stylrite_general.d_clientcontactperson "
					+ "(rowId, clientId, firstName, lastName, contactNo, altContactNo, emailId,"
					+ " department, designation, birthdate, location, isDefault,"
					+ " createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, contactPId);
	        stmt.setString(2, super.getClientId());
	        stmt.setString(3, firstName);
	        stmt.setString(4, lastName);
	        stmt.setLong(5, contactNo);
	        stmt.setLong(6, altContactNo);
	        stmt.setString(7, emailId);
	        stmt.setString(8, department);
	        stmt.setString(9, designation);
	        stmt.setDate(10, birthdate);
	        stmt.setString(11, location);
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
			String sql = "update stylrite_general.d_clientcontactperson set"
					+ " firstName=?,  lastName=?,  contactNo=?,  altContactNo=?, emailId=?,"
					+ " department=?,  designation=?,  birthdate=?,  location=?,  isDefault=?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, firstName);
	        stmt.setString(2, lastName);
	        stmt.setLong(3, contactNo);
	        stmt.setLong(4, altContactNo);
	        stmt.setString(5, emailId);
	        stmt.setString(6, department);
	        stmt.setString(7, designation);
	        stmt.setDate(8, birthdate);
	        stmt.setString(9, location);
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
