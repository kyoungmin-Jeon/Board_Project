<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value='${pageContext.request.contextPath }/'/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="container" style="margin-top: 100px">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div>
					<span> <h3 align='center'>아이디 찾기 결과 </h3>  </span>
				 </div>
				<div class="card shadow">
					<br><br><br><br><br>
					
					<div class="card-body">
					
						<h3 align='center'>아이디는 ${result }입니다.</h3>
					</div>	
					<br><br><br><br><br>
					
					<div class="form-group">
						<div class="text-right" align="center">
							<a href='${root }user/findpw' class='btn btn-info'>비밀번호 찾기</a> 
							<a href='${root }user/login' class='btn btn-primary'>로그인하기</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
	

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>
</html>