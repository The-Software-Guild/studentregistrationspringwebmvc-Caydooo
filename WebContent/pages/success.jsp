<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
</head>
<body>
	Registered Successfully!!!<br/>
	Your details are:<br/>
	Name: ${s.getName()}<br/>
	Age: ${s.getAge()}<br/>
	Mobile Number: ${s.getMobile()}<br/>
	Address: ${s.getAddress()}<br/>
</body>
</html>