function DropDownForEmployee(id) {
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetEmployeeList?dr=true');
    ourRequest1.onload = function() {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML1(data1); createHTML2(data1); createHTML4(data1); createHTML3(data1);
        createHTML5(data1); createHTML6(data1); createClientSalesPerson(data1);
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
    	$('#SalesPerson').empty(); $("#newCustomerForm #SalesPerson").empty(); $("#newElementForm #salesPerson").empty();
        options1 = '<option value="" selected>Select Sales Person</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].designation == "106" || Data.data[i].designation =="101") {
        		options1 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
    		}
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#SalesPerson').html(options1);$("#newCustomerForm #SalesPerson").html(options1); $("#newElementForm #salesPerson").html(options1);
        //$('#SalesPerson').material_select('refresh');$("#newCustomerForm #SalesPerson").material_select('refresh');
    }
    
    function createHTML2(Data) {
    	var options2;
    	$('#depositedBy').empty();
        options2 = '<option value="" selected>Select Deposited By</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options2 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#depositedBy').html(options2);
        //$('#depositedBy').material_select('refresh');
    }
    
    function createHTML3(Data) {
    	var options3;
    	$('#cpc').empty();
        options3 = '<option value="" selected>Select CPC</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options3 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
        }
        $('#cpc').html(options3);
    }
    
    function createHTML4(Data) {
    	var options4;
    	$('#epc').empty();
        options4 = '<option value="" selected>Select EPC</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options4 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#epc').html(options4);
    }
    
    function createHTML5(Data) {
    	var options5;
    	$('#AssignedTo').empty();
        options5 = '<option value="" selected>Select Assigned To</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options5 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#AssignedTo').html(options5);
    }
    
    function createHTML6(Data) {
    	var options6;
    	$('#VisibilityTo').empty();
        options6 = '<option value="" selected>Select Visibility To</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options6 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#VisibilityTo').html(options6);
    }
    
    function createClientSalesPerson(Data) {
    	var options6;
    	$('#clientSalesPerson').empty();
        options6 = '<option value="" selected>Select Sales Person</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        		options6 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#clientSalesPerson').html(options6);
    }
    
}