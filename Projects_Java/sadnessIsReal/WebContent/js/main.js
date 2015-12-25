$(document).ready(function(){
	$("table").append("<tr><td class='number'>5</td><td class='name'>Georgi</td></tr>");


	$("#clicker").click(function(){
		$(this).remove();
		$(".name").remove();
		$(".number").remove();
		$(".die").css("background-color", "red");
		$(".die").css("color", "blue");
		$("table").remove();
		$("#kill-table").remove();
		$("ul li").remove();
	});
	
	$("#mountainRemover").on(
		//"mouseover", function(){
		//	alert("Removing mountains");
		//}
		"click",function(){
			$("#mountains").remove();
			$(this).remove();
		}
	);
	
	$("#addMountain").on("click", function(){
		var newMountainElement = $("<li />");
		var newMountainName = ("#mountainNameInput").val("");
		
		$("#mountains").append(newMountainElement);
	});

});