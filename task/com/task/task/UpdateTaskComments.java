package com.task.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.general.system.GetSystemDetails;


@WebServlet("/UpdateTaskComments")
public class UpdateTaskComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date d1=new Date(System.currentTimeMillis());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logEntry=false;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis());
		Task t=new Task();	
		ProjectTaskLog tl=new ProjectTaskLog();		
		
		tl.setTaskLogId(UUID.randomUUID().toString());
		tl.setTaskId(request.getParameter("TaskId"));
		tl.setAction("400000000010");
		//tl.setFromValue(request.getParameter("commentsOld"));
		//tl.setToValue(request.getParameter("comments"));
		tl.setRemarks(request.getParameter("comments"));
		tl.setCreatedBy(session.getAttribute("userId").toString());
		logEntry = tl.save_TaskLog();
		
		if(logEntry)
			out.println("1");
		else
			out.println("0");
	}
}
