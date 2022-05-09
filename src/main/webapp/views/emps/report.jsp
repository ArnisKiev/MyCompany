<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="uk">
  	<head>
    	<%@ include file="../layouts/head.jsp" %>
  	</head>
  	<body>
    	<header>
    		<%@ include file="../layouts/nav.jsp" %>
    	</header>

		<main class="container">
		  	<div class="bg-light p-5 rounded text-center main-box">
		    	<div class="title-box">
		    		<h1>Моя компанія</h1>
		    		<h3>Офіційний сайт компанії MyCompany</h3>
		    	</div>
		    	<hr>
		    	<div class="content-box">
		    	<!-- ////////////////////// Content Placeholder ///////////////////// -->	
		    		<h2>Звіт про виконання операції</h2>
		    		
		    		<%
		    			String operation = request.getAttribute("operation").toString();
		    			boolean success = (boolean)request.getAttribute("success");
		    		%>
		    		
		    		<br>
		    		<h3 style="color: navy"><%=operation%></h3>
		    		<hr>
		    		    		
		    		<% if (success) { %>
		    			<h4 style="color: green">Співробітника успішно додано!</h4>
		    		<% } else { %>
		    			<h4 style="color: red">Співробітника додати не вдалося</h4>
		    		<% } %>
		    		
		    		<hr>
		    	<!-- ////////////////////// Content Placeholder ///////////////////// -->
		    	</div>
		  	</div>
		</main>
		
		<footer class="container text-center">
			<%@ include file="../layouts/footer.jsp" %>
		</footer>

    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  	</body>
</html>
