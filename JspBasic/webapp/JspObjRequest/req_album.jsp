<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table{
		width: 800px;}
		tr{
		text-align:center;}
	</style>
</head>
<body>

	<div align="center">
		<form action="req_album_result.jsp">
			<table border="1" >
					<tr>
						<th> </th>
						<th> 프로필 사진 </th>
						<th> 이름 </th>
						<th> 최근 개봉작 </th>
						<th> 개봉일 </th>
					</tr>
					<tr>
						<td><input type="radio" name="title" value="sel1" ></td>
						<td><img alt="cm3" src="common-3.jpeg" width="100px" height="100px"></td>
						<td> 오세훈 </td>
						<td>해적: 도깨비 깃발</td>
						<td>2022.01.26.</td>
					</tr>
					<tr>
						<td><input type="radio" name="title" value="sel2"></td>
						<td><img alt="cm4" src="common-4.jpeg" width="100px" height="100px"></td>
						<td> 공명 </td>
						<td>행복의 진수</td>
						<td>2019</td>
					</tr>
					 <tr>
		                <td colspan="5">
		                    <input type="submit" value="확인">
		                </td>
		            </tr>
			</table>
			
		</form>
	
	</div>
	
	
</body>
</html>