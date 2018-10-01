$(document).ready(function(){
	$('#ProductDatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
    $("#ProductDatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    var actionStr="", str="?1=1"; var i=0;
    if(window.location.href.indexOf("Product.jsp")>=0){
    	actionStr='<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
	     		'<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
    	i=10;
    }else if(window.location.href.indexOf("Sample.jsp")>=0){
    	actionStr='<i class="select_me_sample select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    	i=5;
    }else if(window.location.href.indexOf("JSPs/Order.jsp")>=0){
    	actionStr='<i class="select_me_order fa fa-check fa-2x" aria-hidden="true"></i> ';
    	i=5;
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    	i=5;
    }
    
   
	var table = $('#ProductDatatables').DataTable( {
        buttons: [
            {
                text: 'New Product',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": false,
		"iDisplayLength":i,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetProductList"+str,
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "brand_text" },
            { "data": "modelNo" },
            { "data": "color" },
            { "data": "size" },
            { "data": "price" }
            
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#ProductDatatables tbody').on('click', '.edit_me', function() {
	    var data = table.row($(this).parents('tr')).data();
	    document.getElementById("newProductForm").reset();
	    DropDownForHSN();
	    document.querySelector('#ProductId').value = data.rowId;
	    
	    $("#BrandText").text(data.brand_text);
		$("#BrandText").text(data.brand_text); $("#ModelNoText").text(data.modelNo); 
		$("#ColorText").text(data.color); $("#HSNIDText").text(data.hsn_text);
		$("#SizeText").text(data.size); 	 $("#PriceText").text(data.price); 
		$("#TagsText").text(data.Tags);		$("DescriptionText").text(data.description); 
				
	    $('#brand').val(data.brand);  $('#brandText').val(data.brand_text); $('#brandAbbr').val(data.brandAbbr);
	    $('#modelNo').val(data.modelNo);	$('#size').val(data.size);  $('#price').val(data.price);
	    $('#color').val(data.color);	$('#hsnId').val(data.hsnId);     $('#tag').val(data.Tags);  $('#Description').val(data.description);
	    $("#action").val("update");
	    $("#SubmitButtonRegister").addClass("HideThisElement");
	    $("#SubmitButtonUpdate").removeClass("HideThisElement");
	    
	    $("#ProductTableDiv").addClass("HideThisElement");
		$("#ProductFormDiv").addClass("HideThisElement");
		$("#ProductViewDiv").removeClass("HideThisElement");
	});
	
	$('#editClick').click(function() {
		$("#SubmitButtonRegister").addClass("HideThisElement"); //$("#GenerateSKU").addClass("HideThisElement");
	    $("#SubmitButtonUpdate").removeClass("HideThisElement");
	    $("#SubmitButtonBack").removeClass("HideThisElement");	    
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		$("#ProductTableDiv").addClass("HideThisElement");
		$("#myTabContent").removeClass("HideThisElement");		
		$("#ProductViewDiv").addClass("HideThisElement");
		$("#ProductFormDiv").removeClass("HideThisElement");
	});
	/*
	$('#ProductDatatables tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
        document.querySelector('#ResetPassProductId').value = data.ProductloyeeId;
    	$('#centralModalWarningDemo').modal('show');
    } );*/
    
    $('#ProductDatatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteProductId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    });
});

function loadBlankform() {
	document.getElementById("newProductForm").reset();
	$("#myTabContent").removeClass("HideThisElement");		
	$("#SubmitButtonRegister").removeClass("HideThisElement");
	$("#SubmitButtonUpdate").addClass("HideThisElement");
	$("#SubmitButtonBack").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	$("#statuscheckbox").attr("disabled",true);
	$("#ProductTableDiv").addClass("HideThisElement");
	$("#ProductFormDiv").removeClass("HideThisElement");
	$("#action").val("insert");
	var generator = new IDGenerator();
	DropDownForHSN();
	//$("#selectedProductloyeeId").val("E"+ generator.generate());
}