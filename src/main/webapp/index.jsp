<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Страница входа</title>
</head>
<body>
<div style="width: 100%; height: 800px;  display: flex; justify-content: center; align-items: center; background-color: gray">
    <div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
        <form style="width: 100%; height: 100%" id="clientIdentForm" action="${pageContext.request.contextPath}/index" method="post">
            <table align="center" style="height: 100%; width: 100%; border-spacing: 10px">
                <tr>
                    <td width="50%" align="right">
                        <input type="submit" name="userLogin" value="Войти как пользователь" style="width: 400px; height: 50px; font-size: large"/>
                    </td>
                    <td width="50%">
                        <input type="submit" name="adminLogin" value="Войти как администратор" style="width: 400px; height: 50px; font-size: large"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>