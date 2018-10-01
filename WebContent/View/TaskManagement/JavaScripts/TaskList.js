$(document).ready(function(){
	$('#taskDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
    $("#taskDatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
	var table = $('#taskDatatables').DataTable( {
        buttons: [
            {
                text: 'New Task',
                action: function ( e, dt, node, config ) {
                	loadBlankformForTask();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetTaskList",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '                 
             },
            { "data": "taskName" },
            { "data": "startDate" },
            { "data": "endDate" },
            { "data": "assignedTo_txt" },
            { "data": "priority_txt" },
            { "data": "status_txt" },
            { "data": "desc" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        "initComplete": function(settings, json) {                	
        	$(function () {
        	    $('[data-toggle="popover"]').popover()
        	})
        },
        fixedColumns: true
    });
	
	$('#taskDatatables tbody').on('click', '.select_me', function() {
	    var data = table.row($(this).parents('tr')).data();
	    document.getElementById("TaskForm").reset();
		$("#SubmitButtonRegister").addClass("HideThisElement");
		$("#SubmitButtonUpdate").removeClass("HideThisElement");
		$("#SubmitButtonBack").removeClass("HideThisElement");	
	    
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		
		$("#action").val("update");
		dropdownFunctionForTaskLegend();
		DropDownForEmployee("");
		
		$("#TaskNameId").text(data.taskName); 
		$("#StartDateText").text(data.startDate);	$("#EndDateText").text(data.endDate);
		$("#AssignedToText").text(data.assignedTo_txt);	$("#VisibilityText").text(data.visibility_txt);
		$("#VisibilityToText").text(data.visibleTo_txt);
		$("#PriorityText").text(data.priority_txt);	$("#StatusText").text(data.status_txt);
		$("#TaskDescriptionText").html(data.description);
		
		$("#TaskId").val(data.TaskId); 
		$("#taskNameOld").val(data.taskName);  $("#taskName").val(data.taskName); 
		$("#StartDateOld").val(data.startDate); $("#StartDate").val(data.startDate);
		$("#EndDateOld").val(data.endDate);		$("#EndDate").val(data.endDate);
		$("#AssignedToOld").val(data.assignedTo);	$("#AssignedTo").val(data.assignedTo);	
		$("#VisibilityOld").val(data.visibility);	$("#Visibility").val(data.visibility);
		$("#VisibilityToOld").val(data.visibleTo); 	$("#VisibilityTo").val(data.visibleTo);
		$("#PriorityOld").val(data.priority);	$("#Priority").val(data.priority);
		$("#StatusOld").val(data.status); 	$("#Status").val(data.status);
		$("#taskDescriptionOld").val(data.description); $("#taskDescription").val(data.description);
		
		getCommentsHistory(data.TaskId, 0, 1);
		
		$("#statusDivView").html(data.StatusBtn);
		$("#O1").css('padding-left','20%');		
		
	    $("#TaskTableDiv").addClass("HideThisElement");
		$("#TaskViewDiv").removeClass("HideThisElement");
		$("#TaskFormDiv").addClass("HideThisElement");
	});
	
	$('#editClick').click(function() {
		$("#SubmitButtonRegister").addClass("HideThisElement");
	    $("#SubmitButtonUpdate").removeClass("HideThisElement");
	    $("#SubmitButtonBack").removeClass("HideThisElement");	    
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		$("#TaskTableDiv").addClass("HideThisElement");
		$("#TaskViewDiv").addClass("HideThisElement");
		$("#TaskFormDiv").removeClass("HideThisElement");
	});
	
	/*$('#taskDatatables tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
        document.querySelector('#ResetPassTaskId').value = data.TaskloyeeId;
    	$('#centralModalWarningDemo').modal('show');
    } );
    
    $('#taskDatatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteTaskId').value = data.TaskloyeeId;
    	$('#centralModalDangerDemo').modal('show');
    });*/
});

function loadBlankformForTask() {
	document.getElementById("TaskForm").reset();
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	$("#TaskTableDiv").addClass("HideThisElement");
	$("#TaskFormDiv").removeClass("HideThisElement");
	$("#TaskViewDiv").addClass("HideThisElement");
	$("#TaskForm #action").val("insert");
	dropdownFunctionForTaskLegend();
	DropDownForEmployee("");
	var generator = new IDGenerator();
	$("#TaskId").val("T"+ generator.generate());
	$("#Status").val("123124567411");
}

function getCommentsHistory(rowId, start, isRefresh, e) {	
	$.ajax({
		url:"../../../GetCommentsHistoryForTask?TaskId="+rowId+"&start="+start+"&limit=5",
		type:"GET",
		success:function(data){ 
			if(e)	e.preventDefault();
			if(data!=0){
				var str="";$('#lm').html('');
				if(isRefresh==1)$('#remarksDiv').html('');
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', data);
				//$('#remarksDiv').append(data);
				str="<div id='lm'><a href='#' onclick='getCommentsHistory(\""+rowId+"\", "+(parseInt(start)+5)+",0, "+$(this).event+");'>Load More . . .</a></div>";
				document.querySelector('#remarksDiv').insertAdjacentHTML('afterend', str);
				$(document).scrollTop($(document).height());

		        var firstMsg = $('#remarksDiv .card:first');
		        // Store current scroll/offset
		        var curOffset = firstMsg.offset().top - $(document).scrollTop();
		        
		        // Add your new messages
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		       
		        $(document).scrollTop(firstMsg.offset().top-curOffset);

			}else if(data==0){ 
				$('#lm').html('');
				$(document).scrollTop($(document).height());

		        var firstMsg = $('#remarksDiv .card:first');
		        // Store current scroll/offset
		        var curOffset = firstMsg.offset().top - $(document).scrollTop();
		        
		        // Add your new messages
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		        firstMsg.before($('#remarksDiv .card').eq(5).clone());
		       
		        $(document).scrollTop(firstMsg.offset().top-curOffset);
			}
		}
	});
}