package com.inventory.barcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;

public class ChildBarcode {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
	private String rowId; 
	private String productId; 
	private String location; 
	private String purchaseorderitemid; 
	private float rate; 
	private String status; 
	private String createdBy;
	private String GRNNumber;
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPurchaseorderitemid() {
		return purchaseorderitemid;
	}
	public void setPurchaseorderitemid(String purchaseorderitemid) {
		this.purchaseorderitemid = purchaseorderitemid;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	} 
	public String getGRNNumber() {
		return GRNNumber;
	}
	public void setGRNNumber(String gRNNumber) {
		GRNNumber = gRNNumber;
	}
	public String addProduct_inBox(String type) {
		String returnVal = "";
        conn = MySqlConnect.DBConnection();
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO stylrite_inventory.d_child_barcode "
						+ "(rowId, productId, location, purchaseorderitemid, "
						+ "rate, status, createdBy, updatedBy, createdOn, updatedOn, GRNNumber ) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, rowId);
	            stmt.setString(2, productId);
	            stmt.setString(3, location);
	            stmt.setString(4, purchaseorderitemid);
	            stmt.setFloat(5, rate);
	            stmt.setString(6, status);
	            stmt.setString(7, createdBy);
	            stmt.setString(8, createdBy);
	            stmt.setTimestamp(9, timestamp);
	            stmt.setTimestamp(10, timestamp);
	            stmt.setString(11, GRNNumber);
        	}else if(type.indexOf("update")>=0){
        		String sql = "update stylrite_inventory.d_child_barcode  set"
    					+ " location=? where rowId = ?";
    			stmt = conn.prepareStatement(sql);
	            stmt.setString(1, location);
	            stmt.setString(2, rowId);
        	}
            stmt.executeUpdate(); 
            returnVal = rowId;
            conn.close();
            }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = "";
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
	
	public int getLastInsertedId() {
		int lastInserted = 1;
        conn = MySqlConnect.DBConnection();
        try {
        	String sql = "SELECT max(rowNo) as total FROM stylrite_inventory.d_child_barcode ORDER BY rowNo DESC LIMIT 1";
        	stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lastInserted=rs.getString("total")==null?1:rs.getInt("total")+1;
			}
			conn.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            lastInserted = 1;
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return lastInserted;
	}
	
	public boolean updateBoxBarcodeQty() {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
        	String sql = "update stylrite_inventory.d_box_barcode  set quantity=quantity+1 where location=?";
        	stmt = conn.prepareStatement(sql);
			stmt.setString(1, location);
        	//System.out.println(stmt);
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
	
	public boolean updateStatus() {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
        	String sql = "update stylrite_inventory.d_child_barcode set status=? where rowid=?";
        	stmt = conn.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setString(2, rowId);
        	//System.out.println(stmt);
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
