package com.book_manage.service

import com.book_manage.response.BookResponse
import jooq.tables.Books.Companion.BOOKS
import jooq.tables.references.AUTHOR
import org.jooq.DSLContext
import org.jooq.Record2
import org.jooq.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class BookManageService {

    @Autowired
    private lateinit var create: DSLContext

    fun getBook(bookName:String): MutableList<BookResponse> {
        // 書籍の名前と作者名だけ取得する
        val result: Result<Record2<String?, String?>> = create
            .select(BOOKS.BOOK_NAME,AUTHOR.AUTHOR_NAME).from(BOOKS.join(AUTHOR).on(BOOKS.AUTHOR.eq(AUTHOR.ID)))
            .where(BOOKS.BOOK_NAME.like("%$bookName%")).fetch()

        val bookList = mutableListOf<BookResponse>()
        for (record in result){
            val bookResponse = BookResponse(record.getValue(BOOKS.BOOK_NAME),record.getValue(BOOKS.BOOK_NAME))
            bookList.add(bookResponse)
        }

        return bookList

    }

    fun insertBook(bookName:String,author:Int): String {
        val insertRecord:Int = create.insertInto(BOOKS).set(BOOKS.BOOK_NAME,bookName).set(BOOKS.AUTHOR,author).execute()
        return if(insertRecord != 0){
            "正常に書籍が登録されました"
        } else {
            "書籍の登録に失敗しました"
        }
    }

    fun updateBook(id: Int, bookName:String, author:Int): String {
        val updateRecord:Int = create.update(BOOKS).set(BOOKS.BOOK_NAME,bookName).set(BOOKS.AUTHOR,author).where(BOOKS.ID.equal(id)).execute()
        return if(updateRecord != 0){
            "正常に書籍が更新されました"
        } else {
            "書籍の更新に失敗しました"
        }
    }

    fun insertAuthor(author:String): String {
        val insertRecord:Int = create.insertInto(AUTHOR).set(AUTHOR.AUTHOR_NAME,author).execute()
        return if(insertRecord != 0){
            "正常に著者が登録されました"
        } else {
            "著者の登録に失敗しました"
        }
    }

    fun getBookByAuthor(author:String): MutableList<BookResponse> {
        // 著者名(完全一致)で検索する
        val result: Result<Record2<String?, String?>> = create
            .select(BOOKS.BOOK_NAME,AUTHOR.AUTHOR_NAME).from(BOOKS.join(AUTHOR).on(BOOKS.AUTHOR.eq(AUTHOR.ID)))
            .where(AUTHOR.AUTHOR_NAME.equal(author)).fetch()

        val bookList = mutableListOf<BookResponse>()
        for (record in result){
            val bookResponse = BookResponse(record.getValue(BOOKS.BOOK_NAME),record.getValue(BOOKS.BOOK_NAME))
            bookList.add(bookResponse)
        }

        return bookList

    }
}