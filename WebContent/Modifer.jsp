<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un user</title>
</head>
<body>
<form action="modifer" method="post" >

<input type="hidden"   name="iduser" value="${user.getIduser()}">
<br>

modifer Login <input type="text"   name="login" value="${user.getLogin()}">
<br>

modifer mode de pass <input type="text"   name="modpass" value="${user.getPwd()}" >
<br>
<button type="submit" >OK?</button>
</form>

</body>
</html>