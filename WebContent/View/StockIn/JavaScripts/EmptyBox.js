$(document).ready(function(){
	getEmptyBoxes(0,5);
	
	if($("#p").val()=="1")	 $("#PrintBarcodes").addClass('HideThisElement');
	else if($("#p").val()=="2")	 $("#submitRemove").addClass('HideThisElement');
	
	$("#PrintBarcodes").click(function() {
		exportasCSV();
	});
	$("#submitRemove").click(function() {
		var formData="";
		formData+="location=";
		$('.cb').each(function (i) {
			if($($('.cb')[i]).is(":checked")){
				formData+="'"+$($('.cb')[i]).val()+"',";
			}
		});
		$.ajax({
            type: "POST",
            url: "../../../RemoveEmptyBox",
            data: formData.substr(0,parseInt(formData.length)-1),
            async:false,
            success: function(data)
	        {	
            	$(".successMsg").removeClass("HideThisElement");
                $("#successMsg").html(' <strong>Error!</strong> Boxes Removed Successfully !');
                $('#ProductDataBody').html('');
                getEmptyBoxes(0, 5);
	        }
		});
	});
});

function getEmptyBoxes(start, limit) {	
	var newHtml=""; var pg="";
	var type="";
	if($("#p").val()=="1") type="&type=empty";
	else if($("#p").val()=="2")	 type="&type=absent";
	$.ajax({
		url:"../../../GetBoxBarcodeList?1=1&start="+start+"&limit="+limit+type,
		type:"GET",
		async:false,
		success:function(data){ //console.log(data);
			$('.pagination').html('');
			newHtml="";  pg="";
			pg+="<li class='page-item'><a class='page-link' onClick='getEmptyBoxes("+0+", "+5+")'>First</a></li>";
			if(start!=0 )
				pg+= "<li class='page-item'><a class='page-link' onClick='getEmptyBoxes("+parseInt(parseInt(start)-5)+", "+5+")'>Previous</a></li>";
			else
				pg+= "<li class='page-item'><a class='page-link' disabled>Previous</a></li>";
			
			for (var i = 0; i < data.data.length; i++) {
				  newHtml='<tr id="'+start+i+'productIdRow">'+
						  '<td><input type="checkbox" value="'+data.data[i].location+'"  id="'+data.data[i].location+'" class="cb" name="' + data.data[i].location + '"><label for="'+data.data[i].location+'"></label></td>'+
						  '<td>'+data.data[i].location+'</td>'+
						  '<td>'+data.data[i].floor+'</td>'+
						  '<td>'+data.data[i].aisle+'</td>'+
						  '<td>'+data.data[i].rack+'</td>'+
						  '<td>'+data.data[i].section+'</td>'+
						  '</tr>';
				  document.querySelector('#ProductDataBody').insertAdjacentHTML('beforeend', newHtml);				  
			}
			if(limit!=data.total)
				pg+= "<li class='page-item'><a class='page-link' onClick='getEmptyBoxes("+limit+", "+5+")'>Next</a></li>";
			else
				pg+= "<li class='page-item'><a class='page-link' disabled>Next</a></li>";

			pg+="<li class='page-item'><a class='page-link' onClick='getEmptyBoxes("+parseInt(parseInt(data.total)-5)+", "+5+")'>Last</a></li>";
			document.querySelector('.pagination').insertAdjacentHTML('beforeend', pg);
		}
	});
}

function exportasCSV() {
	var formData="";
	formData+="location=";
	$('.cb').each(function (i) {
		if($($('.cb')[i]).is(":checked")){
			formData+="'"+$($('.cb')[i]).val()+"',";
		}
	});
	$.ajax({
    	url:"../../../GetBoxBarcodeList?for=export",
    	data:formData.substr(0,parseInt(formData.length)-1),
    	type:"GET",
        headers: {  'Access-Control-Allow-Origin': '*' },
    	success:function(data){
    		JSONToCSVConvertor(data.data, 'barcode.csv', 'yes');
    	},
        complete: function() {
        	
        }
    });
}
