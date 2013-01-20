<html>
<head>
	<title>Twitter</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js">

	</script>
	
	<script type="text/javascript">
		function blockByScreenName(){

			alert('1');
			
			var rootURL = 'http://localhost:8080/esocial/api/v1/twitter/blockoperations/block';

			alert('2');
			
			


			$.ajax({
				type: "POST",
				url: rootURL + '/' + $('#screenName').val(),
				dataType: "json"
				});


			
		}

	</script>
	
</head>

<body>
<h2>Twitter</h2>

<h5>Block By Screen Name</h5>
<input type="text" id="screenName" />
<input type="button" id="blockByScreenName" value="Block By Screen Name" onclick="blockByScreenName()">
</body>
</html>
