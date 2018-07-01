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
<title>Inquiry画面</title>

<link rel="stylesheet" type="text/css" href="./css/table_style.css">

</head>
<body>
<div id="main">
<!-- ヘッダー -->
<jsp:include page="includeHeader.jsp"/>
          <div id="top">
             <p>Inquiry</p>
          </div>

   <s:form method="post" action="InquiryConfirmAction">
       名前:<input type="text" name="name"/><br>
       お問い合わせの種類:<br>
       <select name="qtype">
          <option value="company">会社について</option>
          <option value="product">製品について</option>
          <option value="support">アフターサポートについて</option>
       </select>
       <br>
       お問い合わせ内容:
       <s:textarea name="body"/>
       <br><s:submit value="登録"/>
    </s:form>
   </div>

<!-- フッター -->
<jsp:include page="includeFooter.jsp"/>

</body>
</html>