<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer un user</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>id</th>
			<th>Login</th>
			<th>Password</th>
			<th>Supprimer</th>
		</tr>
	</thead>
	<tbody>
  
  <c:forEach items="${users}" var="e">

          <tr>
              <td>${e.getIduser()}</td>
              <td>${e.getLogin()}</td>
              <td>${e.getPwd()}</td>
              <td><a  href="suprimeruser?iduser=${e.getIduser()}">Supprimer</a></td>
              
        
          </tr>
   </c:forEach>
  </tbody>
  </table> 
  

</body>
</html>