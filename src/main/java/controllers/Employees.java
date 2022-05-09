package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.EmpsService;

import java.io.IOException;


public class Employees extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EmpsService empsService; 

    public Employees() {
        super();
        empsService = new EmpsService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
			case "employees":
				getEmployeesPage(request, response);
				break;		
			case "admin":
				getAdminPage(request, response);
				break;	
			case "create":
				getCreatePage(request, response);
				break;
			case "detail":
				getDetailPage(request, response);
				break;
			case "update":
				getUpdatePage(request, response);
				break;
			case "delete":
				getDeletePage(request, response);
				break;
		}
	}
	private void getAdminPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Співробітники");
		request.setAttribute("service", empsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/emps/admin.jsp");
		dispatcher.forward(request,  response);
	}
	private void getEmployeesPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/emps/employees.jsp");
		dispatcher.forward(request,  response);
	}
	private void getCreatePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Додання співробітника");
		request.setAttribute("service", empsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/emps/create.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getDetailPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Перегляд співробітника");
		request.setAttribute("service", empsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/emps/detail.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getUpdatePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Зміна співробітника");
		request.setAttribute("service", empsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/emps/update.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getDeletePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Видалення співробітника");
		request.setAttribute("service", empsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/emps/delete.jsp");
		dispatcher.forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
		case "create":
			String empName = request.getParameter("empFullName");
			String operation = "Додання нового співробітника";
			boolean success = empsService.addNewEmployee(empName);
			getReportPage(request, response, operation, success);
			break;
		}
	}
	
	private void getReportPage(HttpServletRequest request, HttpServletResponse response,
			String operation, boolean success) throws ServletException, IOException {
		request.setAttribute("title", "- Сторінка звітів");
		request.setAttribute("operation", operation);
		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/emps/report.jsp");
		dispatcher.forward(request,  response);
	}

}