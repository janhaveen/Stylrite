$(document).ready(function(){
	if($("#for").val() == "newSample")
	{
		$("#action").val("insert");
		DropDownForInventoryLegend();
		$("#SampleFormProductListDiv").removeClass("HideThisElement");
		$("#SampleFormDiv").removeClass("HideThisElement");
		$("#SampleTableDiv").addClass("HideThisElement");
		$("#ProductTableDiv").removeClass("HideThisElement");
		$("#submitBtnDiv").removeClass("HideThisElement");
		$("#updateBtnDiv").addClass("HideThisElement");
		$("#SampleFormDispatchDiv").addClass("HideThisElement");
	}
	else if($("#for").val() == "sampleListInvtAccp")
	{
		$("#action").val("updateAccpStatus");
		$("#SampleFormProductListDiv").addClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
		$("#submitBtnDiv").addClass("HideThisElement");
		$("#updateBtnDiv").removeClass("HideThisElement");
		$("#SampleFormDispatchDiv").addClass("HideThisElement");
	}
	else if($("#for").val() == "sampleListDispatched")
	{
		$("#action").val("updateDispatched");
		$("#SampleFormProductListDiv").addClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
		$("#submitBtnDiv").addClass("HideThisElement");
		$("#updateBtnDiv").addClass("HideThisElement");
		$("#SampleFormDispatchDiv").addClass("HideThisElement");
	}
	else if($("#for").val() == "sampleListRdyToRcv")
	{
		$("#action").val("updateRecieved");
		$("#SampleFormProductListDiv").addClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
		$("#submitBtnDiv").addClass("HideThisElement");
		$("#updateBtnDiv").addClass("HideThisElement");
		$("#SampleFormDispatchDiv").addClass("HideThisElement");
	}
	else if($("#for").val() == "sampleListView")
	{
//		$("#action").val("updateRecieved");
		$("#SampleFormProductListDiv").addClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
		$("#submitBtnDiv").addClass("HideThisElement");
		$("#updateBtnDiv").addClass("HideThisElement");
		$("#SampleFormDispatchDiv").addClass("HideThisElement");
	}
	

	$("#CommentsDetails-tab").click(function() {
		getCommentsHistory($("#selectedRequisitioId").val(), 0, 1);
    });
	
//	$("#ProductDatatables .dt-button").addClass("HideThisElement");
    /*$("#source").change(function () {
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
    });*/
    
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
		if($("#reason").val() == "")
		{
			Swal("Please Select Reason!");
		}
		else if($("#expectedReceiptDate").val() == "")
		{
			Swal("Please Select Expected Receipt Date!");
		}
		else if($("#modeOfTransport").val() == "")
		{
			Swal("Please Select Mode of Transport!");
		}
		else
		{
	    	formSubmit(); 
		}
    	return false;
    });
	
	/*$("#alertMessage #alertConfirmBtn").click(function() {
    	formSubmit();
	});*/
	
	$("#SubmitButtonRegisterComments").click(function() {
		var generator = new IDGenerator();
		$.ajax({
			url:"../../../UpdateRequisitionComments",
			data:{action: "322",remarks: $("#newcomments").val(),requisitionLogID: "RL"+generator.generate(),requisitionID : $("#selectedRequisitioId").val()},
			type:"POST",
			success:function(data){
				$("#newcomments").val('');
//				$("#commDiv").addClass("HideThisElement");
				getCommentsHistory($("#selectedRequisitioId").val(),0,1);
			}
		});
	});
	
	$("#UpdateDispatchButton").click(function() {
		if($("#dispatchedDate").val() == "")
		{
			Swal("Please Select Dispatched Date!");
		}
		else
		{
	    	formSubmit(); 
		}
    	return false;
    });
	
	$("#UpdateReceiveButton").click(function() {
		if($("#sampleReceiptDate").val() == "")
		{
			Swal("Please Select Receipt Date!");
		}
		else
		{
	    	formSubmit(); 
		}
    	return false;
    });
	
    $("#SubmitButtonUpdate").click(function() {
    	var table1 = document.getElementById('ProductDataBody');
    	var rowCount = table1.rows.length;
    	var confirmed = false;
    	
    	if($("#action").val() == "updateAccpStatus")
    	{
    		for (var i = 0; i < rowCount; i++)
    		{
    			var row = table1.rows[i];
    			for(var j=0; j<$(row.cells).length; j++)
    			{
        			if(j==0)
        			{
        				var ProductId=$($(row.cells[j])[0].innerHTML).attr('name');
        				if($('#'+ProductId).is(':checked'))
        					confirmed = true;
        				else
        					confirmed = false;
        					break;
        			}
    			}
    		}
    	}
    	
    	if(confirmed == false)
    	{
    		//SwalConfrm("Some Items are not selected, do you want to proceed?");
    		swal({
    			  title: "Are you sure?",
    			  text: "Some Items are not selected, do you want to proceed?",
    			  type: "warning",
    			  showCancelButton: true,
    			  confirmButtonClass: "btn-danger",
    			  confirmButtonText: "Yes!",
    			  closeOnConfirm: false
    			},
    			function(isConfirm) {
				  if (isConfirm) {
				    swal("Deleted!", "Your imaginary file has been deleted.", "success");
				  } else {
				    swal("Cancelled", "Your imaginary file is safe :)", "error");
				  }
				});
    	}
    	else
    	{
        	formSubmit();
    	}
    	return false;
    });
    
    $("#alertCloseBtn").click(function() {
		$("#SampleFormProductListDiv #alertMessage").addClass("HideThisElement");
    });
    
    $("#BackButtonUpdate").click(function() {
		$("#action").val("update");
		$("#SampleFormProductListDiv").addClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
		$("#SampleViewDiv").addClass("HideThisElement");
    });
    
    /*$("#BackButtonSubmit").click(function() {
		$("#action").val("update");
		$("#SampleFormProductListDiv").addClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#SampleTableDiv").removeClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
		$("#SampleViewDiv").addClass("HideThisElement");
    });*/
    
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

    $('#ProductDatatables tbody').on( 'click', '.select_me_sample', function () {
		var generator = new IDGenerator();
    	var data = $('#ProductDatatables').DataTable().row($(this).parents('tr')).data();
    	var table1 = document.getElementById('ProductDataBody');
    	var rowCount = table1.rows.length;
    	var idExists = false;
    	for(var i=0; i<rowCount; i++) {
    		var row = table1.rows[i];
    		var a = $(row.cells[0]).html();
    		var idToCheck= $(a).attr('id');
        	if (idToCheck == data.rowId) {
    			idExists = true;
    			break;
    		}
    	}
    	/*console.log(idExists);*/
    	if (idExists) {
    		 $(".errorMsg").removeClass("HideThisElement");
             $("#errorMsg").html(' <strong>Error!</strong> Product Already Exists !');
		} else { console.log("dsd");
			var newHtml = '<tr id="productIdRow">'+
						  '<td><input type="checkbox" id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
						  '<td>'+data.skuid+'</td>'+
						  '<td>'+data.productInfo+'</td>'+
						  '</tr>';
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
		}
    });

    $("#DeleteProduct").click(function() {
        try {
            var table = document.getElementById('ProductDataBody');
            var rowCount = table.rows.length;
            for (var i = 0; i < rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];

                if (null != chkbox && true == chkbox.checked) {
                    table.deleteRow(i);
                    //        			calculateAmountPayable();
                    rowCount--;
                    i--;
                }
            }
        } catch (e) {
            alert(e);
        }
        return false;
    });
});

