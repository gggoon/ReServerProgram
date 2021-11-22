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
       <a href="insertBoardForm.do">새글작성</a>
       
       전체 게시글 : ${totalRecord}개<br>
       <table border="1">
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
           <c:if test="${empty list}">
           <tr> 
               <td colspan="5">작성된 게시글이 없습니다.</td>
           </c:if>
           <c:if test="${not empty list}">  
           <c:forEach items="${list}" var="dto">
                <tr>
                  <td>${dto.no}</td>
                  <td><a href="selectBoardByNo.do?no=${dto.no}">${dto.title}</a></td>
                  <td>${dto.author}</td>
                  <td>${dto.postdate}</td>
                  <td>${dto.hit}</td>
                </tr>
           </c:forEach>
          </c:if>
       </tbody>
   </table>
</body>
</html>