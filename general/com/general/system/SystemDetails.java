package com.general.system;

import java.sql.Timestamp;

public class SystemDetails {
	private String systemMac;
	private String systemIp;
	private String systemName;
	private String createdBy;
	
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
}
