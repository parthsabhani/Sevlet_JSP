<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<table border="1" style="text-align: center; align-items: center;">

<tr>
	<th>Student Id</th>
	<th>FirstName</th>
	<th>LastName</th>
	<th>UserName</th>
	<th>Password</th>
	<th></th>
	<th></th>
</tr>
<tr>
	<td>${model.sid}</td>
	<td>${model.firstname}</td>
	<td>${model.lastname}</td>
	<td>${model.username}</td>
	<td>${model.password}</td>
	
	<td><a href="HomeServlet.do?action=editstudent&sid=${model.sid}">Edit</a></td>
<td><a href="HomeServlet.do?action=deletestudent&sid=${model.sid}">Delete</a></td>
</tr>

</table>
<hr>
<form method="post" action="HomeServlet.do">
	<table>
		<tr>
			<td>FistName</td>
			<td><input type="text" name="firstname" value="${model.firstname }"></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><input type="text" name="lastname" value="${model.lastname }"></td>
		</tr>
		<tr>
			<td>UserName</td>
			<td><input type="text" name="username" value="${model.username }"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" value="${model.password }"><input type="hidden" name="sid" value="${model.sid }"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Update"></td>
		</tr>
	</table>
</form>
</body>
</html>