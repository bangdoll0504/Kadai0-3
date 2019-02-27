<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList"%>
<%@ page import="beansdomain.HistoryBean"%>
<jsp:useBean id="login_user_bean" scope="session" class="beansdomain.LoginUserBean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ショッピング風サイト 購入履歴</title>
        <link href="css/shopping.css" rel="stylesheet" type="text/css" />
</head>
<body>
       <jsp:include page="header.jsp"/>

        <h1><jsp:getProperty name="login_user_bean" property="name" />さんの購入履歴</h1>
        <%-- ShoppingServletで付加したattribute: historyをリクエストスコープからBeanクラスのListを取得 --%>
        <% ArrayList<HistoryBean> historyList = (ArrayList<HistoryBean>) request.getAttribute("history"); %>
        <table class="table_list">
            <tbody>
                <tr>
                    <th>商品ID</th>
                    <th>商品名</th>
                    <th>購入数</th>
                </tr>

                <%-- リクエストスコープから表示する値を取得 --%>
                <% for (HistoryBean bean : historyList) {%>
                <tr>
                    <%-- 商品ID --%>
                    <td><%= bean.getItemId()%></td>
                    <%-- 商品名 --%>
                    <td><%= bean.getItemName()%></td>
                    <%-- 数量（在庫） --%>
                    <td class="int"><%= bean.getQuantity()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <form action="./ShoppingServlet" method="post">
            <input class="common_button" type="submit" value="一覧に戻る">
        </form>
</body>
</html>