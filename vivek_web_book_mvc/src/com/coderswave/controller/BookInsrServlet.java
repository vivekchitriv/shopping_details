package com.coderswave.controller;

import java.io.IOException;

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
@WebServlet("/add")
public class BookInsrServlet extends HttpServlet{
	private BookService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new BookServiceImpl();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BookDTO dto = null;
		String result = null;
		RequestDispatcher rd = null;
		res.setContentType("text/html");
		
		dto = new BookDTO();
		
		dto.setBookid(Integer.parseInt(req.getParameter("id")));
		dto.setBookName(req.getParameter("name"));
		dto.setAuthor(req.getParameter("author"));
		dto.setStatus(req.getParameter("status"));
		dto.setPrice(Float.parseFloat(req.getParameter("price")));
		dto.setCategory(req.getParameter("category"));
		
		try {
			result = service.insertBook(dto);
			
		} catch (Exception e) {
			
		}
		
		req.setAttribute("result", result);
		rd = req.getRequestDispatcher("view_book.htm");
		rd.forward(req, res);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPost(req, res);
	}

}
