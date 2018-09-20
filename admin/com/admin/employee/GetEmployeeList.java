package com.admin.employee;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.*;
import com.data.MySql.MySqlConnect;

@WebServlet("/GetEmployeeList")
public class GetEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jArray = new JSONArray();
	Connection conn = null;
	PreparedStatement stmt = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();
	    String sql = "SELECT * FROM stylrite_general.employeelist where 1=1 ";
	    if(request.getParameter("cid")!=null) {
	    	sql+=" AND rowId="+session.getAttribute("userId").toString()+"";
	    }
	    if(request.getParameter("dr")!=null) {
	    	sql+=" AND statustext='Active'";
	    }
	    if(request.getParameter("forDup")!=null) {
	    	if (request.getParameter("mobile")!=null) {
	    		sql +=" AND contactNo='"+request.getParameter("mobile")+"'";
			}
	    	if (request.getParameter("usrid")!=null) {
	    		sql +=" AND userId='"+request.getParameter("usrid")+"'";
			}
	    	if(request.getParameter("selectedEmployeeId")!=null)
	    		sql +=" AND rowId!='"+request.getParameter("selectedEmployeeId")+"'";
	    }
	    System.out.println(sql);
	    conn= MySqlConnect.DBConnection();
		while (jArray.length()>0) {
			jArray.remove(0);
		}
		try
		{
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				 JSONObject arrayObj = new JSONObject();
				 arrayObj.put("employeeId", rs.getString("rowId")==null?"":rs.getString("rowId"));
				 arrayObj.put("employeeName", rs.getString("empname")==null?"":rs.getString("empname"));
				 arrayObj.put("firstName", rs.getString("firstName")==null?"":rs.getString("firstName"));
				 arrayObj.put("lastName", rs.getString("lastName")==null?"":rs.getString("lastName"));
				 arrayObj.put("department", rs.getString("department")==null?"":rs.getString("department"));
				 arrayObj.put("designation", rs.getString("designation")==null?"":rs.getString("designation"));
				 arrayObj.put("mobileNo", rs.getString("contactNo")==null?"":rs.getString("contactNo"));
				 arrayObj.put("altContactNo", rs.getString("altContactNo")==null?"":rs.getString("altContactNo"));
				 arrayObj.put("emailId", rs.getString("emailId")==null?"":rs.getString("emailId"));
				 arrayObj.put("userId", rs.getString("userId")==null?"":rs.getString("userId"));
				 arrayObj.put("status", rs.getString("status")==null?"":rs.getString("status"));
				 arrayObj.put("location", rs.getString("location")==null?"":rs.getString("location"));
				 arrayObj.put("reportTo", rs.getString("reportTo")==null?"":rs.getString("reportTo"));
				 arrayObj.put("birthdaydate", rs.getString("DOB")==null?"":rs.getString("DOB"));
				 arrayObj.put("joiningdate", rs.getString("joiningdate")==null?"":rs.getString("joiningdate"));
				 arrayObj.put("empname", rs.getString("empname")==null?"":rs.getString("empname"));
				 arrayObj.put("designation_desc", rs.getString("desigText")==null?"":rs.getString("desigText"));
				 arrayObj.put("department_desc", rs.getString("deptText")==null?"":rs.getString("deptText"));
				 arrayObj.put("reportingTo", rs.getString("reporttext")==null?"":rs.getString("reporttext"));
				 arrayObj.put("status_desc", rs.getString("statustext")==null?"":rs.getString("statustext"));
				 arrayObj.put("permissions", rs.getString("permissions")==null?"":rs.getString("permissions"));
				 //arrayObj.put("branchId", rs.getString("branchId")==null?"":rs.getString("branchId"));
				 arrayObj.put("gender", rs.getString("gender")==null?"":rs.getString("gender"));
				 arrayObj.put("inputAddress", rs.getString("inputAddress")==null?"":rs.getString("inputAddress")); 
				 arrayObj.put("inputAddress2", rs.getString("inputAddress2")==null?"":rs.getString("inputAddress2")); 
				 arrayObj.put("inputCity", rs.getString("inputCity")==null?"":rs.getString("inputCity")); 
				 arrayObj.put("inputState", rs.getString("inputState")==null?"":rs.getString("inputState")); 
				 arrayObj.put("inputZip", rs.getString("inputZip")==null?"":rs.getString("inputZip")); 
				 arrayObj.put("BasicSalary", rs.getString("BasicSalary")==null?"":rs.getString("BasicSalary")); 
				 arrayObj.put("TravelAllowance", rs.getString("TravelAllowance")==null?"":rs.getString("TravelAllowance")); 
				 arrayObj.put("DearnessAllowance", rs.getString("DearnessAllowance")==null?"":rs.getString("DearnessAllowance")); 
				 arrayObj.put("HouseRentAllowance", rs.getString("HouseRentAllowance")==null?"":rs.getString("HouseRentAllowance")); 
				 arrayObj.put("ConveyanceAllowance", rs.getString("ConveyanceAllowance")==null?"":rs.getString("ConveyanceAllowance")); 
				 arrayObj.put("SpecialAllowance", rs.getString("SpecialAllowance")==null?"":rs.getString("SpecialAllowance")); 
				 arrayObj.put("VariableSalary", rs.getString("VariableSalary")==null?"":rs.getString("VariableSalary")); 
				 arrayObj.put("EPF", rs.getString("EPF")==null?"":rs.getString("EPF")); 
				 arrayObj.put("ESIC", rs.getString("ESIC")==null?"":rs.getString("ESIC")); 
				 arrayObj.put("ProfessionalTax", rs.getString("ProfessionalTax")==null?"":rs.getString("ProfessionalTax")); 
				 arrayObj.put("Mediclaim", rs.getString("Mediclaim")==null?"":rs.getString("Mediclaim")); 
				 arrayObj.put("StatutoryBonus", rs.getString("StatutoryBonus")==null?"":rs.getString("StatutoryBonus")); 
				 arrayObj.put("AccountNo", rs.getString("AccountNo")==null?"":rs.getString("AccountNo")); 
				 arrayObj.put("BankName", rs.getString("BankName")==null?"":rs.getString("BankName")); 
				 arrayObj.put("BankBranch", rs.getString("BankBranch")==null?"":rs.getString("BankBranch")); 
				 arrayObj.put("IFSCCOde", rs.getString("IFSCCOde")==null?"":rs.getString("IFSCCOde")); 
				 arrayObj.put("genderText", rs.getString("genderText")==null?"":rs.getString("genderText")); 
				 arrayObj.put("addressText", rs.getString("addressText")==null?"":rs.getString("addressText")); 
				 //arrayObj.put("branchText", rs.getString("branchText")==null?"":rs.getString("branchText")); 
				 jArray.put(arrayObj);
			}
			JSONObject jsonFinal = new JSONObject();
			jsonFinal.putOnce("data", jArray);
			out.print(jsonFinal);
			conn.close();
			}
		catch (Exception e) {
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