function formSubmit()
{
	var generator = new IDGenerator();
	var returnVal=false;
	var count = 1;
	var requisitionLogID = "RL"+generator.generate();
	
	if($("#action").val() == "insert")
	{
		var requisitionID = "R"+generator.generate();
	}
	else/* if($("#action").val() == "updateAccpStatus" || $("#action").val() == "updateDispatched" || $("#action").val() == "updateRecieved")*/
	{
		var requisitionID = $("#selectedRequisitioId").val();
	}
	
	if($("#action").val() == "insert" || $("#action").val() == "updateAccpStatus")
	{
		var table1 = document.getElementById('ProductDataBody');
		var rowCount = table1.rows.length;
		for (var i = 0; i < rowCount; i++)
		{
			var row = table1.rows[i]; 
			var formData="";
			for(var j=0; j<$(row.cells).length; j++)
			{
				if(j==0)
				{
					var ProductId=$($(row.cells[j])[0].innerHTML).attr('name');
					formData+="ProductId="+ProductId+"&";
				}
				if($("#action").val() == "insert")
				{
					if(j==2)
					{
						formData+="requisitionType=131&requisitionItemID=RI"+generator.generate()+"&requitionstatus=201&requitionItemstatus=211&remarks="+$("#remarks").val()+"&";
					}
				}
				else if($("#action").val() == "updateAccpStatus")
				{
					if(j==0)
					{
						var ProductId=$($(row.cells[j])[0].innerHTML).attr('name');
						if($('#'+ProductId).is(':checked'))
							formData+="requitionItemstatus=212&";
						else
							formData+="requitionItemstatus=213&";
					}
					if(j==4)
					{
						formData+="requisitionItemID="+$($(row.cells[j])).html()+"&requitionstatus=202&remarks="+$("#updateRemarks").val()+"&";
					}
				}
			}
			formData+="requisitionID="+requisitionID+"&requitionAction=321&requisitionLogID="+requisitionLogID+"&reason="+$("#reason").val()+"&modeOfTransport="+$("#modeOfTransport").val()+"&expectedReceiptDate="
			+$("#expectedReceiptDate").val()+"&remarks="+$("#remarks").val()+"&action="+$("#action").val()+"&count="+count;
			console.log(formData);
			$.ajax({
	            type: "POST",
	            url: "../../../ModifyRequisition",
	            data: formData, 
	            async:false,
	            success: function(data)
		        {
	            	if(data!="0")
	            		returnVal=true;
		     	   else
		     		  returnVal=false
	            }
	    	});
			count++;
		}
	}
	else/* if($("#action").val() == "updateDispatched" || $("#action").val() == "updateRecieved")*/
	{
		if($("#action").val() == "updateDispatched")
		{
			var formData=$("#dispatchForm").serialize()+"&requisitionID="+requisitionID+"&requisitionLogID="+requisitionLogID+"&requitionAction=321&requitionstatus=203&action="+$("#action").val()+"&count="+count;
		}
		else if($("#action").val() == "updateRecieved")
		{
			var formData="requisitionID="+requisitionID+"&requitionAction=321&requisitionLogID="+requisitionLogID+"&requitionstatus=204" +
					"&receiptDate="+$("#sampleReceiptDate").val()+"&remarks="+$("#receivedRemarks").val()+
							"&action="+$("#action").val()+"&count="+count;
		}
		console.log(formData);
		$.ajax({
            type: "POST",
            url: "../../../ModifyRequisition",
            data: formData,
            async:false,
            success: function(data)
	        {
            	if(data!="0")
            		returnVal=true;
	     	   else
	     		  returnVal=false
            }
    	});
	}
	if(returnVal)
	{
//		alert("vsgh");
		if($("#for").val() == "newSample" || $("#for").val() == "sampleListRdyToRcv")
		{
			window.location.href = "Sample.jsp?for=sampleListView";
		}
		else if($("#for").val() == "sampleListInvtAccp" || $("#for").val() == "sampleListDispatched")
		{
			location.reload();
			/*$("#action").val("updateAccpStatus");
			$("#SampleFormProductListDiv").addClass("HideThisElement");
			$("#SampleFormDiv").addClass("HideThisElement");
			$("#SampleTableDiv").removeClass("HideThisElement");
			$("#ProductTableDiv").addClass("HideThisElement");
			$("#SampleFormProductListDiv").addClass("HideThisElement");
			$("#SampleViewDiv").addClass("HideThisElement");
			$("#SampleFormDiv").removeClass("HideThisElement");
			$("#SampleTableDiv").removeClass("HideThisElement");
			$("#ProductTableDiv").removeClass("HideThisElement");
		    document.querySelector('#ProductDataBody').value = "";
			$("#DeleteProduct").removeClass("HideThisElement");
			$("#SubmitButtonRegister").removeClass("HideThisElement");
			$("#SubmitButtonUpdate").addClass("HideThisElement");
			$("#SubmitButtonBack").addClass("HideThisElement");
			$("#SampleFormProductListDiv").addClass("HideThisElement");
			$("#updateBtnDiv").addClass("HideThisElement");
			$("#SampleFormDispatchDiv").removeClass("HideThisElement");
			$("#submitBtnDiv").removeClass("HideThisElement");
			$('#datatables').DataTable().ajax.reload();*/
		}
	}
	else
		alert("Failed");
}

