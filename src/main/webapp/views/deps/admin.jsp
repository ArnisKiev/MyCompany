<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Department" %>
<%@ page import="services.DepsService" %>
  
<!DOCTYPE html>
<html lang="uk">
  	<head>
    	<%@ include file="../layouts/head.jsp" %>
    	<style>
    		#deps-table {
    			width: 60%;
    			margin: 20px auto;
    			margin-top: 30px;
    		}
    		#deps-table th,
    		#deps-table td {
    			padding: 5px;
    			border: 1px solid silver;
    		}
    		#deps-table td a {
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
		    		<h2>Управління підрозділами</h2>
		    		<p>
		    			<a href="deps?page=create">Створити підрозділ</a>
		    		</p>
		    		
		    		<% DepsService service = (DepsService)request.getAttribute("service"); %>
		    		<% List<Department> deps = service.getDepsFromDb(); %>
		    		
		    		<table id="deps-table">
		    			<thead>
		    				<tr>
		    					<th>ID</th>
		    					<th>Назва підрозділу</th>
		    					<th>Управління даними</th>
		    				</tr>
		    			</thead>
		    			<tbody>
		    				<% for (Department dep : deps) { %>
		    					<tr>
		    						<td class="c1"><%=dep.getId()%></td>
		    						<td class="c2"><%=dep.getName()%></td>
		    						<td class="c3">
		    							<a href="deps?page=detail&id=<%=dep.getId()%>"
		    							   class="btn btn-sm btn-primary">
		    								Перегляд
		    							</a>
		    							<a href="deps?page=update&id=<%=dep.getId()%>"
		    							   class="btn btn-sm btn-success">
		    								Змінити
		    							</a>
		    							<a href="deps?page=delete&id=<%=dep.getId()%>"
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
