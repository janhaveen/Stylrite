function DropDownForInventoryLegend() {
 	var ourRequest2 = new XMLHttpRequest();
    var data2 = [];
    ourRequest2.open('GET', '../../../GetInventoryLegend');
    ourRequest2.onload = function() {
      if (ourRequest2.status >= 200 && ourRequest2.status < 400) { 
    	  data2 = JSON.parse(ourRequest2.responseText);
    	  fillRequisitionSampleReasons(data2);
    	  fillRequisitionSampleModeOfTrnsprt(data2);
      } else {
    	  console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest2.onerror = function() {
    	console.log("Connection error");
    };
    ourRequest2.send();
    
    function fillRequisitionSampleReasons(Data) {
    	var options1;
    	$('#reason').empty();
        options1 = '<option value="" selected>Select Reason</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Reason") {
        		options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#reason').html(options1);/* $('#visitFrequencyForPiece').html(options1);*/
        //$('#visitFrequency').material_select('refresh'); $('#visitFrequencyForPiece').material_select('refresh');
    }
    
    function fillRequisitionSampleModeOfTrnsprt(Data) {
    	var options1;
    	$('#modeOfTransport').empty();
        options1 = '<option value="" selected>Mode of Transport</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Mode Of Transport") {
        		options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#modeOfTransport').html(options1);/* $('#visitFrequencyForPiece').html(options1);*/
        //$('#visitFrequency').material_select('refresh'); $('#visitFrequencyForPiece').material_select('refresh');
    }
}