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
	    		<h5 class="card-title">Create Task</h5><hr>
	    		<form action="" id="TaskForm" name="TaskForm">
						<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
				        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
				        <div class="alert alert-success HideThisElement" id="successMessage"></div>
				        <input type="hidden" name="TaskId" id="TaskId">
			        	<input type="hidden" name="action" id="action" value="insert">
			        	<div class="form-group">
			                    <label for="taskName">Task Name</label>
			                    <input type="hidden" name="taskNameOld" id="taskNameOld">
			                    <input type="text" class="form-control" name="taskName" id="taskName" placeholder="Task Name">
		                </div>
		                <div class="form-row">
			                	<div class="form-group col-md-4">
				                        <label for="StartDate">Start Date</label>
				                         <input type="hidden" name="StartDateOld" id="StartDateOld">
				                        <input placeholder="Start Date" type="text" id="StartDate" data-value="27 November, 2017" name="StartDate" class="form-control datepicker">
	                    		</div>
	                    		<div class="form-group col-md-4">
				                        <label for="EndDate">End Date</label>
				                         <input type="hidden" name="EndDateOld" id="EndDateOld">
				                        <input placeholder="End Date" type="text" id="EndDate" data-value="27 November, 2017" name="EndDate" class="form-control datepicker">
	                    		</div>
	                    		 <div class="form-group col-md-4">
				                        <label for="AssignedTo">Assigned To</label>
				                        <input type="hidden" name="AssignedToOld" id="AssignedToOld">
				                        <select id="AssignedTo" name="AssignedTo" class="form-control">
					                            <option selected>Select Assigned To</option>
					                            <option>...</option>
				                        </select>
				                </div>
		                </div>	
		                <div class="form-row">
		                		<div class="form-group col-md-3">
				                        <label for="Visibility">Visibility</label>
				                        <input type="hidden" name="VisibilityOld" id="VisibilityOld">
				                        <select id="Visibility" name="Visibility" class="form-control">
					                            <option selected>Select Visibility</option>
					                            <option>...</option>
				                        </select>
				                </div>
				                <div class="form-group col-md-3">
				                        <label for="VisibilityTo">Visibility To</label>
				                        <input type="hidden" name="VisibilityToOld" id="VisibilityToOld">
				                        <select id="VisibilityTo" name="VisibilityTo" class="form-control">
					                            <option selected>Select Visibility To</option>
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
				                <div class="form-group col-md-3">
				                        <label for="Status">Status</label>
				                        <input type="hidden" name="StatusOld" id="StatusOld">
				                        <select id="Status" name="Status" class="form-control">
					                            <option selected>Select Status</option>
					                            <option>...</option>
				                        </select>
				                </div>
		                </div>
		                <div class="form-group">
			                    <label for="taskDescription">Task Description</label>
			                    <input type="hidden" name="taskDescriptionOld" id="taskDescriptionOld">
			                    <textarea class="form-control" name="taskDescription" id="taskDescription" placeholder="Task Description here . . ."></textarea>
		                </div>
		                <div class="form-row">
			                	<div class="form-group col-md-2">
						                <div class="form-check">
											      <input class="form-check-input" type="checkbox" id="AddReminder" >
											      <label class="form-check-label" for="AddReminder">
											        Add Reminder
											      </label>
										  </div>
						  			</div>
						  </div>
						  <div class="form-row HideThisElement" id="ReminderDiv">
						  			<div class="form-group col-md-6">
					                        <label for="Reminder">Reminder</label>
					                        <input type="hidden" name="ReminderOld" id="ReminderOld">
					                        <select id="Reminder" name="Reminder" class="form-control">
						                            <option selected>Select Reminder</option>
						                            <option>...</option>
					                        </select>
					                </div>
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