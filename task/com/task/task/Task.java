package com.task.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Task {

	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
	private String  TaskId; 
	private String  taskName; 
	private String  startDate; 
	private String  endDate; 
	private String  assignedTo; 
	private String  visibility; 
	private String  visibleTo; 
	private String  priority; 
	private String  status; 
	private String  description; 
	private String  createdBy;
	public String getTaskId() {
		return TaskId;
	}
	public void setTaskId(String taskId) {
		TaskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getVisibleTo() {
		return visibleTo;
	}
	public void setVisibleTo(String visibleTo) {
		this.visibleTo = visibleTo;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public boolean modify_task(String type) {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO stylrite_general.d_task "
						+ "(rowId, taskName, startDate, endDate, assignedTo, "
						+ " visibility, visibleTo, priority, status, description, "
						+ " createdBy, updatedBy, createdOn, updatedOn) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, TaskId);
	            stmt.setString(2, taskName);
	            stmt.setString(3, startDate);
	            stmt.setString(4, endDate);
	            stmt.setString(5, assignedTo);
	            stmt.setString(6, visibility);
	            stmt.setString(7, visibleTo);
	            stmt.setString(8, priority);
	            stmt.setString(9, status);
	            stmt.setString(10, description);
	            stmt.setString(11, createdBy);
	            stmt.setString(12, createdBy);
	            stmt.setTimestamp(13, timestamp);
	            stmt.setTimestamp(14, timestamp);
        	}else if(type.indexOf("update")>=0){
        		String sql = "update stylrite_general.d_task  set"
    					+ " taskName=?,  startDate=?,  endDate=?,  assignedTo=?,  "
    					+ " visibility=?,  visibleTo=?,  priority=?,  status=?,  "
    					+ "description=?, updatedBy=?, updatedOn=? where rowId = ?";
    			stmt = conn.prepareStatement(sql);
    			stmt.setString(1, taskName);
	            stmt.setString(2, startDate);
	            stmt.setString(3, endDate);
	            stmt.setString(4, assignedTo);
	            stmt.setString(5, visibility);
	            stmt.setString(6, visibleTo);
	            stmt.setString(7, priority);
	            stmt.setString(8, status);
	            stmt.setString(9, description);
	            stmt.setString(10, createdBy);
	            stmt.setTimestamp(11, timestamp);
	            stmt.setString(12, TaskId);
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
	
	public boolean update_status(){
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection(); 
		try {
			String sql = "UPDATE stylrite_general.d_task SET "
 				   + "updatedOn=?, status=?,  "
 				   + "updatedBy=? "
 				   + "where rowId=?" ;
			  stmt = conn.prepareStatement(sql);
			  stmt.setTimestamp(1, timestamp);
	          stmt.setString(2, status);
	          stmt.setString(3, createdBy);
	          stmt.setString(4, TaskId);
	          stmt.executeUpdate(); System.out.println(stmt);
	          returnVal = true;
	          conn.close();
	    }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
		}
		return returnVal;
	}
	
	public boolean update_TaskDate(String DateCol){
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection(); 
		try {
			String sql = "UPDATE stylrite_general.d_task SET "
 				   + "updatedOn=?, "+DateCol+"=?,  "
 				   + "updatedBy=? "
 				   + "where rowId=?" ;
			  stmt = conn.prepareStatement(sql);
			  stmt.setTimestamp(1, timestamp);
			  stmt.setTimestamp(2, timestamp);
	          stmt.setString(3, createdBy);
	          stmt.setString(4, TaskId);
	          stmt.executeUpdate(); System.out.println(stmt);
	          returnVal = true;
	          conn.close();
	    }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
		}
		return returnVal;
	}
}
