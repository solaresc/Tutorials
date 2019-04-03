<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Confirm JSP</title>
  </head>
  <body>
      <p>
          The first hobby is: <strong>${param.hobby}</strong>
      </p>
      <p>
          The second hobby is: <strong>${param.hobby2}</strong>
      </p>
    <form action="Controller"> 
          <input type="hidden" name="hobby" value="${param.hobby}">
          <input type="hidden" name="hobby2" value="${param.hobby2}">
          <input type="submit" name="editButton" value="Edit">
          <input type="submit" name="processButton" value="Process">
    </form>
  </body>
</html>


