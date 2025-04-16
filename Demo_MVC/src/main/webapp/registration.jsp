<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
${msg}
<form method="post" action="RegistrationServlet">
	<table>
		<tr>
			<td>FistName</td>
			<td><input type="text" name="firstname"></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><input type="text" name="lastname"></td>
		</tr>
		<tr>
			<td>UserName</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Registration"></td>
		</tr>
	</table>
</form>
</body>
</html>