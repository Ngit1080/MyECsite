<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>InquiryComplete画面</title>

<link rel="stylesheet" type="text/css" href="./css/table_style.css">

</head>
<body>
<!-- ヘッダー -->
<jsp:include page="includeHeader.jsp"/>


       <div id="main">
             <div id="top">
             <p>InquiryComplete</p>
             </div>

           <p>お問い合わせを受け付けました。</p>

           <div id="link">
             <p><a href='<s:url action="GoHomeAction"/>'>Homeへ戻る場合はこちら</a></p>
           </div>
    </div>

<!-- フッター -->
<jsp:include page="includeFooter.jsp"/>
</body>
</html>