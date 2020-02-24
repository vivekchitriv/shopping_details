package com.coderswave.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderswave.dto.BookDTO;
import com.coderswave.service.BookService;
import com.coderswave.service.BookServiceImpl;
@WebServlet("/view_book.htm")
public class BookViewServlet extends HttpServlet {
	private BookService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new BookServiceImpl();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<BookDTO> listDTO = null;
		RequestDispatcher rd = null;
		
		try {
			listDTO = service.getBookData();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		req.setAttribute("Books", listDTO);
		rd = req.getRequestDispatcher("view_book.jsp");
		rd.forward(req, res);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
	}
	
}
