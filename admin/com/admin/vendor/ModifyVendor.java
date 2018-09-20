package com.admin.vendor;

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

@WebServlet("/ModifyVendor")
public class ModifyVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Vendor vndr = new Vendor();
		VendorContactPerson vndrCP = new VendorContactPerson();
		VendorAddress vndrAdd = new VendorAddress();
	
		vndr.setVendorId(request.getParameter("selectedVendorId"));
		vndrCP.setVendorId(request.getParameter("selectedVendorId"));
		vndrAdd.setVendorId(request.getParameter("selectedVendorId"));
		
		vndr.setVendorName(request.getParameter("vendorName"));
		vndr.setVendorType(request.getParameter("vendorType"));
		vndr.setEmail(request.getParameter("emailId"));
		vndr.setLocation(request.getParameter("location"));
		try
		{
			vndr.setCreditTime(Integer.parseInt(request.getParameter("creditTime")));
		}
		catch(Exception e)
		{
			vndr.setCreditTime(Integer.parseInt("0"));
			e.printStackTrace();
		}
		try
		{
			vndr.setCreditLimit(Integer.parseInt(request.getParameter("creditLimit")));
		}
		catch(Exception e)
		{
			vndr.setCreditLimit(Integer.parseInt("0"));
			e.printStackTrace();
		}
		vndr.setWebsite(request.getParameter("website"));
		try
		{
			vndr.setLandlineNo(Long.parseLong(request.getParameter("landLineNo")));
		}
		catch(Exception e)
		{
			vndr.setLandlineNo(Integer.parseInt("0"));
			e.printStackTrace();
		}
		vndr.setIndustryType(request.getParameter("industryType"));
		vndr.setSource(request.getParameter("source"));
		try
		{
			if(request.getParameter("source").equals("246"))
			{
				vndr.setReferenceBy(request.getParameter("reference"));
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		vndr.setCategories(request.getParameter("category"));
		
		try
		{
			vndr.setCreatedBy(session.getAttribute("userId").toString());
			vndr.setUpdatedBy(session.getAttribute("userId").toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		vndrCP.setContactPId(request.getParameter("selectedVendorContactPersonId"));
		vndrCP.setFirstName(request.getParameter("firstName"));
		vndrCP.setLastName(request.getParameter("lastName"));
		vndrCP.setLocation(request.getParameter("locationCP"));
		try
		{
			vndrCP.setContactNo(Long.parseLong(request.getParameter("mobileno")));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			vndrCP.setContactNo(Long.parseLong("0"));
		}
		try
		{
			vndrCP.setAltContactNo(Long.parseLong(request.getParameter("altContactNo")));
		}
		catch (Exception e)
		{
			vndrCP.setAltContactNo(Long.parseLong("0"));
		}
		vndrCP.setBirthdate(MySqlConnect.convertToSqlDate(request.getParameter("birthDate")));
		vndrCP.setEmailId(request.getParameter("vendorEmailId"));
		vndrCP.setDepartment(request.getParameter("department"));
		vndrCP.setDesignation(request.getParameter("designation"));
		if(request.getParameter("action").equals("insert"))
		{
			vndrCP.setIsDefault("1");
			vndrAdd.setIsDefault("1");
		}
		try
		{
			vndrCP.setCreatedByCP(session.getAttribute("userId").toString());
			vndrCP.setUpdatedByCP(session.getAttribute("userId").toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		vndrAdd.setAddressId(request.getParameter("selectedVendorAddressId"));
		vndrAdd.setBranchName(request.getParameter("branchName"));
		vndrAdd.setGstNo(request.getParameter("GSTNo"));
		vndrAdd.setAddressLine1(request.getParameter("inputAddress"));
		vndrAdd.setAddressLine2(request.getParameter("inputAddress2"));
		vndrAdd.setLedgerName(request.getParameter("ledgerName"));
		try
		{
			vndrAdd.setContactNo(Long.parseLong(request.getParameter("contactNoAdd")));
		}
		catch (Exception e)
		{
			vndrAdd.setContactNo(Long.parseLong("0"));
		}
		vndrAdd.setLocationAdd(request.getParameter("locationAdd"));
		vndrAdd.setCity(request.getParameter("inputCity"));
		vndrAdd.setState(request.getParameter("inputState"));
		try
		{
			vndrAdd.setPincode(Integer.parseInt(request.getParameter("inputZip")));
		}
		catch (Exception e)
		{
			vndrAdd.setPincode(Integer.parseInt("0"));
		}
		try
		{
			vndrAdd.setCreatedByAdd(session.getAttribute("userId").toString());
			vndrAdd.setUpdatedByAdd(session.getAttribute("userId").toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(request.getParameter("action").equals("insert"))
		{
			if (vndr.newVendor())
			{
				if (vndrAdd.newAddress())
				{
					if (vndrCP.newContactPerson())
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
		else if(request.getParameter("action").equals("updateVendor"))
		{
			if (vndr.updateClient())
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
					vndrAdd.setIsDefault("1");
					vndr.reset_default("address");
				}
			}
			if (vndrAdd.updateAddress())
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
					vndrCP.setIsDefault("1");
					vndr.reset_default("contactP");
				}
			}
			if (vndrCP.updateContactPerson())
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
					vndrAdd.setIsDefault("1");
					vndr.reset_default("address");
				}
			}
			if (vndrAdd.newAddress())
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
					vndrCP.setIsDefault("1");
					vndr.reset_default("contactP");
				}
			}
			if (vndrCP.newContactPerson())
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
