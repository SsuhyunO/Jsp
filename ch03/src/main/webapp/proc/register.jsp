<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>register</title>
	</head>
	<body>
		<h3>등록 페이지</h3>
		<%
			// 전송 데이터 수신
			String userid = request.getParameter("userid");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String[] hobbies = request.getParameterValues("hobby");
			String addr = request.getParameter("addr");
			String introduce = request.getParameter("introduce");
			String id = request.getParameter("id");
		%>
		
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><%= userid %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><%= pass %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%= name %></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><%= birth %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%= email%></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%= age %></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%= gender %></td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<%
						for(String hobby:hobbies){
							out.print(hobby + ", ");
						}
					%>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%= addr %></td>
			</tr>
			<tr>
				<td>소개</td>
				<td><%= introduce %></td>
			</tr>
			<tr>
				<td>숨김필드</td>
				<td><%= id %></td>
			</tr>
		</table>
		
	</body>
</html>