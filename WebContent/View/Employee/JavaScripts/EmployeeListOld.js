/*
 For DataTable
 	
 
 Created By : Aditya
 Designation : Analyst (IT)
 Organization : Effex Business Solutions Pvt Ltd
 Date : 04 Jul 2017
 Version : 1.0
 */

$(document).ready(function(){
	$("#HomeText").text("Employee List");
	validationData();
	report();
	var myString;
	function validationData() {
	$.ajax({
        type: "GET",
        url: "../../../GetEmployeeList",
        success: function(data)
        {
			myString = data;
        }
    });
	}
	// for DataTable
	dropdownFunction();DropDownForBranch();
	// Setup - add a text input to each footer cell
    
	
    
    
    
    
    //for validating the mobile number 
    
    
    /*$('#RegisterNew').on( 'focusout', '#emailId', function () {
    	var email=document.querySelector('#emailId').value;
    	var selectedEmployeeId=document.querySelector('#selectedEmployeeId').value;
    	for(var i=0;i<myString.data.length;i++)
    	{
    		if(email==myString.data[i].emailId)
    		{
    			if(selectedEmployeeId != myString.data[i].employeeId || selectedEmployeeId == "")
				{
	    			document.querySelector('#alertMessage').innerHTML = "<strong>Duplicate!</strong> The Email Id You Entered Is Already In Use By "+myString.data[i].employeeName+" !";
	        		$("#alertMessage").removeClass("HideThisElement");
	        		$("#SubmitButtonUpdate").addClass("disabled");
	        		$("#SubmitButtonUpdate").attr("disabled",true);
	        		$("#SubmitButtonRegister").addClass("disabled");
	        		$("#SubmitButtonRegister").attr("disabled",true);
        		break;
				}
    		}
    		else
			{
    			$("#alertMessage").addClass("HideThisElement");
				$("#SubmitButtonUpdate").removeClass("disabled");
				$("#SubmitButtonUpdate").attr("disabled",false);
        		$("#SubmitButtonRegister").removeClass("disabled");
        		$("#SubmitButtonRegister").attr("disabled",false);
			}
    	}
    });*/
    
    
    

    // For Drop Downs
    
   
    function report() {
    	var ourRequest4 = new XMLHttpRequest();
        var data4 = [];
        ourRequest4.open('GET', '../../../GetManagerList');
        ourRequest4.onload = function() {
          if (ourRequest4.status >= 200 && ourRequest4.status < 400) {
        	data4 = JSON.parse(ourRequest4.responseText);
            createHTML4(data4);
          } else {
            console.log("We connected to the server, but it returned an error.");
          }
        };

        ourRequest4.onerror = function() {
          console.log("Connection error");
        };

        ourRequest4.send();

        function createHTML4(Data) {
        	var options1;
        	$('#reportTo').empty();
            options1 = '<option value="" selected>Select Manager</option>'
            for (i = 0; i < Data.data.length; i++)
            {
//            	if (Data.data[i].status == 201 ) {
            		options1 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
//        		}
            }
             $('#reportTo').html(options1);
             $('#reportTo').material_select('refresh');
            }
	}
    

    
    
    
    $("#SubmitButtonRegister").click(function() {
    	formSubmit("new"); 
    	return false;
    });
    
    $("#SubmitButtonUpdate").click(function() {
    	formSubmit("edit");
    	return false;
    });
    
    function formSubmit(type){ console.log(type);
    	var url = "";
    	if(type=="new"){
			var generator = new IDGenerator();
			var pid= generator.generate();
    		url="../../../ModifyEmployee?action=insert&selectedEmployeeId="+pid+"&statuscheckbox=1";
    	}else{
    		url="../../../ModifyEmployee?action=update";
    	}	
    	if (document.getElementById("firstName").value == "") { 
    		$("#alertMessage").css("display",''); 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> First Name is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement"); 
		} else if (document.getElementById("lastName").value == "") {
			$("#alertMessage").css("display",''); 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Last Name is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("mobileno").value == "") {
			$("#alertMessage").css("display",''); 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Contact Number is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("branch").value == "") {
			$("#alertMessage").css("display",''); 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Branch is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("department").value ==  "") {
			$("#alertMessage").css("display",''); 
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Department is not selected !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("designation").value ==  "") {
			$("#alertMessage").css("display",''); 
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Designation is not selected !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("reportTo").value ==  "") {
			$("#alertMessage").css("display",''); 
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Reporting Manager is not selected !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("UserId").value == "") {
			$("#alertMessage").css("display",''); 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Unique User ID is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("emailId").value == "") {
			$("#alertMessage").css("display",''); 
			document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Email ID is mandatory !";
			$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("location").value == "") {
			$("#alertMessage").css("display",''); 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Location is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("birthDate").value == "") {
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Birthday Date is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement");
		} else if (document.getElementById("joinDate").value == "") {
			$("#alertMessage").css("display",''); 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Joining Date is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement");
		} else {

	    	$.ajax({
	               type: "POST",
	               url: url,
	               data: $("#newElementForm").serialize(), // serializes the form's elements.
	               success: function(data)
	               {
	                   if (data == 1) {
	                	   document.getElementById("newElementForm").reset();
							$("#alertMessage").addClass("HideThisElement");
							$("#errorMessage").addClass("HideThisElement");
							$('#RegisterNew').modal('hide');
							$('#datatables').DataTable().ajax.reload();				
							if(type=="new")
								toastr.success('New Employee Registered Successfully!');
							else
								toastr.success('Employee Details Updated Successfully!');
						} else{
							if(type=="new")
								toastr.error('Failed to Register New Employee!');
							else
								toastr.error('Failed to Update New Employee!');
						}
	               }
	    	});
	    }
        return false; // avoid to execute the actual submit of the form.
    }
	
    function loadBlankform() {
    	document.getElementById("newElementForm").reset();
    	$("#SubmitButtonRegister").removeClass("HideThisElement");
    	$("#SubmitButtonUpdate").addClass("HideThisElement");
    	$("#statuscheckbox").attr("disabled",true);
    	$("#alertMessage").addClass("HideThisElement");
    	$("#errorMessage").addClass("HideThisElement");
    	$('.mdb-select').material_select('destroy');
    	$('.mdb-select').material_select();
    	document.querySelector('#NewElement-modal-title').innerHTML = 'New Employee Details';
    	$('#RegisterNew').modal('show');
    }
    
    
    
    
    
});