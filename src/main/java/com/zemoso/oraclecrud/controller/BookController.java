package com.zemoso.oraclecrud.controller;


import com.zemoso.oraclecrud.dto.BookDto;
import com.zemoso.oraclecrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getBook() {

        return bookService.getBook();
    }

    @PostMapping()
    public BookDto addBook(@RequestBody(required = true) BookDto book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable(value = "id") int bookId, @RequestBody(required = false) BookDto book) {
        bookService.updateBook(bookId,book);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") int id) {
         bookService.deleteBook(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
