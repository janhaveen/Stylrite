package com.admin.employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.data.MySql.MySqlConnect;
public class Employee {
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String selectedEmployeeId;
    private String firstName;
    private String lastName;
    private String Gender;
    private Long mobileno;
    private Long altContactNo;
    private String emailId;
    private String department;
    private String designation;
    private String reportTo;
    private String UserUniqueId="";
    private String password;
    private String location;
    private String branch;
    private Date birthDate;
    private String Status;
    private String inputAddress;
    private String inputAddress2;
    private String inputCity;
    private String inputState;
    private String inputZip;
    private Date joinDate;
    private Float BasicSalary;
    private Float TravelAllowance;
    private Float DearnessAllowance;
    private Float HouseRentAllowance;
    private Float ConveyanceAllowance;
    private Float SpecialAllowance;
    private Float VariableSalary;
    private Float EPF;
    private Float ESIC;
    private Float ProfessionalTax;
    private Float Mediclaim;
    private Float StatutoryBonus;
    private String AccountNo;
    private String BankName;
    private String BankBranch;
    private String IFSCCOde;
	private String createdBy;
	
	public String getSelectedEmployeeId() {
		return selectedEmployeeId;
	}
	public void setSelectedEmployeeId(String selectedEmployeeId) {
		this.selectedEmployeeId = selectedEmployeeId;
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
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
	public String getReportTo() {
		return reportTo;
	}
	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}
	public String getUserUniqueId() {
		return UserUniqueId;
	}
	public void setUserUniqueId(String userUniqueId) {
		UserUniqueId = userUniqueId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getInputAddress() {
		return inputAddress;
	}
	public void setInputAddress(String inputAddress) {
		this.inputAddress = inputAddress;
	}
	public String getInputAddress2() {
		return inputAddress2;
	}
	public void setInputAddress2(String inputAddress2) {
		this.inputAddress2 = inputAddress2;
	}
	public String getInputCity() {
		return inputCity;
	}
	public void setInputCity(String inputCity) {
		this.inputCity = inputCity;
	}
	public String getInputState() {
		return inputState;
	}
	public void setInputState(String inputState) {
		this.inputState = inputState;
	}
	public String getInputZip() {
		return inputZip;
	}
	public void setInputZip(String inputZip) {
		this.inputZip = inputZip;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Float getBasicSalary() {
		return BasicSalary;
	}
	public void setBasicSalary(Float basicSalary) {
		BasicSalary = basicSalary;
	}
	public Float getTravelAllowance() {
		return TravelAllowance;
	}
	public void setTravelAllowance(Float travelAllowance) {
		TravelAllowance = travelAllowance;
	}
	public Float getDearnessAllowance() {
		return DearnessAllowance;
	}
	public void setDearnessAllowance(Float dearnessAllowance) {
		DearnessAllowance = dearnessAllowance;
	}
	public Float getHouseRentAllowance() {
		return HouseRentAllowance;
	}
	public void setHouseRentAllowance(Float houseRentAllowance) {
		HouseRentAllowance = houseRentAllowance;
	}
	public Float getConveyanceAllowance() {
		return ConveyanceAllowance;
	}
	public void setConveyanceAllowance(Float conveyanceAllowance) {
		ConveyanceAllowance = conveyanceAllowance;
	}
	public Float getSpecialAllowance() {
		return SpecialAllowance;
	}
	public void setSpecialAllowance(Float specialAllowance) {
		SpecialAllowance = specialAllowance;
	}
	public Float getVariableSalary() {
		return VariableSalary;
	}
	public void setVariableSalary(Float variableSalary) {
		VariableSalary = variableSalary;
	}
	public Float getEPF() {
		return EPF;
	}
	public void setEPF(Float ePF) {
		EPF = ePF;
	}
	public Float getESIC() {
		return ESIC;
	}
	public void setESIC(Float eSIC) {
		ESIC = eSIC;
	}
	public Float getProfessionalTax() {
		return ProfessionalTax;
	}
	public void setProfessionalTax(Float professionalTax) {
		ProfessionalTax = professionalTax;
	}
	public Float getMediclaim() {
		return Mediclaim;
	}
	public void setMediclaim(Float mediclaim) {
		Mediclaim = mediclaim;
	}
	public Float getStatutoryBonus() {
		return StatutoryBonus;
	}
	public void setStatutoryBonus(Float statutoryBonus) {
		StatutoryBonus = statutoryBonus;
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBankBranch() {
		return BankBranch;
	}
	public void setBankBranch(String bankBranch) {
		BankBranch = bankBranch;
	}
	public String getIFSCCOde() {
		return IFSCCOde;
	}
	public void setIFSCCOde(String iFSCCOde) {
		IFSCCOde = iFSCCOde;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public boolean Employee_action(String type) {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO stylrite_general.d_employee "
						+ "(rowId, firstName, lastName, department, designation, "
						+ "mobileNo, altContactNo, emailId, userId, branchId, "
						+ "password,  birthDate, joinDate,"
						+ " status, reportTo, location, gender, "
						+ "inputAddress, inputAddress2, inputCity, inputState, inputZip, "
						+ "BasicSalary, TravelAllowance, DearnessAllowance, HouseRentAllowance, "
						+ "ConveyanceAllowance, SpecialAllowance, VariableSalary,"
						+ "EPF, ESIC, ProfessionalTax, Mediclaim, StatutoryBonus, "
						+ "AccountNo, BankName, BankBranch, IFSCCOde, "
						+ "createdOn, updatedOn, createdBy, updatedBy) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, selectedEmployeeId);
	            stmt.setString(2, firstName);
	            stmt.setString(3, lastName);
	            stmt.setString(4, department);
	            stmt.setString(5, designation);
	            stmt.setLong(6, mobileno);
	            stmt.setLong(7, altContactNo);
	            stmt.setString(8, emailId);
	            stmt.setString(9, UserUniqueId);
	            stmt.setString(10, branch);
	            stmt.setString(11, password);
	            stmt.setDate(12, birthDate);
	            stmt.setDate(13, joinDate);
	            stmt.setString(14, Status);
	            stmt.setString(15, reportTo);
	            stmt.setString(16, location);
	            stmt.setString(17, Gender);
	            stmt.setString(18, inputAddress);
	            stmt.setString(19, inputAddress2);
	            stmt.setString(20, inputCity);
	            stmt.setString(21, inputState);
	            stmt.setString(22, inputZip);
	            stmt.setFloat(23, BasicSalary);
	            stmt.setFloat(24, TravelAllowance);
	            stmt.setFloat(25, DearnessAllowance);
	            stmt.setFloat(26, HouseRentAllowance);
	            stmt.setFloat(27, ConveyanceAllowance);
	            stmt.setFloat(28, SpecialAllowance);
	            stmt.setFloat(29, VariableSalary);
	            stmt.setFloat(30, EPF);
	            stmt.setFloat(31, ESIC);
	            stmt.setFloat(32, ProfessionalTax);
	            stmt.setFloat(33, Mediclaim);
	            stmt.setFloat(34, StatutoryBonus);
	            stmt.setString(35, AccountNo);
	            stmt.setString(36, BankName);
	            stmt.setString(37, BankBranch);
	            stmt.setString(38, IFSCCOde);
	            stmt.setTimestamp(39, timestamp);
	            stmt.setTimestamp(40, timestamp);
	            stmt.setString(41, createdBy);
	            stmt.setString(42, createdBy);
        	}else if(type.indexOf("update")>=0){
        		String sql = "update stylrite_general.d_employee  set"
    					+ " updatedBy = ?, firstName=?,  lastName=?,  department=?,  designation=?,  "
    					+ "mobileNo=?,  altContactNo=?,  emailId=?,  userId=?,  "
    					+ "branchId=?,   password=?,   birthDate=?,  joinDate=?,   status=?,  "
    					+ "reportTo=?,  location=?,  gender=?,   inputAddress=?,  inputAddress2=?,  "
    					+ "inputCity=?,  inputState=?,  inputZip=?,   BasicSalary=?,  TravelAllowance=?,  "
    					+ "DearnessAllowance=?,  HouseRentAllowance=?,   ConveyanceAllowance=?,  "
    					+ "SpecialAllowance=?,  VariableSalary=?,  EPF=?,  ESIC=?,  ProfessionalTax=?,  "
    					+ "Mediclaim=?,  StatutoryBonus=?,   AccountNo=?,  BankName=?,  BankBranch=?,  "
    					+ "IFSCCOde= ?, updatedOn = ? where rowId = ?";
    			stmt = conn.prepareStatement(sql);
    			stmt.setString(1, createdBy );
	            stmt.setString(2, firstName);
	            stmt.setString(3, lastName);
	            stmt.setString(4, department);
	            stmt.setString(5, designation);
	            stmt.setLong(6, mobileno);
	            stmt.setLong(7, altContactNo);
	            stmt.setString(8, emailId);
	            stmt.setString(9, UserUniqueId);
	            stmt.setString(10, branch);
	            stmt.setString(11, password);
	            stmt.setDate(12, birthDate);
	            stmt.setDate(13, joinDate);
	            stmt.setString(14, Status);
	            stmt.setString(15, reportTo);
	            stmt.setString(16, location);
	            stmt.setString(17, Gender);
	            stmt.setString(18, inputAddress);
	            stmt.setString(19, inputAddress2);
	            stmt.setString(20, inputCity);
	            stmt.setString(21, inputState);
	            stmt.setString(22, inputZip);
	            stmt.setFloat(23, BasicSalary);
	            stmt.setFloat(24, TravelAllowance);
	            stmt.setFloat(25, DearnessAllowance);
	            stmt.setFloat(26, HouseRentAllowance);
	            stmt.setFloat(27, ConveyanceAllowance);
	            stmt.setFloat(28, SpecialAllowance);
	            stmt.setFloat(29, VariableSalary);
	            stmt.setFloat(30, EPF);
	            stmt.setFloat(31, ESIC);
	            stmt.setFloat(32, ProfessionalTax);
	            stmt.setFloat(33, Mediclaim);
	            stmt.setFloat(34, StatutoryBonus);
	            stmt.setString(35, AccountNo);
	            stmt.setString(36, BankName);
	            stmt.setString(37, BankBranch);
	            stmt.setString(38, IFSCCOde);
	            stmt.setTimestamp(39, timestamp);
	            stmt.setString(40, selectedEmployeeId);
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