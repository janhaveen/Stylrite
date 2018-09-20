<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
<div class="card" id="EmpTableDiv">
    <div class="card-body table-responsive-md">
    	<h5 class="card-title">Employee List</h5><hr>
    	<div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
		 <p id="successMsg"></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-danger alert-dismissible fade show HideThisElement errorMsg" role="alert">
		 <p id="errorMsg"></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
    	<table id="datatables" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>Action</th>
		            <th>Employee Name</th>
		            <th>Department</th>
		            <th>Designation</th>
		            <th>User ID</th>
		            <th>Mobile No</th>
		            <th>Email ID</th>
		            <th>Report To</th>
		            <th>Status</th>
		        </tr>
		        <!-- <tr id="filterrow">
		            <td></td>
		            <th>Employee Name</th>
		            <th>Department</th>
		            <th>Designation</th>
		            <th>User ID</th>
		            <th>Mobile No</th>
		            <th>Email ID</th>
		            <th>Report To</th>
		            <th>Status</th>
		        </tr> -->
		    </thead>
		</table>
    </div>
</div>
</body>
</html>