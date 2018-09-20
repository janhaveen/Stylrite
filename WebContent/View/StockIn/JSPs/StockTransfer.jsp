<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Transfer</title>
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
							<label>Select Box</label>
							<input type="hidden" id="barcodeId" name="barcodeId">
							<input id="barcodeText" class="form-control">
						</div>
						<div class="col-md-4">
							<label for="barcodeValTxt" is="barcodeValTxtLbl"></label>
			        		<!-- <button type="button" name="searchbtn" id="searchbtn" class="btn btn-info">Search</button> -->
			        	</div>
			        </div><br>
			        <div class="HideThisElement" id="boxInfoDiv">
			        	<div class="card card-body"><h6>Box Info</h6> 
			        	<dl class="row">
		  					<dt class="col-sm-2">Location:</dt>
		  					<dt class="col-sm-2" id="LocationText">Location:</dt>
		  					<dt class="col-sm-2">Capacity:</dt>
		  					<dt class="col-sm-2" id="CapacityText">Capacity</dt>
		  					<dt class="col-sm-2">Available Space:</dt>
		  					<dt class="col-sm-2" id="SpaceText">Space</dt>
			        	</dl></div><br>
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
						            <th>Actual Quantity</th>
						            <th>Quantity</th>
						            <th>Cost/Unit</th>
						        </tr>
						    </thead>
						    <tbody id="ProductDataBody"></tbody>
						 </table>
						 <button type="button" id="DeleteProduct" class="btn btn-sm btn-outline-primary">Delete</button>
						 <button type="button" id="submitStockIn" class="btn btn-sm btn-primary">Stock In</button>
		        	</div>
    			</div>
    		</div>
    		<div class="card HideThisElement"  id="ViewBarcodeDiv">
    			<div class="card-body">
					<div class="row">
						<div class="col-md-12" style="text-align: right;">
						<button type="button" id="ExportasCSV" class="btn btn-sm btn-primary">Export as CSV</button>
						</div>
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
<script type="text/javascript" src="../JavaScripts/StockTransfer.js"></script>
<script type="text/javascript" src="../JavaScripts/StockInGeneral.js"></script>
<script type="text/javascript" src="../JavaScripts/FormSubmitStockIn.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</html>