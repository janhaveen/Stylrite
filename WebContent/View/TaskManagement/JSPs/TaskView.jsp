<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="TaskViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title row"><i class="fas fa-arrow-circle-left" style="margin: 0px 8px;"  id="SubmitButtonBackFromView"></i> <p id="TaskNameId">Task Details</p></h5></div>
    		<div class="col-md-6 right row" id="O1">
	    		<div class="col-md-3">
	    			<u><a id="editClick" href="#">Edit</a></u>
	    		</div>
	    		<div class="col-md-9">
	    			<div id="statusInfoDiv" class="row"><span id="statusDivView"></span></div>
	    		</div>
    		</div>
    	</div>
    	<hr>
    	<dl class="row">
		  <!-- <dt class="col-sm-2">Start Date</dt>
		  <dd class="col-sm-2" id="StartDateText">Firstname</dd> -->
		  <dt class="col-sm-2">Due Date</dt>
		  <dd class="col-sm-2" id="EndDateText">Lastname</dt>
		  <dt class="col-sm-2">Assigned To</dt>
		  <dd class="col-sm-2" id="AssignedToText">Gender</dd>
		 <!--  <dt class="col-sm-2">Visibility</dt>
		  <dd class="col-sm-2" id="VisibilityText">Contact</dd>
		  <dt class="col-sm-2">Visibility To</dt>
		  <dd class="col-sm-2" id="VisibilityToText">Alt Contact</dd> -->
		  <dt class="col-sm-2">Priority</dt>
		  <dd class="col-sm-2" id="PriorityText">Email</dd>
		  <!-- <dt class="col-sm-2">Status</dt>
		  <dd class="col-sm-2" id="StatusText">Department</dd> -->
		  <dt class="col-sm-2">Task Description</dt>
		  <dd class="col-sm-6" id="TaskDescriptionText">Designation</dd>
		</dl><hr>
		 <button type="button" id="AddComment" class="btn btn-sm btn-primary">Add comment</button><hr>
		    <div id="commDiv" class="HideThisElement">
		    	<label id="commentsLbl" for="comments" class="">Comments</label>	
		        <textarea type="text" rows="4" class="md-textarea  form-control" id="newcomments" name="comments" style="height: 4rem;overflow-y: auto;"></textarea><br>
		        <input type="button" id="SubmitButtonRegisterComments" value="Save" class="btn btn-info btn-rounded">
		    </div>
		  <div id="remarksDiv"></div>
	</div>
</div>
</body>
</html>