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
    
    var actionStr = "";
    if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_client fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
        '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
    }
    
	var table = $('#datatables').DataTable( {
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
		"ajax": "../../../GetClientList",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "companyName" },
            { "data": "location" },
            { "data": "contactPerson" },
            { "data": "contactNoCP" },
            { "data": "altContactNoCP" },
            { "data": "emailIdCP" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
    $('#datatables tbody').off('click');
	DropDownForEmployee("");
	DropDownForLegend();
	
	$('#datatables tbody').on('click', '.edit_me', function() {
		var data = table.row($(this).parents('tr')).data();
	    document.getElementById("newElementForm").reset();
	    document.querySelector('#selectedClientId').value = data.rowId;
		$("#companyNameText").text(data.companyName);
		$("#locationText").text(data.location);
		$("#customerTypeText").text(data.customerType_txt);
		$("#sourceText").text(data.source_text);
		$("#creditTimeText").text(data.creditTime);
		$("#creditLimitText").text(data.creditLimit);
		$("#salesPersonText").text(data.contactPerson);
		
	    getCotactPerson();
	    getAddress();
	    
		$("#companyName").val(data.companyName);
		$("#location").val(data.location);
		document.querySelector('#customerType').value = data.customerType;     
//		$("#customerType").val(data.customerType);
		$("#creditTime").val(data.creditTime);
		$("#creditLimit").val(data.creditLimit);
//		console.log($("#salesPerson").html());
		$("#salesPerson").val(data.salesPerson);
		console.log(data.salesPerson);
		//$("#salesPerson").selectmenu("refresh");
		$("#source").val(data.source);

	    $("#ClientTableDiv").addClass("HideThisElement");
		$("#ClientViewDiv").removeClass("HideThisElement");
		$("#ClientFormDiv").addClass("HideThisElement");
	});
	
	$('#editClick').click(function() {
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		
		/*dropdownFunctionForState();
		DropDownForLegend();
		DropDownForEmployee("");*/
	    
		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").removeClass("HideThisElement");
		
		$("#ClientFormDiv #myTab").addClass("HideThisElement");
		$("#ClientFormDiv #ClientDetails").removeClass("HideThisElement");
		$("#ClientFormDiv #ContactPersonDetails").addClass("HideThisElement");
		$("#ClientFormDiv #AddressDetails").addClass("HideThisElement");
		
		$("#ClientFormDiv #ClientDetails").addClass("active");
		$("#ClientFormDiv #AddressDetails").removeClass("active");
		$("#ClientFormDiv #ContactPersonDetails").removeClass("active");
		
		$("#ClientFormDiv #ClientDetails").addClass("show");
		$("#ClientFormDiv #AddressDetails").removeClass("show");
		$("#ClientFormDiv #ContactPersonDetails").removeClass("show");

		$("#ClientFormDiv .card-title").html("Update Client");

		$("#ClientFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#ClientFormDiv #SubmitButtonUpdate").removeClass("HideThisElement");
		
		$("#ClientFormDiv #action").val("updateClient");
	});
    
    $('#datatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteClientId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    });
});

function loadBlankform() {
	console.log("Hi");
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