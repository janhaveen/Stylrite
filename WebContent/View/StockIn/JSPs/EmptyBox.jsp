<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove and Print Box</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp" %>
	<div class="container">
		<div class="container-fluid">
			<div class="card">
    			<div class="card-body">
    				<input type="hidden" id="p" value="<%=request.getParameter("p")%>">
    				<button type="button" id="PrintBarcodes" class="btn btn-sm btn-primary">Print Barcodes</button>
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
    				<table id="ProductData" class="table table-hover mb-0 nowrap">
					    <thead>
					        <tr id="headerrow" class="">
					         	<th>#</th>
					            <th>Location</th>
					            <th>Floor</th>
					            <th>Aisle</th>
					            <th>Rack</th>
					            <th>Section</th>
					        </tr>
					    </thead>
					    <tbody id="ProductDataBody"></tbody>					   
					 </table>
					 <nav aria-label="Page navigation example" style="float: right;">
					  <ul class="pagination">
					  </ul>
					</nav>
					<!-- <button type="button" id="DeleteProduct" class="btn btn-sm btn-outline-primary">Delete</button> -->
					<button type="button" id="submitRemove" class="btn btn-sm btn-primary">Remove</button>
    			</div>
    		</div>
    	</div>
    </div>
</body>
<script type="text/javascript" src="../JavaScripts/EmptyBox.js"></script>
</html>