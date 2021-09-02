<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
  <form method="post" action="login.jsp?action=login">
    <table>
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <input type="hidden" name="origin_uri" value="${requestScope.origin_uri}">
      </tr>
      <tr>
        <td><input type="reset" value="重填"></td>
        <td><input type="submit" value="提交"></td>
      </tr>
    </table>
  </form>
</body>
</html>
