<%@page contentType="text/html" pageEncoding="windows-1250"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>JAVA 4 US!</title>
    </head>
    <body>
        <form action="RegistrationServlet" method="get">
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
                        Nazwisko :
                    </td>
                    <td>
                        <input type="text" name="surname"  />
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
                <tr>
                    <td>
                        Potwierdź hasło :
                    </td>
                    <td>
                        <input type="text" name="confirmPassword"  />
                    </td>
                </tr>
                <tr>
                    <td>
                        E-mail :
                    </td>
                    <td>
                        <input type="text" name="mail"  />
                    </td>
                </tr>
                <tr>
                    <td>
                        Potwierdź e-mail :
                    </td>
                    <td>
                        <input type="text" name="confirmMail"  />
                    </td>
                </tr>
                <tr>
                    <td>
                        Gdzie pracujesz :
                    </td>
                    <td>
                        <input type="text" name="company"  />
                    </td>
                </tr>
                <tr>
                    <td>
                        Hobby :
                    </td>
                    <td>
                        <input type="text" name="hobby"  />
                    </td>
                </tr>
            </table>
             <br />
            Skąd dowiedziałeś się o konferencji?<br>
            <input type="radio" name="source"  value="anoucementFromWork" checked />Ogłoszenie w pracy <br>
            <input type="radio" name="source"  value="anoucementFromSchool" />Ogłoszenie na uczelni <br>
            <input type="radio" name="source"  value="facebook" />Facebook <br>
            <input type="radio" name="source"  value="friends" />Znajomi <br>
            <input type="radio" name="source"  value="other" />Inne (jakie?) <br>
            <input type="submit" value=" OK ">
        </form>
    </body>
</html>
