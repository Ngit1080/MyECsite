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

<link rel="stylesheet" type="text/css" href="./css/table_style.css">

<title>BuyItem画面</title>

</head>
<body>
<!-- ヘッダー -->
<jsp:include page="includeHeader.jsp"/>

          <div id="main">
               <div id="top">
                       <p>BuyItem</p>
               </div>
               <div>
                       <s:form action="BuyItemAction">

<!-- 商品一覧表示 -->
                       <s:iterator value="#session.buyItemDTOList">
                       <div class="item">
                       <img class="image" style="width:130px; height:180px;" src="<s:property value='image_file_path'/>">

                       <br><br>

                       <s:property value="itemName"/><br>

                       <span>値段</span>

                       <s:property value="itemPrice"/><span>円</span><br>

                       <span>購入個数</span>
                       <select name="count">
                                         <option value="0" selected="selected">0</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="5">6</option>
                                                    <option value="5">7</option>
                                                    <option value="5">8</option>
                                                    <option value="5">9</option>
                                                    <option value="5">10</option>
	                      </select>
						 </div>
                      </s:iterator>

<!-- 繰り返し処理終了 -->
                <div class="payment">

                                <span>支払い方法</span>

                                   <input type="radio" name="pay" value="1" checked="checked">現金払い
                                   <input type="radio" name="pay" value="2">クレジットカード

                                   <s:submit value="購入"/>
				</div>



                   </s:form>
                            <div>
                             <p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
                             <p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
                           </div>
                           </div>
                           </div>

<!-- フッター -->
<jsp:include page="includeFooter.jsp"/>

</body>
</html>