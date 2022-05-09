package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import services.UsersService;
import services.AuthServices;
import services.EmailService;

public class Auth extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsersService usersService;
	private AuthServices authService; 


	public Auth() {
		super();
		
		usersService = new UsersService();
		authService = new AuthServices();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
		case "signin":
			getSigninPage(request, response);
			break;
		case "signup":
			getSignupPage(request, response);
			break;
		case "ajax_signup":
			getAjaxSignupData(request, response);
			break;
		case "ajax_signin":
			getAjaxSigninData(request, response);
			break;
		}
	}

	private void getAjaxSignupData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkLogin = request.getParameter("login");
		String checkEmail = request.getParameter("email");

		String backMessage = "NO";
		
		if (checkLogin != null) {
			// Код із запитом до БД ...

			backMessage = "YES";
			response.getWriter().write(backMessage);
		} else if (checkEmail != null) {
			// Код із запитом до БД ...
			if(!authService.checkEmailExist(checkEmail)) {
				backMessage = "YES";
			}
			response.getWriter().write(backMessage);
		}
		else {
			response.getWriter().write(backMessage);
		}

	}
	
	private void getAjaxSigninData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkLogin = request.getParameter("login");

		String backMessage = "NO";	
		
		if (checkLogin != null) {
			// Код із запитом до БД ...
				backMessage = "YES";
				response.getWriter().write(backMessage);	
		}
		else {
			response.getWriter().write(backMessage);
		}

	}

	private void getSigninPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "- Авторизація");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/signin.jsp");
		dispatcher.forward(request, response);
	}

	private void getSignupPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "- Реєстрація");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
		case "signin":
			handleSigninForm(request, response);
			break;
		case "signup":
			handleSignupForm(request, response);
			break;
		}
	}

	private String getMD5Hash(String initPassword) {
		String hashPassword = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(initPassword));
			hashPassword = String.format("%032x", new BigInteger(1, md5.digest()));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("getMD5Hash-Exception: " + e.getMessage());
		}
		return hashPassword;
	}

	private void handleSigninForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputLogin = request.getParameter("login");
		String inputPass = request.getParameter("pass");
		String hashPassword = getMD5Hash(inputPass);
		boolean resultSuccess = usersService.checkUser(inputLogin, hashPassword);
		String color = "";
		String message = "";

		if (resultSuccess) {
			color = "green";
			message = "Вхід на сайт виконано!";
		}
		request.setAttribute("title", "- Звіт про авторизацію");
		request.setAttribute("color", color);
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/signin_res.jsp");
		dispatcher.forward(request, response);
	}

	private void handleSignupForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputLogin = request.getParameter("login");
		String inputPass1 = request.getParameter("pass1");
		String inputEmail = request.getParameter("email");

		String hashPassword = getMD5Hash(inputPass1);
		boolean resultSuccess = usersService.addUser(inputLogin, hashPassword, inputEmail, 2, 1);
		String color = "";
		String message = "";

		if (resultSuccess) {
			color = "green";
			message = "Ви успішно зареєструвались на нашому сайті!";

			// Відправлення E-Mail для підтвердження реэстрації
			ServletContext context = getServletContext();

			String user = context.getInitParameter("user");
			String pass = context.getInitParameter("pass");
			String host = context.getInitParameter("host");
			String port = context.getInitParameter("port");

			String address = inputEmail;
			String topic = "Підтвердження реєстрації на сайті MyCompany";
			String url = "http://localhost:8080/MyCompany/auth?page=confirm&email=" + inputEmail;

			String html = "<h2>Ви успішно зареєструвались на сайті MyCompany</h2>";
			html += "<hr/><h3>Для активації акаунту перейдіть за посиланням:<br/>";
			html += String.format("<a href=\"%s\">Підтвердити реєстрацію</a>", url);

			try {
				EmailService.sendMail(host, port, user, pass, address, topic, html);
			} catch (MessagingException e) {
				System.out.println("EmailException - " + e.getMessage());
				color = "red";
				message = "Не вдалося відправити листа підтвердження реєстрації!";
			}
		} else {
			color = "red";
			message = "У реєстрації відмовлено!";
		}

		request.setAttribute("title", "- Звіт про реєстрацію");
		request.setAttribute("color", color);
		request.setAttribute("message", message);
		request.setAttribute("email", inputEmail);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/signup_res.jsp");
		dispatcher.forward(request, response);
	}

}
