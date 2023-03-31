<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type = "text/javascript">
	function checkForm(form){
		if(document.getElementById('myRadio').checked){
			return true;
		} else {
			alert("Error: No animal was selected!");
			return false;
		}
	}
</script>

<title>Zoo Animal List</title>
</head>
<body>
<h1>Animals at the zoo: </h1>
<h2>Select the animal you would like to edit, or delete. Or add another animal instead</h2>
<form method="post" onsubmit="return checkForm(this);" action="navigationServlet" >
<table>
<c:forEach items="${requestScope.allAnimals}" var="currentAnimal">
<tr>
	<td><input type="radio" name="id" id="myRadio" value="${currentAnimal.id}"></td>
	<td>${currentAnimal.species}</td>
	<td>${currentAnimal.name}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToItem">
<input type="submit" value="delete" name="doThisToItem">
</form>
<a href="index.html">Insert a new animal</a>
</body>
</html>