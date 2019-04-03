<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Edit JSP</title>
  </head>
  <body>
      <p>
        This page is for entering data.
      </p>
    <form action="Controller">
        First Hobby: <input type="text" name="hobby" value="${param.hobby}">
        <br>
        Second Hobby: <input type="text" name="hobby2" value="${param.hobby2}">
        <input type="submit" name="confirmButton" value="Confirm">
    </form>
  </body>
</html>
