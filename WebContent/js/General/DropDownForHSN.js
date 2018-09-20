function DropDownForHSN() {
 	var ourRequest2 = new XMLHttpRequest();
    var data2 = [];
    ourRequest2.open('GET', '../../../GetHsnId');
    ourRequest2.onload = function() {
      if (ourRequest2.status >= 200 && ourRequest2.status < 400) { 
    	  data2 = JSON.parse(ourRequest2.responseText);
    	  createHTML1(data2);
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
    	$('#hsnId').empty();// $('#prfUnitForPiece').empty(); 
        options1 = '<option value="" selected>Select HSN ID</option>'
        for (i = 0; i < Data.data.length; i++)
        { 
        	options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].Hsnid + "</option>";
        }
        $('#hsnId').html(options1); //$('#prfUnitForPiece').html(options1);
        //$('#hsnId').material_select('refresh'); //$('#prfUnitForPiece').material_select('refresh');
    }
}