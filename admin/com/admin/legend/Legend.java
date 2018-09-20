package com.admin.legend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.data.MySql.MySqlConnect;

public class Legend {
    Connection conn = null;
    PreparedStatement stmt = null;
    
    private String rowId;
    private String projectId;
	private String legendGroup;
	private String category;
	private String subCategory;
	
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getLegendGroup() {
		return legendGroup;
	}

	public void setLegendGroup(String legendGroup) {
		this.legendGroup = legendGroup;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
	
	public boolean legend_action(String type) {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try { 
        	if(type.indexOf("insert") >=0) {
	        	String sql = "INSERT INTO propel_legend.d_project_general_legend "
						+ "( rowId, legendGroup, category, subCategory, description , projectId) VALUES "
					+ "( ?, ?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql); 
	            stmt.setString(1, rowId);
	            stmt.setString(2, legendGroup);
	            stmt.setString(3, category);
	            stmt.setString(4, subCategory);
	            stmt.setString(5, description);
	            stmt.setString(6, projectId);
        	}else if(type.indexOf("update")>=0) {
        		String sql = "update propel_legend.d_project_general_legend  set"
    					+ " legendGroup = ?, category = ?, subCategory = ?, "
    					+ "description = ?, projectId=? "
    					+ "where rowId = ?";
    			stmt = conn.prepareStatement(sql);
    			
                stmt.setString(1, legendGroup);
                stmt.setString(2, category);
                stmt.setString(3, subCategory);
                stmt.setString(4, description);
                stmt.setString(5, projectId);
    			stmt.setString(6, rowId);
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
