<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="models.Employee"%>
<%@page import="services.EmpsService"%>
  
<!DOCTYPE html>
<html lang="uk">
  	<head>
    	<%@ include file="../layouts/head.jsp" %>
    	<style>
    		#emps-table {
    			width: 60%;
    			margin: 20px auto;
    			margin-top: 30px;
    		}
    		#emps-table th,
    		#emps-table td {
    			padding: 5px;
    			border: 1px solid silver;
    		}
    		#emps-table td a {
    			width: 80px;
    		}
    		.c2 {
    			width: 50%;
    		}
    		footer {
    			padding-top: 30px;
    		}
    		p a {
    			text-decoration: none;
    		}
    	</style>
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
		    		<h2>Управління співробітниками</h2>
		    		<p>
		    			<a href="emps?page=create">Додати співробітника</a>
		    		</p>
		    		
		    		<% EmpsService service = (EmpsService)request.getAttribute("service"); %>
		    		<% List<Employee> emps = service.getEmpsFromDb(); %>
		    		
		    		<table id="emps-table">
		    			<thead>
		    				<tr>
		    					<th>ID</th>
		    					<th>Ім'я</th>
		    					<th>Управління даними</th>
		    				</tr>
		    			</thead>
		    			<tbody>
		    				<% for (Employee emp : emps) { %>
		    					<tr>
		    						<td class="c1"><%=emp.getId()%></td>
		    						<td class="c2"><%=emp.getFullName()%></td>
		    						<td class="c3">
		    							<a href="emps?page=detail&id=<%=emp.getId()%>"
		    							   class="btn btn-sm btn-primary">
		    								Перегляд
		    							</a>
		    							<a href="emps?page=update&id=<%=emp.getId()%>"
		    							   class="btn btn-sm btn-success">
		    								Змінити
		    							</a>
		    							<a href="emps?page=delete&id=<%=emp.getId()%>"
		    							   class="btn btn-sm btn-danger">
		    								Видалити
		    							</a>
		    						</td>
		    					</tr>
		    				<% } %>
		    			</tbody>
		    		</table>		    				    	
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
