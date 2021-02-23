<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value='${pageContext.request.contextPath }/' />

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
<script>
$(document).ready(function(){
	$(document).on("keyup", "#user_num", function() { 
	    $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^[0-9]{3})([0-9]{4})([0-9]{4})$/,"$1-$2-$3").replace("--", "-","-") );
	    
	 }); 
})
</script>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />


	<div class="container" style="margin-top: 100px">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div>
					<span> <h3 align='center'>아이디 찾기 </h3>  </span>
				 </div>
				<div class="card shadow">
					<div class="card-body">
						<form:form action="${root }user/findid_pro" method='post' modelAttribute="findIdUserBean">
							<div class="form-group">
								<form:label path="user_name">이름</form:label>
								<form:input path="user_name" class='form-control'/>
							</div>
							<div class="form-group">
								<form:label path="user_num">전화번호</form:label>
								<form:input path="user_num" name="user_num" id="user_num" maxlength="11" class='form-control' />
							</div>

							<div class="form-group">
								<div class="text-right">
									<form:button class='btn btn-primary'>아이디 찾기</form:button>
									<a href='${root }user/findpw' class='btn btn-info'>비밀번호 찾기</a>
								</div>
							</div>

						</form:form>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/include/bottom_info.jsp" />

</body>
</html>