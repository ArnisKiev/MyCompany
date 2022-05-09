<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">MyCompany</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Головна</a></li>
				<li class="nav-item"><a class="nav-link" href="home?page=about">Про
						сайт</a></li>
				<li class="nav-item"><a class="nav-link" href="news?page=list">Новини</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="products?page=catalog">Продукти</a></li>
				<li class="nav-item"><a class="nav-link"
					href="home?page=contacts">Контакти</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown"
					data-bs-toggle="dropdown" aria-expanded="false"> Адмін </a>
					<ul class="dropdown-menu" aria-labelledby="dropdown">
						<li class="nav-item">
							<a class="dropdown-item" href="deps?page=admin">Підрозділи</a>
						</li>
						<li class="nav-item">
			          			<a class="dropdown-item" href="vacs?page=list">Вакансії</a>
			        		</li>
						<li class="nav-item">
							<a class="dropdown-item" href="emps?page=admin">Співробітники</a>
						</li>
						<li class="nav-item">
							<a class="dropdown-item" href="deps?page=admin">Користувачі</a>
						</li>
					</ul>
				</li>
			</ul>
			<ul class="navbar-nav ms-auto mb-2 mb-md-0">
	      			<li class="nav-item">
			          	<a class="nav-link" href="#" style="margin-right: 75px; color: yellow">
			          		Привіт, Гість!
			          	</a>
			        </li>
	      			<li class="nav-item">
			          	<a class="nav-link" href="auth?page=signin">Вхід</a>
			        </li>
			        <li class="nav-item">
			          	<a class="nav-link" href="auth?page=signup">Реєстрація</a>
			        </li>
	      		</ul>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>