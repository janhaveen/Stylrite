<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<title>Change Password</title>
<!-- Font Awesome -->
    <style>
		.companyLogo{
			width: 100pt;
			margin-left:5px;
			}
		.edit_me,.select_me,.delete_me{
			width: 12pt;
			margin-right: 3%;
			cursor: pointer;
		}
		td input {
			width: 80%;
		}
		#headerrow th, #filterrow th{
		text-align: center;
		}
		*{
			font-family: 'Montserrat', sans-serif;
		}
		.dataTables_filter {
		display: none; 
		}
		.delete{
            width: 80pt;
        }
        .HideThisElement{
  			display: none
		}
        $('.datepicker').pickadate({
  			editable: true
		})
    </style>
    
    <style type="text/css">
    	.form-simple .font-small {
		  font-size: 0.8rem; }
		
		.form-simple .header {
		  border-top-left-radius: .3rem;
		  border-top-right-radius: .3rem; }
		
		.form-simple input[type=text]:focus:not([readonly]) {
		  border-bottom: 1px solid #ff3547;
		  -webkit-box-shadow: 0 1px 0 0 #ff3547;
		  box-shadow: 0 1px 0 0 #ff3547; }
		
		.form-simple input[type=text]:focus:not([readonly]) + label {
		  color: #4f4f4f; }
		
		.form-simple input[type=password]:focus:not([readonly]) {
		  border-bottom: 1px solid #ff3547;
		  -webkit-box-shadow: 0 1px 0 0 #ff3547;
		  box-shadow: 0 1px 0 0 #ff3547; }
		
		.form-simple input[type=password]:focus:not([readonly]) + label {
		  color: #4f4f4f; }
    </style>
</head>
<body class="fixed-sn white-skin">
	<%@ include file="../../Header.jsp" %>
	<main> <!--Section: Basic examples-->
	<div class="container" >
	<div class="card" style="margin: 5% 20%;">
	<div class="" id="ChangePassword">

		<!--Form without header-->
		<form action="" id="LogInForm" name="LogInForm">
			<br><p class="h4 text-center">Change Password</p>
	        <div class="alert alert-danger HideThisElement" id="errorMessage" style="margin: 0% 2%;"></div>
	        <div class="alert alert-success HideThisElement" id="successMessage" style="margin: 0% 2%;"></div>
			<input type="hidden" id="cuntPassSession" name="cuntPassSession" class="form-control" value="${password}">
			<br>
			<div class="form-group col-md-12">
				<label for="orangeForm-name">Current Password</label>
				<input type="password" id="cruntPass" name="cruntPass" class="form-control">
			</div>
			<div class="form-group col-md-12">
				<label id="passLbl" name="passLbl" for="orangeForm-email" class="disabled">New Password</label>
				<input type="password" id="pass" name="pass" class="form-control" disabled> 
			</div>

			<div class="form-group col-md-12">
				<label id="cnfrmPassLbl" name="cnfrmPassLbl" for="orangeForm-pass" class="disabled">Confirm password</label>
				<input type="password" id="cnfrmPass" name="cnfrmPass" class="form-control" disabled>
			</div>
			
			<div class="text-center">
				<button class="btn btn-deep-orange" id="changeBtn" name="changeBtn" disabled>Change</button>
			</div>
<br>
		</form>
	</div>
	</div>
	</div>
	</main>
	<script type="text/javascript"
		src="../JavaScripts/ChangePassword.js"></script>
	<script>
		// Material Select Initialization
		/* $(document).ready(function() {
			$('select[name="datatables_length"]').material_select();
		});

		$(document).ready(function() {
			$('.mdb-select').material_select();
		}); */

		//$('.datepicker').pickadate();
	</script>
</body>
</html>