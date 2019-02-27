<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ショッピング風サイト 購入結果</title>
<link href="css/shopping.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>購入結果</h1>
	<p>
		購入しました。<img src="ThankYou.jpg" width="100" height="100" />
	</p>
	<form action="./ShoppingServlet" method="post">
		<input class="common_button" type="submit" value="一覧に戻る">
	</form>
</body>
</html>