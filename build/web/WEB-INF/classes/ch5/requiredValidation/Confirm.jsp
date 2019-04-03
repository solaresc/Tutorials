<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Confirm JSP</title>
  </head>
  <body>
      <p>
          The first hobby is: <strong>${helper.data.hobby}</strong>
      </p>
      <p>
          The second hobby is: <strong>${helper.data.hobby2}</strong>
      </p>
      <p>
          Days per week practiced is: <strong>${helper.data.daysPerWeek}</strong>
      </p>
    <form action="Controller"> 
          <input type="submit" name="editButton" value="Edit">
          <input type="submit" name="processButton" value="Process">
    </form>
  </body>
</html>


