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
    /*if(window.location.href.indexOf("JSPs/Order.jsp")>=0)
    {
    	actionStr = '<i class="select_me_vendor fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    else
    {*/
    	actionStr = '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
        '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
//    }
    
	var table = $('#datatables').DataTable( {
        buttons: [
            {
                text: 'New Vendor',
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
		"ajax": "../../../GetVendorList",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "vendorName" },
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
	
	$('#datatables tbody').on('click', '.edit_me', function() {
		var data = table.row($(this).parents('tr')).data();
	    document.getElementById("newVendorForm").reset();
	    document.querySelector('#selectedVendorId').value = data.rowId;
		$("#vendorNameText").text(data.vendorName);
		$("#locationText").text(data.location);
		$("#vendorTypeText").text(data.vendorType_txt);
		$("#sourceText").text(data.source_text);
		$("#creditTimeText").text(data.creditTime);
		$("#creditLimitText").text(data.creditLimit);
		
	    getCotactPerson();
	    getAddress();
	    
		$("#companyName").val(data.companyName);
		$("#location").val(data.location);
//		document.querySelector('#customerType').value = data.customerType;
//		$("#customerType").val(data.customerType);
		$("#vendorName").val(data.vendorName);
		$("#emailId").val(data.email);
		$("#website").val(data.website);
		$("#landLineNo").val(data.landlineNo);
		$("#creditTime").val(data.creditTime);
		$("#creditLimit").val(data.creditLimit);
		$("#salesPerson").val(data.salesPerson);
		$("#source").val(data.source);

	    $("#VendorTableDiv").addClass("HideThisElement");
		$("#VendorViewDiv").removeClass("HideThisElement");
		$("#VendorFormDiv").addClass("HideThisElement");
	});
	
	$('#editClick').click(function() {
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		
		dropdownFunctionForState();
		DropDownForLegend();
//		DropDownForEmployee("");
	    
		$("#VendorViewDiv").addClass("HideThisElement");
		$("#VendorFormDiv").removeClass("HideThisElement");
		
		$("#VendorFormDiv #myTab").addClass("HideThisElement");
		$("#VendorFormDiv #VendorDetails").removeClass("HideThisElement");
		$("#VendorFormDiv #ContactPersonDetails").addClass("HideThisElement");
		$("#VendorFormDiv #AddressDetails").addClass("HideThisElement");
		
		$("#VendorFormDiv #VendorDetails").addClass("active");
		$("#VendorFormDiv #AddressDetails").removeClass("active");
		$("#VendorFormDiv #ContactPersonDetails").removeClass("active");
		
		$("#VendorFormDiv #VendorDetails").addClass("show");
		$("#VendorFormDiv #AddressDetails").removeClass("show");
		$("#VendorFormDiv #ContactPersonDetails").removeClass("show");

		$("#VendorFormDiv .card-title").html("Update Vendor");

		$("#VendorFormDiv #SubmitButtonRegister").addClass("HideThisElement");
		$("#VendorFormDiv #SubmitButtonUpdate").removeClass("HideThisElement");
		
		$("#VendorFormDiv #action").val("updateVendor");
	});
    
    $('#datatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteClientId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    });
});

function loadBlankform() {
	document.getElementById("newVendorForm").reset();
	$("#myTabContent").removeClass("HideThisElement");		
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
//	$("#statuscheckbox").attr("disabled",true);
	$("#VendorTableDiv").addClass("HideThisElement");
	$("#VendorFormDiv").removeClass("HideThisElement");
	$("#action").val("insert");
	var generator = new IDGenerator();
	DropDownForLegend();
//	DropDownForEmployee("");
	dropdownFunctionForState();
	$("#selectedVendorId").val("V"+ generator.generate());
	$("#selectedVendorAddressId").val("VA"+ generator.generate());
	$("#selectedVendorContactPersonId").val("VCP"+ generator.generate());
}