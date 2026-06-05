<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글검색</title>
    <link rel="stylesheet" href="/jboard/css/style.css"/>
</head>
<body>
    <div id="wrapper">
        <%@ include file="./_head.jsp" %>
        <main id="article">
            <section class="list">
                <nav>
                    <h1>
                    	<a href="/jboard/article/list.do">[전체 글목록]</a>
                        검색 건수 글목록
                        <span>${total}건</span>
                    </h1>
                    <form action="/jboard/article/search.do">
                        <select name="searchType">
                        	<c:if test="${searchType eq 'title'}">
	                    		<option value="title" selected>제목</option>
	                    		<option value="content">내용</option>
	                    		<option value="writer">글쓴이</option>
                    		</c:if>
                    		<c:if test="${searchType eq 'content'}">
	                    		<option value="title">제목</option>
	                    		<option value="content" selected>내용</option>
	                    		<option value="writer">글쓴이</option>
                    		</c:if>
                    		<c:if test="${searchType eq 'writer'}">
	                    		<option value="title">제목</option>
	                    		<option value="content">내용</option>
	                    		<option value="writer" selected>글쓴이</option>
                    		</c:if>
                    	</select>
                        <input type="text" name="keyword" value="${keyword}" placeholder="검색 키워드 입력">
                        <input type="submit" value="검색">
                    </form>
                </nav>
                                
                <table border="0">                    
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>               
                    <c:forEach var="dto" items="${dtoList}">
	                    <tr>
	                        <td>${pageStart}</td>
	                        <td><a href="#">${dto.title}[${dto.comment}]</a></td>
	                        <td>${dto.nick}</td>
	                        <td>${dto.wdate}</td>
	                        <td>${dto.hit}</td>
	                    </tr>
	                    <c:set var="pageStart" value="${pageStart-1}"></c:set>
                    </c:forEach>
                </table>

                <div class="page">
                	<c:if test="${pageGroupDTO.start > 1}">
                		<a href="/jboard/article/search.do?searchType=${searchType}&keyword=${keyword}&page=${pageGroupDTO.start - 1}" class="prev">이전</a>
                	</c:if>
                    
                    <c:forEach var="i" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end}">
                    	<a href="/jboard/article/search.do?searchType=${searchType}&keyword=${keyword}&page=${i}" class="num ${currentPage == i ? 'current' : '' }">${i}</a>
                    </c:forEach>
                    
                    <c:if test="${pageGroupDTO.end < lastPageNum}">
                    	<a href="/jboard/article/search.do?searchType=${searchType}&keyword=${keyword}&page=${pageGroupDTO.end + 1}" class="next">다음</a>
                    </c:if>
                </div>

                <a href="/jboard/article/write.do" class="btn btnWrite">글쓰기</a>
                
            </section>
        </main>
        <%@ include file="./_tail.jsp" %>
    </div>    
</body>
</html>