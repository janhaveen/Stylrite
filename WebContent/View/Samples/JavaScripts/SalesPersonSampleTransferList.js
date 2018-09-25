$(document).ready(function(){
	$('#spdatatables').DataTable().destroy();
	
	var table = $('#spdatatables').DataTable({
        buttons: [
            /*{
                text: 'New Client',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }*/
        ],dom: 'Bfrtip',
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetSampleTransferList?listFor=sp",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i>'
             },
            { "data": "issuesTo_name" },
            { "data": "total" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#spdatatables tbody').on('click', '.select_me', function() {
		var data = table.row($(this).parents('tr')).data();
		$("#SPTableDiv").addClass('HideThisElement');
		$("#SampleForSPTableDiv").removeClass('HideThisElement');
		sampleSpDatatable(data.issuesTo);
	});
});