<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=" UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				text-align: center;
			}
			</style>
	</head>
	<body>
		<%
			request.setCharacterEncoding("UTF-8");
			String productname = request.getParameter("product");
			ArrayList list = (ArrayList)session.getAttribute("productlist");
			if(list == null) {
				list = new ArrayList();
				session.setAttribute("productlist", list);
			}
			list.add(productname);
		%>
		
		<script>
			alert("<%=productname %>)이(가) 추가되었습니다.!");
			history.go(-1);
		</script>
	</body>
</html>