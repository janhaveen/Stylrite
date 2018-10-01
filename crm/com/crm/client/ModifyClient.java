package com.crm.client;

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

@WebServlet("/ModifyClient")
public class ModifyClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Client clnt = new Client();
		ClientContactPerson clntCP = new ClientContactPerson();
		ClientAddress clntAdd = new ClientAddress();

		clnt.setClientId(request.getParameter("selectedClientId"));
		clntCP.setClientId(request.getParameter("selectedClientId"));
		clntAdd.setClientId(request.getParameter("selectedClientId"));
		
		clnt.setCompanyName(request.getParameter("companyName"));
		clnt.setLocation(request.getParameter("location"));
		clnt.setCustomerType(request.getParameter("customerType"));
		clnt.setCreditTime(request.getParameter("creditTime"));
		clnt.setCreditLimit(request.getParameter("creditLimit"));
		clnt.setSalesPerson(request.getParameter("salesPerson"));
		clnt.setSource(request.getParameter("source"));
		try
		{
			if(request.getParameter("source").equals("246"))
			{
				clnt.setReferenceBy(request.getParameter("reference"));
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		clnt.setCreatedBy(session.getAttribute("userId").toString());
		clnt.setUpdatedBy(session.getAttribute("userId").toString());

		clntCP.setContactPId(request.getParameter("selectedClientContactPersonId"));
		clntCP.setFirstName(request.getParameter("firstName"));
		clntCP.setLastName(request.getParameter("lastName"));
		clntCP.setLocation(request.getParameter("locationCP"));
		try
		{
			clntCP.setContactNo(Long.parseLong(request.getParameter("mobileno")));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			clntCP.setContactNo(Long.parseLong("0"));
		}
		try
		{
			clntCP.setAltContactNo(Long.parseLong(request.getParameter("altContactNo")));
		}
		catch (Exception e)
		{
			clntCP.setAltContactNo(Long.parseLong("0"));
		}
		clntCP.setEmailId(request.getParameter("emailId"));
		clntCP.setDepartment(request.getParameter("department"));
		clntCP.setDesignation(request.getParameter("designation"));
		clntCP.setBirthdate(MySqlConnect.convertToSqlDate(request.getParameter("birthDate")));
		if(request.getParameter("action").equals("insert"))
		{
			clntCP.setIsDefault("1");
			clntAdd.setIsDefault("1");
		}
		clntCP.setCreatedByCP(session.getAttribute("userId").toString());
		clntCP.setUpdatedByCP(session.getAttribute("userId").toString());

		clntAdd.setAddressId(request.getParameter("selectedClientAddressId"));
		clntAdd.setBranchName(request.getParameter("branchName"));
		try
		{
			clntAdd.setContactNo(Long.parseLong(request.getParameter("contactNoAdd")));
		}
		catch (Exception e)
		{
			clntAdd.setContactNo(Long.parseLong("0"));
		}
		clntAdd.setAddressLine1(request.getParameter("inputAddress"));
		clntAdd.setAddressLine2(request.getParameter("inputAddress2"));
		clntAdd.setLedgerName(request.getParameter("ledgerName"));
		clntAdd.setLocationAdd(request.getParameter("locationAdd"));
		clntAdd.setCity(request.getParameter("inputCity"));
		clntAdd.setState(request.getParameter("inputState"));
		clntAdd.setGstNo(request.getParameter("GSTNo"));
		try
		{
			clntAdd.setPincode(Integer.parseInt(request.getParameter("inputZip")));
		}
		catch (Exception e)
		{
			clntAdd.setPincode(Integer.parseInt("0"));
		}
		clntAdd.setCreatedByAdd(session.getAttribute("userId").toString());
		clntAdd.setUpdatedByAdd(session.getAttribute("userId").toString());
		
		if(request.getParameter("action").equals("insert"))
		{
			if (clnt.newClient())
			{
				if (clntAdd.newAddress())
				{
					if (clntCP.newContactPerson())
					{
						out.println("1");
					}
					else
					{
						out.println("0");
					}
				}
				else
				{
					out.println("0");
				}
			}
			else
			{
				out.println("0");
			}
		}
		else if(request.getParameter("action").equals("updateClient"))
		{
			if (clnt.updateClient())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
		else if(request.getParameter("action").equals("updateAddress"))
		{
			if(request.getParameter("isDefault")!=null)
			{
				if(request.getParameter("isDefault").equals("true"))
				{
					clntAdd.setIsDefault("1");
					clnt.reset_default("address");
				}
			}
			if (clntAdd.updateAddress())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
		else if(request.getParameter("action").equals("updateContactPerson"))
		{
			if(request.getParameter("isDefault")!=null)
			{
				if(request.getParameter("isDefault").equals("true"))
				{
					clntCP.setIsDefault("1");
					clnt.reset_default("contactP");
				}
			}
			if (clntCP.updateContactPerson())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
		else if(request.getParameter("action").equals("insertAddress"))
		{
			if(request.getParameter("isDefault")!=null)
			{
				if(request.getParameter("isDefault").equals("true"))
				{
					clntAdd.setIsDefault("1");
					clnt.reset_default("address");
				}
			}
			if (clntAdd.newAddress())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
		else if(request.getParameter("action").equals("insertContactPerson"))
		{
			if(request.getParameter("isDefault")!=null)
			{
				if(request.getParameter("isDefault").equals("true"))
				{
					clntCP.setIsDefault("1");
					clnt.reset_default("contactP");
				}
			}
			if (clntCP.newContactPerson())
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		Connection conn = MySqlConnect.DBConnection();
		PreparedStatement stmt;
		try
		{
			stmt = conn.prepareStatement("DELETE FROM stylrite_general.d_employee where rowId ='"+ request.getParameter("DeleteEmpId") +"';");
			int i= stmt.executeUpdate();
			if(i > 0)
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
