<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="TaskFormDiv">
    	<div class="card-body">
    		<form action="" id="TaskForm" name="TaskForm">
					<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
			        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
			        <div class="alert alert-success HideThisElement" id="successMessage"></div>
			        <input type="hidden" name="TaskId" id="TaskId">
			        <input type="hidden" name="Status" id="Status">
		        	<input type="hidden" name="action" id="action" >
		        	<input type="hidden" id="ProjectId" name="ProjectId" value="<%=request.getParameter("id")%>">            							        	
		        	<div class="form-group">
	                    <label for="taskName">Task Name  <span class="mandatory-element">*</span></label>
	                    <input type="hidden" name="taskNameOld" id="taskNameOld">
	                    <input type="text" class="form-control" name="taskName" id="taskName" placeholder="Task Name">
	                </div>
	                <div class="form-row">
                   		<div class="form-group col-md-3">
	                        <label for="EndDate">Due Date</label>
	                        <input type="hidden" name="EndDateOld" id="EndDateOld">
	                        <input placeholder="Due Date" type="text" id="EndDate" data-value="27 November, 2017" name="EndDate" class="form-control datepicker">
                   		</div>
                   		 <div class="form-group col-md-3">
	                        <label for="AssignedToCmp">Assigned To(Company)</label>
	                        <input type="hidden" name="AssignedToCmpOld" id="AssignedToCmpOld">
	                        <select id="AssignedToCmp" name="AssignedToCmp" class="form-control">
		                            <option selected>Select Assigned To</option>
		                            <option>...</option>
	                        </select>
		                </div>
		                <div class="form-group col-md-3">
	                        <label for="AssignedTo">Assigned To</label>
	                        <input type="hidden" name="AssignedToOld" id="AssignedToOld">
	                        <select id="AssignedTo" name="AssignedTo" class="form-control">
		                            <option selected>Select Assigned To</option>
		                            <option>...</option>
	                        </select>
		                </div>
		                <div class="form-group col-md-3">
	                        <label for="Priority">Priority</label>
	                        <input type="hidden" name="PriorityOld" id="PriorityOld">
	                        <select id="Priority" name="Priority" class="form-control">
		                            <option selected>Select Priority</option>
		                            <option>...</option>
	                        </select>
		                </div>
	                </div>	
	                <div class="form-group">
	                    <label for="taskDescription">Task Description</label>
	                    <input type="hidden" name="taskDescriptionOld" id="taskDescriptionOld">
	                    <textarea class="form-control richTextArea" id="taskDescription" placeholder="Task Description here . . ."></textarea>
	                </div>
	                <div class="left">
	                 	<button type="button" class="btn btn-primary " id="SubmitButtonRegister">Submit</button>
				        <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdate">Update</button>
				        <button type="button" class="btn btn-primary " id="SubmitButtonBack">Back</button>
				      </div>
	          </form>	        
		</div>
</div>
</body>
</html>