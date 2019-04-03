<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Process JSP</title>
  </head>
  <body>
      <p>
          The first hobby is: <strong>${helper.data.hobby}</strong>
      </p>
      <p>
          The second hobby is: <strong>${helper.data.hobby2}</strong>
      </p>
      <p>
          Days per week practiced is: <strong>${helper.data.daysPerWeek}</strong>
      </p>
      <form method="POST" action="Controller"> 
          <input type="submit" name="editButton" value="Edit">
      </form>
      <form method="GET" action="Controller">
      <input type="submit" name="editButton" value="New">
    </form>
    <p>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
      <core:forEach var="row" items="${database}">
        ${row.id}, 
        ${row.hobby}, 
        ${row.hobby2},
        ${row.daysPerWeek}<br>
      </core:forEach>
  </body>
</html>

