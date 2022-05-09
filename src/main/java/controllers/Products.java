package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Products extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Products() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
			case "catalog":
				getCatalogPage(request, response);
				break;
		}
	}
	
	private void getCatalogPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("title", "- Продукти");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/products/catalog.jsp");
		dispatcher.forward(request,  response);
	}
	
}
