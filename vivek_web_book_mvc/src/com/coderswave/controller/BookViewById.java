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

import com.coderswave.dto.BookDTO;
import com.coderswave.service.BookService;
import com.coderswave.service.BookServiceImpl;
@WebServlet("/edit_book")
public class BookViewById extends HttpServlet{
		private BookService service = null;
		
		@Override
		public void init(ServletConfig config) throws ServletException {
		service = new BookServiceImpl();
		}
		
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bId = 0;
		BookDTO dto = null;
		RequestDispatcher rd = null;
		
		bId = Integer.parseInt(req.getParameter("id"));
		
		try {
			dto = service.fetchBookDetailsbyId(bId);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		req.setAttribute("dto", dto);
		rd = req.getRequestDispatcher("edit_book.jsp");
		rd.forward(req, res);
		}
		
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			doPost(req, res);
		}
}
