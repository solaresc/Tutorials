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
        Hobby: <input type="text" name="hobby" value="${param.hobby}">
        <input type="submit" name="confirmButton" value="Confirm">
    </form>
  </body>
</html>
