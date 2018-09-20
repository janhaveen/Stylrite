<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<style type="text/css">
	#prHr, .dt-buttons
	{
		display: none !important;
	}
	.red
	{
		color: red !important;
	}
	.green
	{
		color: green !important;
	}
</style>
   <%if(request.getParameter("for").equals("newSample")){ %>
		<style type="text/css">
			.HideStatusClass{
				display: none;
			}
		</style>
    <% }
   	else if(request.getParameter("for").equals("sampleListDispatched") || request.getParameter("for").equals("sampleListRdyToRcv") || request.getParameter("for").equals("sampleListView")){ %>
		<!-- <script type="text/javascript">console.log("In if");</script> -->
		<style type="text/css">
			.HideActionClass{
				display: none;
			}
		</style>
    <% }%>
</head>
<body>
<%@include file="../../Header.jsp"%>
	<div class="container">
		<div class="container-fluid">
       		<input type="hidden" id="for" name="for" value="<%= request.getParameter("for") %>">
			<%@include file="SampleList.jsp"%>
			<%@include file="SampleView.jsp"%>
			<%@include file="SampleForm.jsp"%>
			<%-- <%@include file="DeleteClient.jsp"%> --%>
		</div>
	</div>
</body>
<script type="text/javascript" src="../JavaScripts/SampleList.js"></script>
<script type="text/javascript" src="../../Product/JavaScripts/ProductList.js"></script>
<script type="text/javascript" src="../JavaScripts/Sample.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForEmployee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForState.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForInventoryLegend.js"></script>
</html>