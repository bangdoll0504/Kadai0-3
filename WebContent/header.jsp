<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="css/shopping.css" rel="stylesheet" type="text/css" />

<%-- header --%>
<header>
    <%-- ログイン済みの場合はID を表示 --%>
    <p>
        ようこそ「<jsp:getProperty name="login_user_bean" property="name" />」さん！
        <%-- Getのクエリで購入履歴かログアウトか判断させる --%>
        <a href="ShoppingServlet?submit=history">購入履歴</a>
        <a href="LoginServlet?submit=logout">ログアウト</a>
    </p>
</header>