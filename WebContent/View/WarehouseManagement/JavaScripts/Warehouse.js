$(document).ready(function(){
	
	$("#SubmitButtonRegisterWarehouse").click(function() {
    	formSubmit(); 
    	return false;
    });
    
    $("#SubmitButtonUpdateWarehouse").click(function() {
    	formSubmit();
    	return false;
    });
    
    $("#SubmitButtonBack").click(function() {
	    $("#WhTableDiv").removeClass("HideThisElement");
		$("#WhViewDiv").addClass("HideThisElement");
		$("#WhFormDiv").addClass("HideThisElement");
    });
    
    $("#SubmitButtonBackFromView").click(function() {
	    $("#WhTableDiv").removeClass("HideThisElement");
		$("#WhViewDiv").addClass("HideThisElement");
		$("#WhFormDiv").addClass("HideThisElement");
    });
    
    $("#DeleteWarehouseConfirmed").click(function() {
        var DeleteWhId = document.querySelector('#DeleteWhId').value;
        $.ajax({
            type: "GET",
            url: '../../../ModifyWarehouse?id=' + DeleteWhId,
            success: function(data) {
                if (data == 0) {
                    $('#centralModalDangerDemo').modal('hide');
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Warehouse!');
                } else {
                    $('#centralModalDangerDemo').modal('hide');
                    $('#selectedEmployeeId').val('');
                    $('#WhDatatables').DataTable().ajax.reload();
                    $(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Warehouse Deleted Successfully!');
                }
            }
        })
        return false; // avoid to execute the actual submit of the form.
    });
});



function formSubmit(){ 
	if($("#newWhForm #Name").val()==""){
		$('#newWhForm #alertMessage').html("<strong>Warning!</strong> Branch Name is mandatory !");
		$('#newWhForm #alertMessage').removeClass("HideThisElement");
	}if($("#newWhForm #typeOfBr").val()==""){
		$('#newWhForm #alertMessage').html("<strong>Warning!</strong> Branch Type is mandatory !");
		$('#newWhForm #alertMessage').removeClass("HideThisElement");
	}else if($("#newWhForm #Location").val()==""){
		$('#newWhForm #alertMessage').html("<strong>Warning!</strong> Location is mandatory !");
		$('#newWhForm #alertMessage').removeClass("HideThisElement");
	}else if($("#newWhForm #city").val()==""){
		$('#newWhForm #alertMessage').html("<strong>Warning!</strong> City is mandatory !");
		$('#newWhForm #alertMessage').removeClass("HideThisElement");
	}else if($("#newWhForm #state").val()==""){
		$('#newWhForm #alertMessage').html("<strong>Warning!</strong> State is mandatory !");
		$('#newWhForm #alertMessage').removeClass("HideThisElement");
	}else{
		$.ajax({
			url:"../../../ModifyWarehouse",
			type:"POST",
			data:$("#newWhForm").serialize(),
			success:function(data){
				if (data == 0) {
	            	document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Failed to "+$("#action").val()+" Warehouse !";
					$("#errorMessage").removeClass("HideThisElement");
				} else {
					$("#alertMessage").addClass("HideThisElement");
					$("#errorMessage").addClass("HideThisElement");	
					document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Warehouse "+$("#action").val()+"ed Successfully!";
					$("#successMessage").removeClass("HideThisElement");
					$("#SubmitButtonRegister").addClass("HideThisElement");
				    $("#SubmitButtonUpdate").addClass("HideThisElement");
				    $("#SubmitButtonBack").addClass("HideThisElement");	
					setTimeout(function(){
						$("#WhTableDiv").removeClass("HideThisElement");
						$("#WhFormDiv").addClass("HideThisElement");							
						$('#WhDatatables').DataTable().ajax.reload();	
					}, 3000);		
				}
			}
		});
	}
	return false; // avoid to execute the actual submit of the form.
}