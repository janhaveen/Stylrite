function DropDownForLegend() {
 	var ourRequest2 = new XMLHttpRequest();
    var data2 = [];
    ourRequest2.open('GET', '../../../GetLegendList');
    ourRequest2.onload = function() {
      if (ourRequest2.status >= 200 && ourRequest2.status < 400) { 
    	  data2 = JSON.parse(ourRequest2.responseText);
    	 createHTML3(data2);createHTML4(data2); createHtmlForTypeOfWh(data2);
    	 customerTypeFill(data2); sourceFill(data2);
    	 invoiceTypeFill(data2); modeOfPaymentFill(data2);
      } else {
    	  console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest2.onerror = function() {
    	console.log("Connection error");
    };
    ourRequest2.send();
    
    function createHtmlForTypeOfWh(Data) { 
    	var options1;
    	$('#typeOfBr').empty(); 
        options1 = '<option value="">Select Warehouse Type</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Warehouse Type") {
        		options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#typeOfBr').html(options1); 
        // $('#department').material_select('refresh');  
   }
    
    function createHTML3(Data) { 
    	var options3;
    	$('#department').empty(); 
        options3 = '<option value="">Select Department</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Department") {
        		options3 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#department').html(options3); 
        // $('#department').material_select('refresh');  
   }
    
    function createHTML4(Data) { 
    	var options4;
    	$('#designation').empty(); 
        options4 = '<option value="">Select Designation</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Designation") {
        		options4 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#designation').html(options4); 
         //$('#department').material_select('refresh');  
   }
    
    
    function customerTypeFill(Data) {
    	var optionsType;
    	$('#customerType').empty(); 
        optionsType = '<option value="">Select Type</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Type") {
        		optionsType += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#customerType').html(optionsType); 
         //$('#department').material_select('refresh');
   }
    
    function sourceFill(Data) {
    	var options5;
    	$('#source').empty(); 
        options5 = '<option value="">Select source</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Lead Source") {
        		options5 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#source').html(options5); 
         //$('#department').material_select('refresh');
   }
    
    function invoiceTypeFill(Data) {
    	var options5;
    	$('#invoiceType').empty(); 
        options5 = '<option value="">Select Invoice Type</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Invoice Type") {
        		options5 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#invoiceType').html(options5); 
         //$('#department').material_select('refresh');
   }
    
    function modeOfPaymentFill(Data) {
    	var options5;
    	$('#modeOfPayment').empty(); 
        options5 = '<option value="">Select Mode Of Payment</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Mode Of Payment") {
        		options5 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#modeOfPayment').html(options5); 
         //$('#department').material_select('refresh');
   }
    
    
}