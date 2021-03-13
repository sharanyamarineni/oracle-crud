package com.zemoso.oraclecrud.service;

import com.zemoso.oraclecrud.dao.BookRepository;
import com.zemoso.oraclecrud.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getBook() {
        return bookRepository.getBook();
    }

    public BookDto addBook(BookDto book) {
        return bookRepository.addBook(book);
    }

    public void updateBook(int id,BookDto book) {
        bookRepository.updateBook(id,book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }
}
