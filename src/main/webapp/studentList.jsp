<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
	<c:forEach var="stu"  items = "${studentDetails}">
		
		<c:set var = "name" value = "${stu.name }"/>
		<c:set var = "age" value = "${stu.age }"/>
		<c:set var = "phone" value = "${stu.phone }"/>
		<c:set var = "password" value = "${stu.password }"/>
		
		<tr>
			<td>Student Name</td>
			<td>${stu.name}</td>
		</tr>
		
		<tr>
			<td>Student Age</td>
			<td>${stu.age}</td>
		</tr>
		
		<tr>
			<td>Student Contact No</td>
			<td>${stu.phone}</td>
		</tr>
		
		<tr>
			<td>Password</td>
			<td>${stu.password}</td>
		</tr>
		
		
	</c:forEach>
</table>


<c:url value = "studentUpdate.jsp" var = "stuUpdate">
	<c:param name= "name" value = "${name}"/>
	<c:param name= "age" value = "${age}"/>
	<c:param name= "phone" value = "${phone}"/>
	<c:param name= "password" value = "${password}"/>
</c:url>

<a href= "${stuUpdate }">
	<input type = "button" name="update" value = "update my data">
</a>

</body>


</html>