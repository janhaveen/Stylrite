function sampleSpDatatable(spid) {
	var str="";
	DropDownForInventoryLegend();
	DropDownForEmployee(spid);
	$.ajax({
		url:"../../../GetSampleTransferList?listFor=sampleForSP&spid="+spid,
		type:"GET",
		success:function(data){
	    	for(var i=0; i<data.data.length; i++)
	    	{
				var newHtml = '<tr id="productIdRow">'+
				  '<td class="HideActionClass"><input type="checkbox" id="'+data.data[i].productId+'" name="' + data.data[i].productId + '" class="checkbox" onchange="chckBox(\''+data.data[i].productId+'\')"><label for="'+data.data[i].productId+'"></label></td>'+
				  '<td>'+data.data[i].requisitionDate+'</td>'+
				  '<td>'+data.data[i].productInfo+'</td>'+
				  '<td>'+data.data[i].modeofDelivery_txt+'</td>'+
				  '<td>'+data.data[i].status_txt+'</td>'+
				  '</tr>';
				document.querySelector('#SampleForspdatatablesBody').insertAdjacentHTML('beforeend', newHtml);
	    	}
		}
	});
}