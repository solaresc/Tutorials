<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>First JSP</title>
  </head>
  <body>
    <form>
      <p>
        This page is for entering data.
      <p>
        Hobby: <input type="text" name="hobby" value="">
        <input type="submit" name="confirmButton" value="Confirm">
      <p>
          The hobby is: <strong>${param.hobby}</strong>
    </form>
  </body>
</html>
