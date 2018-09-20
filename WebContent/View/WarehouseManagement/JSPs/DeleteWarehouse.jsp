<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="centralModalDangerDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-notify modal-danger" role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header" style="background:#cc4141;">
                <p class="heading">Delete Warehouse</p>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true" class="white-text">&times;</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body">
                <input type="hidden" id="DeleteWhId" name="DeleteWhId">
                <div class="row">
                    <div class="col-3">
                        <p></p>
                        <p class="text-center"><img class="warningImage" src="../../../img/deleteModel.png"></p>
                    </div>
                    <div class="col-9">
                        <br>
                        <p>Warehouse details will be deleted from system.</p>
                        <p>Click 'Confirm' to proceed, and 'Close' to cancel.</p>
                    </div>
                </div>
            </div>
            <!--Footer-->
            <div class="modal-footer justify-content-center">
                <a type="button" class="btn btn-primary-modal" id="DeleteWarehouseConfirmed" style="background:#cc4141;">Confirm</a>
                <a type="button" class="btn btn-outline-secondary-modal waves-effect" data-dismiss="modal">Close</a>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
</body>
</html>