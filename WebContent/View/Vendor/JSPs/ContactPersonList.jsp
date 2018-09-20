<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="card" id="VendorContactPersonTableDiv">
    <div class="card-body table-responsive-md">
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
    	<table id="contactPersonDatatables" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>Action</th>
                    <th>Contact Person Name</th>
                    <th>Designation</th>
                    <th>Contact No</th>
                    <th>Alt Contact No</th>
                    <th>Email Id</th>
                    <th>Location</th>
		        </tr>
		    </thead>
		</table>
    </div>
</div>
</body>
</html>