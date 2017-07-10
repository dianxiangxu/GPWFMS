var logIn = '';
$(function() {

	// alert(userProfileId + " From Login.jsp")
	if (isAdmin == "false") {
		if (userProfileId != "null") {
			window.location = 'Home.jsp';
		}
	} else {
		if (userProfileId != "null") {
			window.location = 'Dashboard.jsp';
		}
	}

	var validator = $('#form1')
			.validate(
					{
						rules : {
							//changes here
							username : {
								required : true,
								minlength : 3
							},
							password : {
								required : true,
								minlength : 8,
								maxlength : 64
							}
						},

						errorElement : "label",
						messages : {
							username : {
								required : "Please enter a username",
								minlength : "Your username must be at least 3 characters long"
							},
							password : {
								required : "Please provide a password",
								minlength : "Your password must be between 8 and 64 characters",
								maxlength : "Your password must be between 8 and 64 characters"
							}
						},
						//end changes 
						submitHandler : function(form, event) {
							if ($("#remember_me").is(':checked')) {
								toMem();
							}
							// else {
							// delMem();
							// }
							form.submit();
							event.preventDefault();
						}
					});
});