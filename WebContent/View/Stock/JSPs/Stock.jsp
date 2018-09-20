<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp"%>
	<div class="container">
		<div class="container-fluid">
			<%@include file="../../Order/JSPs/OrderList.jsp"%>
			<%-- <%@include file="ClientView.jsp"%> --%>
			<%@include file="StockForm.jsp"%>
			<%-- <%@include file="DeleteClient.jsp"%> --%>
		</div>
	</div>
</body>
<script type="text/javascript" src="../../Order/JavaScripts/OrderList.js"></script>
<script type="text/javascript" src="../JavaScripts/Stock.js"></script>
<!-- <script type="text/javascript" src="../JavaScripts/ContactPersonList.js"></script>
<script type="text/javascript" src="../JavaScripts/ClientAddressList.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForState.js"></script> -->
</html>