$(document).ready(function(){
	"use strict"
	
	$("#remove").on("click", function(){
		var myVal = $("div");
		_.each(myVal, function(value){
			value.remove();
		});
	});
	
	$("#add").on("click", function(){
		var where = $("span").find("span");
		var what = $("<input />");
		what.val("auto");
		where.append(what);
	});
	
	$(".autofill-action").on("click", function(){
		var where = $(".autofill-data");
		_.each(where, function(value){
			var myString = $(value).attr("data-autofill-value");
			value.text = myString;
		});
	});
});