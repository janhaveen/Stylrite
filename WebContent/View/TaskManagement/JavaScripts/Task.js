$(document).ready(function() {
	
	getTaskCards('cmp');getTaskCards('ip');getTaskCards('td');
	dropdownFunctionForTaskLegend();
	getAssignedToEmpDropDown();
	
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
    	getTaskCards('cmp');getTaskCards('ip');getTaskCards('td');
	    $("#TaskTableDiv").removeClass("HideThisElement");
		$("#TaskViewDiv").addClass("HideThisElement");
		$("#TaskFormDiv").addClass("HideThisElement");
    });    
    
    $("#AddComment").click(function() {
		$("#commDiv").removeClass("HideThisElement");
	});
	
	$("#SubmitButtonRegisterComments").click(function() {
		$.ajax({
			url:"../../../UpdateTaskComments",
			data:{TaskId:$("#TaskId").val(),comments: $("#newcomments").val()},
			type:"POST",
			success:function(data){
				$("#newcomments").val('');
				$("#commDiv").addClass("HideThisElement");
				getCommentsHistory($("#TaskId").val(),0,1);
			}
		});
	});
	
	$("#DeleteConfirmed").click(function() {
        var DeleteId = document.querySelector('#DeleteId').value;
        $.ajax({
            type: "GET",
            url: '../../../ModifyTask?id=' + DeleteId,
            success: function(data) {
                if (data == 0) {
                    $('#centralModalDangerDemo').modal('hide');
                    $(".successMsg").addClass("HideThisElement");
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Task!');
                } else {
                    $('#centralModalDangerDemo').modal('hide');
                    $('#DeleteId').val('');
                    getTaskCards('cmp');getTaskCards('ip');getTaskCards('td');
                    $(".errorMsg").addClass("HideThisElement");
                    $(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Task Deleted Successfully!');
                }
            }
        })
        return false; // avoid to execute the actual submit of the form.
    });
	
});

function formSubmit(){ 
	var type=$("#TaskForm #action").val();
	console.log(type);	
	if (document.getElementById("taskName").value == "") { 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Task Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else {
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
						if(type=="insert"){
							document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Task Registered Successfully !";
							$("#successMessage").removeClass("HideThisElement");
						}else{
							document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Task Updated Successfully !";
							$("#successMessage").removeClass("HideThisElement");
						}
						setTimeout(function(){
							$("#TaskTableDiv").removeClass("HideThisElement");
							$("#TaskFormDiv").addClass("HideThisElement");							
							//$('#datatables').DataTable().ajax.reload();	
							getTaskCards('cmp');getTaskCards('ip');getTaskCards('td');
						 }, 3000);		
					} else{
						if(type=="insert"){
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
					//$("#O1").css('padding-left','20%');				
				}
			});
		}
	});
}

function getTaskCards(type) {
	var url="";
	if($("#ProjectId").val()!="null")
		url+="&ProjectId="+$("#ProjectId").val();
	if($("#v").val()!="null")
		url+="&viewOnly="+$("#v").val();
	$.ajax({
		url:"../../../GetTaskCards?1=1"+url,
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

function getAssignedToEmpDropDown() {
	$.ajax({
		url:"../../../GetEmployeeList",
		type:"GET",
		success:function(Data){
			var options1;
	    	$('#AssignedTo').empty();
	        options1 = '<option value="" selected>Select Assigned To</option>';
	        for (var i = 0; i < Data.data.length; i++) {
	        	 options1 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].empname + "</option>";
			}
	        $('#AssignedTo').html(options1);
		}
	});
}

function EditTask(id) {
	$.ajax({
		url:"../../../GetTaskList?TaskId="+id,
		type:"GET",
		success:function(Data){
			var data=Data.data[0];
			$("#TaskNameId").text(data.taskName); 
			$("#StartDateText").text(data.startDate);	$("#EndDateText").text(data.endDate);
			$("#AssignedToText").text(data.assignedTo_txt);	$("#VisibilityText").text(data.visibility_txt);
			$("#VisibilityToText").text(data.visibleTo_txt);
			$("#PriorityText").text(data.priority_txt);	$("#StatusText").text(data.status_txt);
			$("#TaskDescriptionText").html(data.description);
			$('#remarksDiv').html('');
			$("#TaskForm #action").val("updat");
			$("#TaskId").val(data.TaskId); 
			$("#taskNameOld").val(data.taskName);  $("#taskName").val(data.taskName); 
			$("#StartDateOld").val(data.startDate); $("#StartDate").val(data.startDate);
			$("#EndDateOld").val(data.endDateToShow);		$("#EndDate").val(data.endDateToShow);
			$('#AssignedToCmpOld').val(data.assignedToCmp);	$('#AssignedToCmp').val(data.assignedToCmp);
			//getAssignedToEmpDropDown();
			$("#AssignedToOld").val(data.assignedTo);	$("#AssignedTo").val(data.assignedTo);	
			$("#VisibilityOld").val(data.visibility);	$("#Visibility").val(data.visibility);
			$("#VisibilityToOld").val(data.visibleTo); 	$("#VisibilityTo").val(data.visibleTo);
			$("#PriorityOld").val(data.priority);	$("#Priority").val(data.priority);
			$("#StatusOld").val(data.status); 	$("#Status").val(data.status);
			$("#taskDescriptionOld").val(data.description); $("#taskDescription").val(data.description);
			$("#TaskForm .nicEdit-main").html(data.description);
			getCommentsHistory(data.TaskId, 0, 1);
			
			$("#statusDivView").html(data.StatusBtn);
			//$("#O1").css('padding-left','20%');		
			
		    $("#TaskTableDiv").addClass("HideThisElement");
			$("#TaskViewDiv").removeClass("HideThisElement");
			$("#TaskFormDiv").addClass("HideThisElement");
		}
	});
}

function DeleteTask(id) {
	document.querySelector('#DeleteId').value = id;
	$('#centralModalDangerDemo').modal('show');
}
