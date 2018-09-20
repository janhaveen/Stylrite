<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="ProductViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title">Product Details</h5></div>
    		<div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">Brand</dt>
		  <dd class="col-sm-2" id="BrandText">Firstname</dd>
		  <dt class="col-sm-2">Model No </dt>
		  <dd class="col-sm-2" id="ModelNoText">Lastname</dt>
		  <dt class="col-sm-2">Color</dt>
		  <dd class="col-sm-2" id="ColorText">Gender</dd>
		  <dt class="col-sm-2">Size</dt>
		  <dd class="col-sm-2" id="SizeText">Contact</dd>
		  <dt class="col-sm-2">HSN ID </dt>
		  <dd class="col-sm-2" id="HSNIDText">Alt Contact</dd>
		  <dt class="col-sm-2">Price</dt>
		  <dd class="col-sm-2" id="PriceText">Email</dd>
		  <dt class="col-sm-2">Tags</dt>
		  <dd class="col-sm-2" id="TagsText">Department</dd>
		  <dt class="col-sm-2">Description</dt>
		  <dd class="col-sm-2" id="DescriptionText">Designation</dd>
		</dl>
    <button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button></div>
</div>
</body>
</html>