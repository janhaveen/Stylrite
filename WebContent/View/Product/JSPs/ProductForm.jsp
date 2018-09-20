<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="card HideThisElement" id="ProductFormDiv">
    <div class="card-body">
    	<h5 class="card-title">New Product</h5><hr>
		<form action="" id="newProductForm" name="newProductForm">
		<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
        <div class="alert alert-success HideThisElement" id="successMessage"></div>
        <input type="hidden" name="ProductId" id="ProductId">
        <input type="hidden" name="action" id="action" >
        <div class="form-row">
              <div class="form-group col-md-4">
                  <label id="brandLbl" for="brandText" class="">Brand <span class="mandatory-element">*</span></label>
                  <input type="text" class="form-control" id="brandText" name="brandText" placeholder="Brand">  
                  <input type="hidden" id="brand" name="brand">      
                  <input type="hidden" id="brandAbbr" name="brandAbbr">                           
              </div>
              <div class="form-group col-md-4">
                 <label id="modelNoLbl" for="modelNo" class="">Model No <span class="mandatory-element">*</span></label>
                 <input type="text" class="form-control" id="modelNo" name="modelNo"  placeholder="Model No">
              </div>
              <div class="form-group col-md-4">
                  <label>Color <span class="mandatory-element">*</span></label>
                  <input type="text" class="form-control" id="color" name="color1"  placeholder="Color">				
              </div>
              <div class="form-group col-md-4">
                  <label>Size <span class="mandatory-element">*</span></label>
                  <input type="text" class="form-control" id="size" name="size1"  placeholder="Size" >				
              </div>
              <div class="form-group col-md-4">
                  <label>HSN ID <span class="mandatory-element">*</span></label>
                  <select class="form-control" id="hsnId" name="hsnId"></select>				
              </div>
              <div class="form-group col-md-4">
                  <label>Price <span class="mandatory-element">*</span></label>
                  <input type="text" class="form-control" id="price" name="price"  placeholder="Price">				
              </div>
              <div class="form-group col-md-12">
                  <label>Tags</label>
                  <input type="text" class="form-control" id="tag" name="tag"  placeholder="Tags">	
              </div>
              <div class="form-group col-md-12">
                  <label>Description</label>
                  <textarea class="form-control capitalizeText" id="Description" rows="3" name="Description"  placeholder="Description"></textarea>				
              </div>
              <div class="form-group col-md-12" id="skuDiv">
                 				
              </div>
          </div>
	      <div class="left">
		        <button type="button" class="btn btn-primary" id="GenerateSKU">Generate SKU</button>
		       	<button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonRegister">Submit</button>		        
		        <button type="button" class="btn btn-primary HideThisElement" id="SubmitButtonUpdate">Update</button>
	        	<button type="button" class="btn btn-primary " id="SubmitButtonBack">Back</button>
	      </div>
        </form>
    </div>
    </div>
</body>
</html>