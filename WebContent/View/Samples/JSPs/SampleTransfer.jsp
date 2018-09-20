<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../Header.jsp"%>
	<div class="container">
		<div class="container-fluid">
			<%@include file="SalesPersonListForSample.jsp"%>
			<%@include file="SampleListPerSalesPerson.jsp"%>
			<%-- <%@include file="DeleteClient.jsp"%> --%>
		</div>
	</div>
</body>
<script type="text/javascript" src="../JavaScripts/SalesPersonSampleTransferList.js"></script>
<script type="text/javascript" src="../JavaScripts/SampleForSalesPersonList.js"></script>
</html>