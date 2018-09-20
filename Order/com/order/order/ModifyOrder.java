package com.order.order;

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

@WebServlet("/ModifyOrder")
public class ModifyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		boolean checkOf1ststatus = false;
		boolean checkstatus = false;
		
		Order order = new Order();
		OrderItem orderItm = new OrderItem();
		/*RequisitionLog rqtnLog = new RequisitionLog();*/

		order.setOrderId(request.getParameter("orderID"));
		orderItm.setOrderId(request.getParameter("orderID"));
		/*rqtnLog.setRequisitionId(request.getParameter("requisitionID"));*/
		orderItm.setOrderItemId(request.getParameter("orderItemID"));
		/*rqtnLog.setRequisitionLogId(request.getParameter("requisitionLogID"));*/
		
		order.setClientId(request.getParameter("selectedClientId"));
		order.setContactPersonId(request.getParameter("selectedClientContactPersonId"));
		order.setBillingAddressId(request.getParameter("selectedBillingAddressId"));
		order.setDeliveryAddressId(request.getParameter("selectedDeliveryAddressId"));
		order.setSalesPerson(request.getParameter("clientSalesPerson"));
		order.setInvoiceType(request.getParameter("invoiceType"));
		order.setModeOfPayment(request.getParameter("modeOfPayment"));
		
		if(request.getParameter("expectedDeliveryDate") != null && !request.getParameter("expectedDeliveryDate").equals(""))
		{
			order.setExpectedDeilvery(MySqlConnect.convertToSqlDate(request.getParameter("expectedDeliveryDate")));
		}
		order.setOrderStatus(request.getParameter("orderStatus"));
		
		order.setOrderCreatedBy(session.getAttribute("userId").toString());
		order.setOrderUpdatedBy(session.getAttribute("userId").toString());

		orderItm.setProductId(request.getParameter("ProductId"));
		try
		{
			orderItm.setQuantity(Integer.parseInt(request.getParameter("Qty")));
			orderItm.setRate(Float.parseFloat(request.getParameter("rate")));
			orderItm.setDiscount(Integer.parseInt(request.getParameter("discount")));
			orderItm.setIgst(Integer.parseInt(request.getParameter("tax")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		orderItm.setHsnId(request.getParameter("hsnId"));
		orderItm.setOrderItemStatus(request.getParameter("orderItemstatus"));
		
		orderItm.setOrderItemCreatedBy(session.getAttribute("userId").toString());
		orderItm.setOrderItemUpdatedBy(session.getAttribute("userId").toString());

		/*rqtnLog.setRemarks(request.getParameter("remarks"));
		rqtnLog.setRequisitionLogStatus(request.getParameter("requitionstatus"));
		rqtnLog.setRequisitionLogCreatedBy(session.getAttribute("userId").toString());*/
		
		if(request.getParameter("action").equals("insertOrder"))
		{
			if(request.getParameter("count").equals("1"))
			{
				checkOf1ststatus = true;
				if (order.newOrder())
				{
					/*if(rqtnLog.newRequisitionLog())
					{*/
						checkstatus = true;
					/*}
					else
					{
						checkstatus = false;
					}*/
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
					if (orderItm.newOrderItem())
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
				if (orderItm.newOrderItem())
				{
					out.println("1");
				}
				else
				{
					out.println("0");
				}
			}
		}
		/*else if(request.getParameter("action").equals("updateAccpStatus"))
		{
			if(request.getParameter("count").equals("1"))
			{
				checkOf1ststatus = true;
				if (order.updateStatus())
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
					if (orderItm.updateStatus())
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
				if (orderItm.updateStatus())
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
			if (order.updateRequisitionDispatchDetails())
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
			if (order.updateRequisitionRecievedDetails())
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
		}*/
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
