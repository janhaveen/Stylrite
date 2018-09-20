<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GRN Stock In</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<style type="text/css">
#prHr, .dt-buttons{
	display: none	!important;
}
</style>
<style>
  #project-label {
    display: block;
    font-weight: bold;
    margin-bottom: 1em;
  }
  #project-icon {
    float: left;
    height: 32px;
    width: 32px;
  }
  #project-description {
    margin: 0;
    padding: 0;
  }
  #LocationText, #CapacityText, #SpaceText{
  	font-weight: 400 !important;
  }
  </style>
</head>
<body>
<%@include file="../../Header.jsp" %>
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="StockInDiv">
    			<div class="card-body">
    				<!-- <h5 class="card-title">Stock In</h5><hr> -->
					<div class="form-row">
						<div class="col-md-4">
							<label>Enter GRN</label>
							<input id="GRNText" class="form-control">
						</div>
			        </div><br>
			        <div class="col-md-12" id="boxInfoDiv">			        
			        	<button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#SelectProduct">Add Product</button>
			        	<hr>
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
						            <th>Action</th>
						            <th>Product Info</th>
						            <th>Quantity</th>
						            <th>Cost/Unit</th>
						        </tr>
						    </thead>
						    <tbody id="ProductDataBody"></tbody>
						 </table>
						 <button type="button" id="DeleteProduct" class="btn btn-sm btn-outline-primary HideThisElement">Delete</button>
						 <button type="button" id="submitStockIn" class="btn btn-sm btn-primary HideThisElement">Stock In</button>
		        	</div>
    			</div>
    		</div>
    		<div class="card HideThisElement"  id="ViewBarcodeDiv">
    			<div class="card-body">
					<div class="row">
						<div class="col-md-12" style="text-align: right;">
						<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						</div><br>
						<div class="col-md-12">
						    <div class="alert alert-success alert-dismissible fade show  successMsg" role="alert">
								 <p id="successMsg"></p>
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
								    <span aria-hidden="true">×</span>
								  </button>
							</div>
					    </div>
					</div><br>
					<div class="row">
						<div class="col-md-12">
							<div id="GeneratedChildBarcodeDiv"></div>
						</div>
					</div>
    			</div>
    		</div>
		</div>
	</div>
	<%@include file="SelectProductModal.jsp" %>
</body>
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<script type="text/javascript" src="../../Product/JavaScripts/ProductList.js"></script>
<script type="text/javascript" src="../JavaScripts/StockInUsingGRN.js"></script>
<script type="text/javascript" src="../JavaScripts/FormSubmitStockIn.js"></script>
</html>