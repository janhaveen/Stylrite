$(document).ready(function(){
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
    });
    
	$('#newElementForm').on('focusout', '#mobileno', function() {
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

    $('#datatables tbody').on( 'click', '.select_me', function () {
		var generator = new IDGenerator();
		
        $("#StockListDiv").removeClass("HideThisElement");
        $("#OrderTableDiv").addClass("HideThisElement");
        
    	var dataTbl = $('#datatables').DataTable().row($(this).parents('tr')).data();
    	
		$.ajax({
            type: "GET",
            url: "../../../GetOrderList?for=StockOutItem&orderId="+dataTbl.orderId,
            success: function(data)
	        {
            	console.log(data);
            	var table1 = document.getElementById('OrderItemDataBody');
            	var rowCount = table1.rows.length;

                for (i = 0; i < data.data.length; i++)
                {
                	var maxQty = 0;
                	if(parseInt(data.data[i].availableStock)>parseInt(data.data[i].quantity))
                	{
                		console.log("In If");
                		maxQty = parseInt(data.data[i].quantity);
                	}
                	else
                	{
                		console.log("In Else");
                		maxQty = parseInt(data.data[i].availableStock);
                	}
        			var newHtml = '<tr id="productIdRow">'+
					  /*'<td><input type="checkbox" id="'+data.data[i].rowId+'" name="' + data.data[i].rowId + '"><label for="'+data.data[i].rowId+'"></label></td>'+*/
					  '<td>'+data.data[i].productInfo+'</td>'+
					  '<td>'+data.data[i].quantity+'</td>'+
					  '<td>'+data.data[i].quantity+'</td>'+
					  '<td>'+data.data[i].availableStock+'</td>'+
					  '<td style="text-align: center"><input type="number" value=0 style="width:50px;" id="qty' + data.data[i].rowId + '" name="qty" min="0" max="'+maxQty+'"></td>' +
					  '</tr>';
        			document.querySelector('#OrderItemDataBody').insertAdjacentHTML('beforeend', newHtml);
                }
            }
    	});
    });
	
	$("#SubmitButtonRegister").click(function() {
    	formSubmit("out"); 
    	return false;
    });
	
	$("#rejectBtn").click(function() {
    	formSubmit("reject"); 
    	return false;
    });
    
	/*$("#SubmitButtonUpdate").click(function() {
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
    });*/
});

function formSubmit(type){
	var generator = new IDGenerator();
	var returnVal=false;
	var count = 1;
	var callServlet = false;
	
	var table1 = document.getElementById('OrderItemDataBody');
	var rowCount = table1.rows.length;
	
	for (var i = 0; i < rowCount; i++)
	{
		var row = table1.rows[i];
		var formData="";
		for(var j=0; j<$(row.cells).length; j++)
		{
			if(parseInt($(row.cells[4].childNodes[0]).val()) != 0 && type == "out")
			{
				if(j==4)
				{
					var name = $($(row.cells[j]).html()).attr('name');
					var id = $($(row.cells[j]).html()).attr('id');
					formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&orderItemId="+id.substring(3)+"&";
					callServlet = true;
				}
			}
			else if(type == "reject")
			{
				if(j==2)
				{
					formData+="qty="+$(row.cells[j]).html()+"&";
				}
				else if(j==4)
				{
					var id = $($(row.cells[j]).html()).attr('id');
					formData+="orderItemId="+id.substring(3)+"&";
				}
				callServlet = true;
			}
		}
		if(callServlet)
		{
			if(type == "out")
			{
				formData+="status=942";
			}
			else if(type == "reject")
			{
				formData+="status=943";
			}
			console.log(formData);
			$.ajax({
	            type: "POST",
	            url: "../../../ModifyStock",
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
}