<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>MyPage画面</title>

<link rel="stylesheet" type="text/css" href="./css/table_style.css">

</head>
<body>
<!-- ヘッダー -->
<jsp:include page="includeHeader.jsp"/>

<div id="container">

     <div id="main">
           <div id="top">
                    <p>MyPage</p>
           </div>
           <div>
<!-- 購入したものがない場合 -->
           <s:if test="myPageList == null">
                    <h3>ご購入情報はありません。</h3>
           </s:if>
<!-- 購入したものがある場合 -->
           <s:elseif test="message == null">
           <div class="push"></div>

           <span>購入履歴</span>
           <table class="mypage-table">

                     <tr>
                            <th>商品名</th>
                            <th>値段</th>
                            <th>購入個数</th>
                            <th>支払い方法</th>
                            <th>購入日</th>
                    </tr>
           <s:iterator value="myPageList">
                <tr>
                     <td><s:property value="itemName"/></td>
                     <td><s:property value="totalPrice"/><span>円</span></td>
                     <td><s:property value="totalCount"/><span>個</span></td>
                     <td><s:property value="payment"/></td>
                     <td><s:property value="insert_date"/></td>
                 </tr>
            <div class="push"></div>
            </s:iterator>
            </table>

            <!-- 履歴の削除機能 -->
            <s:form action="MyPageAction">
               <input type="hidden" name="deleteFlg" value="1">
               <s:submit value="削除" method="delete"/>
            </s:form>
        </s:elseif>

        <!-- message(MyPageActionで定義した変数)に値が入っている場合 -->
        <s:if test="message != null">
                <h3><s:property value="message"/></h3>
        </s:if>

        <div id="text-right">
                <p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
                <p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
        </div>
     </div>
    </div>

<!-- フッター -->
<jsp:include page="includeFooter.jsp"/>
</div>
</body>
</html>