function formSubmit() {
	var returnVal=false;
	var barcodeArr=[];
	var table1 = document.getElementById('ProductDataBody');
	var rowCount = table1.rows.length; 		
	for (var i = 0; i < rowCount; i++) {
	     var row = table1.rows[i]; 
	     var formData=""; 
		 for(var j=0; j<$(row.cells).length; j++){
			if(j==0){
				var ProductId=$($(row.cells[j]).html()).val();
				formData+="ProductId="+ProductId+"&qty="+$("#qty"+ProductId).val()+"&";
			}else if(j==5){
				var cbId=$($(row.cells[j]).html()).val();
				formData+="cbId="+cbId+"&";
			}
			if(window.location.href.indexOf("StockTransfer.jsp")>=0){
				if(j==6){
					var cdRowId=$($(row.cells[j]).html()).val();
					formData+="cdRowId="+cdRowId+"&"; 	//child barcode id of product
				}
			}
		}
		if(window.location.href.indexOf("StockTransfer")>=0){
			checkQty();
			formData+="action=update"+"&";
		}else{
			formData+="action=insert"+"&";
		}
		 
		 var msg="";
		if($("#barcodeText").length>0){
			if($("#barcodeText").val()!=""){
				 formData+="location="+$("#barcodeText").val();
			}else{
				msg="<strong>Error!</strong> Location is mandatory !";
			}
		}else if($("#GRNText").length>0){
			if($("#GRNText").val()!=""){
				formData+="GRNNumber="+$("#GRNText").val();
			}else{
				msg="<strong>Error!</strong> GRN Number is mandatory !";
			}
		}
		if(msg!=""){
			$("#boxInfoDiv .errorMsg").removeClass("HideThisElement");
	        $("#boxInfoDiv #errorMsg").html(msg);
		}else if($("#qty"+ProductId).val()==""){
			$("#boxInfoDiv .errorMsg").removeClass("HideThisElement");
	        $("#boxInfoDiv #errorMsg").html(' <strong>Error!</strong> Product Quantity is mandatory !');
		}else{
			$("#boxInfoDiv .errorMsg").addClass("HideThisElement");
			console.log(formData);
			for (var k = 0; k < $("#qty"+ProductId).val(); k++) {
				$.ajax({
		            type: "POST",
		            url: "../../../AddProductInBox",
		            data: formData, 
		            async:false,
		            success: function(data)
			        {	
		            	if(data!="0"){
		            		barcodeArr.push($.trim(data));
		            		returnVal=true;
		            	}
			     	   else
			     		  returnVal=false
		            }
		    	});
			}
		}
	}
	if(returnVal){
		printBarcode(barcodeArr);
	}
}

function printBarcode(barArray){ console.log(barArray, barArray.length);
	$("#GeneratedChildBarcodeDiv").html('');
	var html="<div class='row'>";
	for (var i = 0; i < barArray.length; i++) {
			html+=
				"<div class='col-md-4' style='border: 1px solid;'>" +
				"<p  class='brcd' style='font-size:30px;'>"+barArray[i]+"</p>"+
				"<input type='hidden' class='barcodePrintVal' value='"+barArray[i]+"'>"+
				"</div>";
			/*if(barArray[i+1]){
				html+=	"<td style='border: 1px solid black;'>"+
				"<p  class='brcd'>"+barArray[i+1]+"</p><br>"+
				"<p>"+barArray[i+1]+"</p>"+
				"</td>";
			}if(barArray[i+1]){
				html+="<td style='border: 1px solid black;'>"+
				"<p class='brcd'>"+barArray[i+2]+"</p><br>"+
				"<p>"+barArray[i+2]+"</p>"+
				"</td>";
			}*/
			//html+="</tr>";
	}
	html+="</div>";
	document.querySelector('#GeneratedChildBarcodeDiv').insertAdjacentHTML('beforeend', html);
	$("#ViewBarcodeDiv").removeClass("HideThisElement");
	$("#boxInfoDiv").addClass("HideThisElement");
	$("#ViewBarcodeDiv .successMsg").removeClass("HideThisElement");
    $("#ViewBarcodeDiv #successMsg").html(' <strong>Success!</strong> Barcode Generated Successfully !');
}

function exportasCSV() {
	var str="";
	$('.barcodePrintVal').each(function (i) {
		str+=",'"+$($('.barcodePrintVal')[i]).val()+"'";
	});
	if($("#barcodeText").length>0) var csvName=$("#barcodeText").val();
	else var csvName=$("#GRNText").val();
	$.ajax({
    	url:"../../../ExportBarcodeAsCSV?Barcodes="+str.substr(1,str.length),
    	type:"GET",
        headers: {  'Access-Control-Allow-Origin': '*' },
    	success:function(data){
    		console.log(JSON.parse(JSON.stringify(data.data, null, 2)), data.data);
    		JSONToCSVConvertor(data.data, 'csvName.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
}