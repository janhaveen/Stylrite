function dropdownFunctionForManager() {
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetEmployeeList?dr=true');
    ourRequest1.onload = function() {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML1(data1); 
      } else {
        console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest1.onerror = function() {
      console.log("Connection error");
    };
    ourRequest1.send();
    
    function createHTML1(Data) {
    	var options1;
    	$('#reportTo').empty(); 
        options1 = '<option value="" selected>Select Supervisor</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].designation_desc == "Manager" || 
        			Data.data[i].designation_desc == "EPC" || 
        				Data.data[i].department_desc== "Management") {
        		options1 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
    		}
        }
        $('#reportTo').html(options1);
    }
}