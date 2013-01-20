<html>
<head>
<title>Employee</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.0.min.js">
	
</script>

<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/components/core-min.js"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/components/enc-utf16-min.js"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/components/enc-base64-min.js"></script>

<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/hmac-md5.js"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/hmac-sha1.js"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/hmac-sha256.js"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/hmac-sha512.js"></script>


<script type="text/javascript">
	//should never be send in request
	var publicKey = 'api-1234';
	//to be generated randomly for each request
	var salt = "hmaciscool";
	//should always be send in request
	var privateKey = "api-pk-9999";

	function findOne(){
		var signature =  CryptoJS.HmacSHA256(salt, privateKey);

		var base64 = CryptoJS.enc.Base64.stringify(signature);

		var rootURL = 'http://localhost:8080/restapi/api/v1/employee/operations/findone';


		$.ajax({
			type : 'GET'
				,
			
			beforeSend: function (request)
            {
                request.setRequestHeader("apikey", publicKey);
                request.setRequestHeader("salt", salt);
                request.setRequestHeader("signature", base64);
            },
			
			
			contentType : 'application/json',
			url: rootURL + '/' + $('#empId').val(),
			
			success : function(data, textStatus, jqXHR) {
				alert('Employee found successfully - = ' + data);
				
			},
			error : function(jqXHR, textStatus, errorThrown) {
				
				alert('Employee find error : ' + errorThrown);
			}

		});

	}
	

	function save() {

		var signature =  CryptoJS.HmacSHA256(salt, privateKey);

		var base64 = CryptoJS.enc.Base64.stringify(signature);
		
		
		var rootURL = 'http://localhost:8080/restapi/api/v1/employee/operations/create';

		$.ajax({
			type : 'POST'
				,
			
			beforeSend: function (request)
            {
                request.setRequestHeader("apikey", publicKey);
                request.setRequestHeader("salt", salt);
                request.setRequestHeader("signature", base64);
            },
			
			
			contentType : 'application/json',
			dataType : "json",
			url: rootURL,
			data: formToJSON(),
			success : function(data, textStatus, jqXHR) {
				alert('Employee created successfully - id = ' + data.id);
				
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Employee create error: ' + textStatus);
				alert('Employee create errorThrown: ' + errorThrown);
			}

		});

	}


	// Helper function to serialize all the form fields into a JSON string
	function formToJSON() {
	    return JSON.stringify({
	        "firstName": $('#firstName').val(),
	        "lastName": $('#lastName').val()
	       
	        });
	}
</script>

</head>

<body>
	<h2>User</h2>

	<h5>New Employee</h5>
	<span>First Name</span>
	<input type="text" id="firstName" />
	<br/>
	<span>Last Name</span>
	<input type="text" id="lastName" />
	<br/>
	<input type="button" id="createUser" value="Save" onclick="save()">
	
	<br/>
	<h5>Find Employee</h5>
	<span>Enter Emp #</span>
	<input type="text" id="empId" />
	<br/>
	<input type="button" id="createUser" value="Find" onclick="findOne()">
</body>
</html>
