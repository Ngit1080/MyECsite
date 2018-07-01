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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="./css/table_style.css">


<title>BuyItemConfirm画面</title>



<script type="text/javascript">
        function submitAction(url) {
        	$('form').attr('action',url);
        	$('form').submit();
        }
</script>
</head>
<body>
<!-- ヘッダー -->
<jsp:include page="includeHeader.jsp"/>

        <div id="main">
                  <div id="top">
                         <p>BuyItem</p>
                  </div>
                  <div>
                       <s:form>
                       <s:iterator value="buyItemDTOList">
                       <s:if test="count !=0">

                       <div class="buyitem">

                       <img class="image" style="width:130px; height:180px;" src="<s:property value='image_file_path'/>"><br>


                         商品名
                         <s:property value="itemName"/><br>


                         値段
                         <s:property value="itemPrice"/><span>円</span><br>

                         購入個数
                         <s:property value="count"/><span>個</span><br>


                        </div>
                        <br>
                        </s:if>
                        </s:iterator>

                  <!-- 商品の計算 -->
                     <s:if test="buyItemDTOList.size()>1">
                        合計金額
                        <s:property value="session.totalPrice"/><span>円</span>
                     </s:if>
                     <s:else>
                        合計金額
                        <s:property value="session.total_price"/><span>円</span>
                     </s:else>
                     <tr>
                        <td>支払い方法</td>
                        <td><s:property value="session.pay"/></td>
                     </tr>
                     <tr>

                         <td><br></td>

                     </tr>
                     <tr>
                         <td><input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>
                         <td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>

                    </tr>
             </s:form>
          </div>
       <div class="push">
               <p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
               <p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
       </div>
        </div>

<!-- フッター -->
<jsp:include page="includeFooter.jsp"/>

</body>
</html>

