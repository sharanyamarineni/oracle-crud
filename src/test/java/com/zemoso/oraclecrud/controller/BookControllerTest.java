package com.zemoso.oraclecrud.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookControllerTest {
    private MockMvc mockMvc;

    @Autowired
    BookController bookController;

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    @DisplayName("get all books test")
    void getBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("add book test")
    void addBooks() throws Exception {
        String jsonString="{\"id\": \"4\", \"title\": \"social\", \"isbn\": \"789\", \"description\": \"social book\", \"no_pages\": 67} ";
        MvcResult mvcResult = mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonString))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    @DisplayName("Should delete a book")
    void testDeleteBook() {
        ResponseEntity<String> result= bookController.deleteBook(4);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    @DisplayName("Should update a book")
    void testUpdateBook() throws Exception {
        String jsonString="{\"title\": \"current affairs\"} ";
        MvcResult mvcResult = mockMvc.perform(put("/books/4")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonString))
                .andExpect(status().isCreated())
                .andReturn();
    }

}