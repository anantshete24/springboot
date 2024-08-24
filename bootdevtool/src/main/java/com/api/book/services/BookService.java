package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;


@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	/*
	private static List<Book> list = new ArrayList();
	
	static {
		
		list.add(new Book(12,"Java Complete Reference", "XYZ"));
		list.add(new Book(24,"Python Complete Reference", "ABC"));
		list.add(new Book(36,"C++ Complete Reference", "KYC"));
		
	
	}
	*/
	public List<Book> getAllBooks()
	{
		List <Book>list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	public Book getBookbyId(int id)
	{
		Book book=null;
		try
		{
		//	book=list.stream().filter(e->e.getId()==id).findFirst().get();
		book=	this.bookRepository.findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	//adding the book
	public Book addBook(Book b)
	{
		Book result=this.bookRepository.save(b);
	
		return result;
	}
	//delete book 
	public void deleteBook(int bid)
	{
		//list=list.stream().filter(book-> book.getId()!=bid).collect(Collectors.toList());
		this.bookRepository.deleteById(bid);
	}

	//update book
	public void updateBook(Book book, int bookId) 
	{
		book.setId(bookId);
		this.bookRepository.save(book);
		/*
		list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
				
		return b;
		}).collect(Collectors.toList());
	}
	*/
	}
}
