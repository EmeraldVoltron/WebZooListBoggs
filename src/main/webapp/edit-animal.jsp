<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Animal</title>
</head>
<body>
<h1>Edit your animals here: </h1>
<form action="editAnimalServlet" method="post">
Species: <input type ="text" name="species" value="${animalToEdit.species}">
Animal's Name: <input type="text" name="name" value="${animalToEdit.name}">
<input type="hidden" name="id" value="${animalToEdit.id}">
<input type="submit" value="Saved Edited Animal">
</form>

</body>
</html>