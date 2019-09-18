<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdatePostingServlet" method="post">
<table cellpadding="5">
<tr>
	<td>
		<table width="550">
			<tr>
				<td>
				<b>글번호 : <input type="text" name="no" value="${vo.no}" readonly="readonly"> |
				   타이틀 : <input type="text" name="title" value="${vo.title}"></b>
				  <hr style="color: #6691BC; border-style: dotted; margin: 0">
				</td>
			</tr>
			<tr><td>
			<font size="2">작성자 : 
			<input type="text" name="writer" value="${vo.writer}"> |
			작성일시 : ${vo.timePosted}			
			</font></td></tr>
			
			<tr><td>
			<hr style="color: #6691BC; margin: 0">
			<textarea rows="15" cols="75" name="content"> ${vo.content}
			</textarea></td></tr>
			
			<tr><td valign="middle">
			<input type="submit" value="수정하기"></td></tr>
		</table>
	</td>
</tr>
</table>
</form>
</body>
</html>















