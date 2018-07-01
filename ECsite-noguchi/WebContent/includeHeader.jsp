<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" type="text/css" href="./css/includeHeader.css">
<!-- <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet"> -->

<!-- <link href="https://fonts.googleapis.com/css?family=Great+Vibes" rel="stylesheet"> -->

</head>
<header>
<div id="header">
 <ul>
     <li><a href='<s:url action="GoHomeAction"/>'>トップ</a></li>
      <li><a href='<s:url action="HomeAction"/>'>商品購入</a></li>
      <li><a href='<s:url action="UserCreateAction"/>'>ユーザー登録</a></li>
      <li><a href='<s:url action="InquiryAction"/>'>お問い合わせ</a></li>
      <li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
     </ul>
</div>
</header>
</html>