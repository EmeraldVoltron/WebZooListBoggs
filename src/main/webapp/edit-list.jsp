<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type = "text/javascript">
	function checkForm(form){
		if(form.listName.value == ""){
			alert("Please provide a list name" );
			document.myForm.species.focus();
			return false;
		}
		if(form.keeperName.value == ""){
			alert("Please provide the Zoo Keeper's name");
			document.myForm.name.focus();
			return false;
		}
		if(form.month.value == "" || isNaN(form.month.value)){
			alert("Please provide the month of last shift in number fomr mm");
			document.myForm.name.focus();
			return false;
		}
		if(form.day.value == "" || isNaN(form.day.value)){
			alert("Please provide the day of last shift in number form dd");
			document.myForm.name.focus();
			return false;
		}
		if(form.year.value == "" || isNaN(form.year.value)){
			alert("Please provide the year of last shift in number form yyyy.");
			document.myForm.name.focus();
			return false;
		}
		return(true);
	}
</script>
<title>Edit Animal Lists</title>
</head>
<body>
<h2>Edit the list using the fields below: </h2>
<form action="editZooListDetailsServlet" method="post" onsubmit="return checkForm(this);">
<input type="hidden" name="id" value= "${listToEdit.id}">
List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br />

Zoo Keeper Name: <input type="text" name="keeperName" value="${listToEdit.zooKeeper.keeperName}"><br />
Last Shift: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
<input type="text" name="day" placeholder="dd" size="4" value="${date}">
<input type="text" name="year" placeholder="year" size="4" value="${year}">
<br />

Available Animals: <br />
<select name="allAnimalsToAdd" multiple size="6">
<c:forEach items="${requestScope.allAnimals}" var="currentAnimal">
	<option value="${currentAnimal.id}">${currentAnimal.species} | ${currentAnimal.name}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Edit List and Add Animals">
</form>
<a href="index.html">Go add new Animals instead.</a>

</body>
</html>