<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="uk">
  	<head>
    	<%@ include file="../layouts/head.jsp" %>
    	<style>
    		#signinForm {
    			border: 1px solid silver;
    			border-radius: 15px;
    			width: 400px;
    			padding: 20px;
    			margin: 20px auto;
    			text-align: left; 
    		}
    		#signinForm label {
    			padding-bottom: 0px;
    			color: navy;
    		}
    		.my-btn {
    			margin-top: 25px;
    			margin-bottom: 10px;
    			width: 150px;
    			border-radius: 5px;
    		}
    		footer {
    			padding-top: 30px;
    		}
    		.error {
    			display: block;
    			margin-top: 3px;
    			color: red;
    			font-style: italic;
    			font-size: 10pt;
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
		    		<h2>Авторизація</h2>
		    		<form id="signinForm" action="auth?page=signin" method="post" onsubmit="return false">
		    			<div class="form-group">
		    				<label for="login">Логін:</label>
		    				<input type="text" id="login" name="login" class="form-control" required>
		    				<span id="login_err" class="error"></span>  			
		    			</div>
		    			<div class="form-group">
		    				<label for="pass">Пароль:</label>
		    				<input type="password" id="pass" name="pass" class="form-control" required>
		    			    <span id="pass_err" class="error"></span>
		    			</div>
		    		    <span id="signin_err" class="error"></span>	
		    			<br>
		    			<div class="form-group text-center">
		    				<input type="checkbox" id="remember" name="remember" required>
		    				<label for="remember">Залишатись в системі</label>		    				
		    			</div>
		    			<div class="form-group text-center">
		    				<input type="submit" value="Відправити" class="btn btn-success my-btn">
		    				<input type="reset" value="Очистити" class="btn btn-danger my-btn">
		    			</div>
		    		</form>
		    		<script src="static/js/signin.js"></script>
		    		
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
