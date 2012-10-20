<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<meta charset="utf-8">
<title>add User</title>

<h1>User Registration</h1>

<c:if test="${error != null}"><p class="error">${error}</p></c:if>

<form action="create" method="post">
	<table>
		<tr>
			<th>Name</th>
			<td><input type="text" name="name" value="${param.name}"></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><input type="text" name="email" value="${param.email}"></td>
		</tr>
	</table>
	<input type="submit" value="send">
</form>
