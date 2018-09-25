$(document).ready(function(){
	
});

function getAddress()
{
//	var data = [];
	$('#addressDatatables').DataTable().destroy();
	
	$('#addressDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#addressDatatables thead input").on('keyup change', function () {
        contactPersonTable.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr = "";
    if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_clientAdd fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
            '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>'
    }
    
	var addressTable = $('#addressDatatables').DataTable( {
        buttons: [
            {
                text: 'New Address',
                action: function ( e, dt, node, config ) {
                	loadBlankformAddress();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetAddressList?clientId="+$("#selectedClientId").val(),
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "branchName" },
            { "data": "contactNo" },
            { "data": "gstNo" },
            { "data": "location" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#addressDatatables tbody').off('click');
	
	$('#addressDatatables tbody').on('click', '.edit_me', function() {
		var data = addressTable.row($(this).parents('tr')).data();
	    document.getElementById("newElementForm").reset();
		/*DropDownForLegend();
		dropdownFunctionForManager();*/
		dropdownFunctionForState();
	    document.querySelector('#selectedClientId').value = data.clientId;
	    document.querySelector('#selectedClientAddressId').value = data.rowId;

		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").removeClass("HideThisElement");
		
		$("#ClientFormDiv #myTab").addClass("HideThisElement");
		$("#ClientFormDiv #ClientDetails").addClass("HideThisElement");
		$("#ClientFormDiv #ContactPersonDetails").addClass("HideThisElement");
		$("#ClientFormDiv #AddressDetails").removeClass("HideThisElement");
		
		$("#ClientFormDiv #ClientDetails").removeClass("active");
		$("#ClientFormDiv #AddressDetails").addClass("active");
		$("#ClientFormDiv #ContactPersonDetails").removeClass("active");
		
		$("#ClientFormDiv #ClientDetails").removeClass("show");
		$("#ClientFormDiv #AddressDetails").addClass("show");
		$("#ClientFormDiv #ContactPersonDetails").removeClass("show");

		$("#ClientFormDiv .card-title").html("Update Address");

		$("#ClientFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#ClientFormDiv #SubmitButtonUpdate").removeClass("HideThisElement");

		$("#ClientFormDiv #action").val("updateAddress");
		
		$("#branchName").val(data.branchName);
		$("#ledgerName").val(data.ledgerName);
		$("#GSTNo").val(data.gstNo);
		$("#contactNoAdd").val(data.contactNo);
		$("#inputAddress").val(data.addressLine1);
		$("#inputAddress2").val(data.addressLine2);
		$("#locationAdd").val(data.location);
		$("#inputCity").val(data.city);
		console.log($("#inputState").val(data.state),data.state);
		$("#inputZip").val(data.pincode);
	});
    
    $('#addressDatatables tbody').on( 'click', '.delete_me', function () {
    	var data = contactPersonTable.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteClientId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    });
    
    $('#addressDatatables tbody').on( 'click', '.select_me_clientAdd', function () {
		var data = $('#addressDatatables').DataTable().row($(this).parents('tr')).data();
		if($('#addressType').val() == "billingAddress")
		{
			$('#selectedBillingAddressId').val(data.rowId);
			$('#clientBillingAddress').val(data.addressLine1);
			$('#SelectClientAddressModal').modal('hide');
		}
		else if($('#addressType').val() == "deliveryAddress")
		{
			$('#selectedDeliveryAddressId').val(data.rowId);
			$('#clientDeliveryAddress').val(data.addressLine1);
			$('#SelectClientAddressModal').modal('hide');
		}
    });
}

function loadBlankformAddress() {
	var generator = new IDGenerator();
	var clientId = $('#selectedClientId').val();
	document.getElementById("newElementForm").reset();
    $('#selectedClientId').val(clientId);
	$("#selectedClientAddressId").val("CA"+ generator.generate());

	$("#ClientViewDiv").addClass("HideThisElement");
	$("#ClientFormDiv").removeClass("HideThisElement");
	
	$("#ClientFormDiv #myTab").addClass("HideThisElement");
	$("#ClientFormDiv #ClientDetails").addClass("HideThisElement");
	$("#ClientFormDiv #ContactPersonDetails").addClass("HideThisElement");
	$("#ClientFormDiv #AddressDetails").removeClass("HideThisElement");
	
	$("#ClientFormDiv #ClientDetails").removeClass("active");
	$("#ClientFormDiv #AddressDetails").addClass("active");
	$("#ClientFormDiv #ContactPersonDetails").removeClass("active");
	
	$("#ClientFormDiv #ClientDetails").removeClass("show");
	$("#ClientFormDiv #AddressDetails").addClass("show");
	$("#ClientFormDiv #ContactPersonDetails").removeClass("show");

	$("#ClientFormDiv .card-title").html("New Address");

	$("#ClientFormDiv #SubmitButtonRegister").removeClass("HideThisElement");
	$("#ClientFormDiv #SubmitButtonUpdate").addClass("HideThisElement");

	$("#ClientFormDiv #action").val("insertAddress");
	DropDownForLegend();
	DropDownForEmployee("");
	dropdownFunctionForState();
}