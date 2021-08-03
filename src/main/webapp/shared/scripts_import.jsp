
<!-- BS4 JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<!-- VENOBOX JS     -->
<script src="${pageContext.request.contextPath}/js/venobox.min.js"></script>
<script>
	$(document).ready(function() {
		$('.venobox').venobox();
	});
</script>

<!-- MAIN JS -->
<script>
	window.onscroll = function() {
		if (document.body.scrollTop > 200
				|| document.documentElement.scrollTop > 200) {
			// translate(-50%,0)
			document.getElementById("headerFixed").style.transform = "translate(-50%,0)";
		} else {
			document.getElementById("headerFixed").style.transform = "translate(-50%,-100%)";
		}
	}
</script>