package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.DepsService;

import java.io.IOException;


public class Deps extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int depId=0;
	private DepsService depsService; 
       
    public Deps() {
        super();
        depsService = new DepsService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
			case "admin":
				getAdminPage(request, response);
				break;
			case "create":
				getCreatePage(request, response);
				break;
			case "detail":
				 depId = Integer.parseInt(request.getParameter("id"));
				getDetailPage(request, response, depId);
				break;
			case "update":
				 depId = Integer.parseInt(request.getParameter("id"));
				getUpdatePage(request, response,depId);
				break;
			case "delete":
				getDeletePage(request, response);
				break;
		}
	}
	
	private void getAdminPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Підрозділи");
		request.setAttribute("service", depsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/deps/admin.jsp");
		dispatcher.forward(request,  response);
	}

	private void getCreatePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Створення підрозділу");
		request.setAttribute("service", depsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/deps/create.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getDetailPage(HttpServletRequest request, HttpServletResponse response,
			int depId) throws ServletException, IOException {
		request.setAttribute("depId", depId);
		request.setAttribute("title", "- Перегляд підрозділу");
		request.setAttribute("service", depsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/deps/detail.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getUpdatePage(HttpServletRequest request, HttpServletResponse response, int depId) 
			throws ServletException, IOException {
		request.setAttribute("depId", depId);
		request.setAttribute("title", "- Зміна підрозділу");
		request.setAttribute("service", depsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/deps/update.jsp");
		dispatcher.forward(request,  response);
	}
	
	private void getDeletePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Видалення підрозділу");
		request.setAttribute("service", depsService);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/deps/delete.jsp");
		dispatcher.forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depName="";
		int depId=0;
		String operation="";
		boolean success = false;
		String page = request.getParameter("page");
		switch (page) {
		case "create":
			 depName = request.getParameter("depName");
			 operation = "Створення нового підрозділу";
			 success = depsService.createDepartment(depName);
			getReportPage(request, response, operation, success);
			break;
		case "update":
			 depName = request.getParameter("depName");
			 depId = Integer.parseInt(request.getParameter("depId"));
			 System.out.println(depId);
			 operation = "Зміна підрозділу";
			 success = depsService.updateDepartment(depName,depId);
			getReportPage(request, response, operation, success);
			break;
		}
	}
	
	private void getReportPage(HttpServletRequest request, HttpServletResponse response,
			String operation, boolean success) throws ServletException, IOException {
		request.setAttribute("title", "- Сторінка звітів");
		request.setAttribute("operation", operation);
		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/deps/report.jsp");
		dispatcher.forward(request,  response);
	}

}
