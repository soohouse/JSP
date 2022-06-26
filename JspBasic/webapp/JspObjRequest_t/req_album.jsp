<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
		table {
			width: 800px;
		}
		
		tr {
			text-align: center;
		}
	</style>

</head>
<body>

	<div align="center">
		<form action="req_album_result.jsp">
			<table border="1">
				<tr>
					<th></th>
					<th>앨범 커버</th>
					<th>가수</th>
					<th>앨범 제목</th>
					<th>발매일</th>
				</tr>
				<tr>
					<td>
						<input type="radio" name="title" value="sel1">
					</td>
					<td>
						<img alt="pic1" src="psy.jpg" width="100px" height="100px">
					</td>
					<td>싸이 (PSY)</td>
					<td>That That (prod. & feat. SUGA of BTS)</td>
					<td>2022.04.29</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="title" value="sel2">
					</td>
					<td>
						<img alt="pic2" src="bigbang.jpg" width="100px" height="100px">
					</td>
					<td>BIGBANG (빅뱅)</td>
					<td>봄여름가을겨울 (Still Life)</td>
					<td>2022.04.05</td>
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





















