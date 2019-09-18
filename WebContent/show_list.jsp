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
<c:import url="header.jsp"></c:import>
<h2 align="center"><b>전체 게시글 보기</b></h2><p>
<table border="1" width="650" cellpadding="2" align="center">
	<tr>
		<th width="10%">번호</th>
		<th width="50%">제목</th>
		<th width="15%">작성자</th>
		<th width="15%">작성일</th>
		<th width="10%">조회수</th>
	</tr>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.no}</td>
			<td><a href="ShowContentHits?&no=${vo.no}&&hits=${vo.hits}">${vo.title}</a></td>
			<td>${vo.writer}</td>
			<td>${vo.timePosted}</td>
			<td>${vo.hits}</td>
		</tr>	
	</c:forEach>
</table><p>

<div align="center">
<a href="write.jsp"><img alt="글쓰기 이미지" src="img/write_btn.jpg"></a>
</div>
</body>
</html>
















