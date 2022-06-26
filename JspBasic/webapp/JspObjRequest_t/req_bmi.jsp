<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	bmi지수 계산 공식: 체중(kg) / 신장(m) * 신장(m)
    	- bmi지수가 25를 초과한다면 "당신은 과체중입니다." 를 출력
    	- 18.5미만이라면 "당신은 저체중입니다." 를 출력
    	- 나머지는 "당신은 정상체중입니다." 를 출력하세요.
    	
    	주의!) 
    	request.getParameter()의 리턴 타입은 String입니다.
    	숫자가 전달되어도 타입이 문자열입니다.
    	그렇기 때문에 bmi 지수를 계산하려면 실수나 정수로 변환 후 계산해야 합니다.
    	Integer.parseInt(문자열), Double.parseDouble(문자열)
    	신장 -> cm, 체중 -> kg 두 값 모두 소수점 포함 값으로 받도록 하겠습니다.
     --%>
     
     <%
     	//넘어오는 파라미터값 받고 실수로 변환
     	String strCm = request.getParameter("cm");
     	String strKg = request.getParameter("kg");
     	
     	double cm = Double.parseDouble(strCm);
     	double kg = Double.parseDouble(strKg);
     	
     	//bmi 지수 계산
     	double bmi = kg / (cm/100 * cm/100);
     	bmi = Math.round(bmi*100) / 100.0;
     	
     %>
     
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>체질량 지수(BMI) 계산</h2>
	<hr>
	<p>
		- 신장: <%=cm %>cm <br>
		- 체중: <%=kg %>kg
	</p>
	
	<p>
		BMI지수: <strong><%=bmi %></strong> <br>
		<% if(bmi > 25) { %>
			당신은 과체중입니다.
		<% } else if(bmi < 18.5) { %>
			당신은 저체중입니다.
		<% } else { %>
			당신은 정상체중입니다.
		<% } %>
	</p>

</body>
</html>



















