<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>UserCreateComplete画面</title>

<link rel="stylesheet" type="text/css" href="./css/table_style.css">

</head>
<body>
<!-- ヘッダー -->
<jsp:include page="includeHeader.jsp"/>

        <div id="main">
                <div id="top">
                        <p>UserCreateComplete</p>
                </div>
                <div>
                        <h3>ユーザーの登録が完了いたしました。</h3>
                        <div>
                             <a href='<s:url action="HomeAction"/>'>ログインへ</a>
                        </div>

                </div>
        </div>

<!-- フッター -->
<jsp:include page="includeFooter.jsp"/>
</body>
</html>