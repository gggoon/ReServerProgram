<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

    <div>
     <form id="f" action="insert.board" method="post">
     
        <label for="writer">작성자</label>
        <input type="text" name="writer" id="writer"><br>
      
        <label for="title">제목</label>
        <input type="text" name="title" id="title"><br><br>
        
        <label for="content">내용</label>
        <textarea rows="5" cols="30" name="content"></textarea><br>
        <button>저장하기</button>
        <input type="reset" value="작성초기화">
        <input type="button" value="목록보기" onclick="location.href='list.listBoard'">
     </form>
   </div>

</body>
</html>