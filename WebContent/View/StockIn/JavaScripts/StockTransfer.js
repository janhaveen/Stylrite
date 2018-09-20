$(document).ready(function(){
	$("#HomeText").text("Stock Transfer");
	
	var table = $('#ProductDatatables').DataTable( {
        dom: 'frtip',
		"bLengthChange": false,
		"iDisplayLength":5,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetChildBarcodeList?unknownLocation=y",
		"columns": [
        	 {
             	className: "center",
                 defaultContent:'<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '
             },
            { "data": "brand_text" },
            { "data": "modelNo" },
            { "data": "color" },
            { "data": "size" },
            { "data": "price" }
            
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#ProductDatatables tbody').on('click', '.select_me', function() {
		
		$('#productIdRowEmp').remove();
		var generator = new IDGenerator();
		var data = $('#ProductDatatables').DataTable().row($(this).parents('tr')).data();
    	var table1 = document.getElementById('ProductData');
    	var rowCount = table1.rows.length;
    	var idExists = false;
    	for(var i=1; i<rowCount-1; i++) {
    		var row = table1.rows[i];
    		var a = $(row.cells[0]).html();
    		var idToCheck= $(a).attr('id');
        	if (idToCheck == data.rowId) {
    			idExists = true;
    			break;
    		}
    	}
    	console.log(idExists);
    	checkQty();
    	if (idExists) {
			//toastr.error('Product Already Exists!');
    		 $("#ProductTableDiv .errorMsg").removeClass("HideThisElement");
             $("#ProductTableDiv #errorMsg").html(' <strong>Error!</strong> Product Already Exists !');
		} else { console.log("dsd");
			var newHtml = '<tr id="productIdRow">'+
						  '<td><input type="checkbox" value="'+data.productId+'"  id="'+data.productId+'" name="' + data.productId + '"><label for="'+data.productId+'"></label></td>'+
						  '<td>'+data.productInfo+'</td>'+
						  '<td>'+data.productQty+'</td>'+
						  //'<td><input class="form-control qty" type="text" onkeyup="checkQty(this,\''+data.productId+'\', '+data.productQty+');" id="qty'+data.productId+'"></td>'+
						  '<td><input class="form-control qty" type="text" value="1" readOnly id="qty'+data.productId+'"></td>'+
						  '<td>'+data.price+'</td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+data.productId+'"></label></td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value="'+data.rowId+'"><label for="'+data.rowId+'"></label></td>'+
						  '</tr>';
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
			$("#SelectProduct").modal('hide');			
			checkQty();
		}    	
	});
});

function checkQty() { //console.log($(element).val());
	//var qty=0;$("#qty"+id).val($(element).val());
	for (var i = 0; i < $('.qty').length; i++) {
		qty+=parseInt($($('.qty')[i]).val());
	}
	if(qty>parseInt($("#SpaceText").text())){
		$("#boxInfoDiv .errorMsg").removeClass("HideThisElement");
        $("#boxInfoDiv #errorMsg").html(' <strong>Error!</strong> Product Quantity is greater than capacity !');
	}else {
		$("#boxInfoDiv .errorMsg").addClass("HideThisElement");
	}
	
}