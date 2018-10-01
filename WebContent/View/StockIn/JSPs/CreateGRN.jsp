<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../Header.jsp" %>
	<div class="container">
		<div class="container-fluid">
			<div class="card" id="StockInDiv">
    			<div class="card-body">
    				<!-- <h5 class="card-title">Stock In</h5><hr> -->
					<div class="form-row">
						<div class="col-md-4">
							<label>Enter GRN</label>
							<input id="GRNText" class="form-control">
						</div>
						<div class="col-md-4">
							<label>Select Vendor</label>
							<input id="VendorText" class="form-control">
						</div>
						<div class="col-md-4">
							<label>Select Contact Person</label>
							<input id="VendorText" class="form-control">
						</div>
						<div class="col-md-4">
							<label>Select Address</label>
							<input id="VendorText" class="form-control">
						</div>
			        </div><br>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>