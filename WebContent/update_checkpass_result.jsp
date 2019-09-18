<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
<c:choose>
	<c:when test="${flag==true}">
		if(confirm("정말로 수정 하시겠습니까?"))
			//글 하나를 수정하기 위해서 받아오는  Controller로 연결함..
			opener.location.href="UpdateViewServlet?no=${param.no}";
			self.close();
	</c:when>
	<c:otherwise>
		alert("해당글의 패스워드와 일치하지 않습니다..");
	</c:otherwise>
</c:choose>

</script>







