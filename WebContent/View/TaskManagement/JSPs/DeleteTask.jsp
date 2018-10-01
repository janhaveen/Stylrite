<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="centralModalDangerDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-notify modal-danger" role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header" style="background:#cc4141;">
                <p class="heading">Delete Task</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body">
                <input type="hidden" id="DeleteId" name="DeleteId">
                <div class="row">
                    <div class="col-3">
                        <p></p>
                        <p class="text-center"><img class="warningImage" src="../../../img/deleteModel.png"></p>
                    </div>
                    <div class="col-9">
                        <br>
                         <p>Task details will be deleted from system.</p>
                        <p>Click <b>'Confirm'</b> to proceed, and <b>'Close'</b> to cancel.</p>
                    </div>
                </div>
            </div>
            <!--Footer-->
            <div class="modal-footer justify-content-center">
                <a type="button" class="btn btn-primary-modal" id="DeleteConfirmed" style="background:#cc4141;">Confirm</a>
                <a type="button" class="btn btn-outline-secondary-modal waves-effect" data-dismiss="modal">Close</a>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
</body>
</html>