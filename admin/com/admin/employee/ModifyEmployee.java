package com.admin.employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.data.MySql.MySqlConnect;
@WebServlet("/ModifyEmployee")
public class ModifyEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Employee emp = new Employee();
		emp.setSelectedEmployeeId(request.getParameter("selectedEmployeeId"));
		emp.setFirstName(request.getParameter("firstName"));
		emp.setLastName(request.getParameter("lastName"));
		emp.setDepartment(request.getParameter("department"));
		emp.setDesignation(request.getParameter("designation"));
		emp.setLocation(request.getParameter("location"));
		emp.setBranch(request.getParameter("branch"));
		try {
			emp.setMobileno(Long.parseLong(request.getParameter("mobileno")));
		} catch (Exception e) {
			emp.setMobileno(Long.parseLong("0"));
		}
		try {
			emp.setAltContactNo(Long.parseLong(request.getParameter("altContactNo")));
		} catch (Exception e) {
			emp.setAltContactNo(Long.parseLong("0"));
		}
		emp.setEmailId(request.getParameter("emailId"));
		emp.setReportTo(request.getParameter("reportTo"));
		emp.setUserUniqueId(request.getParameter("UserId"));
		emp.setGender(request.getParameter("Gender"));
		emp.setLocation(request.getParameter("location"));
		emp.setStatus(request.getParameter("Status"));
		emp.setInputAddress(request.getParameter("inputAddress"));
		emp.setInputAddress2(request.getParameter("inputAddress2"));
		emp.setInputCity(request.getParameter("inputCity"));
		emp.setInputState(request.getParameter("inputState"));
		emp.setInputZip(request.getParameter("inputZip"));
		try {
			emp.setBasicSalary(Float.parseFloat(request.getParameter("BasicSalary")));
		} catch (Exception e) {
			emp.setBasicSalary(Float.parseFloat("0"));
		}
		try {
			emp.setTravelAllowance(Float.parseFloat(request.getParameter("TravelAllowance")));
		} catch (Exception e) {
			emp.setTravelAllowance(Float.parseFloat("0"));
		}
		try {
			emp.setDearnessAllowance(Float.parseFloat(request.getParameter("DearnessAllowance")));
		} catch (Exception e) {
			emp.setDearnessAllowance(Float.parseFloat("0"));
		}
		try {
			emp.setHouseRentAllowance(Float.parseFloat(request.getParameter("HouseRentAllowance")));
		} catch (Exception e) {
			emp.setHouseRentAllowance(Float.parseFloat("0"));
		}
		try {
			emp.setConveyanceAllowance(Float.parseFloat(request.getParameter("ConveyanceAllowance")));
		} catch (Exception e) {
			emp.setConveyanceAllowance(Float.parseFloat("0"));
		}
		try {
			emp.setSpecialAllowance(Float.parseFloat(request.getParameter("SpecialAllowance")));
		} catch (Exception e) {
			emp.setSpecialAllowance(Float.parseFloat("0"));
		}
		try {
			emp.setVariableSalary(Float.parseFloat(request.getParameter("VariableSalary")));
		} catch (Exception e) {
			emp.setVariableSalary(Float.parseFloat("0"));
		}
		try {
			emp.setEPF(Float.parseFloat(request.getParameter("EPF")));
		} catch (Exception e) {
			emp.setEPF(Float.parseFloat("0"));
		}
		try {
			emp.setESIC(Float.parseFloat(request.getParameter("ESIC")));
		} catch (Exception e) {
			emp.setESIC(Float.parseFloat("0"));
		}
		try {
			emp.setProfessionalTax(Float.parseFloat(request.getParameter("ProfessionalTax")));
		} catch (Exception e) {
			emp.setProfessionalTax(Float.parseFloat("0"));
		}
		try {
			emp.setMediclaim(Float.parseFloat(request.getParameter("Mediclaim")));
		} catch (Exception e) {
			emp.setMediclaim(Float.parseFloat("0"));
		}
		try {
			emp.setStatutoryBonus(Float.parseFloat(request.getParameter("StatutoryBonus")));
		} catch (Exception e) {
			emp.setStatutoryBonus(Float.parseFloat("0"));
		}
		
		emp.setAccountNo(request.getParameter("AccountNo"));
		emp.setBankName(request.getParameter("BankName"));
		emp.setBankBranch(request.getParameter("BankBranch"));
		emp.setIFSCCOde(request.getParameter("IFSCCOde"));
		try {
			emp.setBirthDate(MySqlConnect.convertToSqlDate(request.getParameter("birthDate")));
		} catch (Exception e) {
		}
		try {
			if(request.getParameter("joinDate")!="")
				emp.setJoinDate(MySqlConnect.convertToSqlDate(request.getParameter("joinDate")));
		} catch (Exception e) {
		}
		emp.setCreatedBy(session.getAttribute("userId").toString());
		emp.setPassword("pass123");
		if (emp.Employee_action(request.getParameter("action"))) {
			out.println("1");
		} else {
			out.println("0");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM stylrite_general.d_employee where rowId ='"+ request.getParameter("DeleteEmpId") +"';");
			int i= stmt.executeUpdate();
			if(i > 0){
				out.println("1");
			}else {
				out.println("0");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}