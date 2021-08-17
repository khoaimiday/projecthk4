<%-- 
    Document   : insertDishCategory
    Created on : Jul 28, 2021, 10:39:31 AM
    Author     : HUYNH HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        <form action="adminServlet" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"/></td>
                </tr>
            </table>
            <input type="submit" value="insertDishCategory" name="action" />
        </form>
    </body>
</html>
