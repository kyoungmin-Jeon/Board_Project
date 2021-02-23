<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value='${pageContext.request.contextPath }/'/>

<script>
	alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요")
	location.href='${root}user/updatePw?user_name=${user_name}'
</script>