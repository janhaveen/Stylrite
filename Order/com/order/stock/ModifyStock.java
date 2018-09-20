package com.order.stock;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ModifyStock")
public class ModifyStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Stock stock = new Stock();

		stock.setOrderItemId(request.getParameter("orderItemId"));
		
		try
		{
			stock.setQty(Integer.parseInt(request.getParameter("qty")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		stock.setStatus(request.getParameter("status"));
		
		stock.setCreatedBy(session.getAttribute("userId").toString());
		

		if(stock.newOrderExctn())
		{
			out.println("1");
		}
		else
		{
			out.println("0");
		}
	}
}
