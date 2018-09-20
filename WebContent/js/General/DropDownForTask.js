function dropdownFunctionForTaskLegend() {
    var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetTaskLegend');
    ourRequest1.onload = function() {
        if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
            data1 = JSON.parse(ourRequest1.responseText);
            createHTML1(data1);createHTML2(data1);createHTML3(data1);createHTML4(data1);
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
        $('#Visibility').empty();
        options1 = '<option value="" selected>Select Visibility</option>'
        for (i = 0; i < Data.data.length; i++) {
            if (Data.data[i].category == "Visiblity Level") {
                options1 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
            }
        }
        $('#Visibility').html(options1);
    }
    
    function createHTML1(Data) {
        var options1;
        $('#Visibility').empty();
        options1 = '<option value="" selected>Select Visibility</option>'
        for (i = 0; i < Data.data.length; i++) {
            if (Data.data[i].category == "Visiblity Level") {
                options1 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
            }
        }
        $('#Visibility').html(options1);
    }
    
    function createHTML2(Data) {
        var options2;
        $('#Priority').empty();
        options2 = '<option value="" selected>Select Priority</option>'
        for (i = 0; i < Data.data.length; i++) {
            if (Data.data[i].category == "Priority") {
                options2 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
            }
        }
        $('#Priority').html(options2);
    }
    
    function createHTML3(Data) {
        var options3;
        $('#Status').empty();
        options3 = '<option value="" selected>Select Status</option>'
        for (i = 0; i < Data.data.length; i++) {
            if (Data.data[i].category == "Status") {
                options3 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
            }
        }
        $('#Status').html(options3);
    }
    
    function createHTML4(Data) {
        var options4;
        $('#Reminder').empty();
        options4 = '<option value="" selected>Select Reminder</option>'
        for (i = 0; i < Data.data.length; i++) {
            if (Data.data[i].category == "Reminder") {
                options4 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
            }
        }
        $('#Reminder').html(options4);
    }
}