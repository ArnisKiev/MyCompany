<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="uk">
  	<head>
    	<%@ include file="../layouts/head.jsp" %>
    	<style>
    		#depForm {
    			border: 1px solid silver;
    			border-radius: 15px;
    			width: 400px;
    			padding: 20px;
    			margin: 20px auto;
    			text-align: left; 
    		}
    		#depForm label {
    			padding-bottom: 0px;
    			color: navy;
    		}
    		.my-btn {
    			margin-top: 25px;
    			margin-bottom: 10px;
    			width: 150px;
    			border-radius: 5px;
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
		    		<h2>Створення підрозділу</h2>
		    		<form id="depForm" action="deps?page=create" method="post">
		    			<div class="form-group">
		    				<label>Назва нового підрозділу:</label>
		    				<input type="text" name="depName" class="form-control" required>
		    			</div>
		    			<div class="form-group text-center">
		    				<input type="submit" value="Відправити" class="btn btn-success my-btn">
		    				<input type="reset" value="Очистити" class="btn btn-danger my-btn">
		    			</div>
		    		</form>
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
