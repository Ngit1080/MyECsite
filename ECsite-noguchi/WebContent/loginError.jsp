<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>LoginOut画面</title>

<link rel="stylesheet" type="text/css" href="./css/table_style.css">

</head>
<body>
<!-- ヘッダー -->
<jsp:include page="includeHeader.jsp"/>

    <div id="main">
           <div id="top">
                   <p>LoginError</p>
           </div>
           <div>
                   <h3>ログインIDかパスワードに誤りがあります。</h3>
                   <s:form action="LoginAction">
                         <s:textfield name="loginUserId"/>
                         <s:password name="loginPassword"/>
                         <s:submit value="ログイン"/>
                   </s:form>
                   <br/>
                   <div id="text-link">
                     <p>新規ユーザー登録は
                         <a href='<s:url action="UserCreateAction"/>'>こちら</a></p>
                     <p>Homeへ戻る場合は
                         <a href='<s:url action="GoHomeAction"/>'>こちら</a></p>

                   </div>
           </div>
    </div>

<!-- フッター -->
<jsp:include page="includeFooter.jsp"/>
</body>
</html>