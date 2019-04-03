<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Confirm JSP</title>
  </head>
  <body>
      <p>
          The hobby is: <strong>${param.hobby}</strong>
      </p>
    <form action="Edit.jsp"> 
          <input type="hidden" name="hobby" value="${param.hobby}">
          <input type="submit" name="confirmButton" value="Edit">
    </form>
    <form action="Process.jsp">
            <input type="hidden" name="hobby" value="${param.hobby}">
            <input type="submit" name="processButton" value="Process">
    </form>
  </body>
</html>


