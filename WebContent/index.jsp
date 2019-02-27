<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="login_user_bean" scope="session" class="beansdomain.LoginUserBean" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ショッピング風サイト ログイン画面</title>
<link href="css/shopping.css" rel="stylesheet" type="text/css" />
</head>
<body>
        <main class="login_pane">
            <h1>ようこそショッピング風サイトへ！</h1>
            <p>ログインIDとパスワードを入力して下さい</p>

            <form action="./LoginServlet" method="post">
                <table class="table_form">
                    <tbody>
                        <tr>
                            <%-- ログイン済みの場合はIDを表示 --%>
                            <th>ログインID</th>
                            <td><input type="text" name="id" value="<%=login_user_bean.getId()%>"/></td>
                        </tr>
                        <tr>
                            <th>パスワード</th>
                            <td><input type="password" name="pass"/></td>
                        </tr>
                    </tbody>
                </table>

                <div class="buttons">
                    <input class="common_button" type="submit" name="submit"  value="ログイン"/>

                    <%-- ログイン済みの場合はログアウトボタンを表示 --%>
                    <% if ("login".equals(session.getAttribute("login_state"))) { %>
                    <input class="common_button" type="submit" name="submit" value="ログアウト"/>
                    <% }%>
                </div>
            </form>
        </main>
</body>
</html>