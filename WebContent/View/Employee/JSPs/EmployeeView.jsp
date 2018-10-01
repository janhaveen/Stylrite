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
		  <dd class="col-sm-2" id="firstNameText">-</dd>
		  <dt class="col-sm-2">Lastname</dt>
		  <dd class="col-sm-2" id="LastnameText">-</dt>
		  <dt class="col-sm-2">Gender</dt>
		  <dd class="col-sm-2" id="GenderText">-</dd>
		  <dt class="col-sm-2">-</dt>
		  <dd class="col-sm-2" id="ContactText">Contact</dd>
		  <dt class="col-sm-2">Alt Contact No</dt>
		  <dd class="col-sm-2" id="AltContactText">-</dd>
		  <dt class="col-sm-2">Email ID</dt>
		  <dd class="col-sm-2" id="EmailText">-</dd>
		  <dt class="col-sm-2">Department</dt>
		  <dd class="col-sm-2" id="DepartmentText">-</dd>
		  <dt class="col-sm-2">Designation</dt>
		  <dd class="col-sm-2" id="DesignationText">-</dd>
		  <dt class="col-sm-2">Supervisor</dt>
		  <dd class="col-sm-2" id="SupervisorText">-</dd>
		  <dt class="col-sm-2">User ID</dt>
		  <dd class="col-sm-2" id="UserText">-</dd>
		  <dt class="col-sm-2">Location</dt>
		  <dd class="col-sm-2" id="LocationText">-</dd>
		  <dt class="col-sm-2">Branch</dt>
		  <dd class="col-sm-2" id="BranchText">-</dd>
		  <dt class="col-sm-2">Birthdate</dt>
		  <dd class="col-sm-2" id="BirthdateText">-</dd>
		  <dt class="col-sm-2">Status</dt>
		  <dd class="col-sm-2" id="StatusText">-</dd>
		</dl><hr>
		<h5 class="card-title">Address Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Address</dt>
		  <dd class="col-sm-2" id="AddressText">-</dd>
		</dl><hr>
		<h5 class="card-title">Salary Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Joining Date</dt>
		  <dd class="col-sm-2" id="JoiningText">-</dd>
		  <dt class="col-sm-2">Basic Salary</dt>
		  <dd class="col-sm-2" id="BasicSalaryText">-</dd>
		  <dt class="col-sm-2">Travel Allowance (TA)</dt>
		  <dd class="col-sm-2" id="TAText">-</dd>
		  <dt class="col-sm-2">Dearness Allowance (DA)</dt>
		  <dd class="col-sm-2" id="DAText">-</dd>
		  <dt class="col-sm-2">House Rent Allowance (HRA)</dt>
		  <dd class="col-sm-2" id="HRAText">-</dd>
		  <dt class="col-sm-2">Conveyance Allowance</dt>
		  <dd class="col-sm-2" id="CAText">-</dd>
		  <dt class="col-sm-2">Special Allowance</dt>
		  <dd class="col-sm-2" id="SAText">-</dd>
		  <dt class="col-sm-2">Variable Salary</dt>
		  <dd class="col-sm-2" id="VSText">-</dd>
		</dl>
		<h6><li>Deduction</li></h6>
		<dl class="row">
			<dt class="col-sm-2">Employee's Provident Fund (EPF)</dt>
			<dd class="col-sm-2" id="EPFText">-</dd>
			<dt class="col-sm-2">ESIC (Employee Contribution)</dt>
			<dd class="col-sm-2" id="ESICText">-</dd>
			<dt class="col-sm-2">Professional Tax (PT)</dt>
			<dd class="col-sm-2" id="PTText">-</dd>
			<dt class="col-sm-2">Mediclaim</dt>
			<dd class="col-sm-2" id="MediclaimText">-</dd>
			<dt class="col-sm-2">Statutory Bonus</dt>
			<dd class="col-sm-2" id="StatutoryText">-</dd>
		</dl>
		<hr>
		<h5 class="card-title">Account Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Account No</dt>
		  <dd class="col-sm-2" id="AccountNoText">-</dd>
		  <dt class="col-sm-2">Bank Name</dt>
		  <dd class="col-sm-2" id=BankNameText">-</dd>
		  <dt class="col-sm-2">Bank Branch</dt>
		  <dd class="col-sm-2" id="BankBranchText">-</dd>
		  <dt class="col-sm-2">IFSC COde</dt>
		  <dd class="col-sm-2" id="IFSCText">-</dd>
		</dl>
    </div>
    <button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button></div>
</div>
</body>
</html>