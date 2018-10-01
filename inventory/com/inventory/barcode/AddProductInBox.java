package com.inventory.barcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddProductInBox")
public class AddProductInBox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		ChildBarcode cb=new ChildBarcode();
		String cdRowId="";
		if(request.getParameter("action").equals("insert"))
			cdRowId="SRDI00000000"+cb.getLastInsertedId();
		if(request.getParameter("action").equals("update"))
			cdRowId=request.getParameter("cdRowId"); System.out.println("wedwed"+request.getParameter("cbId"));
		if(request.getParameter("cbId")!=null) {
			if(request.getParameter("cbId")=="") {
				cb.setRowId(cdRowId);
				cb.setProductId(request.getParameter("ProductId"));
				cb.setLocation(request.getParameter("location"));
				cb.setGRNNumber(request.getParameter("GRNNumber"));
				//cb.setPurchaseorderitemid(purchaseorderitemid);
				//cb.setRate(rate);
				cb.setStatus(request.getParameter(""));
				cb.setCreatedBy(session.getAttribute("userId").toString());
				
				//if(true) {
					String cbOutStr=cb.addProduct_inBox(request.getParameter("action"));
					cdRowId="SRDI00000000"+cb.getLastInsertedId();
					cb.updateBoxBarcodeQty();
					out.println(cbOutStr);
				/*}else {
					out.println("0");
				}*/
			}
		}else {
			out.println(cdRowId);
		}
		
	}

}
