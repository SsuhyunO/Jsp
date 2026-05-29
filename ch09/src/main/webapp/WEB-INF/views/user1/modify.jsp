<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::수정</title>
	</head>
	<body>
		<h3>User1 수정</h3>
		<a href="/ch09">메인</a>
		<a href="/ch09/user1/register.do">등록</a>
		<a href="/ch09/user1/list.do">목록</a>

	<form action="/ch09/user1/modify.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" value="${user1DTO.userid}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user1DTO.name}"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" value="${user1DTO.birth}"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${user1DTO.hp}"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="${user1DTO.age}"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
	</form>		
		
		
	</body>
</html>