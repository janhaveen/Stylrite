package com.inventory.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;

public class Product {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
	private String  ProductId; 
	private String  brand; 
	private String  modelNo; 
	private String  hsnId; 
	private String  color; 
	private String  size; 
	private float  price; 
	private String  Tags; 
	private String  description;
	private String  createdBy;
	private String  sku;
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getHsnId() {
		return hsnId;
	}
	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTags() {
		return Tags;
	}
	public void setTags(String tags) {
		Tags = tags;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	} 	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public boolean modify_product(String type) {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO stylrite_inventory.d_product "
						+ "(rowId, brand, modelNo, hsnId, "
						+ "color, size, price, Tags, description, "
						+ "systemMac, systemIp, systemName, createdBy, updatedBy, "
						+ "createdOn, updatedOn,sku ) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, ProductId);
	            stmt.setString(2, brand);
	            stmt.setString(3, modelNo);
	            stmt.setString(4, hsnId);
	            stmt.setString(5, color);
	            stmt.setString(6, size);
	            stmt.setFloat(7, price);
	            stmt.setString(8, Tags);
	            stmt.setString(9, description);
	            stmt.setString(10, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
	            stmt.setString(11, GetSystemDetails.getIp());
	            stmt.setString(12, GetSystemDetails.getSystemName());
	            stmt.setString(13, createdBy);
	            stmt.setString(14, createdBy);
	            stmt.setTimestamp(15, timestamp);
	            stmt.setTimestamp(16, timestamp);
	            stmt.setString(17, sku);
        	}else if(type.indexOf("update")>=0){
        		String sql = "update stylrite_inventory.d_product  set"
    					+ " brand=?,  modelNo=?,  hsnId=?,  color=?,  "
    					+ "size=?,  price=?,  Tags=?,  description=?,  "
    					+ "systemMac=?,  systemIp=?,  systemName=?,  updatedBy=?,  "
    					+ "updatedOn=?, sku=? where rowId = ?";
    			stmt = conn.prepareStatement(sql);
    			stmt.setString(1, brand);
	            stmt.setString(2, modelNo);
	            stmt.setString(3, hsnId);
	            stmt.setString(4, color);
	            stmt.setString(5, size);
	            stmt.setFloat(6, price);
	            stmt.setString(7, Tags);
	            stmt.setString(8, description);
	            stmt.setString(9, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
	            stmt.setString(10, GetSystemDetails.getIp());
	            stmt.setString(11, GetSystemDetails.getSystemName());
	            stmt.setString(12, createdBy);
	            stmt.setTimestamp(13, timestamp);
	            stmt.setString(14, sku);
	            stmt.setString(15, ProductId);
        	}System.out.println(stmt);
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
