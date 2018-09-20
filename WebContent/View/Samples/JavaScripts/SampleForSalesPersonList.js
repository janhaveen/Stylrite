function sampleSpDatatable(spid) {
	/*var str="";
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
				  '<td id="chck'+data.data[i].modeofDelivery_txt+'" class="'+data.data[i].class+'">'+data.data[i].rqtnItmstatus_text+'</td>'+
				  '<td style="display:none;" id="requitionItemId">'+data.data[i].rowId+'</td>'+
				  '<td style="display:none;">'+data.data[i].status+'</td>'+
				  '<td class="HideActionClass"><input type="text" id="barcode'+data.data[i].productId+'" name="barcode' + data.data[i].productId + '" class="form-control" ></td>'+
				  '</tr>';
				document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
	    	}
		}*/
	//str+""
	
	
	
	/*$('#SampleForspdatatables').DataTable().destroy();
	
	var table = $('#SampleForspdatatables').DataTable({
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
		"ajax": "../../../
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i>'
             },
             { "data": "requisitionDate" },
             { "data": "productInfo" },
             { "data": "modeofDelivery_txt" },
             { "data": "" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#SampleForspdatatables tbody').on('click', '.select_me', function() {
		var data = table.row($(this).parents('tr')).data();
		
	});*/
}