<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <title>listBoard.jsp</title>
</head>
<body>
   <div>
      <a href="/ReServerProgram/selectBoardList.do">새글 작성하기</a>
   </div>
   <table border="1">
       <caption>전체 게시글 : ${totalCount}개</caption>
       <thead>
           <tr>
              <td>글번호</td>
              <td>제목</td>
              <td>작성자</td>
              <td>작성일</td>
              <td>조회수</td>
           </tr>           
       </thead>
       <tbody>
           <c:forEach items="${list}" var="board">
                <tr>
                  <td>${board.no}</td>
                  <td>${board.title}</td>
                  <td>${board.author}</td>
                  <td>${board.postdate}</td>
                  <td>${board.hit}</td>
                </tr>
           </c:forEach>
          
       </tbody>
   </table>
</body>
</html>