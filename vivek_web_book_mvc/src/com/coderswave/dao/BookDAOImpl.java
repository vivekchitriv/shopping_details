package com.coderswave.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coderswave.bo.BookBO;
import com.coderswave.connection.ConnectionManager;

public class BookDAOImpl implements BookDAO {
	private static Connection con;
	private static final String INSERT_BOOK_DETAILS = "INSERT INTO BOOK_DETAILS(BOOKID,BOOKNAME,AUTHOR,STATUS,PRICE,CATEGORY) VALUES(?,?,?,?,?,?)";
	private static final String GET_BOOK_DETAILS = "SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,PRICE,CATEGORY FROM BOOK_DETAILS";
	private static final String GET_BOOK_DETAILS_BY_ID = "SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,PRICE,CATEGORY FROM BOOK_DETAILS WHERE BOOKID=?";
	private static final String DELETE_BOOK_BY_ID = "DELETE BOOK_DETAILS WHERE BOOKID = ? ";
	private static final String UPDATE_BOOK_BY_ID = "UPDATE BOOK_DETAILS SET BOOKNAME=?,AUTHOR=?,STATUS=?, PRICE=?, CATEGORY=? WHERE BOOKID=?  ";
	@Override
	public int insert(BookBO bo) throws Exception {
		int k = 0 ;
		con = ConnectionManager.getConnection();
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","916776");
		PreparedStatement ps = null;
		ps = con.prepareStatement(INSERT_BOOK_DETAILS);
		
		ps.setInt(1, bo.getBookid());
		ps.setString(2, bo.getBookName());
		ps.setString(3, bo.getAuthor());
		ps.setString(4, bo.getStatus());
		ps.setFloat(5, bo.getPrice());
		ps.setString(6, bo.getCategory());
		k = ps.executeUpdate();
		
		
		return k;
	}
	@Override
	public List<BookBO> getBook() throws Exception {
		
		con = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BookBO> listBO = null;
		BookBO bo = null;
		ps = con.prepareStatement(GET_BOOK_DETAILS);
		rs = ps.executeQuery();
		
		listBO = new ArrayList<BookBO>();
		while(rs.next())
		{
			bo = new BookBO();
			bo.setBookid(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setPrice(rs.getFloat(5));
			bo.setCategory(rs.getString(6));
			listBO.add(bo);
		}
		return listBO;
		
	}
	@Override
	public BookBO getBookDetailsById(int bId) throws SQLException {
		con = ConnectionManager.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		BookBO bo = null;
		ps = con.prepareStatement(GET_BOOK_DETAILS_BY_ID);
		ps.setInt(1, bId);
		rs = ps.executeQuery();
		if(rs.next())
		{
			bo = new BookBO();
			bo.setBookid(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setPrice(rs.getFloat(5));
			bo.setCategory(rs.getString(6));
		}
		return bo;
	}
	@Override
	public int delete(int id) throws SQLException {
		int k = 0;
		con = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement(DELETE_BOOK_BY_ID);
		ps.setInt(1, id);
		k = ps.executeUpdate();
		return k;
	}
	@Override
	public int update(BookBO bo) throws SQLException {
		con = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		
		ps = con.prepareStatement(UPDATE_BOOK_BY_ID);
		ps.setString(1, bo.getBookName());
		ps.setString(2, bo.getAuthor());
		ps.setString(3, bo.getStatus());
		ps.setFloat(4, bo.getPrice());
		ps.setString(5, bo.getCategory());
		ps.setInt(6, bo.getBookid());
		result = ps.executeUpdate();
		return result;
	}

}
