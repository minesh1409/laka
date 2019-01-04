<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">
     var auto = setInterval(    function ()
     {
          $('#created').load('datetime.jsp').fadeIn("slow");
     }, 1000); // refresh every 5000 milliseconds
</script>
</head>
<body>
<h1>Unauthorized User</h1>
<p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p>
<div id='created'></div>
<div>There was an unexpected error (type=Unauthorized User, status=401).</div>
<div>No message available</div></body>
</body>
</html>