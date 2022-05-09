<%@page import="models.Vacancy"%>
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
    		#vacs-table {
    			width: 100%;
    			margin: 20px auto;
    			margin-top: 30px;
    		}
    		#vacs-table th,
    		#vacs-table td {
    			padding: 5px;
    			border: 1px solid silver;
    		}
    		footer {
    			padding-top: 30px;
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
		    		<h2>Перегляд підрозділу</h2>
		    		<br>
		    		
		    		<%
		    			int depId = (int)request.getAttribute("depId");
		    			DepsService service = (DepsService)request.getAttribute("service");	    			
		    			Department dep = service.getDepartmentById(depId);
		    			List<Vacancy> vacancies = service.getVacanciesByDep(depId);
		    		%>
		    		
		    		<h3 style="color: navy"><%=dep.getName()%></h3>
		    		
		    		<h4 style="color: darkcyan">Список вакансій</h4>
		    		
		    		<table id="vacs-table">
		    			<thead>
		    				<tr>
		    					<th>№</th>
		    					<th>Назва посади</th>
		    					<th>Обов'язки</th>
		    					<th>Графік роботи</th>
		    					<th>Посадовий оклад</th>
		    					<th>Кількість вакансій</th>
		    				</tr>
		    			</thead>
		    			<tbody>
		    				<%! int k = 1; %>
		    				<% for (Vacancy vac : vacancies) { %>
		    					<tr>
		    						<td><%=k%></td>
		    						<td><%=vac.getPosition()%></td>
		    						<td><%=vac.getDuties()%></td>
		    						<td><%=vac.getSchedule()%></td>
		    						<td><%=vac.getSalary()%></td>
		    						<td><%=vac.getQuantity()%></td>
		    					</tr>
		    				<% k++; } %>
		    			</tbody>
		    		</table>
		    		
		    		<p>
		    			<a href="deps?page=admin" class="btn btn-primary" style="margin-top: 20px">
		    				Повернутись до списку підрозділів
		    			</a>
		    		</p>
		    		
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
