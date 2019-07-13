$(document).ready(function(){
	$("body").on("click", "#playRound", function(){
		$.post("/playRound", function(fragment){
			console.log(fragment);
			$("#gameStats").replaceWith(fragment);
		});
	});
});