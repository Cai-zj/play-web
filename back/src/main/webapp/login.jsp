<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
  h1{
    margin-top: 240px;
    text-align: center;
  }
  div{
    text-align:center;width:100%;
    font-size: 18px;
    margin: 10px;

  }
  input{
    background-color: #F9F9AF;
    width: 250px;
    height: 35px;
  }
  p{
    text-align: center;width: 100%;
  }
  button{
    font-size: 18px;
    width: 155px;
    background-color: #3071a9;
    border-color: #285e8e;
    color: #fff;
  }
</style>
<html>
<head>
    <title>登录</title>
</head>
<body>

<h1>系统登录</h1>

<div>
  <c:if test="${param.error != null}">
    <p>用户名密码错误！</p>
  </c:if>
  <c:if test="${param.logout != null}">
    <p>您已注销！</p>
  </c:if>
</div>
<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post" id="loginForm">
  <div>
    <input type="text" name="username" class="username" placeholder="用户名" autocomplete="off"/>
  </div>
  <div>
    <input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false"/>
  </div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <p><button id="submit" type="submit">登录</button></p>
</form>


</body>
</html>
