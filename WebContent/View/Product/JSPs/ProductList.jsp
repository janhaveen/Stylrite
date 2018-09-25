<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card" id="ProductTableDiv">
    <div class="card-body table-responsive-md">
    	<h5 class="card-title">Product List</h5><hr id="prHr">
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
    	<table id="ProductDatatables" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>Action</th>
		            <th>Brand</th>
		            <th>Model Number</th>
		            <th>Color</th>
		            <th>Size</th>
		            <th>Price</th>
		        </tr>
		        <!-- <tr id="filterrow">
		            <td></td>
		            <th>Productloyee Name</th>
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