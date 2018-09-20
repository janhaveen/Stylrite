<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https:////code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://localhost:8083/Stylrite/css/Bootstrap/Style.css">
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
    <script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css">
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="http://localhost:8083/Stylrite/js/General/IDGenerator.js"></script> 
    <script type="text/javascript" src="http://localhost:8083/Stylrite/js/General/DataExport.js"></script> 
    <style type="text/css">
       body, .form-control {
		    font-size: 90% !important;
		    height: auto !important; 
		}
		.alert p, .navbar p{
			margin-bottom: 0rem	!important; 
		}
		.collapse{
			margin-left: 13%;	
		}
		<%-- <%if(session.getAttribute("designationTxt")=="cpc"){%>
			.epc
		<%}%> --%>
    </style>
</head>

<body>
<header>
    <div id="mySidenav" class="sidenav">
    	<input type="hidden" id="designationHeader" value="<%=session.getAttribute("designationTxt")%>"> 
    	<input type="hidden" id="departmentHeader" value="<%=session.getAttribute("departmentTxt")%>"> 
        	<a href="http://localhost:8083/Stylrite/View/UserHome.jsp" style="padding:  0px;margin-left: 6%;"><img style="width: 90%;margin-top: -5%;" src="http://localhost:8083/Stylrite/img/CompanyLogo.png" class="CompanyLogo"></a>
			
			<div class="collapsible">
			  <li id="100001">
			  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Admin"><i class="fas fa-cogs"></i> Admin <i class="fa fa-angle-down pull-right"  ></i></a>
               	 <div class="collapse" id="Admin">
               		<ul>
               			<li id="100003"><a href="http://localhost:8083/Stylrite/View/Employee/JSPs/Employee.jsp" class="waves-effect">Employee</a>
                         </li>
               		</ul>
              	  </div>
               </li>
				<li id="100001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Inventory"><i class="fas fa-calendar-alt"></i> Inventory <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Inventory">
	               		<ul>
	               			<li id="100003"><a href="http://localhost:8083/Stylrite/View/Product/JSPs/Product.jsp" class="waves-effect">Product</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/StockIn/JSPs/StockIn.jsp" class="waves-effect">Stock In</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/StockIn/JSPs/StockInUsingGRN.jsp" class="waves-effect">Stock In Using GRN</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/StockIn/JSPs/StockTransfer.jsp" class="waves-effect">Stock Transfer</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/StockIn/JSPs/EmptyBox.jsp?p=1" class="waves-effect">Remove Boxes</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/StockIn/JSPs/EmptyBox.jsp?p=2" class="waves-effect">Reprint Removed Boxes</a>
	                         </li>
	               		</ul>
	              	  </div>
	             </li>
	             <li id="100001">
				  	<a class="collapsible-header waves-effect arrow-r" data-toggle="collapse" data-target="#Sample"><i class="fab fa-wpforms"></i> Sample <i class="fa fa-angle-down pull-right"  ></i></a>
	               	 <div class="collapse" id="Sample">
	               		<ul>
	               			<li id="100003"><a href="http://localhost:8083/Stylrite/View/Samples/JSPs/Sample.jsp?for=newSample" class="waves-effect">New Sample</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListInvtAccp" class="waves-effect">Stock Out</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListDispatched" class="waves-effect">Dispatched</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListRdyToRcv" class="waves-effect">Ready To Receive</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/Samples/JSPs/Sample.jsp?for=sampleListView" class="waves-effect">View Sample List</a>
	                         </li>
	                         <li id="100003"><a href="http://localhost:8083/Stylrite/View/Samples/JSPs/SampleTransfer.jsp?for=sampleListView" class="waves-effect">Sample Transfer</a>
	                         </li>
	               		</ul>
	              	  </div>
	             </li>
			</div>
    </div>
    <nav class="navbar navbar-expand-sm navbar-dark sticky-top">
        <div class="float-left">
            <p style="cursor:pointer" onclick="openNav()"><i class="fa fa-bars" style="margin-right: 10px;font-size: 120%;"></i> </p>
        </div>
        <!-- Breadcrumb-->
        <div class="breadcrumb-dn mr-auto">
            <p id="HomeText" style="font-size: 120%;font-weight: 500;"> Home</p>
        </div>

        <ul class="navbar-nav">
            <li class="nav-item">
                <a style="font-size: 120% !important; color:  white;" class="nav-link dropdown-toggle waves-effect" href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user"></i> <span class="clearfix d-none d-sm-inline-block" style="font-size:15px;"><%=session.getAttribute("userName") %></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" style="margin-right: 1%;">
                    <a class="dropdown-item" href="http://localhost:8083/Stylrite/LogOut">Log Out</a>
                    <a class="dropdown-item" href="#">My account</a>
                </div>
            </li>
            <li class="nav-item">

            </li>
        </ul>
    </nav>
    <br>
    </header>
</body>
<script type="text/javascript">
function openNav() {
	if(!$("#mySidenav").hasClass("viewDiv")){
	    document.getElementById("mySidenav").style.width = "230px";
	    $("#mySidenav").addClass("viewDiv");
	}else{
		document.getElementById("mySidenav").style.width = "0px";
		$("#mySidenav").removeClass("viewDiv");
	}
}

/* function closeNav() {
    document.getElementById("mySidenav").style.width = "0px";
} */
$( function() {
	if($("#designationHeader").val().indexOf("CPC")>=0){
		$(".epc").addClass('HideThisElement');
		$(".mg").addClass('HideThisElement');
	}else if($("#designationHeader").val().indexOf("EPC")>=0){
		//$(".epc").addClass('HideThisElement');
		$(".mg").addClass('HideThisElement');
	}else {
		$(".epc").addClass('HideThisElement');
		$(".cpc").addClass('HideThisElement');
	}
	
   $( ".datepicker" ).datepicker({
	   format: "dd MM, yyyy"
   });
   
   $('body').on('click', function (e) { console.log($(e.target).attr('class'));
	    //did not click a popover toggle or popover
	    if ($(e.target).data('toggle') !== 'popover'
	        && $(e.target).parents('.popover.in').length === 0) { 
	        $('[data-toggle="popover"]').popover('hide');
	    }
	    /* if(!$(e.target).attr('class')=="fa fa-bars"){
	    	openNav();
	    } */
	    
	});
 });
</script>
</html>