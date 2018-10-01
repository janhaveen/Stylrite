<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee</title>
</head>
<body>	
    <div class="card HideThisElement" id="EmpFormDiv">
    <div class="card-body">
    	<h5 class="card-title">New Employee</h5><hr>
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="EmployeeDetails-tab" data-toggle="tab" href="#EmployeeDetails" role="tab" aria-controls="EmployeeDetails" aria-selected="true">Employee Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Address-tab" data-toggle="tab" href="#AddressDetails" role="tab" aria-controls="AddressDetails" aria-selected="true">Address Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="SalaryDetails-tab" data-toggle="tab" href="#SalaryDetails" role="tab" aria-controls="SalaryDetails" aria-selected="false">Salary Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Account-tab" data-toggle="tab" href="#AccountDetails" role="tab" aria-controls="AccountDetails" aria-selected="false">Account Details</a>
            </li>
        </ul>
		<form action="" id="newElementForm" name="newElementForm">
		<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
        <div class="alert alert-success HideThisElement" id="successMessage"></div>
        <input type="hidden" name="selectedEmployeeId" id="selectedEmployeeId">
        <input type="hidden" name="action" id="action">
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="EmployeeDetails" role="tabpanel" aria-labelledby="EmployeeDetails-tab">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label id="firstNameLbl" for="firstName" class="">First Name <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control capitalizeText" id="firstName" name="firstName" placeholder="First Name">
                    </div>
                    <div class="form-group col-md-4">
                       <label id="lastNameLbl" for="lastName" class="">Last Name <span class="mandatory-element">*</span></label>
                       <input type="text" class="form-control capitalizeText" id="lastName" name="lastName"  placeholder="Last Name">
                    </div>
                    <div class="form-group col-md-4">
                        <label>Gender</label><br>
                        <div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="Gender" id="Male" value="801" checked="checked">
							  <label class="form-check-label" for="Male">Male</label>
						</div>
						<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="Gender" id="Female" value="802">
							  <label class="form-check-label" for="Female">Female</label>
						</div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label id="mobilenoLbl" for="mobileno" class="">Contact No <span class="mandatory-element">*</span></label>
                        <input type="number" maxlength="10" min="1000000000" max="9999999999" class="form-control validate" id="mobileno" name="mobileno"  placeholder="Contact No">
                    </div>
                    <div class="form-group col-md-4">
                        <label id="altContactNoLbl" for="altContactNo" class="">Alt Contact No</label>
                        <input type="number" class="form-control validate" id="altContactNo" name="altContactNo"  placeholder="Alt Contact No">
                    </div>
                    <div class="form-group col-md-4">
                        <label id="emailIdLbl" for="emailId"  class="">Email ID <span class="mandatory-element">*</span></label>
                    	<input type="email" class="form-control validate" id="emailId"  pattern=".+@.+..+" name="emailId"  placeholder="name@example.com">
                    </div>
                </div>
                <div class="form-row">
                	<div class="form-group col-md-4">
                        <label for="department">Department <span class="mandatory-element">*</span></label>
                        <select class="form-control" id="department" name="department">
                            <option value=""  selected>Select Department</option>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Designation <span class="mandatory-element">*</span></label>
                        <select class="form-control" id="designation" name="designation">
                            <option value=""  selected>Select Designation</option>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Supervisor </label>
                        <select class="form-control" id="reportTo" name="reportTo">
                            <option value=""  selected>Select Supervisor</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                	<div class="form-group col-md-4">
                         <label id="UserIdLbl" for="UserId" class="">User ID <span class="mandatory-element">*</span></label>
                        <input type="text" class="form-control" id="UserId" name="UserId" placeholder="User ID">
                    </div>
                    <div class="form-group col-md-4">
                       <label id="locationLbl" for="location" class="">Location <span class="mandatory-element">*</span></label>
                       <input type="text" class="form-control capitalizeText" id="location" name="location" placeholder="Location">
                    </div>
                    <!-- <div class="form-group col-md-4">
                    	<label>Branch <span class="mandatory-element">*</span></label>
                     	<select class="form-control" id="branch" name="branch">
                            <option value="" selected>Select Branch</option>
                        </select>                        
                    </div> -->
                    <div class="form-group col-md-4">
                        <label>Status</label><br>
                        <div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="Status" id="Active" value="501" checked="checked">
							  <label class="form-check-label" for="Active">Active</label>
						</div>
						<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="Status" id="Inactive" value="502">
							  <label class="form-check-label" for="Inactive">Inactive</label>
						</div>
                    </div>
                </div>
                <div class="form-row">
                	<div class="form-group col-md-4">
                        <label id="birthDateLbl" for="birthDate">Select Birth Date <span class="mandatory-element">*</span></label>
                        <input placeholder="Birth Date" type="text" id="birthDate" data-value="27 November, 2017" name="birthDate" class="form-control datepicker">
                    </div>
                    <!-- <div class="form-group col-md-4">
                        <label id="joinDateLbl" for="joinDate">Select Join Date <span class="mandatory-element">*</span></label>
                        <input placeholder="JoinDate" type="text" id="joinhDate" data-value="27 November, 2017" name="joinDate" class="form-control datepicker">
                    </div> -->
                </div>
                <!-- <button type="submit" class="btn btn-primary">Employee Details</button> -->
            </div>
            <div class="tab-pane fade" id="AddressDetails" role="tabpanel" aria-labelledby="AddressDetails-tab">
                <div class="form-group">
                    <label for="inputAddress">Address Line 1</label>
                    <input type="text" class="form-control" name="inputAddress" id="inputAddress" placeholder="Address Line 1">
                </div>
	            <div class="form-group">
                    <label for="inputAddress2">Address Line 2</label>
                    <input type="text" class="form-control" name="inputAddress2" id="inputAddress2" placeholder="Address Line 2">
	             </div>
	             <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">City</label>
                        <input type="text" class="form-control" name="inputCity" id="inputCity">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputState">State</label>
                        <select id="inputState" name="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                        </select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputZip">Pin</label>
                        <input type="number" class="form-control" name="inputZip" id="inputZip">
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="SalaryDetails" role="tabpanel" aria-labelledby="SalaryDetails-tab">
               <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="joinDate">Joining Date</label>
                        <input placeholder="Joining Date" type="text" id="joinDate" data-value="27 November, 2017" name="joinDate" class="form-control datepicker">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="BasicSalary">Basic Salary</label>
                        <input type="text" class="form-control" id="BasicSalary" placeholder="Basic Salary" name="BasicSalary">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="TravelAllowance">Travel Allowance (TA)</label>
                        <input type="text" class="form-control" id="TravelAllowance" placeholder="Travel Allowance (TA)" name="TravelAllowance">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="DearnessAllowance">Dearness Allowance (DA)</label>
                        <input type="text" class="form-control" id="DearnessAllowance" placeholder="Dearness Allowance (DA)" name="DearnessAllowance">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="HouseRentAllowance">House Rent Allowance (HRA)</label>
                        <input type="text" class="form-control" id="HouseRentAllowance" placeholder="House Rent Allowance (HRA)" name="HouseRentAllowance">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="ConveyanceAllowance">Conveyance Allowance</label>
                        <input type="text" class="form-control" id="ConveyanceAllowance" placeholder="Conveyance Allowance" name="ConveyanceAllowance">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="SpecialAllowance">Special Allowance</label>
                        <input type="text" class="form-control" id="SpecialAllowance" placeholder="Special Allowance" name="SpecialAllowance"> 
                    </div>
                    <div class="form-group col-md-4">
                        <label for="VariableSalary">Variable Salary</label>
                        <input type="text" class="form-control" id="VariableSalary" placeholder="Variable Salary" name="VariableSalary">
                    </div>
                </div><hr>
                <h5><li>Deduction</li></h5>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="EPF">Employee's Provident Fund (EPF)</label>
                        <input type="text" class="form-control" name="EPF" id="EPF" placeholder="Employee's Provident Fund (EPF)">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="ESIC">ESIC (Employee Contribution)</label>
                        <input type="text" class="form-control" name="ESIC" id="ESIC" placeholder="ESIC (Employee Contribution)">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="ProfessionalTax">Professional Tax (PT)</label>
                        <input type="text" class="form-control" id="ProfessionalTax" name="ProfessionalTax" placeholder="Professional Tax (PT)">
                    </div>
                </div>
               	<div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="Mediclaim">Mediclaim</label>
                        <input type="text" class="form-control" name="Mediclaim" id="Mediclaim" placeholder="Mediclaim">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="StatutoryBonus">Statutory Bonus</label>
                        <input type="text" class="form-control" id="StatutoryBonus" name="StatutoryBonus" placeholder="Statutory Bonus">
                    </div>
                </div>
                <!-- <button type="submit" class="btn btn-primary">Salary Details</button> -->
            </div>
            <div class="tab-pane fade" id="AccountDetails" role="tabpanel" aria-labelledby="AccountDetails-tab">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="AccountNo">Account No</label>
                        <input type="text" class="form-control" id="AccountNo" placeholder="Account No" name="AccountNo">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="BankName">Bank Name</label>
                        <input type="text" class="form-control" name="BankName" id="BankName" placeholder="Bank Name">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="BankBranch">Branch</label>
                        <input type="text" class="form-control" name="BankBranch" id="BankBranch" placeholder="Branch">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="IFSCCOde">IFSC Code</label>
                        <input type="text" class="form-control" name="IFSCCOde" id="IFSCCOde" placeholder="IFSC Code">
                    </div>
                </div>
                <!-- <button type="submit" class="btn btn-primary">Account Details</button> -->
            </div>
        </div>
        <div class="left">
	        <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonRegister">Submit</button>
	        <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdate">Update</button>
	        <button type="button" class="btn btn-primary" id="SubmitButtonBack">Back</button></div>
        </form>
    </div>
    </div>
</body>

<script>
	 
</script>
</html>