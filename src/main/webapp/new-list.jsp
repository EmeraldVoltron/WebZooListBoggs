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
<title>Create a new list</title>
</head>
<body>
<h2>Create a new list: </h2>
<form action = "createNewListServlet" method="post" onsubmit="return checkForm(this);">
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