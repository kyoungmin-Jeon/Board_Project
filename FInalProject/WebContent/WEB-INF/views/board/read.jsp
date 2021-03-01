<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var='root' value='${pageContext.request.contextPath }/'/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<script >

</script>
<body>
	
	<c:import url="/WEB-INF/views/include/top_menu.jsp"/>
	
<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<div class="form-group">
						<label for="board_writer_name">작성자</label>
						<input type="text" id="board_writer_name" name="board_writer_name" class="form-control" value="${readContentBean.content_writer_name }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_date">작성날짜</label>
						<input type="text" id="board_date" name="board_date" class="form-control" value="${readContentBean.content_date }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_subject">제목</label>
						<input type="text" id="board_subject" name="board_subject" class="form-control" value="${readContentBean.content_subject }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_content">내용</label>
						<textarea id="board_content" name="board_content" class="form-control" rows="10" style="resize:none" disabled="disabled">${readContentBean.content_text }</textarea>
					</div>
					
					<c:if test="${readContentBean.content_file != null }">
					 	<div class="form-group">
							<label for="board_file">첨부 이미지</label>
							<img src="${root }upload/${readContentBean.content_file}" width="50%"/>						
						</div>
					</c:if>
		
						<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top : 10px">
							<form:form action='${root}board/write_reply' modelAttribute="boardReplyBean" method='post'>
								<form:hidden path="board_info_idx"/>
								<form:hidden path="content_idx"/>	
								<form:hidden path="rno"/>
								
								<h6>댓글 작성</h6><br>	
								<div class='row'>
									<div class='col-sm-5'>
										<form:input path="writer" class='form-control' style='float:left;' placeholder='작성자'/> 
									</div>
									
									
									<div class='col-sm-10'>
										<form:textarea path="content" class='form-control' rows='3'  placeholder='댓글을 입력해주세요'/>
									</div>
										<button type='submit' class='btn btn-sm btn-primary' id='ReplySave' >저장</button>
								</div>							
							</form:form>
						</div>	
						
					<div class="form-group">
						<label for="board_reply" class='label label-info'>댓글</label>
						<c:forEach items="${replyList }" var="replyList">
							<div class='my-3 p-3 bg-white rounded shadow-sm' >	
								<p>
									 작성자 : ${replyList.writer } &nbsp;
								   (<fmt:formatDate value="${replyList.regDate }" pattern="yyyy-MM-dd" />)
								</p>
								
								<p>댓글 : ${replyList.content }  </p>
							</div>
						</c:forEach>
					</div>
					
					</div>
					
					<div class="form-group">
						<div class="text-right">
								<a href="${root }board/main?board_info_idx=${board_info_idx}&page=${page}" class="btn btn-primary">목록보기</a>
								<a href="${root }board/modify?board_info_idx=${board_info_idx}&content_idx=${content_idx}&page=${page}" class="btn btn-info">수정하기</a>
								<a href="${root }board/delete?board_info_idx=${board_info_idx}&content_idx=${content_idx}" class="btn btn-danger">삭제하기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>

<c:import url="/WEB-INF/views/include/bottom_info.jsp"/>

</body>
</html>
