
$(document).ready(function () {

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

            notifySuccess(projectPayload);

		},

		error: function (jqXHR, status) {

			console.log("error during request /",jqXHR);

            notifyFailure(projectPayload);

		}

	});

}

function notifySuccess(projectPayload) {

    alert("project created!");

}

function notifyFailure(projectPayload) {

    alert("error creating project.");

}

//////////////////////////////////////////
