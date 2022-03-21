<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="hello-servlet" method="post">
    <label>UserName</label>
    <input type="text" placeholder="Enter Username" name="username" required>
    <label>Password</label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <button type="submit">Login</button>
</form>
</body>
</html>