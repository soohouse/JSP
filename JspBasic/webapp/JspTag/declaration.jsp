<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!


	/*
	Declaration(선언자)은 jsp 파일 내부에서 사용할 멤버변수나 메서드 등을
	선언할 때 사용하는 태그입니다.
	선언자에 작성한 코드는 jsp파일이 클래스로 변환될 때 실제 클래스 블록에 선언됩니다.
	해당 클래스로 객체가 생성될 때, 멤버변수(속성), 메서드(기능)로 동작하기 때문에
	객체가 소멸하지 않는 이상 요청이 들어온다면 값을 계속 누적할 수 있고
	메서드의 호출 또한 가능합니다.
	*/
	
	public int i;

	public int add(int n1, int n2) {
		return n1 + n2;
	}
	
	//Math.random();
%>

<%

	/*
	Scriptlet(스크립틀릿)은 지역변수 및 메서드 내부의 코드를 작성하는 태그입니다.
	스크립틀릿에 작성한 내용은 jsp파일이 클래스로 변환될 때 jsp_service()라는
	메서드 내부에 작성됩니다.
	페이지 요청이 발생할 때마다 실행할 로직을 작성할 수 있습니다.
	*/

	int j = 1;

	/* 
	void hello() {
		out.print("안녕~");
	}
	*/
	
	i++;
	j++;
	
	int result = add(7,8);
	double rn = Math.random();
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	i의 값: <%= i %> <br>
	j의 값: <%= j %> <br>
	result의 값: <%= result %> <br>
	난수값: <%=rn %>
	
</body>
</html>