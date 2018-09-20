<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Out</title>
</head>
<body>
    <div class="card HideThisElement" id="StockListDiv">
	    <div class="card-body">
    		<h5 class="card-title"><button type="button" class="btn btn-danger btn-sm" id="rejectBtn">Reject</button></h5><!-- <hr> -->
			<div class="alert alert-warning HideThisElement row" id="alertMessage" style="background-color: #ffbb33">
                <!-- <div class="col-md-10">
					<p id="alertPTag"></p>
                </div>
                <div class="col-md-2">
					<button type="button" class="btn btn-primary btn-sm" id="alertConfirmBtn">Confirm</button>
					<button type="button" class="btn btn-primary btn-sm" id="alertCloseBtn">Close</button>
				</div> -->
			</div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div>
	    	<table id="OrderItemData" class="table table-hover mb-0 nowrap">
			    <thead>
			        <tr id="headerrow" class="" style="text-align: center;">
			            <!-- <th class="HideActionClass">Action</th>
			            <th>SKU ID</th> -->
			            <th>Product Info</th>
			            <th>Order Quantity</th>
			            <th>Pending</th>
			            <th>Stock</th>
			            <th>Quantity</th>
			            <!-- <th class="HideStatusClass">Product Status</th> -->
			        </tr>
			    </thead>
			    <tbody id="OrderItemDataBody" style="text-align: center;"></tbody>
			</table><br>
	        <!-- <div class="row HideThisElement" id="updateBtnDiv">
                <div class="form-group col-md-6" style="margin: 0;">
                	<div class="form-group">
                    	<label id="updateRemarksLbl" for="updateRemarks" class="">Remarks</label>
                		<textarea class="form-control" rows="5" id="updateRemarks" placeholder="Enter Remarks"></textarea>
                    </div>
                </div>
                <div class="form-group col-md-6" style="margin: 0;padding-top: 28px;">
			        <div class="row">
                		<div class="form-group col-md-12">
			        		<button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdate">Update</button>
                		</div>
			        </div>
			        <div class="row">
                		<div class="form-group col-md-12">
			        		<button type="button" class="btn btn-primary" id="BackButtonUpdate">Back</button>
                		</div>
			        </div>
                </div>
	        </div> -->
	        <div class="left" id="submitBtnDiv">
		        <!-- <button type="button" class="btn btn-primary" id="DeleteProduct">Delete</button> -->
		        <button type="button" class="btn btn-primary btn-sm" id="SubmitButtonRegister">Submit</button>
		        <!-- <button type="button" class="btn btn-primary" id="BackButtonSubmit">Back</button> -->
		    </div>
	    </div>
    </div>
</body>
</html>