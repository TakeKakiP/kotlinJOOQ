/*
 * This file is generated by jOOQ.
 */
package jooq.tables


import jooq.BookDb
import jooq.keys.KEY_BOOKS_PRIMARY
import jooq.tables.records.BooksRecord

import kotlin.collections.Collection

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Books(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, BooksRecord>?,
    parentPath: InverseForeignKey<out Record, BooksRecord>?,
    aliased: Table<BooksRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<BooksRecord>(
    alias,
    BookDb.BOOK_DB,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>book_db.books</code>
         */
        val BOOKS: Books = Books()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<BooksRecord> = BooksRecord::class.java

    /**
     * The column <code>book_db.books.id</code>.
     */
    val ID: TableField<BooksRecord, Int?> = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>book_db.books.book_name</code>.
     */
    val BOOK_NAME: TableField<BooksRecord, String?> = createField(DSL.name("book_name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>book_db.books.author</code>.
     */
    val AUTHOR: TableField<BooksRecord, Int?> = createField(DSL.name("author"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<BooksRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<BooksRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<BooksRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>book_db.books</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>book_db.books</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>book_db.books</code> table reference
     */
    constructor(): this(DSL.name("books"), null)
    override fun getSchema(): Schema? = if (aliased()) null else BookDb.BOOK_DB
    override fun getIdentity(): Identity<BooksRecord, Int?> = super.getIdentity() as Identity<BooksRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<BooksRecord> = KEY_BOOKS_PRIMARY
    override fun `as`(alias: String): Books = Books(DSL.name(alias), this)
    override fun `as`(alias: Name): Books = Books(alias, this)
    override fun `as`(alias: Table<*>): Books = Books(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Books = Books(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Books = Books(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Books = Books(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Books = Books(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Books = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Books = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Books = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Books = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Books = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Books = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Books = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Books = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Books = where(DSL.notExists(select))
}
