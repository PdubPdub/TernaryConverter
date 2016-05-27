$(document).ready(function(){
		$(".aboutMe").hide();
		$(".ternary").hide();
		
		$(function(){
			$("#aboutMe").click(function() {
				$(".aboutMe").show();
				$(".ternary").hide();
			});
			$("#ternary").click(function() {
				$(".aboutMe").hide();
				$(".ternary").show();
			});
		});
		
		$(".aboutMe").append("My Name is Patrick J. Walton and I am a recent graduate of the computer programmer diploma program at Sheridan College in Oakville, Ontario.");
		
	});