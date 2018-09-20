$(document).ready(function(){
	DropDownForEmployee('');
	DropDownForLegend();

    $('#ProductDatatables tbody').on( 'click', '.select_me_order', function () {
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
						  '<td style="text-align: center"><input type="number" value=1 style="width:50px;" id="ItemQty' + data.rowId + '" name="Qty" onkeyup="RateChangeFunc(this);"></td>' +
						  '<td style="text-align: center">'+data.availableStock+' ('+data.blocked+')</td>' +
						  '<td style="text-align: center"><input type="number" value=' + parseFloat(data.price).toFixed(2) + ' style="width:80px;" id="ItemRate' + data.rowId + '" name="rate" step="0.01" onkeyup="RateChangeFunc(this);"></td>' +
						  '<td style="text-align: center"><input type="number" value=0 style="width:50px;" id="ItemDiscount' + data.rowId + '" name="discount" min="0" max="100" onkeyup="RateChangeFunc(this);"></td>' +
						  '<td style="display:none;"><input type="hidden" id="tax' + data.rowId + '" name="tax" value="' + data.Igst + '"></td>' +
						  '<td style="display:none;"><input type="hidden" id="hsnId' + data.rowId + '" name="hsnId" value="' + data.hsnId + '"></td>' +
						  '</tr>';
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
		}
    });
	
	$("#SubmitButtonRegister").click(function() {
		if($("#selectedClientId").val() == "")
		{
			Swal("Please Select Client!");
		}
		else if($("#selectedClientContactPersonId").val() == "")
		{
			Swal("Please Select Contact Person!");
		}
		else if($("#selectedBillingAddressId").val() == "")
		{
			Swal("Please Select Billing Address!");
		}
		else if($("#selectedDeliveryAddressId").val() == "")
		{
			Swal("Please Select Delivery Address!");
		}
		else if($("#clientSalesPerson").val() == "")
		{
			Swal("Please Select Sales Person!");
		}
		else if($("#invoiceType").val() == "")
		{
			Swal("Please Select Invoice Type!");
		}
		else if($("#modeOfPayment").val() == "")
		{
			Swal("Please Select Mode Of Payment!");
		}
		else if($("#expectedDeliveryDate").val() == "")
		{
			Swal("Please Select Expected Delivery Date!");
		}
		else
		{
			$("#action").val('insertOrder');
	    	formSubmit(); 
		}
    	return false;
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
	var orderID = "O"+generator.generate();
	
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
			if(j==3)
			{
				var name = $($(row.cells[j]).html()).attr('name');
				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
			}
			if(j==4)
			{
				var name = $($(row.cells[j]).html()).attr('name');
				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
			}
			if(j==5)
			{
				var name = $($(row.cells[j]).html()).attr('name');
				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
			}
			if(j==6)
			{
				var name = $($(row.cells[j]).html()).attr('name');
				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
			}
			if(j==7)
			{
				var name = $($(row.cells[j]).html()).attr('name');
				formData+=name+"="+parseFloat($(row.cells[j].childNodes[0]).val())+"&";
				formData+="orderItemID=OI"+generator.generate()+"&orderItemstatus=951&";
			}
		}
		formData+="orderID="+orderID+"&orderStatus=941&modeOfPayment="+$("#modeOfPayment").val()+"&expectedDeliveryDate="
					+$("#expectedDeliveryDate").val()+"&invoiceType="+$("#invoiceType").val()+"&selectedClientId="+$("#selectedClientId").val()+
						"&selectedClientContactPersonId="+$("#selectedClientContactPersonId").val()+"&selectedBillingAddressId="+$("#selectedBillingAddressId").val()+
								"&selectedDeliveryAddressId="+$("#selectedDeliveryAddressId").val()+"&clientSalesPerson="+$("#clientSalesPerson").val()+"&action="+$("#action").val()+"&count="+count;
		console.log(formData);
		$.ajax({
            type: "POST",
            url: "../../../ModifyOrder",
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
	/*
	
	if($("#action").val() == "insert")
	{
	}
	else if($("#action").val() == "updateAccpStatus" || $("#action").val() == "updateDispatched" || $("#action").val() == "updateRecieved")
	{
		var requisitionID = $("#selectedRequisitioId").val();
	}
	
	if($("#action").val() == "insert" || $("#action").val() == "updateAccpStatus")
	{
	}
	else if($("#action").val() == "updateDispatched" || $("#action").val() == "updateRecieved")
	{
		if($("#action").val() == "updateDispatched")
		{
			var formData=$("#dispatchForm").serialize()+"&requisitionID="+requisitionID+"&requisitionLogID="+requisitionLogID+"&requitionstatus=203&action="+$("#action").val()+"&count="+count;
		}
		else if($("#action").val() == "updateRecieved")
		{
			var formData="requisitionID="+requisitionID+"&requisitionLogID="+requisitionLogID+"&requitionstatus=204" +
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
			$("#action").val("updateAccpStatus");
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
			$('#datatables').DataTable().ajax.reload();
		}
	}
	else
		alert("Failed");*/
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