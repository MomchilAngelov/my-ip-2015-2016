$(document).ready(function() {
	"use strict";
	
	var currentActiveTaskID;
	
	var ENDPOINT = "http://localhost:3000/tasks";
	function taskEndpoint(taskId) {
		return ENDPOINT + "/" + taskId;
	}
	
	function showPanel(panelName) {
		var ALL_PANELS = ["emptyPanel", "readPanel", "updatePanel", "createPanel"];
		_.forEach(ALL_PANELS, function(nextValue) {
			$("#"+nextValue).hide("slow");
		});
		$("#"+panelName).show("fast");
	}

	function listTasks() {
		return $.ajax(ENDPOINT, {
			method: "GET",
			dataType: "json"
		});
	}
	function readTask(taskId) {
		return $.ajax(taskEndpoint(taskId), {
			method: "GET",
			dataType: "json"
		});
	}
	function showTaskView(task) {
		$("#readPanel .task-title").text(task.title);
		$("#readPanel .task-description").text(task.description);
		showPanel("readPanel");
	}
	function reloadTasks() {
		listTasks().then(function(response) {
			function addTaskToList(task) {
				var newItem = $("<li />");
				newItem.text(task.title);
				newItem.addClass("list-group-item");
				newItem.attr("data-task-id", task.id);
				$("#tasksList").append(newItem);
			}
			$("#tasksList").html("");
			_.forEach(response, addTaskToList);
		});
	}
	function attachHandlers() {
		
		//This is where it all begins
		
		//Shows the task 
		$(document).on("click", "#tasksList [data-task-id]", function() {
			var taskId = $(this).attr("data-task-id");
			readTask(taskId).then(showTaskView);
			currentActiveTaskID = taskId;
		});
		
		$(document).on("click", "#addTaskButton", function(){
			showPanel("createPanel");
		});
		
		//Add a task
		$("#createPanel").find(".task-action-ok").click(function(){
			var title = $("#createPanel").find("[name=title]").val();
			var desc = $("#createPanel").find("[name=description]").val();
			var task = {
					title: title,
					description: desc
				};
			var createPromise = $.ajax(ENDPOINT, {
				method: "POST",
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify(task),
				dataType: "json"
			}).then(function(response) {
				console.log(response);
				showPanel("emptyPanel");
				reloadTasks();
				return responce;
			});
		});
		
		
		//Press the delete button
		$(document).on("click", ".task-action-remove", function(){
			var taskID = currentActiveTaskID;
			
			var createPromise = $.ajax(taskEndpoint(taskID), {
				method: "DELETE"
			}).then(function(responce){
				showPanel("emptyPanel");
				reloadTasks();
			});
		});
		
		//Press the edit button!
		$("#readPanel").find(".task-action-ok").click(function(){
			showPanel("updatePanel");
		});
		
		//Edit
		$("#updatePanel").find(".task-action-ok").click(function(){
			var taskID = currentActiveTaskID;
			var title = $("#updatePanel").find("[name=title]").val();
			var desc = $("#updatePanel").find("[name=description]").val();
			$.ajax(taskEndpoint(taskID), {
				method: "PUT",
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify({
					title: title,
					description: desc
				}),
				dataType: "json"
			}).then(function(response) {
				showPanel("emptyPanel");
				reloadTasks();
			});
			
		})
		
		
		//Press the cancel button!
		$(document).on("click", ".task-action-cancel", function(){
			showPanel("emptyPanel");
		});
	}
	attachHandlers();
	reloadTasks();
});

