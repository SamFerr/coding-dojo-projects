package com.codingdojo.books.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.codingdojo.books.models.Book;
import com.codingdojo.books.repositories.BookRepository;


@Service
public class BookService {
	
	private BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    // initialize the books variable with values
    private List<Book> books = new ArrayList<Book>(Arrays.asList(
            ));
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    public Book findBookById(Long id) {
    	return bookRepository.findOne(id);
    }

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}	

	public void destroyBook(Long id) {
		bookRepository.delete(id);
	}
}