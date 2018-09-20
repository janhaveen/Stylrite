$(document).ready(function(){
	$('#datatables').DataTable().destroy();
	
	$('#datatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
    $("#datatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var strAction = "";
	if($("#for").val() == "newSample" || $("#for").val() == "sampleListInvtAccp" || $("#for").val() == "sampleListDispatched" || $("#for").val() == "sampleListRdyToRcv")
	{
		strAction = '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '
	}
	else if($("#for").val() == "sampleListView")
	{
		strAction = '<i class="view_me fa fa-eye fa-2x" aria-hidden="true"></i> '
	}
    
	var table = $('#datatables').DataTable({
        buttons: [
            {
                text: 'New Client',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetRequisitionList?list="+$("#for").val(),
		"columns": [
        	 {
             	className: "center",
                 defaultContent: strAction
             },
            { "data": "formattedOrderCreatedOn" },
            { "data": "reason_text" },
            { "data": "EmpName" },
            { "data": "formattedExpectedReceiptDate" },
            { "data": "count" },
            { "data": "rqtnStatus_text" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#datatables tbody').on('click', '.select_me', function() {
		var data = table.row($(this).parents('tr')).data();
		$("#SampleFormProductListDiv").removeClass("HideThisElement");
		$("#SampleViewDiv").removeClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").addClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
	    document.querySelector('#ProductDataBody').value = "";
		$("#DeleteProduct").addClass("HideThisElement");
		$("#SubmitButtonRegister").addClass("HideThisElement");
		$("#SubmitButtonUpdate").removeClass("HideThisElement");
		$("#SubmitButtonBack").removeClass("HideThisElement");
		$("#SampleFormProductListDiv").removeClass("HideThisElement");
		
		$("#selectedRequisitioId").val(data.requisitionId);
		$("#ReasonText").text(data.reason_text);
		$("#expectedReceiptDateText").text(data.formattedExpectedReceiptDate);
		$("#dispatchedDateText").text(data.formattedDispatchedDateDate);
		$("#modeOfDeliveryText").text(data.modeofDelivery_text);
		$("#dispatchedDateText").text(data.formattedDispatchedDate);
		$("#transportNameText").text(data.transportName);
		$("#trackingIDText").text(data.trackingID);
		$("#eBillNoText").text(data.eBillNo);
		$("#receiptDateText").val(data.formattedReceiptDate);
		
		$("#remarksDiv").html("");
		getRemarksHistory(data.requisitionId,0,1);
		getProducts(data.requisitionId);
	    /*document.getElementById("newElementForm").reset();
		$("#sourceText").text(data.source_text);
		$("#creditTimeText").text(data.creditTime);
		$("#creditLimitText").text(data.creditLimit);
		$("#salesPersonText").text(data.contactPerson);

	    $("#ClientTableDiv").addClass("HideThisElement");
		
	    getCotactPerson();
	    getAddress();
	    
		$("#companyName").val(data.companyName);
		$("#location").val(data.location);
		$("#customerType").val(data.customerType);
		$("#creditTime").val(data.creditTime);
		$("#creditLimit").val(data.creditLimit);
		$("#salesPerson").val(data.salesPerson);
		$("#source").val(data.source);*/
		if($("#for").val() == "sampleListInvtAccp")
		{
			$("#updateBtnDiv").removeClass("HideThisElement");
			$("#SampleFormDispatchDiv").addClass("HideThisElement");
			$("#submitBtnDiv").addClass("HideThisElement");
		}
		else if($("#for").val() == "sampleListDispatched")
		{
			$("#updateBtnDiv").addClass("HideThisElement");
			$("#SampleFormDispatchDiv").removeClass("HideThisElement");
			$("#submitBtnDiv").addClass("HideThisElement");
		}
		else if($("#for").val() == "sampleListRdyToRcv")
		{
			/*$("#updateBtnDiv").addClass("HideThisElement");*/
			$("#SampleFormReceiveDiv").removeClass("HideThisElement");
			/*$("#submitBtnDiv").addClass("HideThisElement");*/
		}
	});
	
	$('#datatables tbody').on('click', '.view_me', function() {
		var data = table.row($(this).parents('tr')).data();
		console.log(data);
		$("#SampleFormProductListDiv").removeClass("HideThisElement");
		$("#SampleViewDiv").removeClass("HideThisElement");
		$("#SampleFormDiv").addClass("HideThisElement");
		$("#SampleTableDiv").addClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
	    document.querySelector('#ProductDataBody').value = "";
		$("#DeleteProduct").addClass("HideThisElement");
		$("#SubmitButtonRegister").addClass("HideThisElement");
		$("#SubmitButtonUpdate").removeClass("HideThisElement");
		$("#SubmitButtonBack").removeClass("HideThisElement");
		$("#SampleFormProductListDiv").removeClass("HideThisElement");
		
		$("#selectedRequisitioId").val(data.requisitionId);
		$("#ReasonText").text(data.reason_text);
		$("#expectedReceiptDateText").text(data.formattedExpectedReceiptDate);
		$("#modeOfDeliveryText").text(data.modeofDelivery_text);
		
		$("#remarksDiv").html("");
		getRemarksHistory(data.requisitionId,0,1);
		getProducts(data.requisitionId);
	    /*document.getElementById("newElementForm").reset();
		$("#sourceText").text(data.source_text);
		$("#creditTimeText").text(data.creditTime);
		$("#creditLimitText").text(data.creditLimit);
		$("#salesPersonText").text(data.contactPerson);

	    $("#ClientTableDiv").addClass("HideThisElement");
		
	    getCotactPerson();
	    getAddress();
	    
		$("#companyName").val(data.companyName);
		$("#location").val(data.location);
		$("#customerType").val(data.customerType);
		$("#creditTime").val(data.creditTime);
		$("#creditLimit").val(data.creditLimit);
		$("#salesPerson").val(data.salesPerson);
		$("#source").val(data.source);*/
		if($("#for").val() == "sampleListInvtAccp")
		{
			$("#updateBtnDiv").removeClass("HideThisElement");
			$("#SampleFormDispatchDiv").addClass("HideThisElement");
			$("#submitBtnDiv").addClass("HideThisElement");
		}
		else if($("#for").val() == "sampleListDispatched")
		{
			$("#updateBtnDiv").addClass("HideThisElement");
			$("#SampleFormDispatchDiv").removeClass("HideThisElement");
			$("#submitBtnDiv").addClass("HideThisElement");
		}
		else if($("#for").val() == "sampleListRdyToRcv")
		{
			/*$("#updateBtnDiv").addClass("HideThisElement");*/
			$("#SampleFormReceiveDiv").removeClass("HideThisElement");
			/*$("#submitBtnDiv").addClass("HideThisElement");*/
		}
	});
});

function getProducts(rowId) {
	$.ajax({
		url:"../../../GetRequisitionList?requisitionId="+rowId,
		type:"GET",
		success:function(data){
	    	for(var i=0; i<data.data.length; i++)
	    	{
				var newHtml = '<tr id="productIdRow">'+
				  '<td class="HideActionClass"><input type="checkbox" id="'+data.data[i].productId+'" name="' + data.data[i].productId + '" class="checkbox" onchange="chckBox(\''+data.data[i].productId+'\')"><label for="'+data.data[i].productId+'"></label></td>'+
				  '<td>'+data.data[i].skuid+'</td>'+
				  '<td>'+data.data[i].productInfo+'</td>'+
				  '<td id="chck'+data.data[i].productId+'" class="'+data.data[i].class+'">'+data.data[i].rqtnItmstatus_text+'</td>'+
				  '<td style="display:none;" id="requitionItemId">'+data.data[i].rowId+'</td>'+
				  '<td style="display:none;">'+data.data[i].status+'</td>'+
				  '<td class="HideActionClass"><input type="text" id="barcode'+data.data[i].productId+'" name="barcode' + data.data[i].productId + '" class="form-control" ></td>'+
				  '</tr>';
				document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
	    	}
		}
	});
}

function chckBox(id)
{
    if($('#'+id).is(':checked'))
    {
        $("#chck"+id).removeClass('red');
        $("#chck"+id).addClass('green');
        $("#chck"+id).html('Ready');
		$("#SampleFormProductListDiv #alertMessage").addClass("HideThisElement");
    }
    else
    {
        $("#chck"+id).addClass('red');
        $("#chck"+id).removeClass('green');
        $("#chck"+id).html('Pending');
		$("#SampleFormProductListDiv #alertMessage").addClass("HideThisElement");
    }
}

function getRemarksHistory(rowId, start, isRefresh, e) {
	$.ajax({
		url:"../../../GetRequisitionRemarksHistory?requisitionId="+rowId+"&start="+start+"&limit=5",
		type:"GET",
		success:function(data){ 
			if(e)	e.preventDefault();
			if(data!=0){
				var str="";$('#lm').html('');
				if(isRefresh==1)$('#remarksDiv').html('');
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', data);
				//$('#remarksDiv').append(data);
				str="<div id='lm'><a href='#' onclick='getRemarksHistory(\""+rowId+"\", "+(parseInt(start)+5)+",0, "+$(this).event+");'>Load More . . .</a></div>";
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', str);
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0){
			        var firstMsg = $('#remarksDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}
			}else if(data==0){ 
				$('#lm').html('');
				$(document).scrollTop($(document).height());

		        var firstMsg = $('#remarksDiv .card:first');
		        // Store current scroll/offset
		        var curOffset = firstMsg.offset().top - $(document).scrollTop();
		        
		        // Add your new messages
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		       
		        $(document).scrollTop(firstMsg.offset().top-curOffset);
			}
		}
	});
}

function loadBlankform() {
	document.getElementById("newElementForm").reset();
	$("#myTabContent").removeClass("HideThisElement");		
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	$("#statuscheckbox").attr("disabled",true);
	$("#ClientTableDiv").addClass("HideThisElement");
	$("#ClientFormDiv").removeClass("HideThisElement");
	$("#action").val("insert");
	var generator = new IDGenerator();
	DropDownForLegend();
	DropDownForEmployee("");
	dropdownFunctionForState();
	$("#selectedClientId").val("C"+ generator.generate());
	$("#selectedClientAddressId").val("CA"+ generator.generate());
	$("#selectedClientContactPersonId").val("CCP"+ generator.generate());
}