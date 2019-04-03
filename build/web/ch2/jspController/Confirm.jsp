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
    <form action="Controller.jsp"> 
          <input type="hidden" name="hobby" value="${param.hobby}">
          <input type="submit" name="editButton" value="Edit">
          <input type="submit" name="processButton" value="Process">
    </form>
    </form>
  </body>
</html>


