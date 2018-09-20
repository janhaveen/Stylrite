<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order</title>
</head>
<body>	
   	<%@include file="../../Client/JSPs/ClientInfo.jsp" %>
    <input type="hidden" name="action" id="action">
    <!-- <div class="card HideThisElement" id="SampleFormDiv">
    <div class="card-body" style="padding-bottom: 0px;">
    	<h5 class="card-title">New Sample</h5><hr>
		<form action="" id="newElementForm" name="newElementForm">
			<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div>
	        <input type="hidden" name="selectedClientId" id="selectedClientId">
	        <div class="" id="myTabContent">
	            <div class="tab-pane fade show active" id="ClientDetails" role="tabpanel" aria-labelledby="ClientDetails-tab">
                <div class="form-row">
                    <div class="form-group col-md-6">
                    	<div class="form-group col-md-12" style="padding: 0;">
		                    <div class="form-group">
		                        <label for="reason">Reason <span class="mandatory-element">*</span></label>
		                        <select class="form-control" id="reason" name="reason">
		                        </select>
		                    </div>
	                    </div>
	                    <div class="row">
	                    	<div class="form-group col-md-6">
			                	<div class="form-group">
			                        <label id="expectedReceiptDateLbl" for="expectedReceiptDate">Expected Receipt Date <span class="mandatory-element">*</span></label>
			                        <input type="text" id="expectedReceiptDate" name="expectedReceiptDate" class="form-control datepicker">
			                    </div>
	                    	</div>
	                    	<div class="form-group col-md-6">
			                	<div class="form-group">
			                        <label for="modeOfTransport">Mode of Transport <span class="mandatory-element">*</span></label>
			                        <select class="form-control" id="modeOfTransport" name="modeOfTransport">
			                        </select>
			                    </div>
	                    	</div>
	                    </div>
                    </div>
                    <div class="form-group col-md-6">
                    	<div class="form-group">
                        	<label id="remarksLbl" for="remarks" class="">Remarks</label>
                    		<textarea class="form-control" rows="5" id="remarks" placeholder="Enter Remarks"></textarea>
                        </div>
                    </div>
                </div>
	        </div>
        	</form>
    </div>
    </div> --><!-- <br> -->
   	<%@include file="../../Product/JSPs/ProductList.jsp" %><!-- <br> -->
    <div class="card HideThisElement" id="OrderProductListDiv">
	    <div class="card-body" style="padding-bottom: 0;">
    		<h5 class="card-title">Product Info</h5><!-- <hr> -->
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
	    	<table id="ProductData" class="table table-hover mb-0 nowrap">
			    <thead>
			        <tr id="headerrow" class="" style="text-align: center;">
			            <th class="HideActionClass">Action</th>
			            <th>SKU ID</th>
			            <th>Product Info</th>
			            <th>Quantity</th>
			            <th>Stock</th>
			            <th>Rate</th>
			            <th>Discount (%)</th>
			            <!-- <th class="HideStatusClass">Product Status</th> -->
			        </tr>
			    </thead>
			    <tbody id="ProductDataBody" style="text-align: center;"></tbody>
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
		        <button type="button" class="btn btn-primary" id="DeleteProduct">Delete</button>
		        <button type="button" class="btn btn-primary" id="SubmitButtonRegister">Submit</button>
		        <!-- <button type="button" class="btn btn-primary" id="BackButtonSubmit">Back</button> -->
		    </div>
	    </div>
    </div>
    <div class="card HideThisElement" id="SampleFormDispatchDiv">
	    <div class="card-body">
    		<h5 class="card-title">Dispatch Details</h5><!-- <hr> -->
			<div class="alert alert-warning HideThisElement row" id="alertMessage" style="background-color: #ffbb33">
			</div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div>
			<form action="" id="dispatchForm" name="dispatchForm">
	            <div class="form-row">
	                <div class="form-group col-md-6">
						<div class="row">
							<div class="form-group col-md-6" style="margin: 0;">
								<div class="form-group">
									<label for="transportName">Transport Name</label>
									<input type="text" id="transportName" name="transportName" class="form-control">
								</div>
							</div>
							<div class="form-group col-md-6" style="margin: 0;">
								<div class="form-group">
									<label for="dispatchedDate">Dispatched Date <span class="mandatory-element">*</span></label>
									<input type="text" id="dispatchedDate" name="dispatchedDate" class="form-control datepicker">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-6" style="margin: 0;">
								<div class="form-group">
									<label for="trackingID">Tracking ID</label>
									<input type="text" id="trackingID" name="trackingID" class="form-control">
								</div>
							</div>
							<div class="form-group col-md-6" style="margin: 0;">
								<div class="form-group">
									<label for="EWayBillNo">E-Way Bill No</label>
									<input type="text" id="EWayBillNo" name="EWayBillNo" class="form-control">
								</div>
							</div>
						</div>
	                </div>
	                <div class="form-group col-md-6">
	                	<div class="form-group">
	                    	<label id="remarksLbl" for="remarks" class="">Remarks</label>
	                		<textarea class="form-control" rows="5" id="remarksDipatched" name="remarks" placeholder="Enter Remarks"></textarea>
	                    </div>
	                </div>
	            </div>
		        <div class="left" id="submitBtnDiv">
			        <button type="button" class="btn btn-primary" id="UpdateDispatchButton">Update</button>
			        <button type="button" class="btn btn-primary" id="BackButtonSubmit">Back</button>
			    </div>
			</form>
	    </div>
    </div>
    <div class="card HideThisElement" id="SampleFormReceiveDiv">
	    <div class="card-body">
    		<h5 class="card-title">Details</h5><!-- <hr> -->
			<div class="alert alert-warning HideThisElement row" id="alertMessage" style="background-color: #ffbb33">
			</div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div>
	            <div class="form-row">
	                <div class="form-group col-md-3">
						<div class="row">
							<div class="form-group col-md-12" style="margin: 0;">
								<div class="form-group">
									<label for="sampleReceiptDate">Receipt Date <span class="mandatory-element">*</span></label>
									<input type="text" id="sampleReceiptDate" name="sampleReceiptDate" class="form-control datepicker">
								</div>
							</div>
							<!-- <div class="form-group col-md-6" style="margin: 0;">
								<div class="form-group">
									<label for="dispatchedDate">Dispatched Date <span class="mandatory-element">*</span></label>
									<input type="text" id="dispatchedDate" name="dispatchedDate" class="form-control datepicker">
								</div>
							</div> -->
						</div>
						<!-- <div class="row">
							<div class="form-group col-md-6" style="margin: 0;">
								<div class="form-group">
									<label for="trackingID">Tracking ID <span class="mandatory-element">*</span></label>
									<input type="text" id="trackingID" name="trackingID" class="form-control">
								</div>
							</div>
							<div class="form-group col-md-6" style="margin: 0;">
								<div class="form-group">
									<label for="EWayBillNo">E-Way Bill No <span class="mandatory-element">*</span></label>
									<input type="text" id="EWayBillNo" name="EWayBillNo" class="form-control">
								</div>
							</div>
						</div> -->
	                </div>
	                <div class="form-group col-md-9">
	                	<div class="form-group">
	                    	<label id="remarksLbl" for="remarks" class="">Remarks</label>
	                		<textarea class="form-control" rows="5" id="receivedRemarks" name="remarks" placeholder="Enter Remarks"></textarea>
	                    </div>
	                </div>
	            </div>
		        <div class="left" id="submitBtnDiv">
			        <button type="button" class="btn btn-primary" id="UpdateReceiveButton">Update</button>
			        <button type="button" class="btn btn-primary" id="BackButtonReceive">Back</button>
			    </div>
	    </div>
    </div>
</body>
</html>