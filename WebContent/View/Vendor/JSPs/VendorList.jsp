<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor</title>
</head>
<body>
<div class="card" id="VendorTableDiv">
    <div class="card-body table-responsive-md">
    	<!-- <h5 class="card-title">Client List</h5><hr> -->
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
                    <th>Vendor Name</th>
                    <th>Location</th>
                    <th>Contact Person</th>
                    <th>Contact No</th>
                    <th>Alt Contact No</th>
                    <th>Email Id</th>
		        </tr>
		    </thead>
		</table>
    </div>
</div>
</body>
</html>