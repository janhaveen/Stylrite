$(document).ready(function(){
//	var ab=${password};
	var matched=false;
	var sessionPwd=document.querySelector('#cuntPassSession').value;
	$('#ChangePassword').on( 'focusout', '#cruntPass', function () {
		console.log(document.querySelector('#cruntPass').value);
		var Pwd=document.querySelector('#cruntPass').value;
    		if(sessionPwd==Pwd)
    		{
//    			matched=true;
    			$("#errorMessage").addClass("HideThisElement");
    			$("#successMessage").addClass("HideThisElement");
    			$("#pass").attr("disabled",false);
    			$("#cnfrmPass").attr("disabled",false);
    			$("#passLbl").removeClass("disabled");
    			$("#cnfrmPassLbl").removeClass("disabled");
    		}
    		else
			{
//    			matched=false;
    			$("#errorMessage").removeClass("HideThisElement");
    			$("#successMessage").addClass("HideThisElement");
                $("#errorMessage").html(' <strong>Error!</strong> Enter your current password !');
    			$("#pass").attr("disabled",true);
    			$("#cnfrmPass").attr("disabled",true);
    			$("#passLbl").addClass("disabled");
    			$("#cnfrmPassLbl").addClass("disabled");
			}
//    		if(matched)
//    		{
//    		}
    });
	
	$('#ChangePassword').on( 'focusout', '#cnfrmPass', function () {
    	var cnfpassword=document.querySelector('#cnfrmPass').value;
    	var password=document.querySelector('#pass').value;
    		if(cnfpassword=="" || password=="")
    		{
    			$("#errorMessage").removeClass("HideThisElement");
    			$("#successMessage").addClass("HideThisElement");
                $("#errorMessage").html(' <strong>Error!</strong> Please Enter The Password	!');
    			//toastr.error('Please Enter The Password');
    		}
    		else if(cnfpassword===password)
			{
    			$("#errorMessage").addClass("HideThisElement");
    			$("#successMessage").addClass("HideThisElement");
    			$("#changeBtn").attr("disabled",false);
			}
    		else
    		{
    			$("#errorMessage").removeClass("HideThisElement");
    			$("#successMessage").addClass("HideThisElement");
                $("#errorMessage").html(' <strong>Error!</strong> Password Did Not Match !');
    			//toastr.error('Password Did Not Match!');
    		}
			return false;
    });
	
	$("#changeBtn").click(function() {
    	var cnfpassword=document.querySelector('#cnfrmPass').value;
    	$.ajax({
            type: "POST",
            url: '../../../ChangePasswordServlet',
            data:$("#LogInForm").serialize(),
            success: function(data)
            {
                if (data.indexOf("0")>=0) {
                	$("#errorMessage").removeClass("HideThisElement");
        			$("#successMessage").addClass("HideThisElement");
                    $("#errorMessage").html(' <strong>Error!</strong> Failed to Change Password !');
                	//toastr.error('Failed to Change Password!');                	
    			} else {
    				$("#errorMessage").addClass("HideThisElement");
        			$("#successMessage").removeClass("HideThisElement");
                    $("#successMessage").html(' <strong>Success !</strong> Password Changed Successfully !');
    				setTimeout(function(){window.location='../../../index.jsp';}, 3000);
				}
            }
    	
    	});
        return false; // avoid to execute the actual submit of the form.
    });
});