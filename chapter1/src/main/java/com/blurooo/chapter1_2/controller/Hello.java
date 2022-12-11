package com.blurooo.chapter1_2.controller;


import com.blurooo.chapter1_2.bean.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/")
    public String hello() {
        return "hello, spring security";
    }
    @GetMapping("/book")
    public Book book() {
        Book book = new Book();
        book.setName("三国演义123");
        book.setAuthor("罗贯中");
        System.out.println("book print::" + book);
        return book;
    }

}
