package com.coderswave.dao;

import java.sql.SQLException;
import java.util.List;

import com.coderswave.bo.BookBO;

public interface BookDAO {
	public int insert(BookBO bo) throws Exception;
	public List<BookBO> getBook() throws  Exception;
	public BookBO getBookDetailsById(int Pid) throws SQLException;
	public int delete(int id) throws SQLException;
	public int update(BookBO bo) throws SQLException;
}