package com.admin.hsn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
 
public class HsnId  {
     
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String rowId;
    private String hsnId;
    private String sgst;
    private String cgst;
    private String igst;
    private String ugst;
    private String userID ;
	private String sgst1;
	private String cgst1;
	private String igst1;
	private Float MRP;
	
	public String getClientId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getHsnId() {
		return hsnId;
	}

	public void setHsnId(String hsnId) {
		this.hsnId = hsnId;
	}
	
	public Float getMRP() {
		return MRP;
	}

	public void setMRP(Float MRP) {
		this.MRP = MRP;
	}
	
	public String getSgst1() {
		return sgst1;
	}

	public void setSgst1(String sgst1) {
		this.sgst1 = sgst1;
	}

	public String getCgst1() {
		return cgst1;
	}

	public void setCgst1(String cgst1) {
		this.cgst1 = cgst1;
	}

	public String getIgst1() {
		return igst1;
	}

	public void setIgst1(String igst1) {
		this.igst1 = igst1;
	}
	
	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getIgst() {
		return igst;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}


	public String getUgst() {
		return ugst;
	}

	public void setUgst(String ugst) {
		this.ugst = ugst;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public boolean hsnid_action(String type) {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
        	if(type.indexOf("insert") >=0) {
        		String sql = "INSERT INTO sment_general.d_hsn "
					+ "(rowId, Hsnid, Sgst, Cgst, Igst,"
					+ "createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        		
	            stmt = conn.prepareStatement(sql);
	            
	            stmt.setString(1, rowId);
	            stmt.setString(2, hsnId);
	            stmt.setString(3, sgst);
	            stmt.setString(4, cgst);
	            stmt.setString(5, igst);
	            stmt.setTimestamp(6, timestamp);
	            stmt.setTimestamp(7, timestamp);
	            stmt.setString(8, userID);
	            stmt.setString(9, userID);
	            
        	}else if(type.indexOf("update")>=0) {
        		String sql = "update sment_general.d_hsn  set"
    					+ " Hsnid = ?, Sgst = ?, Cgst = ?, Igst = ?,"
    					+ "updatedBy = ?, updatedOn = ?"
    					+ "where rowId = ?";
				stmt = conn.prepareStatement(sql);
			
				stmt.setString(1, hsnId);
	            stmt.setString(2, sgst);
	            stmt.setString(3, cgst);
	            stmt.setString(4, igst);
	            stmt.setString(5, userID);
	            stmt.setTimestamp(6, timestamp);
	            stmt.setString(7, rowId);
        	} 
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
}