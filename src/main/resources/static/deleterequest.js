$(document).ready(
		function() {

			// GET REQUEST
			$("#deleteStudent").click(function(event) {
				event.preventDefault();
				ajaxDelete();
			});
function ajaxDelete() {
  $.ajax({
    type: "DELETE",
    url: "delete",
    success: function () {
      var msg = "delete successful";
      console.log(msg);
      htmlOutput(msg);
    },
  });
}