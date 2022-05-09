package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Home extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
			case "about":
				getAboutPage(request, response);
				break;
			case "contacts":
				getContactsPage(request, response);
				break;
			case "feedback":
				getFeedbackPage(request, response);
				break;
		}
	}
	
	private void getAboutPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Про сайт");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/home/about.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getContactsPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Контакти");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/home/contacts.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getFeedbackPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Feedback");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/home/feedback.jsp");
		dispatcher.forward(request,  response);
	}
}
