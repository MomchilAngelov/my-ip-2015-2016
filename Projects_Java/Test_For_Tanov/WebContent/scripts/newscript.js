$(document).ready(function() {
	"use strict";

	var ENDPOINT = "http://localhost:3000/cars";
	function taskEndpoint(taskId) {
		return ENDPOINT + "/" + taskId;
	}

	function listTasks() {
		return $.ajax(ENDPOINT, {
			method: "GET",
			dataType: "json"
		});
	}

	function deleteme(id){
		var createPromise = $.ajax(taskEndpoint(id), {
			method: "DELETE",
		}).then(function() {
			alert("Deleted a car");	
			dome();
		});
	}

	function dome(){
		listTasks().then(function(response) {
			function addTaskToList(task) {
				var newItem = "<tr><td>"+task.model+"</td>";
				newItem += "<td><button value='"+task.id+"'>Delete</button></td></tr>";
				$("#result").append(newItem);
			}
			$("#result").html("");
			_.forEach(response, addTaskToList);
		});
	}

	function attach(){
		$(document).on("click", "td [value]", function() {
			var taskId = $(this).attr("value");
			deleteme(taskId);
		});
	}

	dome();
	attach();
});