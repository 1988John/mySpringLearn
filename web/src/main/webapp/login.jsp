
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>测试spring websocket</title>
    <!--
	<link rel="stylesheet" href="/css/style.css"/>
	<script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript">
    </script>
    -->
</head>
<body>

<form action="${ctx}/websocket/login">
    登录名：<input type="text" name="username"/>
    <input type="submit" value="登录聊天室"/>
</form>

</body>
</html>
