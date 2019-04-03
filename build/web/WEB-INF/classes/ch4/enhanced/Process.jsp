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
      <form action="Controller"> 
          <input type="submit" name="editButton" value="Edit">
      </form>
  </body>
</html>

