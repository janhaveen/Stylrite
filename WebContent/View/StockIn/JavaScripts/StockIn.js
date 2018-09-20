 $(document).ready(function(){
	 $("#HomeText").text("Stock In");
    $(".StockInDiv" ).on("focusout", "#barcodeText", function() { console.log("5655");
    	$( "#LocationText" ).text( ui.item.location );
    	 getBarcodeProductInfo(ui.item.location);
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
    	if (idExists) {
			//toastr.error('Product Already Exists!');
    		 $("#ProductTableDiv .errorMsg").removeClass("HideThisElement");
             $("#ProductTableDiv #errorMsg").html(' <strong>Error!</strong> Product Already Exists !');
		} else { console.log("dsd");
			var newHtml = '<tr id="productIdRow">'+
						  '<td><input type="checkbox" value="'+data.rowId+'"  id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
						  '<td>'+data.productInfo+'</td>'+
						  '<td><input class="form-control qty" type="text" onkeyup="checkQty(this,\''+data.rowId+'\');" id="qty'+data.rowId+'"></td>'+
						  '<td>'+data.price+'</td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+data.rowId+'"></label></td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+data.lacation+'"></label></td>'+
						  '</tr>';
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
			$("#SelectProduct").modal('hide');
		}    	
	});
});
	