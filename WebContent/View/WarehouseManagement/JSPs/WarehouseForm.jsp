<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div class="card HideThisElement" id="WhFormDiv">
        <div class="card-body">
            <h5 class="card-title">New Warehouse</h5><hr>
            <form action="" id="newWhForm" name="newWhForm">
                    <input type="hidden" name="WarehouseId" id="WarehouseId">
                    <input type="hidden" name="action" id="action">
                    <div class="form-row">
                        <div class="form-group col-md-8">
                             <label id="NameLbl" for="Name" class="">Name <span class="mandatory-element">*</span></label>                        
                             <input type="text" id="Name" name="Name" class="form-control">
                         </div> 
                         <div class="form-group col-md-4">
                             <label id="branchManagerLbl" for="branchManager" class="">Warehouse Manager <span class="mandatory-element">*</span></label>
                      		 <select class="form-control" id="branchManager" name="branchManager">
                                 <option value=""  selected>Warehouse Manager</option>
                             </select>
                         </div>               
                        <div class="form-group col-md-4">
                             <label id="LocationLbl" for="Location" >Location <span class="mandatory-element">*</span></label>
                             <input type="text" id="Location" name="Location" class="form-control">
                        </div>
                        <div class="form-group col-md-4">
                             <label id="AreaLbl" for="Area" class="">Area (Sq.Ft.)</label>
                             <input type="text" id="Area" name="Area" class="form-control">
                        </div>
                        <div class="form-group col-md-4">
                             <label id="typeOfBrLbl" for="typeOfBr" class="">Type <span class="mandatory-element">*</span></label>
                             <select class="form-control" id="typeOfBr" name="typeOfBr">
                                 <option value=""  selected>Type</option>
                             </select>
                        </div>
                        <div class="form-group col-md-12">
                              <label id="AddressLbl" for="Address" class="">Address 1</label>
                              <input type="text" id="Address" name="Address"  class="form-control">
                        </div>
                        <div class="form-group col-md-12">
                              <label id="Address2Lbl" for="Address2" class="">Address 2</label>
                              <input type="text" id="Address2" name="Address2"  class="form-control">
                        </div>
                        <div class="form-group col-md-8">
                             <label id="AreaAddressLbl" for="AreaAddress" class="">Area</label>
                             <input type="text" id="AreaAddress" name="AreaAddress"  class="form-control">
                        </div>
                        <div class="form-group col-md-4">
                             <label id="GSTNumberLbl" for="GSTNumber" class="">GST No</label>
                             <input type="text" id="GSTNumber" name="GSTNumber" class="form-control">
                        </div>
                        <div class="form-group col-md-4">
                             <label id="cityLbl" for="city" class="">City <span class="mandatory-element">*</span></label>
                             <input type="text" class="form-control" id="city" name="city"  class="form-control">
                        </div>
                        <!-- <div class="form-group col-md-4">
                             <label id="DistrictLbl" for="district" class="">District</label>
                             <input type="text" id="District" name="District" class="form-control">
                        </div> -->
                        <div class="form-group col-md-4">
                             <label id="stateLbl" for="state" class="">State <span class="mandatory-element">*</span></label>
                             <select  class="form-control" id="state" name="state">
                                 <option value="" disabled selected>State</option>
                             </select>
                        </div>
                        <div class="form-group col-md-4">
                             <label id="pinLbl" for="pin" class="">PIN Code</label>
                             <input type="text" class="form-control" id="pin" name="pin">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="left">
                            <button id="SubmitButtonRegisterWarehouse" class="btn btn-primary">Submit </button>
                            <button id="SubmitButtonUpdateWarehouse" class="btn btn-primary HideThisElement" >Update</button>
                            <button id="SubmitButtonBack" class="btn btn-primary" data-dismiss="modal">Back</button>
                        </div>
                    </div>
                </form>
        </div>
    </div>
</body>
</html>