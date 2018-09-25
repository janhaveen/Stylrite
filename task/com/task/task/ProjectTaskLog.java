package com.task.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;
import com.general.system.SystemDetails;

public class ProjectTaskLog extends Task{
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private String  TaskLogId; 
	private String  action; 
	private String  fromValue; 
	private String  toValue; 
	private String  suggestedDate; 
	private String  remarks;
	
	public String getTaskLogId() {
		return TaskLogId;
	}
	public void setTaskLogId(String taskLogId) {
		TaskLogId = taskLogId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getFromValue() {
		return fromValue;
	}
	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}
	public String getToValue() {
		return toValue;
	}
	public void setToValue(String toValue) {
		this.toValue = toValue;
	}
	public String getSuggestedDate() {
		return suggestedDate;
	}
	public void setSuggestedDate(String suggestedDate) {
		this.suggestedDate = suggestedDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	} 
	public boolean save_TaskLog() {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
        	String sql = "INSERT INTO propel_general.f_task_logs "
        			+ "(rowId, TaskId, action, fromValue, toValue, remarks, "
        			+ " createdBy, createdOn) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, TaskLogId);
            stmt.setString(2, super.getTaskId());
            stmt.setString(3, action);
            stmt.setString(4, fromValue);
            stmt.setString(5, toValue);
            stmt.setString(6, remarks);
            stmt.setString(7,  super.getCreatedBy());
            stmt.setTimestamp(8, timestamp);
            stmt.executeUpdate(); System.out.println(stmt);
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
