<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Management</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp" %>
<div class="container">
		<div class="container-fluid">
			<%@include file="TaskList.jsp" %>
			<%@include file="TaskView.jsp" %>
			<%@include file="CreateTask.jsp" %>
		</div>
</div>
</body>
<script type="text/javascript" src="../JavaScripts/TaskList.js"></script>
<script type="text/javascript" src="../JavaScripts/Task.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForTask.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
</html>