$(document).ready(function(){
    $("#source").change(function () {
        var val = this.value;
		$('#legendGroupLbl').addClass("active");
        if (val=="246") {
        	$('#reference').val("");
        	$("#referenceDiv").removeClass("HideThisElement");
		}
        else
        {
        	$("#referenceDiv").addClass("HideThisElement");
        }
    });
    
	/*$('#newElementForm').on('focusout', '#mobileno', function() {
	    var mobile = $('#mobileno').val();
	    var selectedEmployeeId = document.querySelector('#selectedEmployeeId').value;
	    $.ajax({
    		type: "GET",
	        url: "../../../GetClientList?forDup=dup&mobile="+mobile+"&selectedEmployeeId="+selectedEmployeeId,
	        success: function(data)
	        {
				if(data.data.length>0){
	                document.querySelector('#alertMessage').innerHTML = "<center><strong>Duplicate!</strong> The Number You Entered Is Already In Use By " + data.data[0].employeeName + " !</center>";
	                $("#alertMessage").removeClass("HideThisElement");
	               // $("#alertMessage").delay(5000).fadeOut(100);
	                $("#SubmitButtonUpdate").addClass("disabled");
	                $("#SubmitButtonUpdate").attr("disabled", true);
	                $("#SubmitButtonRegister").addClass("disabled");
	                $("#SubmitButtonRegister").attr("disabled", true);
		        } else {
		            $("#alertMessage").addClass("HideThisElement");
		            $("#SubmitButtonUpdate").removeClass("disabled");
		            $("#SubmitButtonUpdate").attr("disabled", false);
		            $("#SubmitButtonRegister").removeClass("disabled");
		            $("#SubmitButtonRegister").attr("disabled", false);
		        }
	        }
	    });
	});*/
	
	/*$('#newElementForm').on('focusout', '#UserId', function() {
	    var usrid = document.querySelector('#UserId').value;
	    var selectedEmployeeId = document.querySelector('#selectedEmployeeId').value;
	    $.ajax({
    		type: "GET",
	        url: "../../../GetEmployeeList?forDup=dup&usrid="+usrid+"&selectedEmployeeId="+selectedEmployeeId,
	        success: function(data)
	        {
				if(data.data.length>0){
	                document.querySelector('#alertMessage').innerHTML = "<strong>Duplicate!</strong> The User Id You Entered Is Already In Use By " + data.data[0].employeeName + " !";
	                $("#alertMessage").removeClass("HideThisElement");
	                $("#SubmitButtonUpdate").addClass("disabled");
	                $("#SubmitButtonUpdate").attr("disabled", true);
	                $("#SubmitButtonRegister").addClass("disabled");
	                $("#SubmitButtonRegister").attr("disabled", true);
		        } else {
		            $("#alertMessage").addClass("HideThisElement");
		            $("#SubmitButtonUpdate").removeClass("disabled");
		            $("#SubmitButtonUpdate").attr("disabled", false);
		            $("#SubmitButtonRegister").removeClass("disabled");
		            $("#SubmitButtonRegister").attr("disabled", false);
		        }
	        }
	    });
	});*/
	
	$("#SubmitButtonRegister").click(function() {
    	formSubmit("new"); 
    	return false;
    });
    
    $("#SubmitButtonUpdate").click(function() {
    	formSubmit("edit");
    	return false;
    });
    
    $("#SubmitButtonBack").click(function() {
	    $("#ClientTableDiv").removeClass("HideThisElement");
		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").addClass("HideThisElement");
    });
    
    $("#SubmitButtonBackFromView").click(function() {
	    $("#ClientTableDiv").removeClass("HideThisElement");
		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").addClass("HideThisElement");
    });
    
    $("#DeleteEmployeeConfirmed").click(function() {
        var DeleteEmpId = document.querySelector('#DeleteEmpId').value;
        $.ajax({
            type: "GET",
            url: '../../../ModifyEmployee?DeleteEmpId=' + DeleteEmpId,
            success: function(data) {
                if (data == 0) {
                    $('#centralModalDangerDemo').modal('hide');
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Employee!');
                } else {
                    $('#centralModalDangerDemo').modal('hide');
                    $('#selectedEmployeeId').val('');
                    $('#datatables').DataTable().ajax.reload();
                    $(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Employee Deleted Successfully!');
                }
            }
        })
        return false; // avoid to execute the actual submit of the form.
    });
});

function formSubmit(type){
	console.log(type);
	var url = "";
	if(type=="new"){
		url="../../../ModifyClient";
	}else{
		url="../../../ModifyClient";
	}	
	/*if (document.getElementById("firstName").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> First Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else if (document.getElementById("lastName").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Last Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("mobileno").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Contact Number is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("emailId").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Email ID is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("department").value ==  "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Department is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("designation").value ==  "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Designation is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("reportTo").value ==  "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Reporting Manager is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("UserId").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Unique User ID is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	}  else if (document.getElementById("location").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Location is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("birthDate").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Birthday Date is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("joinDate").value == "") {
		$("#alertMessage").css("display",''); 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Joining Date is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else {*/
		var data = "";
		if($("#action").val() != "insert")
		{
			if($("#action").val()=="insertContactPerson")
			{
				data = "&isDefault="+$("#isDefaultCP").is(":checked");
			}
			else if($("#action").val()=="insertAddress")
			{
				data = "&isDefault="+$("#isDefaultAdd").is(":checked");
			}
		}
		console.log($("#newElementForm").serialize());
    	$.ajax({
           type: "POST",
           url: url,
           data: $("#newElementForm").serialize()+data,
           success: function(data)
           {
               if (data == 1) {
            	   document.getElementById("newElementForm").reset();
					$("#alertMessage").addClass("HideThisElement");
					$("#errorMessage").addClass("HideThisElement");	
					if(type=="new"){
						document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Client Registered Successfully !";
						$("#successMessage").removeClass("HideThisElement");
					}else{
						document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Client Updated Successfully !";
						$("#successMessage").removeClass("HideThisElement");
					}
					$("#myTabContent").addClass("HideThisElement");		
					$("#SubmitButtonRegister").addClass("HideThisElement");
				    $("#SubmitButtonUpdate").addClass("HideThisElement");
				    $("#SubmitButtonBack").addClass("HideThisElement");	
					setTimeout(function(){
						$("#ClientTableDiv").removeClass("HideThisElement");
						$("#ClientFormDiv").addClass("HideThisElement");							
						$('#datatables').DataTable().ajax.reload();	
					 }, 3000);		
				} else{
					if(type=="new"){
						document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Failed to Register New Client !";
						$("#errorMessage").removeClass("HideThisElement");
					}else{
						document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Failed to Update New Client !";
						$("#errorMessage").removeClass("HideThisElement");
					}
				}
           }
    	});
//    }
    return false;
}