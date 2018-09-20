package com.requistion.requistion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
/*import java.sql.Timestamp;
import java.util.UUID;*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateRequisitionComments")
public class UpdateRequisitionComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date d1=new Date(System.currentTimeMillis());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logEntry=false;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		/*Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis());*/
		//PlanOfAction poa=new PlanOfAction();	
		RequisitionLog poal=new RequisitionLog();

		poal.setRequisitionId(request.getParameter("requisitionID"));
		poal.setRequisitionLogId(request.getParameter("requisitionLogID"));
		poal.setAction(request.getParameter("action"));
		//poal.setFromValue(request.getParameter("commentsOld"));
		//poal.setToValue(request.getParameter("comments"));
		poal.setRemarks(request.getParameter("remarks"));
		poal.setRequisitionLogCreatedBy(session.getAttribute("userId").toString());
		logEntry = poal.newRequisitionLog();
		
		if(logEntry)
			out.println("1");
		else
			out.println("0");
	}
}
