<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="EmpViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title">Employee Details</h5></div>
    		<div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">Firstname</dt>
		  <dd class="col-sm-2" id="firstNameText">Firstname</dd>
		  <dt class="col-sm-2">Lastname</dt>
		  <dd class="col-sm-2" id="LastnameText">Lastname</dt>
		  <dt class="col-sm-2">Gender</dt>
		  <dd class="col-sm-2" id="GenderText">Gender</dd>
		  <dt class="col-sm-2">Contact No</dt>
		  <dd class="col-sm-2" id="ContactText">Contact</dd>
		  <dt class="col-sm-2">Alt Contact No</dt>
		  <dd class="col-sm-2" id="AltContactText">Alt Contact</dd>
		  <dt class="col-sm-2">Email ID</dt>
		  <dd class="col-sm-2" id="EmailText">Email</dd>
		  <dt class="col-sm-2">Department</dt>
		  <dd class="col-sm-2" id="DepartmentText">Department</dd>
		  <dt class="col-sm-2">Designation</dt>
		  <dd class="col-sm-2" id="DesignationText">Designation</dd>
		  <dt class="col-sm-2">Supervisor</dt>
		  <dd class="col-sm-2" id="SupervisorText">Supervisor</dd>
		  <dt class="col-sm-2">User ID</dt>
		  <dd class="col-sm-2" id="UserText">User</dd>
		  <dt class="col-sm-2">Location</dt>
		  <dd class="col-sm-2" id="LocationText">User</dd>
		  <dt class="col-sm-2">Branch</dt>
		  <dd class="col-sm-2" id="BranchText">Branch</dd>
		  <dt class="col-sm-2">Birthdate</dt>
		  <dd class="col-sm-2" id="BirthdateText">Birthdate</dd>
		  <dt class="col-sm-2">Status</dt>
		  <dd class="col-sm-2" id="StatusText">Status</dd>
		</dl><hr>
		<h5 class="card-title">Address Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Address</dt>
		  <dd class="col-sm-2" id="AddressText">Firstname</dd>
		</dl><hr>
		<h5 class="card-title">Salary Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Joining Date</dt>
		  <dd class="col-sm-2" id="JoiningText">Firstname</dd>
		  <dt class="col-sm-2">Basic Salary</dt>
		  <dd class="col-sm-2" id="BasicSalaryText">Firstname</dd>
		  <dt class="col-sm-2">Travel Allowance (TA)</dt>
		  <dd class="col-sm-2" id="TAText">Firstname</dd>
		  <dt class="col-sm-2">Dearness Allowance (DA)</dt>
		  <dd class="col-sm-2" id="DAText">Firstname</dd>
		  <dt class="col-sm-2">House Rent Allowance (HRA)</dt>
		  <dd class="col-sm-2" id="HRAText">Firstname</dd>
		  <dt class="col-sm-2">Conveyance Allowance</dt>
		  <dd class="col-sm-2" id="CAText">Firstname</dd>
		  <dt class="col-sm-2">Special Allowance</dt>
		  <dd class="col-sm-2" id="SAText">Firstname</dd>
		  <dt class="col-sm-2">Variable Salary</dt>
		  <dd class="col-sm-2" id="VSText">Firstname</dd>
		</dl>
		<h6><li>Deduction</li></h6>
		<dl class="row">
			<dt class="col-sm-2">Employee's Provident Fund (EPF)</dt>
			<dd class="col-sm-2" id="EPFText">Firstname</dd>
			<dt class="col-sm-2">ESIC (Employee Contribution)</dt>
			<dd class="col-sm-2" id="ESICText">Firstname</dd>
			<dt class="col-sm-2">Professional Tax (PT)</dt>
			<dd class="col-sm-2" id="PTText">Firstname</dd>
			<dt class="col-sm-2">Mediclaim</dt>
			<dd class="col-sm-2" id="MediclaimText">Firstname</dd>
			<dt class="col-sm-2">Statutory Bonus</dt>
			<dd class="col-sm-2" id="StatutoryText">Statutory Bonus</dd>
		</dl>
		<hr>
		<h5 class="card-title">Account Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Account No</dt>
		  <dd class="col-sm-2" id="AccountNoText">Firstname</dd>
		  <dt class="col-sm-2">Bank Name</dt>
		  <dd class="col-sm-2" id=BankNameText">Firstname</dd>
		  <dt class="col-sm-2">Bank Branch</dt>
		  <dd class="col-sm-2" id="BankBranchText">Bank Branch</dd>
		  <dt class="col-sm-2">IFSC COde</dt>
		  <dd class="col-sm-2" id="IFSCText">Firstname</dd>
		</dl>
    </div>
    <button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button></div>
</div>
</body>
</html>