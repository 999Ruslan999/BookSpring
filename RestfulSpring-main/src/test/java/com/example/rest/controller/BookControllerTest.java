package com.example.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.rest.service.BookController;
import com.example.rest.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(BookController.class)
public class BookControllerTest {
    @MockBean
    BookService bookService;
    @Autowired
    MockMvc mockMvc;

//    @Test
//    public void testfindAll() throws Exception {
//        Book book = new Book(1L, "Re", LocalDate.now());
//        List<Book> books = Collections.singletonList(book);
//
//        Mockito.when(bookService.getAllBooks()).thenReturn(books);
//
//        mockMvc.perform(get("/books/all"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(jsonPath("$[0].title", Matchers.is("Re")));
//    }


//    @Test
//    public void getBookById() throws Exception {
//        Book book = new Book(1L, "Re", LocalDate.now());
//
//        Mockito.when(bookService.findById(1L)).thenReturn(book);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/books/{id}", 1)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.title").value("Re"));
//
//    }

    @Test
    public void testDelete() throws Exception {
        willDoNothing().given(bookService).delete(any());

        mockMvc.perform(delete("/books/delete/{id}", 1))
                .andExpect(status().isOk())
                .andDo(print());
    }

}