<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Process JSP</title>
  </head>
  <body>
      <p>
          The first hobby is: <strong>${bean.hobby}</strong>
      </p>
      <p>
          The second hobby is: <strong>${bean.hobby2}</strong>
      </p>
      <form action="Controller"> 
          <input type="hidden" name="hobby" value="${bean.hobby}">
          <input type="hidden" name="hobby2" value="${bean.hobby2}">
          <input type="submit" name="editButton" value="Edit">
      </form>
  </body>
</html>

