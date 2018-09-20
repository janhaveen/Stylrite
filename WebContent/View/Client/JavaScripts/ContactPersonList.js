$(document).ready(function(){
	
});

function getCotactPerson()
{
	$('#contactPersonDatatables').DataTable().destroy();
	
	$('#contactPersonDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#contactPersonDatatables thead input").on('keyup change', function () {
        contactPersonTable.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr = "";
    if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_clientCP fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
            '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>'
    }
    
	var contactPersonTable = $('#contactPersonDatatables').DataTable( {
        buttons: [
            {
                text: 'New Contact Person',
                action: function ( e, dt, node, config ) {
                	loadBlankformCP();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetContactPersonList?clientId="+$("#selectedClientId").val(),
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "name" },
            { "data": "designation_text" },
            { "data": "contactNo" },
            { "data": "altContactNo" },
            { "data": "emailId" },
            { "data": "location" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#contactPersonDatatables tbody').off('click');
	
	$('#contactPersonDatatables tbody').on('click', '.edit_me', function() {
	    var data = contactPersonTable.row($(this).parents('tr')).data();
	    document.getElementById("newElementForm").reset();
		/*DropDownForLegend();
		dropdownFunctionForManager();*/
		dropdownFunctionForState();
		DropDownForLegend();
		DropDownForEmployee("");
	    document.querySelector('#selectedClientId').value = data.clientId;
	    document.querySelector('#selectedClientContactPersonId').value = data.rowId;
	    
		$("#ClientViewDiv").addClass("HideThisElement");
		$("#ClientFormDiv").removeClass("HideThisElement");
		
		$("#ClientFormDiv #myTab").addClass("HideThisElement");
		$("#ClientFormDiv #ClientDetails").addClass("HideThisElement");
		$("#ClientFormDiv #ContactPersonDetails").removeClass("HideThisElement");
		$("#ClientFormDiv #AddressDetails").addClass("HideThisElement");
		
		$("#ClientFormDiv #ClientDetails").removeClass("active");
		$("#ClientFormDiv #AddressDetails").removeClass("active");
		$("#ClientFormDiv #ContactPersonDetails").addClass("active");
		
		$("#ClientFormDiv #ClientDetails").removeClass("show");
		$("#ClientFormDiv #AddressDetails").removeClass("show");
		$("#ClientFormDiv #ContactPersonDetails").addClass("show");

		$("#ClientFormDiv .card-title").html("Update Contact Person");

		$("#ClientFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#ClientFormDiv #SubmitButtonUpdate").removeClass("HideThisElement");
		
		$("#ClientFormDiv #action").val("updateContactPerson");
		
		$("#firstName").val(data.firstName);
		$("#lastName").val(data.lastName);
		$("#locationCP").val(data.location);
		$("#mobileno").val(data.contactNo);
		$("#altContactNo").val(data.altContactNo);
		$("#emailId").val(data.emailId);
		$("#department").val(data.location);
		$("#designation").val(data.city);
		/*console.log($("#inputState").val(data.state),data.state);*/
		$("#birthDate").val(data.formattedBirthdate);
	});
    
    $('#contactPersonDatatables tbody').on( 'click', '.select_me_clientCP', function () {
		var data = $('#contactPersonDatatables').DataTable().row($(this).parents('tr')).data();
		console.log(data);
		$('#selectedClientContactPersonId').val(data.rowId);
		$('#clientContactPersonName').val(data.name);
		$('#SelectClientContactPersonModal').modal('hide');
    });
	
	/*$('#editClick').click(function() {
		$("#SubmitButtonRegister").addClass("HideThisElement");
	    $("#SubmitButtonUpdate").removeClass("HideThisElement");
	    $("#SubmitButtonBack").removeClass("HideThisElement");	    
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		$("#EmpTableDiv").addClass("HideThisElement");
		$("#myTabContent").removeClass("HideThisElement");		
		$("#EmpViewDiv").addClass("HideThisElement");
		$("#EmpFormDiv").removeClass("HideThisElement");
	});*/
	
	/*$('#contactPersonDatatables tbody').on( 'click', '.select_me', function () {
    	var data = contactPersonTable.row( $(this).parents('tr') ).data();
        document.querySelector('#ResetPassEmpId').value = data.employeeId;
    	$('#centralModalWarningDemo').modal('show');
    });*/
    
    $('#contactPersonDatatables tbody').on( 'click', '.delete_me', function () {
    	var data = contactPersonTable.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteClientId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    });
}

function loadBlankformCP() {
	var generator = new IDGenerator();
	var clientId = $('#selectedClientId').val();
	document.getElementById("newElementForm").reset();
	
	/*$("#myTabContent").removeClass("HideThisElement");		
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	$("#statuscheckbox").attr("disabled",true);
	$("#ClientTableDiv").addClass("HideThisElement");
	$("#ClientFormDiv").removeClass("HideThisElement");*/
    $('#selectedClientId').val(clientId);
	$("#selectedClientContactPersonId").val("CCP"+ generator.generate());

	/*$("#ClientViewDiv").addClass("HideThisElement");
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

	$("#ClientFormDiv .card-title").html("New Address");*/


	
	
	

	$("#ClientViewDiv").addClass("HideThisElement");
	$("#ClientFormDiv").removeClass("HideThisElement");
	
	$("#ClientFormDiv #myTab").addClass("HideThisElement");
	$("#ClientFormDiv #ClientDetails").addClass("HideThisElement");
	$("#ClientFormDiv #ContactPersonDetails").removeClass("HideThisElement");
	$("#ClientFormDiv #AddressDetails").addClass("HideThisElement");
	
	$("#ClientFormDiv #ClientDetails").removeClass("active");
	$("#ClientFormDiv #AddressDetails").removeClass("active");
	$("#ClientFormDiv #ContactPersonDetails").addClass("active");
	
	$("#ClientFormDiv #ClientDetails").removeClass("show");
	$("#ClientFormDiv #AddressDetails").removeClass("show");
	$("#ClientFormDiv #ContactPersonDetails").addClass("show");

	$("#ClientFormDiv .card-title").html("New Contact Person");

	$("#ClientFormDiv #SubmitButtonRegister").removeClass("HideThisElement");
	$("#ClientFormDiv #SubmitButtonUpdate").addClass("HideThisElement");
	$("#ClientFormDiv #action").val("insertContactPerson");
	DropDownForLegend();
	DropDownForEmployee("");
	dropdownFunctionForState();
}