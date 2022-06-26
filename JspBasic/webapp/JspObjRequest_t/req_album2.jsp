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
			<table border="1">
				<tr>
					<th>앨범 커버</th>
					<th>가수</th>
					<th>앨범 제목</th>
					<th>발매일</th>
				</tr>
				<tr>
					<td>
						<img alt="pic1" src="psy.jpg" width="100px" height="100px">
					</td>
					<td>싸이 (PSY)</td>
					<td>
						<a href="req_album_result.jsp?title=sel1">That That (prod. & feat. SUGA of BTS)</a>
					</td>
					<td>2022.04.29</td>
				</tr>
				<tr>
					<td>
						<img alt="pic2" src="bigbang.jpg" width="100px" height="100px">
					</td>
					<td>BIGBANG (빅뱅)</td>
					<td>
						<a href="req_album_result.jsp?title=sel2">봄여름가을겨울 (Still Life)</a>
					</td>
					<td>2022.04.05</td>
				</tr>
			</table>
	</div>

</body>
</html>





















