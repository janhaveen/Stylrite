<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.col-md-3 .card{
	margin: 1%;
}
</style>
</head>
<body>
<div class="card" id="TaskTableDiv">
    <div class="card-body table-responsive-md">
    	<h5 class="card-title">Task List</h5><hr>
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
    	<div class="col-md-12 row">
    		<div class=col-md-3 id="todo" style="border: 1px solid #d4c9c9;">
    			
    		</div>
    		<div class=col-md-3 id="inProgress" style="border: 1px solid #d4c9c9;margin: 0% 2%;">
    		</div>
    		<div class=col-md-3 id="done" style="border: 1px solid #d4c9c9;">
    		</div>
    	</div>
    </div>
</div>
</body>
</html>