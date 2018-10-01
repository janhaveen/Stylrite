<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.col-md-3 .card{
	margin: 4%;
}
.card-header {
	margin: 4%;
}
</style>
</head>
<body>
<div class="card" id="TaskTableDiv">
    <div class="card-body table-responsive-md">
    	<div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
		 <p id="successMsg"></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-danger alert-dismissible fade show HideThisElement errorMsg" role="alert">
		 <p id="errorMsg"></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<button class='btn btn-primary IfNotProjectId' onclick='loadBlankformForTask();' style="margin-bottom: 1%;"><i class='fa fa-plus mr-1'></i> New Task</button><br>
    	<div class="col-md-12 row">
	    	<div class="card col-md-3" id="todo" style="padding: 7px;">
			</div>
    		<div class="card col-md-3" id="inProgress" style="padding: 7px;margin: 0% 2%;">
    		</div>
    		<div class="card col-md-3" id="done" style="padding: 7px;">
    		</div>
    	</div>
    </div>
</div>
</body>
</html>