$(document).ready(function() {
	var brandData=[]; var SkuData=[];
	$.ajax({
		url:"../../../GetProductLegendList",
		data:{type:"Brand"},
		type:"GET",
		async:false,
		success:function(data){
			for (var i = 0; i < data.data.length; i++) {
				brandData.push({name:data.data[i].description, id:data.data[i].rowId, otherInfo:data.data[i].otherInfo});
			}
		}
	});
	$("#brandText" ).autocomplete({
	      minLength: 0,
	      source: brandData,
	      focus: function( event, ui ) {
	      $("#brandText").val( ui.item.name );
	        	return false;
	      },	    	 
	      select: function( event, ui ) {
		        $( "#brandText").val( ui.item.name );
		        $( "#brand" ).val( ui.item.id );
		        $( "#brandAbbr" ).val( ui.item.otherInfo );
		        return false;
	      }
    }).autocomplete( "instance" )._renderItem = function( ul, item ) {
		  return $( "<li>" )
          .append( "<div>" + item.name + "</div>" )
          .appendTo( ul );
    };
    
    
    $("#color").keypress(function(e){
    	if($("#action").val().indexOf("update")>=0){
        	var input = document.getElementById('color').value;
    	    if(e.keyCode==44) {
    	    	return false;//alert('No duplicate commas allowed!');
    	    }
    	}
	});
    
    $("#size").keypress(function(e){
    	if($("#action").val().indexOf("update")>=0){
        	var input = document.getElementById('size').value;
    	    if(e.keyCode==44) {
    	    	return false;
    	    }
    	}
	});
    
/*    $('#newProductForm').on('focusout', '#modelNo', function() {
	    var modelNo = document.querySelector('#modelNo').value;
	    //var ProductId = document.querySelector('#ProductId').value;
	    $.ajax({
    		type: "GET",
	        url: "../../../GetProductList?forDup=dup&modelNo="+modelNo+"&ProductId="+ProductId,
	        success: function(data)
	        {
				if(data.data.length>0){
	                document.querySelector('#alertMessage').innerHTML = "<center><strong>Duplicate!</strong> The Model Number You Entered Is Already In Use By " + data.data[0].employeeName + " !</center>";
	                $("#alertMessage").removeClass("HideThisElement");
	                $("#SubmitButtonUpdate").addClass("disabled");
	                $("#SubmitButtonUpdate").attr("disabled", true);
	                $("#SubmitButtonRegister").addClass("disabled");
	                $("#SubmitButtonRegister").attr("disabled", true);
		        } else {
		            $("#alertMessage").addClass("HideThisElement");
		            $("#SubmitButtonUpdate").removeClass("disabled");
		            $("#SubmitButtonUpdate").attr("disabled", false);
		            $("#SubmitButtonRegister").removeClass("disabled");
		            $("#SubmitButtonRegister").attr("disabled", false);
		        }
	        }
	    });
	});*/
    
    $("#DeleteProductConfirmed").click(function() { 
        var DeleteProductId = document.querySelector('#DeleteProductId').value;
        $.ajax({
            type: "GET",
            url: '../../../ModifyProduct?id=' + DeleteProductId,
            success: function(data) {
                if (data == 0) {
                    $('#centralModalDangerDemo').modal('hide');
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Product!');
                } else {
                    $('#centralModalDangerDemo').modal('hide');
                    $('#DeleteProductId').val('');
                    $('#ProductDatatables').DataTable().ajax.reload();
                    $(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Product Deleted Successfully!');
                }
            }
        })
        return false; // avoid to execute the actual submit of the form.
    });
    
    $("#SubmitButtonRegister").click(function() {
		formSubmit();
	});
    
    $("#SubmitButtonUpdate").click(function() {
		formSubmit();
	});
    
    $("#brand").change(function() {
    	$("#GenerateSKU").removeClass("HideThisElement");
        $("#SubmitButtonRegister").addClass("HideThisElement");
	});
    
    $("#modelNo").change(function() {
    	$("#GenerateSKU").removeClass("HideThisElement");
        $("#SubmitButtonRegister").addClass("HideThisElement");
	});
    
    $("#color").change(function() {
    	$("#GenerateSKU").removeClass("HideThisElement");
        $("#SubmitButtonRegister").addClass("HideThisElement");
	});
    $("#size").change(function() {
    	$("#GenerateSKU").removeClass("HideThisElement");
        $("#SubmitButtonRegister").addClass("HideThisElement");
	});
    
    $("#GenerateSKU").click(function() { 
    	if (document.getElementById("brand").value == "") { 
    		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Brand Name is mandatory !";
    		$("#alertMessage").removeClass("HideThisElement"); 
    	} else{
    		SkuData=GenerateSKU(); 
	    	$("#skuDiv").html('');
	    	var skuDiv="<div class='form-row'>";
	    	for (var i = 0; i < SkuData.length; i++) { 
	    		skuDiv+="<div class='col-md-3'><div class='custom-control custom-checkbox skuDi'>"+
				  		"<input type='checkbox' class='custom-control-input sku' id='customCheck"+i+"' value='"+SkuData[i].color+"'>"+
				  		"<input type='hidden' class='custom-control-input size' id='customCheck"+i+"' value='"+SkuData[i].size+"'>"+
				  		"<label class='custom-control-label' for='customCheck"+i+"'>"+SkuData[i].sku+"</label>"+
				  		"</div></div>";
			}
	    	skuDiv+="</div>";
	    	document.querySelector('#skuDiv').insertAdjacentHTML('beforeend', skuDiv);
	    	$("#GenerateSKU").addClass("HideThisElement");
	    	if($("#action").val().indexOf("insert")>=0) $("#SubmitButtonRegister").removeClass("HideThisElement");
	    	else $("#SubmitButtonUpdate").removeClass("HideThisElement");
    	}
	});
});

function formSubmit() {
	var successMsg=false; var ifDuplicate="";
	if (document.getElementById("brand").value == "") { 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Brand Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else if (document.getElementById("modelNo").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Model Number is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("color").value == "") { 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Color is mandatory !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else if (document.getElementById("size").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Size is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	}else if (document.getElementById("hsnId").value == "") { 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> HSN ID is not selected !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else if (document.getElementById("price").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Price is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	}else {
	    if ($('.sku:checked').length>0) {
	    	var pid="";
	    	var generator = new IDGenerator();
		    for (var j = 0; j < $('.sku:checked').length; j++) {
		    	var sizeStr = document.getElementById("size").value;
				var sizeStrArray = sizeStr.split(",");
				//$("#size").attr("disabled", true);
				//for (var i = 0; i < sizeStrArray.length; i++) {
					$.ajax({
						url:"../../../CheckSkuExists",
						data:{brand:$("#brand").val(), model:$("#modelNo").val(), color:$($('.sku')[j]).val(), size:$($('.size')[j]).val()},
						type:"GET",
						 async:false,
						success:function(data){ 
							if($("#action").val().indexOf("insert")>=0){
								$("#ProductId").attr("disabled", true);
								pid="P"+generator.generate();
							}
							if(data.indexOf("1")>=0){ console.log("d233h", data);
								$.ajax({
						            type: "POST",
						            url: "../../../ModifyProduct",
						            data: $("#newProductForm").serialize()+"&size="+$.trim(sizeStrArray[i])+"&ProductId="+pid+"&color="+$($('.sku')[j]).val(), 
						            async:false,// serializes the form's elements.
						            success: function(data)
						            {
						            	successMsg=true;
						            }
								});
							}else{
								if(ifDuplicate!="") ifDuplicate+=",";
								ifDuplicate+=$("#brandText").val()+"-"+$("#modelNo").val()+"-"+$($('.sku')[j]).val()+"-"+sizeStrArray[i];
							}
						}
					});
				//}
		    }
		    if (successMsg) {
				$("#alertMessage").addClass("HideThisElement");
				$("#errorMessage").addClass("HideThisElement");	
				document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Product "+$("#action").val()+"ed Successfully !";
				$("#successMessage").removeClass("HideThisElement");
				$("#SubmitButtonRegister").addClass("HideThisElement");
			    $("#SubmitButtonUpdate").addClass("HideThisElement");
			    $("#SubmitButtonBack").addClass("HideThisElement");	
			    document.getElementById("newProductForm").reset();
				setTimeout(function(){
					$("#ProductTableDiv").removeClass("HideThisElement");
					$("#ProductFormDiv").addClass("HideThisElement");							
					$('#ProductDatatables').DataTable().ajax.reload();	
				 }, 3000);		
			}
		    if(ifDuplicate!=""){
		    	document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Product "+ifDuplicate+" already exists !";
				$("#alertMessage").removeClass("HideThisElement");
		    } else if(!successMsg){						
				document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Failed to "+$("#action").val()+" Product !";
				$("#errorMessage").removeClass("HideThisElement");
			}
	    }else{
	    	document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Select SKU to "+$("#action").val()+" Product !";
			$("#errorMessage").removeClass("HideThisElement");
	    }	    
		
	}return false;
}

function GenerateSKU() {
	var skuId=[];
	if (document.getElementById("brand").value == "") { 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Brand Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else if (document.getElementById("modelNo").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Model Number is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("color").value == "") { 
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Color is mandatory !";
		$("#alertMessage").removeClass("HideThisElement"); 
	} else{
		var str = document.getElementById("color").value;
		var str1 = document.getElementById("size").value;
		var res = str.split(",");	var res1 = str1.split(",");	
		var sku="";
		for (var i = 0; i < res.length; i++) {
			for (var j = 0; j < res1.length; j++) {
				sku=document.getElementById("brandAbbr").value+"-"+document.getElementById("modelNo").value+"-"+$.trim(res[i])+"-"+$.trim(res1[j]);
				skuId.push({sku:sku, color:$.trim(res[i]), size:$.trim(res1[j])});
			}			
		}		
	}
	return skuId;
}
