package com.coderswave.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderswave.service.BookService;
import com.coderswave.service.BookServiceImpl;
@WebServlet("/delete_book")
public class BookDeleServlet extends HttpServlet {
	private static BookService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new BookServiceImpl();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		int id = 0;
		String result = null;
		RequestDispatcher rd = null;
		id  = Integer.parseInt(req.getParameter("id"));
		
		try {
			result = service.deleteBookById(id);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		req.setAttribute("Result", result);
		rd =  req.getRequestDispatcher("view_book.htm");
		rd.forward(req, res);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPost(req, res);
	}
}
