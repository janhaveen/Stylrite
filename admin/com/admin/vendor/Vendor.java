package com.admin.vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Vendor {
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String vendorId;
    private String vendorName;
    private String vendorType;
    private String email;
    private String location;
    private int creditTime;
    private int creditLimit;
    private String website;
    private long landlineNo;
    private String industryType;
    private String source;
    private String referenceBy;
    private String categories;
	private String createdBy;
	private String updatedBy;
	
	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCreditTime() {
		return creditTime;
	}

	public void setCreditTime(int creditTime) {
		this.creditTime = creditTime;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public long getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(long landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
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

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
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

	public boolean newVendor() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
	    	String sql = "INSERT INTO stylrite_general.d_vendor "
					+ "(rowId, vendorName, vendorType, email, location, creditTime, creditLimit,"
					+ " website, landlineNo, industryType, source, referenceBy, categories,"
					+ " createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, vendorId);
	        stmt.setString(2, vendorName);
	        stmt.setString(3, vendorType);
	        stmt.setString(4, email);
	        stmt.setString(5, location);
	        stmt.setInt(6, creditTime);
	        stmt.setInt(7, creditLimit);
	        stmt.setString(8, website);
	        stmt.setLong(9, landlineNo);
	        stmt.setString(10, industryType);
	        stmt.setString(11, source);
	        stmt.setString(12, referenceBy);
	        stmt.setString(13, categories);
	        stmt.setTimestamp(14, timestamp);
	        stmt.setTimestamp(15, timestamp);
	        stmt.setString(16, createdBy);
	        stmt.setString(17, updatedBy);
	        
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
			String sql = "update stylrite_general.d_vendor  set"
					+ " vendorName = ?, vendorType = ?, email = ?, location = ?,"
					+ " creditTime = ?, creditLimit = ?, website = ?, landlineNo = ?,"
					+ " industryType = ?, source = ?, referenceBy = ?, categories = ?,"
					+ " updatedBy= ?, updatedOn = ? where rowId = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vendorName);
	        stmt.setString(2, vendorType);
	        stmt.setString(3, email);
	        stmt.setString(4, location);
	        stmt.setInt(5, creditTime);
	        stmt.setInt(6, creditLimit);
	        stmt.setString(7, website);
	        stmt.setLong(8, landlineNo);
	        stmt.setString(9, industryType);
	        stmt.setString(10, source);
	        stmt.setString(11, referenceBy);
	        stmt.setString(12, categories);
	        stmt.setString(13, updatedBy);
	        stmt.setTimestamp(14, timestamp);
	        stmt.setString(15, vendorId);
	        
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
		    	sql = "update stylrite_general.d_vendor_contactperson  set"
						+ " isDefault = 0 "
						+ "where vendorId = ?";
        	}
        	else
        	{
		    	sql = "update stylrite_general.d_vendor_address set"
						+ " isDefault = 0 "
						+ "where vendorId = ?";
        	}
			stmt = conn.prepareStatement(sql);
			
            stmt.setString(1, vendorId);
			
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
