<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp" %>
	<div class="container">
		<div class="container-fluid">
			<%@include file="EmployeeList.jsp" %>
			<%@include file="EmployeeView.jsp" %>
			<%@include file="EmployeeForm.jsp" %>
			<%@include file="ResetPassword.jsp" %>
			<%@include file="DeleteEmployee.jsp" %>
		</div>
	</div>
</body>
<script type="text/javascript" src="../JavaScripts/EmployeeList.js"></script>
<script type="text/javascript" src="../JavaScripts/Employee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
<script type="text/javascript" src="../../../js/General/SelectForManager.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForState.js"></script>
</html>