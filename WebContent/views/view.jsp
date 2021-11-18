<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <div>
      작성자 : ${board.author}<br>
      작성일 : ${board.postdate}<br>
      작성IP : ${board.ip}<br>
      조회수 : ${board.hit}<br>
      <label><input type="text" name="title" id="title" placeholder="변경된 약관을 확인하세요">제목 : ${notice.title}</label><br><br>
      <label for="content">${notice.content}</label> 
      <textarea rows="5" cols="30" name="content"></textarea><br>
      <br>

      <c:if test="${board.author">
      <input type="button" value="삭제하기" onclick="fnBoardDelete()">
      </c:if>
      <input type="button" value="목록보기" onclick="location.href='list.listBoard'">
       
       
       <script>
           function fnBoardDelete() {
        	 if(confirm('게시글을 삭제할까요?')) {
        		 location.href = 'delete.board?nNo=${board.No}';
        	 }
           }
       </script> 
        
      <hr>
      
   </div>
</body>
</html>