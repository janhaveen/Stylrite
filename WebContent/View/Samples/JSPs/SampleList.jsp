<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample</title>
</head>
<body>
<div class="card" id="SampleTableDiv">
    <div class="card-body table-responsive-md" style="text-align: center;">
    	<!-- <h5 class="card-title">Sample List</h5><hr> -->
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
                    <th>Requested Date</th>
                    <th>Reason</th>
                    <th>Employee Name</th>
                    <th>Expected By</th>
                    <th>No of Products</th>
                    <th>Status</th>
		        </tr>
		    </thead>
		</table>
    </div>
</div>
</body>
</html>