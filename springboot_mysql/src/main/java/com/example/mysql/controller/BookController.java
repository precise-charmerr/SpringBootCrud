package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.Book;
import com.example.mysql.repo.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Record saved successfully";
	}
	
	@PostMapping("/multipleBookSave")
	public String insertManyBook(@RequestBody List<Book> book) {
		bookRepository.saveAll(book);
		return "Many Books saved successfully";
	}
	
	@GetMapping("/getAllBook")
	public List<Book> getBook() {
		return (List<Book>) bookRepository.findAll();
	}
	
	@GetMapping("/getByBookId/{bookId}")
	public Optional<Book> getBookbyId(@PathVariable("bookId") long id) {
		return bookRepository.findById(id);
	}
	
	@GetMapping("/getByBookName/{name}")
	public List<Book> getBookbyName(@PathVariable("name") String book_name) {
		return (List<Book>) bookRepository.findBybookName(book_name);
	}
	
	@PutMapping("/UpdateBookById/{id}")
	public void UpdateDataById(@RequestBody Book book, @PathVariable("id") long id) {
		book.setBookId(id);
		bookRepository.save(book);
	}
	
	@DeleteMapping("/DeleteBookById/{id}")
	public void DeleteBookById(@PathVariable("id") long id) {
		bookRepository.deleteById(id);
	}
	
}
