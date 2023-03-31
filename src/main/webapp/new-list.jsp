<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
<h2>Create a new list: </h2>
<form action = "createNewListServlet" method="post">
List Name: <input type="text" name = "listName"><br />
Zoo Keeper Name: <input type="text" name = "keeperName"><br />
Last Shift: <input type="text" name = "month" placeholder="mm"
size="4"> <input type="text" name="day" placeholder="dd" size="4">
<input type="text" name="year" placeholder="yyyy" size="4">
<br />

Available Animals: <br />

<select name="allAnimalsToAdd" multiple size="6">
<c:forEach items="${requestScope.allAnimals}" var="currentAnimal">
	<option value = "${currentAnimal.id}">${currentAnimal.name} | ${currentAnimal.species}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create list and Add Animals">
</form>
<a href="index.html">Go add new animals instead.</a>

</body>
</html>