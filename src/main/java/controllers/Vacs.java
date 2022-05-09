package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import services.VacsService;
import models.Vacancy;


public class Vacs extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    private VacsService vacsService;
	
	public Vacs() {
        super();
        vacsService = new VacsService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
			case "list":
				getListPage(request, response);
				break;
		}
	}
	
	private void getListPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "- Вакансії");
		List<Vacancy> vacancies = vacsService.getAllVacancies();
		request.setAttribute("vacancies", vacancies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/vacs/list.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
