<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Confirm JSP</title>
  </head>
  <body>
    <form action="Edit.jsp">
      <p>
          The hobby is: <strong>${param.hobby}</strong> 
          <input type="hidden" name="hobby" value="${param.hobby}">
          <input type="submit" name="confirmButton" value="Edit">
      </p>
    </form>
  </body>
</html>

