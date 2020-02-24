package com.coderswave.service;

import java.sql.SQLException;
import java.util.List;

import com.coderswave.dto.BookDTO;

public interface BookService {

	public String insertBook(BookDTO dto) throws Exception;
	public List<BookDTO> getBookData() throws Exception;
	public BookDTO fetchBookDetailsbyId(int bId) throws SQLException; 
	public String deleteBookById(int id) throws SQLException;
	public String updateBookById(BookDTO dto) throws SQLException;
}
