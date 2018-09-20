<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client</title>
<style type="text/css">
    .searchIcon {
        float: left;
        margin-left: 10px;
        margin-top: -23px;
        position: relative;
        z-index: 2;
    }
</style>
</head>
<body>
    <div class="card HideThisElement" id="clientInfoDiv">
    <div class="card-body" style="padding-bottom: 0px;">
    	<!-- <h5 class="card-title">Client Info</h5><hr> -->
		<!-- <form action="" id="newElementForm" name="newElementForm"> -->
			<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
	        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage"></div>
	        <input type="hidden" name="action" id="action">
	        <div class="" id="myTabContent">
	            <!-- <div class="tab-pane fade show active" id="ClientDetails" role="tabpanel" aria-labelledby="ClientDetails-tab"> -->
                <div class="form-row">
                    <div class="form-group col-md-6">
	                    <div class="form-group">
	       					<input type="hidden" name="selectedClientId" id="selectedClientId">
	                        <label for="reason">Client <span class="mandatory-element">*</span></label>
	                        <input type="text" id="clientName" name="clientName" class="form-control" class="form-control" style="padding-left: 30px;" disabled>
			            	<i class="fa fa-search prefix searchIcon" onclick="$('#SelectClientModal').modal('show');"></i>
	                    </div>
                    </div>
                    <div class="form-group col-md-6">
	                    <div class="form-group">
	       					<input type="hidden" name="selectedClientContactPersonId" id="selectedClientContactPersonId">
	                        <label for="reason">Client Contact Person<span class="mandatory-element">*</span></label>
	                        <input type="text" id="clientContactPersonName" name="clientContactPersonName" class="form-control" class="form-control" style="padding-left: 30px;" disabled>
			            	<i class="fa fa-search prefix searchIcon" onclick="$('#SelectClientContactPersonModal').modal('show');"></i>
	                    </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
	                    <div class="form-group">
	       					<input type="hidden" name="selectedBillingAddressId" id="selectedBillingAddressId">
	                        <label for="reason">Billing Address <span class="mandatory-element">*</span></label>
	                        <input type="text" id="clientBillingAddress" name="clientBillingAddress" class="form-control" style="padding-left: 30px;" disabled>
			            	<i class="fa fa-search prefix searchIcon" onclick="showAddressModal('billingAddress');"></i>
	                    </div>
                    </div>
                    <div class="form-group col-md-4">
	                    <div class="form-group">
	       					<input type="hidden" name="selectedDeliveryAddressId" id="selectedDeliveryAddressId">
	                        <label for="reason">Delivery Address <span class="mandatory-element">*</span></label>
	                        <input type="text" id="clientDeliveryAddress" name="clientDeliveryAddress" class="form-control" class="form-control" style="padding-left: 30px;" disabled>
			            	<i class="fa fa-search prefix searchIcon" onclick="showAddressModal('deliveryAddress');"></i>
	                    </div>
                    </div>
                   	<div class="form-group col-md-4">
	                	<div class="form-group">
							<label for="clientSalesPerson">Sales Person <span class="mandatory-element">*</span></label>
							<select class="form-control" id="clientSalesPerson" name="clientSalesPerson">
							</select>
	                    </div>
                   	</div>
                </div>
                <div class="form-row">
                   	<div class="form-group col-md-4">
	                	<div class="form-group">
							<label for="invoiceType">Invoice Type <span class="mandatory-element">*</span></label>
							<select class="form-control" id="invoiceType" name="invoiceType">
							</select>
	                    </div>
                   	</div>
                   	<div class="form-group col-md-4">
	                	<div class="form-group">
							<label for="modeOfPayment">Mode Of Payment <span class="mandatory-element">*</span></label>
							<select class="form-control" id="modeOfPayment" name="modeOfPayment">
							</select>
	                    </div>
                   	</div>
                   	<div class="form-group col-md-4">
	                	<div class="form-group">
							<label for="expectedDeliveryDate">Expected Delivery Date <span class="mandatory-element">*</span></label>
	                        <input type="text" id="expectedDeliveryDate" name="expectedDeliveryDate" class="form-control datepicker">
	                    </div>
                   	</div>
                </div>
	        </div>
        	<!-- </form> -->
    </div>
    </div>
   	<%@include file="SelectClientModal.jsp" %>
   	<%@include file="SelectClientContactPersonModal.jsp" %>
   	<%@include file="SelectClientAddressModal.jsp" %>
</html>