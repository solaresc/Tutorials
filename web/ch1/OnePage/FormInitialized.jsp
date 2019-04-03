<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Form Initialized JSP</title>
  </head>
  <body>
    <form>
      <p>
        This page is for entering data.
      <p>
        Hobby: <input type="text" name="hobby" value=${param.hobby}>
        <input type="submit" name="confirmButton" value="Confirm">
      <p>
          The hobby is: <strong>${param.hobby}</strong>
    </form>
  </body>
</html>

