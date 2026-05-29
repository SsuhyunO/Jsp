<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::수정</title>
	</head>
	<body>
		<h3>User4 수정</h3>
		<a href="/ch09">메인</a>
		<a href="/ch09/user4/register.do">등록</a>
		<a href="/ch09/user4/list.do">목록</a>

	<form action="/ch09/user4/modify.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" value="${user4DTO.userid}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user4DTO.name}"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label>
			            <input type="radio" name="gender" value="M" 
			                   ${user4DTO.gender eq 'M' ? 'checked' : ''}>남
			        </label>
			        <label>
			            <input type="radio" name="gender" value="F" 
			                   ${user4DTO.gender eq 'F' ? 'checked' : ''}>여
			        </label>
				</td>			
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="${user4DTO.age}"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${user4DTO.hp}"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="${user4DTO.addr}"></td>
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