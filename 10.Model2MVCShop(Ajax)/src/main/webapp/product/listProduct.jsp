<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.common.*" %>
--%>

<!DOCTYPE html>
<html>

<head>
<!--  <title>��ǰ �����ȸ</title>-->
<title>${param.menu=="manage"?"��ǰ����":"��ǰ �����ȸ"}</title>
 
<link rel="stylesheet" href="/css/admin.css" type="text/css">

	<!-- CDN(Content Delivery Network) ȣ��Ʈ ��� -->
	<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">

	//=====����Code �ּ� ó�� ��  jQuery ���� ======//
	// �˻� / page �ΰ��� ��� ��� Form ������ ���� JavaScrpt �̿�  
	function fncGetList(currentPage) {
		//document.getElementById("currentPage").value = currentPage;
		$("#currentPage").val(currentPage)
	   	//document.detailForm.submit();
		$("form").attr("method" , "POST").attr("action" , "/product/listProduct").submit();
	}
	//===========================================//
	//==> �߰��Ⱥκ� : "�˻�" ,  userId link  Event ���� �� ó��
	 $(function() {
		 
		//==> �˻� Event ����ó���κ�
		//==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		//==> 1 �� 3 ��� ���� : $("tagName.className:filter�Լ�") �����. 
		 $( "td.ct_btn01:contains('�˻�')" ).on("click" , function() {
			//Debug..
			//alert(  $( "td.ct_btn01:contains('�˻�')" ).html() );
			fncGetList(1);
		});
		
		
		//==> prodNo LINK Event ����ó��
		//==> DOM Object GET 3���� ��� ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
		//==> 3 �� 1 ��� ���� : $(".className tagName:filter�Լ�") �����.
		$( ".ct_list_pop td:nth-child(3)" ).on("click" , function() {
				//Debug..
				//alert(  $( this ).text().trim() );
				self.location ="/product/getProduct?prodNo="+$(this).data("value");
				//self.location=$('.hidden_link', $(this)).text();
		});
		
		//==> UI ���� �߰��κ�  :  prodNo LINK Event End Product ���� ���ϼ� �ֵ��� 
		$( ".ct_list_pop td:nth-child(3)" ).css("color" , "orange");
		$("h7").css("color" , "red");
		
		
		//==> �Ʒ��� ���� ������ ������ ??
		//==> �Ʒ��� �ּ��� �ϳ��� Ǯ�� ���� �����ϼ���.					
		$(".ct_list_pop:nth-child(4n+6)" ).css("background-color" , "whitesmoke");
		//console.log ( $(".ct_list_pop:nth-child(1)" ).html() );
		//console.log ( $(".ct_list_pop:nth-child(2)" ).html() );
		//console.log ( $(".ct_list_pop:nth-child(3)" ).html() );
		//console.log ( $(".ct_list_pop:nth-child(4)" ).html() ); //==> ok
		//console.log ( $(".ct_list_pop:nth-child(5)" ).html() ); 
		console.log ( $(".ct_list_pop:nth-child(6)" ).html() ); //==> ok
		//console.log ( $(".ct_list_pop:nth-child(7)" ).html() ); 
	});	
	</script>		

</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<!--  <form name="detailForm" action="/listProduct.do?menu=search" method="post">-->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////// 
<form name="detailForm" action='/listProduct.do?&menu=${param.menu}' method="post">
////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- ////////////////// jQuery Event ó���� ����� /////////////////////////
<form name="detailForm" action="/listUser.do" method="post">
<form name="detailForm" action='/product/listProduct?&menu=${param.menu}' method="post">
////////////////////////////////////////////////////////////////////////////////////////////////// --><!-- 2022-04-28 shhwang -->
<form name="detailForm">

<%-- 
<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
 			<%if(menu.equals("search")){ %>
				��ǰ �����ȸ			
			<%}else if(menu.equals("manage")) { %>
				��ǰ ����			
			<%}%>
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>
--%>
<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
						${param.menu=="manage"?"��ǰ����":"��ǰ �����ȸ"}
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table><br/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0">��ǰ��ȣ</option>
				<option value="1">��ǰ��</option>
				<option value="2">��ǰ����</option>
			</select>
			<input type="text" name="searchKeyword"  class="ct_input_g" style="width:200px; height:19px" />
		</td>
				
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
							<!-- ////////////////// jQuery Event ó���� ����� /////////////////////////
							<a href="javascript:fncGetList();">�˻�</a>
							////////////////////////////////////////////////////////////////////////////////////////////////// -->							
						�˻�
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>



<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >
			��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">
			��ǰ��<br>
			<h7 >(��ǰ�� click:������)</h7>
			</td>
		
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">�������</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>

 	<c:set var="i" value="0" />
	<c:forEach var="product" items="${list}">
		<c:set var="i" value="${ i+1 }" />
		<c:set var="menu" value="menu" />		
		<tr class="ct_list_pop">
			<td align="center">${ i }</td>
			<td></td>
			
			<!--  <td align="left"><a href="/getProduct.do?prodNo=${product.prodNo}">${product.prodName}</a></td>-->
			<td align="left" data-value="${product.prodNo}" >
				<!-- ////////////////// jQuery Event ó���� ����� /////////////////////////
				<a href="/product/getProduct?prodNo=${product.prodNo}">${product.prodName}</a></td>
				////////////////////////////////////////////////////////////////////////////////////////////////// --><!-- 2022-04-28 shhwang -->
				${product.prodName}
			<td></td>
			<td align="left">${product.price}</td>
			<td></td>
			<td align="left">${product.regDate}</td>		
			<td></td>
			<td align="left">
			
				�Ǹ���
			
			</td>		
		</tr>
		<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
		</tr>
	</c:forEach>

<%-- 
	<tr class="ct_list_pop">
		<td></td>
		<td align = "left">
 			<%if(menu.equals("search")){ %>
				<a href = "/getProduct.do?prodNo=${product.ProdNo}">${product.ProdName}</a>			
			<%}else if(menu.equals("manage")) { %>
				<a href = "/updateProductView.do?prodNo=${product.ProdNo}">${product.ProdName}</a>
			<%}else{ %>
			   <a href = "/getProduct.do?prodNo=${product.ProdNo}">${product.ProdName}</a>
			<% }%>
		</td>
		<td></td>
		<td align="left">${product.Price}</td>
		<td></td>
		<td align="left">${product.redDate}
		<td></td>
		<td align="left">
		<td>		
			�Ǹ���		
		</td>	
	</tr>
--%>
	
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	
<%-- 	
	<% } %>
--%>  	
</table>

<!-- PageNavigation Start... -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top:10px;">
	<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
	
			<jsp:include page="../common/pageNavigator.jsp"/>	
			
    	</td>
	</tr>
</table>
<!-- PageNavigation End... -->

</form>

</div>
</body>
</html>
