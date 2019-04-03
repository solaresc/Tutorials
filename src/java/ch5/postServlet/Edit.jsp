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
    <form method="POST" action="Controller">
        First Hobby: ${helper.errors.hobby}
        <input type="text" name="hobby" value="${helper.data.hobby}">
        <br>
        Second Hobby: ${helper.errors.hobby2}
        <input type="text" name="hobby2" value="${helper.data.hobby2}">
        <br>
        Days per week practicing hobby: ${helper.errors.daysPerWeek}
        <input type="text" name="daysPerWeek" value="${helper.data.daysPerWeek}">
        <br>
        <input type="submit" name="confirmButton" value="Confirm">
    </form>
  </body>
</html>
