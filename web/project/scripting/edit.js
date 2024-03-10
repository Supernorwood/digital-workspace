
$(document).ready(function () {
    
    alert("edit.js");

	clearForm();

});

function clearForm(){

    $("#name").val("");

    $("#description").val("");

    $("#client").val("");

    $("#intention").val("");

}

function processForm() {

	console.debug("enter > processForm");	

	projectPayload = JSON.stringify({

		name: $("#name").val(),

		description:  $("#description").val(),

		client:  $("#client").val(),

		intention:  $("#intention").val(),

	});

	console.debug("projectPayload / ", projectPayload);

	$.ajax({

		type: "PUT",

		url: apiURLBase + "/project/",

		data: projectPayload,

		contentType: "application/json; charset=utf-8",

		crossDomain: true,

		dataType: "text",

		success: function (data, status, jqXHR) {

			clearForm();

            notifySaveSuccess(projectPayload);

		},

		error: function (jqXHR, status) {

			console.log("error during request /",jqXHR);

            notifySaveFailure(projectPayload);

		}

	});

}

function notifySaveSuccess(projectName) {

    toastr.success(

        'Project Created',

        'The project "'+ projectName +'" was created.',

        {timeOut: 5000});

}

function notifySaveFailure(projectName) {

    toastr.error(

        'Project Creation Failure',

        'The project "'+ projectName +'" WAS NOT created.',

        {timeOut: 5000}

    );   

}
