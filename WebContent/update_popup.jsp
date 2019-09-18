<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateAction() {
		var pass = document.updateCheckForm.password.value;
		if(pass=="")
			alert("비밀번호를 입력하세여...");
		else
			document.updateCheckForm.submit();
	}
</script>
</head>
<body>
<form action="UpdateCheckPasswordServlet" name="updateCheckForm" method="post">
<input type="hidden" name="no" value="${param.no}">
<input type="password" name="password"><br><br>
<input type="button" value="수정" onclick="updateAction()">
<input type="button" value="창끄기" onclick="javascript:self.close()">
</form>
</body>
</html>



















