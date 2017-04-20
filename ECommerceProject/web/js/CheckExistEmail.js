$("#email").blur(function(){
	var email = $("#email").val();
	$.ajax({
		url: 'ajax/admin/check-email-exists',
		type: 'GET',
		dataType: 'text',
		data: email,
		success: function (res) {
                if(res){
				$("#emailErrorMessage").html('Email đã tồn tại trong database');
			}
		}
	});
 });
               
               