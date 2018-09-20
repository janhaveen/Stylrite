$(document).ready(function() {
	
	getTaskCards('cmp');getTaskCards('ip');getTaskCards('td');
	
	$('#AddReminder').click(function() {
		if ($("#AddReminder").is(':checked'))
		    	$("#ReminderDiv").removeClass('HideThisElement');
		else
			$("#ReminderDiv").addClass('HideThisElement');
	});
	
	$("#SubmitButtonRegister").click(function() {
    	formSubmit(); 
    });
    
    $("#SubmitButtonUpdate").click(function() {
    	formSubmit();
    });
    
    $("#SubmitButtonBack").click(function() {
	    $("#TaskTableDiv").removeClass("HideThisElement");
		$("#TaskViewDiv").addClass("HideThisElement");
		$("#TaskFormDiv").addClass("HideThisElement");
    });
    
    $("#SubmitButtonBackFromView").click(function() {
	    $("#TaskTableDiv").removeClass("HideThisElement");
		$("#TaskViewDiv").addClass("HideThisElement");
		$("#TaskFormDiv").addClass("HideThisElement");
    });    
    
    $("#AddComment").click(function() {
		$("#commDiv").removeClass("HideThisElement");
	});
	
	$("#SubmitButtonRegisterComments").click(function() {
		$.ajax({
			url:"../../../UpdateComments",
			data:{TaskId:$("#TaskId").val(),comments: $("#newcomments").val()},
			type:"POST",
			success:function(data){
				$("#newcomments").val('');
				$("#commDiv").addClass("HideThisElement");
				getCommentsHistory($("#TaskId").val(),0,1);
			}
		});
	});
	
});

function formSubmit(type){ console.log(type);	
	if (document.getElementById("taskName").value == "") { 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Task Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else if (document.getElementById("StartDate").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Start Date is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("EndDate").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> End Date is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("AssignedTo").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Assigned To is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("Visibility").value ==  "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Visibility is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("VisibilityTo").value ==  "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Visibile To is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("Status").value ==  "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Status is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	}else {
	
		$.ajax({
	           type: "POST",
	           url: "../../../ModifyTask",
	           data: $("#TaskForm").serialize(), // serializes the form's elements.
	           success: function(data)
	           {
	               if (data == 1) {
	            	   document.getElementById("TaskForm").reset();
						$("#alertMessage").addClass("HideThisElement");
						$("#errorMessage").addClass("HideThisElement");	
						if(type=="new"){
							document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Task Registered Successfully !";
							$("#successMessage").removeClass("HideThisElement");
						}else{
							document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Task Updated Successfully !";
							$("#successMessage").removeClass("HideThisElement");
						}
						setTimeout(function(){
							$("#TaskTableDiv").removeClass("HideThisElement");
							$("#TaskFormDiv").addClass("HideThisElement");							
							$('#datatables').DataTable().ajax.reload();	
						 }, 3000);		
					} else{
						if(type=="new"){
							document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Failed to Register New Task !";
							$("#errorMessage").removeClass("HideThisElement");
						}else{
							document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Failed to Update Task !";
							$("#errorMessage").removeClass("HideThisElement");
						}
					}
	           }
		});
	}
	return false; // avoid to execute the actual submit of the form.
}

function updateStatus(id, statusOld, status) {
	var statusPOA="";
	/*if(status=="100001"){
		statusPOA="100002";
	}else if(status=="100002"){
		statusPOA="100005";
	}*/
	$.ajax({
		url:"../../../UpdateStatusForTask",
		data:{TaskId:id, StatusOld: statusOld,Status:status},
		type:"POST",
		success:function(data){
			$.ajax({
				url:"../../../GetTaskList?TaskId="+id,
				type:"GET",
				success:function(data){
					$("#statusDivView").html(data.data[0].StatusBtn);
					$("#O1").css('padding-left','20%');				
				}
			});
		}
	});
}

function getTaskCards(type) {
	$.ajax({
		url:"../../../GetTaskCards",
		data:{status:type},
		type:"GET",
		success:function(data){
			if(type=="td"){
				$("#todo").html('');
				document.querySelector('#todo').insertAdjacentHTML('beforeend', data);
			}
			if(type=="cmp"){
				$("#done").html('');
				document.querySelector('#done').insertAdjacentHTML('beforeend', data);
			}
			if(type=="ip"){
				$("#inProgress").html('');
				document.querySelector('#inProgress').insertAdjacentHTML('beforeend', data);
			}
		}
	});
}