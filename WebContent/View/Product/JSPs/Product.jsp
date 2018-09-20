<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp" %>
	<div class="container">
		<div class="container-fluid">
			<%@include file="ProductList.jsp" %>
			<%@include file="ProductView.jsp" %>
			<%@include file="ProductForm.jsp" %>
			<%@include file="DeleteProduct.jsp" %>
		</div>
	</div>
</body>
<script type="text/javascript" src="../JavaScripts/ProductList.js"></script>
<script type="text/javascript" src="../JavaScripts/Product.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForHSN.js"></script>
<!-- <script type="text/javascript" src="../JavaScripts/Employee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
<script type="text/javascript" src="../../../js/General/SelectForManager.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForState.js"></script> -->
</html>