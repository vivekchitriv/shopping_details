 package com.coderswave.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coderswave.bo.BookBO;
import com.coderswave.dao.BookDAO;
import com.coderswave.dao.BookDAOImpl;
import com.coderswave.dto.BookDTO;

public class BookServiceImpl implements BookService{

	@Override
	public String insertBook(BookDTO dto) throws Exception {
		BookDAO dao = null;
		BookBO bo =null;
		int result = 0;
		bo = new BookBO();
		dao = new BookDAOImpl();
		
		bo.setBookid(dto.getBookid());
		bo.setBookName(dto.getBookName());
		bo.setAuthor(dto.getAuthor());
		bo.setStatus(dto.getStatus());
		bo.setPrice(dto.getPrice());
		bo.setCategory(dto.getCategory());
		result = dao.insert(bo);
		if(result>0)
			return "Data inserted Successfully";
		else
			return "failed";
	}

	@Override
	public List<BookDTO> getBookData() throws Exception {
		
		BookDAO dao = null;
		List<BookBO> listBO = null;
		List<BookDTO> listDTO = new ArrayList<BookDTO>();
		dao = new BookDAOImpl();
		listBO = dao.getBook();
		listBO.forEach(bo->{
			BookDTO dto = new BookDTO();
			dto.setBookid(bo.getBookid());
			dto.setBookName(bo.getBookName());
			dto.setAuthor(bo.getAuthor());
			dto.setStatus(bo.getStatus());
			dto.setPrice(bo.getPrice());
			dto.setCategory(bo.getCategory());
			
			listDTO.add(dto);
			
		});
		return listDTO;
	}

	@Override
	public BookDTO fetchBookDetailsbyId(int bId) throws SQLException {
		BookDAO dao = null;
		BookDTO dto = null;
		BookBO bo = null;
		
		dao = new BookDAOImpl();
		dto = new BookDTO();
		bo = dao.getBookDetailsById(bId);
		
		bo.setBookid(dto.getBookid());
		bo.setBookName(dto.getBookName());
		bo.setAuthor(dto.getAuthor());
		bo.setStatus(dto.getStatus());
		bo.setPrice(dto.getPrice());
		bo.setCategory(dto.getCategory());
		
		return dto;
	}

	@Override
	public String deleteBookById(int id) throws SQLException {
		BookDAO dao = null;
		int result = 0;
		dao = new BookDAOImpl();
		result = dao.delete(id);
		
		if(result>0)
			return "Deleted";
		else
			return "failed";
		
	}

	@Override
	public String updateBookById(BookDTO dto) throws SQLException {
		BookDAO dao = null;
		BookBO bo = null;
		int result = 0;
		dao = new BookDAOImpl();
		bo = new BookBO();
		bo.setBookid(dto.getBookid());
		bo.setBookName(dto.getBookName());
		bo.setAuthor(dto.getAuthor());
		bo.setStatus(dto.getStatus());
		bo.setPrice(dto.getPrice());
		bo.setCategory(dto.getCategory());
		result = dao.update(bo);
		if(result>0)
			return "updated";
		else
			return "failed";
			}
	
	

}
