$(document).ready(function() {
	getProjectList();
	$('#projectdatatables tbody').on( 'click', '.select_me', function () {
		var data = $('#projectdatatables').DataTable().row($(this).parents('tr')).data();
		window.location.href="Menu.jsp?id="+data.rowid;
	});
});