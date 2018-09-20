function dropdownFunctionForState(){	    
		    var ourRequest2 = new XMLHttpRequest();
		    var data1 = []; var url="";
		    if(window.location.href.indexOf("Warehouse.jsp")>=0){
		    	url=url='../../../GetState';
		    }else{
		    	url='../../../GetState';
		    }
		    ourRequest2.open('GET', url);
		    ourRequest2.onload = function() {
		      if (ourRequest2.status >= 200 && ourRequest2.status < 400) {
		    	data2 = JSON.parse(ourRequest2.responseText);
		        createHTML6(data2);
		      } else {
		        console.log("We connected to the server, but it returned an error.");
		      }
		    };
		    ourRequest2.onerror = function() {
		      console.log("Connection error");
		    };	
		    ourRequest2.send();
		    
		    function createHTML6(Data) {
		    	var options6= [];
		    	var selectBox2 = document.getElementById("state");
		    	var selectBox3 = document.getElementById("state");
		    	$("#newCustomerForm #state option").each(function(index, option) {
		            $(option).remove();
		       });
		    	$("#state option").each(function(index, option) {
		            $(option).remove();
		       });
		    	options6.push("<option value='' selected>Select State</option>");
		    	options6.push("<optgroup label= 'Union Territory'>");
		    
		        for (i = 0; i < Data.data.length; i++)
		        {
		        	if (Data.data[i].statetype === "Union Territory") 
		        		options6.push("<option value='" + Data.data[i].rowno + "'>" + Data.data[i].state + "</option>");
		        }
		        options6.push("<optgroup label= 'State'>");
		        for (i = 0; i < Data.data.length; i++)
		        {
		        	if (Data.data[i].statetype === "State") 
		        		options6.push("<option value='" + Data.data[i].rowno + "'>" + Data.data[i].state + "</option>");
		        }
		        $('#newCustomerForm #state').append(options6.join(""));
		        $('#state').append(options6.join(""));
		        //$('#newCustomerForm #state').material_select('enable');
		        //$( "#newCustomerForm #state" ).material_select( "refresh" );
		        
		        //$('#state').append(options6.join("")).material_select();
		        //$('#state').material_select('enable');
		        //$( "#state" ).material_select( "refresh" )
		    }
	    }