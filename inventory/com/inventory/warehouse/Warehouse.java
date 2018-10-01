package com.inventory.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;


public class Warehouse {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
	private String WarehouseId;
	private String name;
	private String location;
	private String address; 
	private String pincode; 
	private String state; 
	private float area; 
	private String systemMac; 
	private String systemIp; 
	private String systemName; 
	private String createdBy;
	private String City;
	private String address1;
	private String areaAddress;
	private String typeOfBr;
	private String branchManager;
	private String GSTNumber;
	public String getWarehouseId() {
		return WarehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.WarehouseId = warehouseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public String getSystemMac() {
		return systemMac;
	}
	public void setSystemMac(String systemMac) {
		this.systemMac = systemMac;
	}
	public String getSystemIp() {
		return systemIp;
	}
	public void setSystemIp(String systemIp) {
		this.systemIp = systemIp;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAreaAddress() {
		return areaAddress;
	}
	public void setAreaAddress(String areaAddress) {
		this.areaAddress = areaAddress;
	}	
	public String getTypeOfBr() {
		return typeOfBr;
	}
	public void setTypeOfBr(String typeOfBr) {
		this.typeOfBr = typeOfBr;
	}
	public String getBranchManager() {
		return branchManager;
	}
	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}
	public String getGSTNumber() {
		return GSTNumber;
	}
	public void setGSTNumber(String gSTNumber) {
		GSTNumber = gSTNumber;
	}
	public boolean Warehouse_action(String type) {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try { 
        	if(type.indexOf("insert") >=0) {
	        	String sql = "INSERT INTO stylrite_inventory.d_warehouse"
	        			   + "(rowId, name, location, address, city, "
	        			   + "pincode, state, area, systemMac, systemIp, systemName, "
	        			   + "createdBy, updatedBy, createdOn, updatedOn, address1,areaAddress, type, branchManager, GSTNumber)"
	        			   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	            stmt = conn.prepareStatement(sql); 
	            stmt.setString(1, WarehouseId);
	            stmt.setString(2, name);
	            stmt.setString(3, location); 
	            stmt.setString(4, address);
	            stmt.setString(5, City);
	            stmt.setString(6, pincode);	        
	            stmt.setString(7, state);  
	            stmt.setFloat(8, area);
	            stmt.setString(9, systemMac);
	            stmt.setString(10, systemIp);
	            stmt.setString(11, systemName);
	            stmt.setString(12, createdBy);
	            stmt.setString(13, createdBy);
	            stmt.setTimestamp(14, timestamp);
	            stmt.setTimestamp(15, timestamp);
	            stmt.setString(16, address1);
	            stmt.setString(17, areaAddress);
	            stmt.setString(18, typeOfBr);
	            stmt.setString(19, branchManager);
	            stmt.setString(20, GSTNumber);System.out.println(stmt);
        	}else if(type.indexOf("update")>=0) {
        		String sql = "UPDATE stylrite_inventory.d_warehouse SET  "
        				   + "name=?, location=?, address=?, city=?, pincode=?, state=?, area=?, "
        				   + "systemMac=?, systemIp=?, systemName=?, updatedBy=?, updatedOn=?, "
        				   + "address1=? ,areaAddress=?,  type=?, branchManager=? , GSTNumber=? "
        				   + "WHERE rowId = ?" ;
        		stmt = conn.prepareStatement(sql); 
	            stmt.setString(1, name);
	            stmt.setString(2, location); 
	            stmt.setString(3, address);
	            stmt.setString(4, City);
	            stmt.setString(5, pincode);	        
	            stmt.setString(6, state);  
	            stmt.setFloat(7, area);
	            stmt.setString(8, systemMac);
	            stmt.setString(9, systemIp);
	            stmt.setString(10, systemName);
	            stmt.setString(11, createdBy);
	            stmt.setTimestamp(12, timestamp);
	            stmt.setString(13, address1);
	            stmt.setString(14, areaAddress);
	            stmt.setString(15, typeOfBr);
	            stmt.setString(16, branchManager);
	            stmt.setString(17, GSTNumber);
	            stmt.setString(18, WarehouseId);System.out.println(stmt);	
        	}
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
