package com.requistion.requistion;

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

@WebServlet("/ModifyRequisition")
public class ModifyRequisition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		boolean checkOf1ststatus = false;
		boolean checkstatus = false;
		
		Requisition rqtn = new Requisition();
		RequisitionItem rqtnItm = new RequisitionItem();
		RequisitionLog rqtnLog = new RequisitionLog();

		rqtn.setRequisitionId(request.getParameter("requisitionID"));
		rqtnItm.setRequisitionId(request.getParameter("requisitionID"));
		rqtnLog.setRequisitionId(request.getParameter("requisitionID"));
		rqtnItm.setRequisitionItemId(request.getParameter("requisitionItemID"));
		rqtnLog.setRequisitionLogId(request.getParameter("requisitionLogID"));
		
		rqtn.setReason(request.getParameter("reason"));
		
		if(request.getParameter("expectedReceiptDate") != null && !request.getParameter("expectedReceiptDate").equals(""))
		{
			rqtn.setExpectedReceiptDate(MySqlConnect.convertToSqlDate(request.getParameter("expectedReceiptDate")));
		}
		rqtn.setModeofDelivery(request.getParameter("modeOfTransport"));
		if(request.getParameter("dispatchedDate") != null && !request.getParameter("dispatchedDate").equals(""))
		{
			rqtn.setDispatchedDate(MySqlConnect.convertToSqlDate(request.getParameter("dispatchedDate")));
		}
		rqtn.setTransportName(request.getParameter("transportName"));
		rqtn.setTrackingID(request.getParameter("trackingID"));
		rqtn.seteBillNo(request.getParameter("EWayBillNo"));
		if(request.getParameter("receiptDate") != null && !request.getParameter("receiptDate").equals(""))
		{
			rqtn.setReceiptDate(MySqlConnect.convertToSqlDate(request.getParameter("receiptDate")));
		}
		rqtn.setRequisitionType(request.getParameter("requisitionType"));
		rqtn.setRequisitionStatus(request.getParameter("requitionstatus"));
		
		rqtn.setRequisitionCreatedBy(session.getAttribute("userId").toString());
		rqtn.setRequisitionUpdatedBy(session.getAttribute("userId").toString());

		rqtnItm.setProductId(request.getParameter("ProductId"));
		rqtnItm.setRequisitionItemStatus(request.getParameter("requitionItemstatus"));
		rqtnItm.setRequisitionItemCreatedBy(session.getAttribute("userId").toString());
		rqtnItm.setRequisitionItemUpdatedBy(session.getAttribute("userId").toString());

		rqtnLog.setRemarks(request.getParameter("remarks"));
		rqtnLog.setRequisitionLogStatus(request.getParameter("requitionstatus"));
		rqtnLog.setRequisitionLogCreatedBy(session.getAttribute("userId").toString());
		
		if(request.getParameter("action").equals("insert"))
		{
			if(request.getParameter("count").equals("1"))
			{
				checkOf1ststatus = true;
				if (rqtn.newRequisition())
				{
					if(rqtnLog.newRequisitionLog())
					{
						checkstatus = true;
					}
					else
					{
						checkstatus = false;
					}
				}
				else
				{
					checkstatus = false;
				}
			}
			else
			{
				checkOf1ststatus = false;
			}
			
			if(checkOf1ststatus)
			{
				if(checkstatus)
				{
					if (rqtnItm.newRequisitionItem())
					{
						out.println("1");
					}
					else
					{
						out.println("0");
					}
				}
			}
			else
			{
				if (rqtnItm.newRequisitionItem())
				{
					out.println("1");
				}
				else
				{
					out.println("0");
				}
			}
		}
		else if(request.getParameter("action").equals("updateAccpStatus"))
		{
			if(request.getParameter("count").equals("1"))
			{
				checkOf1ststatus = true;
				if (rqtn.updateStatus())
				{
					if(rqtnLog.newRequisitionLog())
					{
						checkstatus = true;
					}
					else
					{
						checkstatus = false;
					}
				}
				else
				{
					checkstatus = false;
				}
			}
			else
			{
				checkOf1ststatus = false;
			}
			
			if(checkOf1ststatus)
			{
				if(checkstatus)
				{
					if (rqtnItm.updateStatus())
					{
						out.println("1");
					}
					else
					{
						out.println("0");
					}
				}
			}
			else
			{
				if (rqtnItm.updateStatus())
				{
					out.println("1");
				}
				else
				{
					out.println("0");
				}
			}
		}
		else if(request.getParameter("action").equals("updateDispatched"))
		{
			if (rqtn.updateRequisitionDispatchDetails())
			{
				if(rqtnLog.newRequisitionLog())
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
		else if(request.getParameter("action").equals("updateRecieved"))
		{
			if (rqtn.updateRequisitionRecievedDetails())
			{
				if(rqtnLog.newRequisitionLog())
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
