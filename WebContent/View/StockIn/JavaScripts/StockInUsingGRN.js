$(document).ready(function(){
	$("#HomeText").text("Stock In");
	
	$('#ProductDatatables tbody').on('click', '.select_me', function() {
		$('#productIdRowEmp').remove();
		$("#DeleteProduct").removeClass('HideThisElement');
		$("#submitStockIn").removeClass('HideThisElement');
		var generator = new IDGenerator();
		var data = $('#ProductDatatables').DataTable().row($(this).parents('tr')).data();
    	var table1 = document.getElementById('ProductData');
    	var rowCount = table1.rows.length;
    	var idExists = false; console.log(rowCount-1, "111dff");
    	for(var i=1; i<=rowCount-1; i++) {	console.log(i, "dff");
    		var row = table1.rows[i];
    		var a = $(row.cells[0]).html();
    		var idToCheck= $(a).attr('id'); 
        	if (idToCheck == data.rowId) {
    			idExists = true;
    			break;
    		}
    	}
    	if (idExists) {
			//toastr.error('Product Already Exists!');
    		 $("#ProductTableDiv .errorMsg").removeClass("HideThisElement");
             $("#ProductTableDiv #errorMsg").html(' <strong>Error!</strong> Product Already Exists !');
		} else { 
			var newHtml = '<tr id="productIdRow">'+
						  '<td><input type="checkbox" value="'+data.rowId+'" id="'+data.rowId+'" name="' + data.rowId + '"><label for="'+data.rowId+'"></label></td>'+
						  '<td>'+data.productInfo+'</td>'+
						  '<td><input class="form-control qty" type="text" id="qty'+data.rowId+'"></td>'+
						  '<td>'+data.price+'</td>'+
						  '<td class="HideThisElement">'+data.price+'</td>'+
						  '<td class="HideThisElement"><input type="checkbox"  value=""><label for="'+data.rowId+'"></label></td>'+
						  '</tr>';
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
			$("#SelectProduct").modal('hide');
		}    	
	});
	
	$("#DeleteProduct").click(function() {
    	try {
        	var table = document.getElementById('productTableBody');
        	var rowCount = table.rows.length;
        	for(var i=0; i<rowCount; i++) {
        		var row = table.rows[i]; 
        		var chkbox = row.cells[0].childNodes[0]; 

        		if(null != chkbox && true == chkbox.checked) {
        			table.deleteRow(i); 
        			calculateAmountPayable();
        			rowCount--;
        			i--;
        			count--;
        		}
        	}
        	}catch(e) {
        		alert(e);
        	}
        return false; // avoid to execute the actual submit of the form.
    });
	
	$("#submitStockIn").click(function() {
		formSubmit();
	});
	
	$("#ExportasCSV").click(function() {
		exportasCSV();
	});
});

