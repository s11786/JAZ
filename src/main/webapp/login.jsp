<%@page contentType="text/html" pageEncoding="windows-1250"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>JAVA 4 US!</title>
    </head>
    <body>
        <form action="LoginServlet" method="get">
            <table>
                <tr>
                    <td>
                        Imię :
                    </td>
                    <td>
                        <input type="text" name="name"  />
                    </td>
                </tr>
                <tr>
                    <td>
                        Hasło :
                    </td>
                    <td>
                        <input type="text" name="password"  />
                    </td>
                </tr>
            </table>
            <input type="submit" value=" OK ">
        </form>
    </body>
</html>
