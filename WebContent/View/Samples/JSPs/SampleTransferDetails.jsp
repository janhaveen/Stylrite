<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="form-row">
          <!-- <div class="form-group col-md-3">
              <label id="requisitionIDLbl" for="requisitionID" class="">Requisition ID </label>
              <input type="text" class="form-control" id="requisitionID" name="requisitionID" readOnly>
          </div>  -->
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
</body>
</html>