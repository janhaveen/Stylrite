package com.task.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.MySql.MySqlConnect;

@WebServlet("/ModifyTask")
public class ModifyTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Task t=new Task();
		TaskLog tl=new TaskLog();
		boolean retunVal=false;
		t.setTaskId(request.getParameter("TaskId"));
		t.setTaskName(request.getParameter("taskName"));
		System.out.print(MySqlConnect.convertToSqlTimeStamp(request.getParameter("StartDate"))+" 00:00 am");
		t.setStartDate(MySqlConnect.convertToSqlTimeStamp(request.getParameter("StartDate")+" 00:00 am"));
		
		t.setEndDate(MySqlConnect.convertToSqlTimeStamp(request.getParameter("EndDate")+" 00:00 am"));
		
		t.setAssignedTo(request.getParameter("AssignedTo"));
		t.setVisibility(request.getParameter("Visibility"));
		t.setVisibleTo(request.getParameter("VisibilityTo"));
		t.setPriority(request.getParameter("Priority"));
		t.setStatus(request.getParameter("Status"));
		t.setDescription(request.getParameter("taskDescription"));
		t.setCreatedBy(session.getAttribute("userId").toString());
		
		if (request.getParameter("action").equals("update")) {
			if(!request.getParameter("taskNameOld").equals(request.getParameter("taskName"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000001");
				tl.setFromValue(request.getParameter("taskNameOld"));
				tl.setToValue(request.getParameter("taskName"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("StartDateOld").equals(request.getParameter("StartDate"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000002");
				tl.setFromValue(request.getParameter("StartDateOld"));
				tl.setToValue(request.getParameter("StartDate"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("EndDateOld").equals(request.getParameter("EndDate"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000003");
				tl.setFromValue(request.getParameter("EndDateOld"));
				tl.setToValue(request.getParameter("EndDate"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("AssignedToOld").equals(request.getParameter("AssignedTo"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000004");
				tl.setFromValue(request.getParameter("AssignedToOld"));
				tl.setToValue(request.getParameter("AssignedTo"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("VisibilityOld").equals(request.getParameter("Visibility"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000005");
				tl.setFromValue(request.getParameter("VisibilityOld"));
				tl.setToValue(request.getParameter("Visibility"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("VisibilityToOld").equals(request.getParameter("VisibilityTo"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000006");
				tl.setFromValue(request.getParameter("VisibilityToOld"));
				tl.setToValue(request.getParameter("VisibilityTo"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("PriorityOld").equals(request.getParameter("Priority"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000007");
				tl.setFromValue(request.getParameter("PriorityOld"));
				tl.setToValue(request.getParameter("Priority"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("StatusOld").equals(request.getParameter("Status"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000008");
				tl.setFromValue(request.getParameter("StatusOld"));
				tl.setToValue(request.getParameter("Status"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
			if(!request.getParameter("taskDescriptionOld").equals(request.getParameter("taskDescription"))) {
				tl.setTaskLogId(UUID.randomUUID().toString());
				tl.setTaskId(request.getParameter("TaskId"));
				tl.setAction("400000000009");
				tl.setFromValue(request.getParameter("taskDescriptionOld"));
				tl.setToValue(request.getParameter("taskDescription"));
				//tl.setRemarks(request.getParameter("comments"));
				tl.setCreatedBy(session.getAttribute("userId").toString());
				retunVal = tl.save_TaskLog();
			}
		}else {
			tl.setTaskLogId(UUID.randomUUID().toString());
			tl.setTaskId(request.getParameter("TaskId"));
			tl.setAction("400000000011");
			tl.setFromValue("");
			tl.setToValue("");
			tl.setRemarks(request.getParameter("taskDescription"));
			tl.setCreatedBy(session.getAttribute("userId").toString());
			retunVal = tl.save_TaskLog();
		}
		
		if(retunVal) {
			if(t.modify_task(request.getParameter("action")))
				out.println("1");
			else
				out.println("0");
		}else {
			out.println("0");
		}
	}
}
