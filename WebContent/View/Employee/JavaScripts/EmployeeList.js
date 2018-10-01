$(document).ready(function(){
	DropDownForLegend();
	dropdownFunctionForManager();
	dropdownFunctionForState();
	$('#datatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
    $("#datatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
	var table = $('#datatables').DataTable( {
        buttons: [
            {
                text: 'New Employee',
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
		"ajax": "../../../GetEmployeeList",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '+
                 '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
                 '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>'
             },
            { "data": "employeeName" },
            { "data": "department_desc" },
            { "data": "designation_desc" },
            { "data": "userId" },
            { "data": "mobileNo" },
            { "data": "emailId" },
            { "data": "reportingTo" },
            { "data": "status_desc" }
            
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#datatables tbody').on('click', '.edit_me', function() {
	    var data = table.row($(this).parents('tr')).data();
	    document.getElementById("newElementForm").reset();		
	    document.querySelector('#selectedEmployeeId').value = data.employeeId;
	    
		$("#firstNameText").text(data.firstName); $("#LastnameText").text(data.lastName); $("#GenderText").text(data.genderText);
		$("#ContactText").text(data.mobileNo); $("#AltContactText").text(data.altContactNo); $("#EmailText").text(data.emailId);
		$("#DepartmentText").text(data.department_desc); $("#DesignationText").text(data.designation_desc); 
		$("#SupervisorText").text(data.reportingTo);
		$("#UserText").text(data.userId); $("#LocationText").text(data.location); 
		$("#BranchText").text(data.branchText);
		$("#BirthdateText").text(data.birthdaydate); $("#StatusText").text(data.status_desc); 
		
		
		$("#AddressText").html(data.addressText);
		
	    if (data.firstName !== "") {
	        $('#firstName').val(data.firstName);
	        $('#firstNameLbl').addClass("active");
	    }
	    if (data.lastName !== "") {
	        $('#lastName').val(data.lastName);
	        $('#lastNameLbl').addClass("active");
	    }
	    if (data.mobileNo !== "") {
	        $('#mobileno').val(data.mobileNo);
	        $('#mobilenoLbl').addClass("active");
	    }
	    if (data.altContactNo !== "") {
	        $('#altContactNo').val(data.altContactNo);
	        $('#altContactNoLbl').addClass("active");
	    }
	    if (data.emailId !== "") {
	        $('#emailId').val(data.emailId);
	        $('#emailIdLbl').addClass("active");
	    }
	    if (data.location !== "") {
	        $('#location').val(data.location);
	        $('#locationLbl').addClass("active");
	    }
	    if (data.userId !== "") {
	        $('#UserId').val(data.userId);
	        $('#UserIdLbl').addClass("active");
	    }
	    if (data.birthdaydate !== "") {
	        $('#birthDate').val(data.birthdaydate);
	        $('#birthDateLbl').addClass("active");
	    }
	    if (data.joiningdate !== "") {
	        $('#joinDate').val(data.joiningdate);
	        $('#joinDateLbl').addClass("active");
	    }
	    if (data.reportTo !== "") {
	        $('#reportTo').val(data.reportTo);
	    }
	    if (data.branchId !== "") {
	        $('#branch').val(data.branchId);
	    }
	    console.log(data.department);
	    //if (data.department !== "") {
	       
	    /*}
	    if (data.designation !== "") {*/
	       
	   // }
	    if (data.status_desc == "Inactive") {
	        $("input [name='Status']").prop("checked", false);
	    }

	    $('#inputAddress').val(data.inputAddress);
	    $('#inputAddress2').val(data.inputAddress2);
	    $('#inputCity').val(data.inputCity);
	    $('#inputState').val(data.inputState);
	    $('#inputZip').val(data.inputZip);
	    
	    
	    $("#BasicText").text(data.BasicSalary); $("#TAText").text(data.BasicSalary); $("#DAText").text(data.DearnessAllowance);
		$("#HRAText").text(data.HouseRentAllowance); $("#CAText").text(data.ConveyanceAllowance); $("#SAText").text(data.SpecialAllowance);
		$("#VSText").text(data.VariableSalary); $("#EPFText").text(data.EPF); $("#ESICText").text(data.ESIC);
		$("#PTText").text(data.ProfessionalTax); $("#MediclaimText").text(data.Mediclaim); $("#StatutoryText").text(data.StatutoryBonus);
		$("#AccountNoText").text(data.AccountNo); $("#BankNameText").text(data.BankName); $("#BankBranchText").text(data.BankBranch); $("#IFSCText").text(data.IFSCCOde);
		
	    $('#BasicSalary').val(data.BasicSalary);
	    $('#TravelAllowance').val(data.BasicSalary);
	    $('#DearnessAllowance').val(data.DearnessAllowance);
	    $('#HouseRentAllowance').val(data.HouseRentAllowance);
	    $('#ConveyanceAllowance').val(data.ConveyanceAllowance);
	    $('#SpecialAllowance').val(data.SpecialAllowance);
	    $('#VariableSalary').val(data.VariableSalary);
	    $('#EPF').val(data.EPF);
	    $('#ESIC').val(data.ESIC);
	    $('#ProfessionalTax').val(data.ProfessionalTax);
	    $('#Mediclaim').val(data.Mediclaim);
	    $('#StatutoryBonus').val(data.StatutoryBonus);
	    
	    $('#AccountNo').val(data.AccountNo);
	    $('#BankName').val(data.BankName);
	    $('#BankBranch').val(data.BankBranch);
	    $('#IFSCCOde').val(data.IFSCCOde);
	    $("#action").val("update");
	    $("#SubmitButtonRegister").addClass("HideThisElement");
	    $("#SubmitButtonUpdate").removeClass("HideThisElement");
	    $('#department').val(data.department);
	    $('#EmpFormDiv #designation').val(data.designation);
	    $("#EmpTableDiv").addClass("HideThisElement");
		$("#EmpViewDiv").removeClass("HideThisElement");
		$("#EmpFormDiv").addClass("HideThisElement");
		$("#EmpViewDiv").removeClass("HideThisElement");
	});
	
	$('#editClick').click(function() {
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
	});
	
	$('#datatables tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
        document.querySelector('#ResetPassEmpId').value = data.employeeId;
    	$('#centralModalWarningDemo').modal('show');
    } );
    
    $('#datatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteEmpId').value = data.employeeId;
    	$('#centralModalDangerDemo').modal('show');
    });
});

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
	$("#EmpTableDiv").addClass("HideThisElement");
	$("#EmpFormDiv").removeClass("HideThisElement");
	$("#action").val("insert");
	var generator = new IDGenerator();
	DropDownForLegend();
	dropdownFunctionForManager();
	dropdownFunctionForState();
	$("#selectedEmployeeId").val("E"+ generator.generate());
}