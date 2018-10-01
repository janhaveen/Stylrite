$(document).ready(function(){	
	var barcodeData=[]; var SkuData=[];
	$.ajax({
		url:"../../../GetBoxBarcodeList",
		type:"GET",
		async:false,
		success:function(data){
			for (var i = 0; i < data.data.length; i++) {
				barcodeData.push({name:data.data[i].location, id:data.data[i].rowNo,
					location:data.data[i].location, remQty:data.data[i].remQty, capacity:data.data[i].capacity});
			}
		}
	});
	
	$("#barcodeText" ).autocomplete({
	     minLength: 0,
	      source: barcodeData,
	      focus: function( event, ui ) { 
	      	$("#barcodeText").val( ui.item.name );
	        	return false;
	      },	    	 
	      select: function( event, ui ) { 
		        $( "#barcodeText").val( ui.item.name );
		        $( "#barcodeId" ).val( ui.item.id );
		        $( "#LocationText" ).text( ui.item.location );
		        $( "#CapacityText" ).text( ui.item.capacity );
		        $( "#SpaceText" ).text( ui.item.remQty );
		        $( "#BrandText" ).text( ui.item.remQty );
		        $("#boxInfoDiv").removeClass("HideThisElement");
		        getBarcodeProductInfo(ui.item.location);
		        return false;
	      }
    }).autocomplete( "instance" )._renderItem = function( ul, item ) { 
		  return $( "<li>" )
          .append( "<div>" + item.name + "</div>" )
          .appendTo( ul );
    };
   
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

function getBarcodeProductInfo(id) {
	$('#ProductDataBody').html('');
	var newHtml = "";
	$.ajax({
		url:"../../../GetChildBarcodeList?boxbarcodeId="+id,
		type:"GET",
		async:false,
		success:function(data){
			if(data.data.length>0){
				for (var i = 0; i < data.data.length; i++) {
					newHtml += '<tr id="productIdRow">'+
					  '<td><input type="checkbox" disabled id="'+data.data[i].productId+'" name="' + data.data[i].productId + '" value="' + data.data[i].productId + '"><label for="'+data.data[i].productId+'"></label></td>'+
					  '<td>'+data.data[i].productInfo+'</td>'+
					  '<td>0</td>'+
					  '<td>'+data.data[i].productQty+'</td>'+
					  '<td>'+data.data[i].price+'</td>'+
					  '<td class="HideThisElement"><input type="checkbox" id="'+data.data[i].rowId+'" name="' + data.data[i].rowId + '" value="' + data.data[i].rowId + '"><label for="'+data.data[i].rowId+'"></label></td>'+
					  '</tr>';
				}
			}else{
				newHtml = '<tr id="productIdRowEmp">'+
						  '<td colspan="4" class="center">Box is empty!</td>'+
						  '</tr>';
			}
			
			document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);
		}
	});
}

function checkQty(element, id) { //console.log($(element).val());
	var qty=0;$("#qty"+id).val($(element).val());
	for (var i = 0; i < $('.qty').length; i++) {
		qty+=parseInt($($('.qty')[i]).val());
	}
	if(qty>parseInt($("#SpaceText").text())){
		$("#boxInfoDiv .errorMsg").removeClass("HideThisElement");
        $("#boxInfoDiv #errorMsg").html(' <strong>Error!</strong> Product Quantity is greater than capacity !');
	}else{
		$("#boxInfoDiv .errorMsg").addClass("HideThisElement");
	}
	
}

