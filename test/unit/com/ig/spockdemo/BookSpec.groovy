package com.ig.spockdemo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Book: constraints validation"() {
        setup:
        Book book
        Book exisingBook

        when:
        book = new Book()

        then:
        !book.validate()
        book.errors.getFieldError('title').code == 'nullable'
        book.errors.getFieldError('author').code == 'nullable'

        when:
        exisingBook = new Book(title: "Misery", author: "Stephen King")
        mockForConstraintsTests(Book, [exisingBook])
        book = new Book(title: "Misery", author: "JK")

        then:
        !book.validate()
        book.errors.getFieldError('title').code == 'unique'
        book.errors.getFieldError('author').code == 'minSize.notmet'

        when:
        book = new Book(title: "The Shining", author: "Stephen King")

        then:
        book.validate()

    }

}