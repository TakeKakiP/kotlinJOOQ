package com.book_manage.controller

import com.book_manage.response.BookResponse
import com.book_manage.service.BookManageService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class BooKManageController {

    @Autowired
    lateinit var bookManageService: BookManageService

    @GetMapping(value = ["/bookmanage/book"])
    fun getBook(@RequestParam("bookName") bookName:String): MutableList<BookResponse> {
        return bookManageService.getBook(bookName)
    }

    @PostMapping(value = ["/bookmanage/book"])
    fun insertBook(@RequestParam("bookName") bookName:String,
                   @RequestParam("author") author:Int): String {
        return bookManageService.insertBook(bookName,author)
    }

    @PutMapping(value = ["/bookmanage/book"])
    fun updateBook(@RequestParam("id") id: Int,
                   @RequestParam("bookName") bookName:String,
                   @RequestParam("author") author:Int): String {
        return bookManageService.updateBook(id,bookName,author)
    }

    @PostMapping(value = ["/bookmanage/author"])
    fun insertAuthor(@RequestParam("author") author:String): String {
        return bookManageService.insertAuthor(author)
    }

    @GetMapping(value = ["/bookmanage/bookbyauthor"])
    fun getBookByAuthor(@RequestParam("author") author:String): MutableList<BookResponse> {
        return bookManageService.getBookByAuthor(author)
    }
}