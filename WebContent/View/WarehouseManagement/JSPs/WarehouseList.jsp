<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card " id="WhTableDiv">
    <div class="card-body table-responsive-md">
    	<!-- <h5 class="card-title">Warehouse List</h5><hr id="prHr"> -->
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
        <table id="WhDatatables" class="table table-hover mb-0 nowrap" cellspacing="0" width="100%">
            <thead>
                <tr id="headerrow" class="">
                    <th>Action</th>
                    <th>Name</th>
                    <th>Location</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Pin code</th>
                    <th>Area (Sq.Ft)</th>
               </tr>
            </thead>
        </table>
    </div>
</div>
</body>
</html>