function Swal(msg)
{
	swal({
		  text: msg,
		  type: "warning",
		  confirmButtonText: "Ok!",
		  closeOnConfirm: false
		});
}

function getCommentsHistory(rowId, start, isRefresh, e) {
	$.ajax({
		url:"../../../GetRequisitionRemarksHistory?requisitionId="+rowId+"&action=322&start="+start+"&limit=5",
		type:"GET",
		success:function(data){
			if(e)	e.preventDefault();
			if(data!=0)
			{
				var str="";
				$('#lm').html('');
				if(isRefresh==1){$('#commentsDiv').html(''); $('#lm').html('');}
				document.querySelector('#commentsDiv').insertAdjacentHTML('beforeend', data);
				//$('#remarksDiv').append(data);
				str="<div id='lm'><a href='#' onclick='getCommentsHistory(\""+rowId+"\", "+(parseInt(start)+5)+",0, "+$(this).event+");'>Load More . . .</a></div>";
				document.querySelector('#commentsDiv').insertAdjacentHTML('beforeend', str);
				$(document).scrollTop($(document).height());
				if($('#commentsDiv .card:first').length>0)
				{
			        var firstMsg = $('#commentsDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#commentsDiv .card').eq(5).clone());
			        firstMsg.before($('#commentsDiv .card').eq(5).clone());
			        firstMsg.before($('#commentsDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}
			}
			else if(data==0)
			{ 
				$('#lm').html('');
				$(document).scrollTop($(document).height());
				if($('#commentsDiv .card:first').length>0)
				{
			        var firstMsg = $('#commentsDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#commentsDiv .card').eq(5).clone());
			        firstMsg.before($('#commentsDiv .card').eq(5).clone());
			        firstMsg.before($('#commentsDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				 }
			 }
		}
	});
}

function SwalConfrm(msg)
{
	swal({
	  title: "Are you sure?",
	  text: msg,
	  type: "warning",
	  showCancelButton: true,
	  confirmButtonClass: "btn-danger",
	  confirmButtonText: "Yes!",
	  closeOnConfirm: false
	},
	function(isConfirm){ console.log(isConfirm);
	  /*if (isConfirm) {
		    swal("Deleted!", "Your imaginary file has been deleted.", "success");
		console.log("Hi btn");
	  }*/
//    	formSubmit();
	});
}