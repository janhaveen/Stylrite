$(document).ready(function(){
    $('#datatables tbody').on( 'click', '.select_me_client', function () {
		var data = $('#datatables').DataTable().row($(this).parents('tr')).data();
		console.log(data);
		$("#selectedClientId").val(data.rowId);
		$('#clientName').val(data.companyName);
		
		$('#selectedBillingAddressId').val(data.addressId);
		$('#clientBillingAddress').val(data.branchName+", "+data.locationadd+", "+data.address+", "+data.state_text+", "+data.pincode);
		getAddress();
		
		$('#selectedDeliveryAddressId').val(data.addressId);
		$('#clientDeliveryAddress').val(data.branchName+", "+data.locationadd+", "+data.address+", "+data.state_text+", "+data.pincode);
		
		$('#selectedClientContactPersonId').val(data.CPId);
		$('#clientContactPersonName').val(data.contactPerson);
		getCotactPerson();
		
		$('#SelectClientModal').modal('hide');
    });
	
    /*$('#addressModal').on('shown.bs.modal', function (e) {
    	$('#addressTable').DataTable().destroy();
    	addressList();
	})
	
    $('#contactPersonModal').on('shown.bs.modal', function (e) {
    	$('#contactPTable').DataTable().destroy();
    	contactPList();
	})*/
});

function showAddressModal(type)
{
	$("#addressType").val(type);
	$('#SelectClientAddressModal').modal('show');
}