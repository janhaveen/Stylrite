<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="SampleForSPTableDiv">
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
    	<table id="SampleForspdatatables" class="table table-hover mb-0 nowrap">
		    <thead>
		        <tr id="headerrow" class="">
		            <th>Action</th>
		            <th>Requisition Date</th>
                    <th>Product Info</th>
                    <th>Mode of Transfer</th>
                    <th>Status</th>
		        </tr>
		    </thead>
		    <tbody id="SampleForspdatatablesBody"></tbody>
		</table>
		<hr>
		<div class="form-row">
            <div class="form-group col-md-6">
                <label for="reason">Transfer To <span class="mandatory-element">*</span></label>
                <select class="form-control" id="TransferTo" name="TransferTo">
                </select>
            </div>
          </div>
		<%@include file="SampleTransferDetails.jsp" %>
		<div class="left">
	        <button type="button" class="btn btn-primary" id="SubmitSampleTransfer">Submit</button>
	        <button type="button" class="btn btn-outline-primary" id="CancelSampleTransfer">Cancel</button>	        
	        <!-- <button type="button" class="btn btn-primary" id="BackButtonSubmit">Back</button> -->
	    </div>
    </div>
</div>
</body>
</html>