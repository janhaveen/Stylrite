package com.task.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.general.system.GetSystemDetails;

/**
 * Servlet implementation class UpdateStatusForPOA
 */
@WebServlet("/UpdateStatusForTask")
public class UpdateStatusForTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logEntry=false;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Task t=new Task();
		ProjectTaskLog tl=new ProjectTaskLog();
		t.setTaskId(request.getParameter("TaskId"));
		t.setStatus(request.getParameter("Status"));
		
		if(request.getParameter("Status")!=null || request.getParameter("StatusOld")!=null) {
			if(!request.getParameter("StatusOld").equals(request.getParameter("Status"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000008");
				tl.setFromValue(request.getParameter("StatusOld"));
				tl.setToValue(request.getParameter("Status"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				logEntry = tl.save_TaskLog();
			}
		}

		t.setCreatedBy(session.getAttribute("userId").toString());
		
		String colName="";
		if(request.getParameter("Status").equals("123124567412")) {
			colName = "actualStartdate";
		}else if(request.getParameter("Status").equals("123124567413") || request.getParameter("Status").equals("123124567417")) {
			colName = "actualEnddate";
		}
		if(colName!="")
			t.update_TaskDate(colName);
		
		if(t.update_status())			
			out.println("1");
		else
			out.println("0");
			
	}

}
