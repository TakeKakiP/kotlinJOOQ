package com.book_manage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookManageApplication

fun main(args: Array<String>) {
	runApplication<BookManageApplication>(*args)
}
