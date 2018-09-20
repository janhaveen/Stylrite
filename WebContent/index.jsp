<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Log In</title>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://localhost:8080/Stylrite/css/Bootstrap/login.css">
    <!-- Font Awesome -->
    <!-- <link rel="stylesheet" href="css/fontawesome-all.css">
    Bootstrap core CSS
    <link href="css/bootstrap.min.css" rel="stylesheet">
    Material Design Bootstrap
    <link href="css/mdb.min.css" rel="stylesheet">
    Your custom styles (optional)
    <link href="css/style.css" rel="stylesheet"> -->
    
    <link rel="shortcut icon" href="img/TitleImage.png">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
  </head>
<body id="LoginForm">
<div class="container">
<img style="width: 24%;margin: 0% 39%;" src="http://localhost:8080/Stylrite/img/CompanyLogo.png" class="CompanyLogo">
<div class="login-form">
<div class="main-div">
    <div class="panel">
     <h2>Sign In</h2>
   	  <p>Please enter your Username and Password</p>
    	<form id="LogInForm">
            <div class="form-group">
               <i class="fas fa-user prefix"></i>
               <input type="text" id="userId" placeholder="Username" name="userId" class="form-control">
               <!-- <label for="userId"></label> -->
           </div>

            <div class="form-group">
               <i class="fas fa-key prefix fa-flip-horizontal"></i>
               <input type="password" id="password" placeholder="Password" name="password" class="form-control">
              <!--  <label for="password">Your Password</label> -->
           </div>

           <div class="text-center">
              <!--  <fieldset class="form-group">
                   <input type="checkbox" id="checkbox2">
                   <label for="checkbox2">Remember me</label>
               </fieldset> -->
               <button class="btn btn-primary" id="SignInButton">Sign in</button>
           </div>
           <!-- <div class="text-center">
               <p><a href="#">Forgot Your Password?</a></p>
           </div> -->
        </form>
    </div>
 </div>
</div>
</div>
<!-- 	<!-- <main id="mainContainer">
        <div class="container" >
            Signup or Login
            <section class="section mt-3">
                <div class="row">

                    <div class="col-lg-6 mx-auto">
                        
                    </div>
                </div>
            </section>


        </div>
        /.Main Container
    </main> -->
   <!--  <div class="container">
    	<div class="col-md-12" style="padding: 8% 18%;">
    		<div class="card">
                <div class="card-body">

                    Header
                    <div class="form-header">
                        <h3>Sign In</h3>
                    </div>
                    
                    <form id="LogInForm">
                    <div class="md-form">
                        <i class="fas fa-user prefix"></i>
                        <input type="text" id="userId" name="userId" class="form-control">
                        <label for="userId">Your User Name</label>
                    </div>

                    <div class="md-form">
                        <i class="fas fa-key prefix fa-flip-horizontal"></i>
                        <input type="password" id="password" name="password" class="form-control">
                        <label for="password">Your Password</label>
                    </div>

                    <div class="text-center">
                        <fieldset class="form-group">
                            <input type="checkbox" id="checkbox2">
                            <label for="checkbox2">Remember me</label>
                        </fieldset>
                        <button class="btn btn-primary" id="SignInButton">Sign in</button>
                    </div>
                    <div class="text-center">
                        <p><a href="#">Forgot Your Password?</a></p>
                    </div>
                    </form>

                </div>
            </div>
    	</div>
    </div> -->
	
    <!-- /Start your project here-->

    <!-- SCRIPTS -->
    <!-- JQuery -->
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
	
	<script type="text/javascript">
	$(function() {
	    $("#SignInButton").click(function() {
	    	var url = "LogIn"; // the script where you handle the form input.
	        $.ajax({
	               type: "POST",
	               url: url,
	               data: $("#LogInForm").serialize(), // serializes the form's elements.
	               success: function(data)
	               {
	            	   // show response from the servlet.
	            	   if (data == 0) {
	            		   toastr.error('User Name or Password is Incorrect!');
	            		   
						} else {
							location='StartSession?department='+data;
						}
	               }
	             });
	        return false; // avoid to execute the actual submit of the form.
	    });
	  });
	</script>
</body>

</html>
