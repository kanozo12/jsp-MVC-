<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function winOpen(kind) {
		window.open(kind+"_popup.jsp?no=${vo.no}"," ", "resizable=true, toolbar=no,width=600, height=200, top=300, left=200");
	}
</script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<table cellpadding="5">
<tr>
	<td>
		<table width="550">
			<tr>
				<td>글번호 : ${vo.no} |
				    타이틀 : ${vo.title}
				 <hr style="color: #6691BC; border-style: dotted; margin: 0">				
				</td>
			</tr>
			<tr>
				<td>이름 : ${vo.writer} |
				    작성일시 : ${vo.timePosted} 
				   &nbsp; count : ${vo.hits} 
				</td>
			</tr>
			<tr>
				<td>
					<hr style="color: #6691BC; margin: 0">
					<pre>${vo.content}</pre>
				</td>
			</tr>
			<tr>
				<td valign="middle">
				<a href="ShowListServlet">
				<img alt="목록" src="img/list_btn.jpg" border="0"></a>
				
				<img alt="삭제" src="img/delete_btn.jpg" border="0" 
				  onclick="winOpen('delete')">
				<img alt="수정" src="img/modify_btn.jpg" border="0"
				  onclick="winOpen('update')">
				</td>			
			</tr>
		</table>
	</td>
</tr>
</table>
</body>
</html>
















