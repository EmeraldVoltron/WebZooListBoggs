<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animal Lists</title>
</head>
<body>
<h2>All the lists: </h2>
<h3>Choose one to either delete, edit or add a new list.</h3>
<form method = "post" action="listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentList">
<tr>
	<td><input type="radio" name="id" value="${currentList.id}"></td>
	<td><h2>${currentList.listName}</h2></td>
</tr>
<tr><td colspan="3">Last Shift Date: ${currentList.lastShift}</td></tr>
<tr><td colspan="3">Zoo Keeper: ${currentList.zooKeeper.keeperName}</td></tr>
<c:forEach var="listVal" items="${currentList.listOfAnimals}">
<tr><td></td><td colspan="3">${listVal.species}, ${listVal.name}</td></tr>
</c:forEach>
</c:forEach>
</table>

<input type="submit" value="edit" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
</form>

<a href="addAnimalsToListServlet">Create a new List</a>
<a href="index.html">Insert a new animal</a>

</body>
</html>