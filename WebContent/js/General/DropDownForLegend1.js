function DropDownForLegend() {
 	var ourRequest2 = new XMLHttpRequest();
    var data2 = [];
    ourRequest2.open('GET', '../../../GetLegendList');
    ourRequest2.onload = function() {
      if (ourRequest2.status >= 200 && ourRequest2.status < 400) { 
    	  data2 = JSON.parse(ourRequest2.responseText);
    	  createHTML1(data2);createHTML2(data2);createHTML3(data2);createHTML4(data2); createHTML5(data2); customerTypeFill(data2); sourceFill(data2);
      } else {
    	  console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest2.onerror = function() {
    	console.log("Connection error");
    };
    ourRequest2.send();
    
    function createHTML1(Data) {
    	var options1;
    	$('#visitFrequency').empty();
        options1 = '<option value="" selected>Select Visit Frequency</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Visit Frequency") {
        		options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#visitFrequency').html(options1); $('#visitFrequencyForPiece').html(options1);
        //$('#visitFrequency').material_select('refresh'); $('#visitFrequencyForPiece').material_select('refresh');
    }
    
    function createHTML2(Data) {
    	var options2;
    	$('#modeOfPayText').empty();
        options2 = '<option value="" selected>Select Mode of Payment</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Mode of Payment") { 
        		options2 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#modeOfPayText').html(options2);
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
        	if (Data.data[i].category == "Designation")
        	{
        		options4 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#designation').html(options4); 
         //$('#department').material_select('refresh');  
   }
    
    function createHTML5(Data) { 
    	var options4;
    	$('#preferredDayText').empty(); 
        options5 = '<option value="">Select Preferred Day</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Preferred Day") {
        		options5 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#preferredDayText').html(options5); 
         //$('#department').material_select('refresh');  
   }
    
    function customerTypeFill(Data) {
    	var options4;
    	$('#customerType').empty(); 
        options5 = '<option value="">Select Type</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Type") {
        		options5 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#customerType').html(options5); 
         //$('#department').material_select('refresh');
   }
    
    function sourceFill(Data) {
    	var options4;
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
}