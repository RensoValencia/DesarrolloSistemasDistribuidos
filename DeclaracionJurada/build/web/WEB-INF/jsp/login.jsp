<%-- 
    Document   : login
    Created on : 29-ene-2017, 13:10:11
    Author     : RENSO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Loguearse en el sistema</h2>
        <spring:form method="post" commandName="account" action="login.html">
            ${message}
            <table border="0" cellpadding="3" cellspacing="2">
                
                <tr>
                    <td>Username</td>
                    <td><spring:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><spring:input path="password" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="login" /></td>
                </tr>  
            </table>
        </spring:form>
    </body>
</html>
