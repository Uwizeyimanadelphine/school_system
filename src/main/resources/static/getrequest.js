GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#getALlStudents").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "getStudents",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,
									function(i, user) {
										var user = "Student Name  "
												+ user.username
												+ ", reg_no  = " + user.id
												+ "<br>";
										$('#getResultDiv .list-group').append(
												user)
									});
							console.log("Success: ", result);
							sessionStorage.setItem("sessionID", result);
							alert(sessionStorage.getItem("sessionID"));
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})