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
        exisingBook = new Book(title: "Misery", author: "Stephen King")
        mockForConstraintsTests(Book, [exisingBook])
        book = new Book(title: title, author: author)

        then:
        book.validate() == expectedValidationResult
        book.hasErrors() == hasErrors
        book.errors?.getFieldError('title')?.code == errorCodeTitle
        book.errors?.getFieldError('author')?.code == errorCodeAuthor

        where:
        sno | title         | author         | errorCodeTitle | errorCodeAuthor  | expectedValidationResult | hasErrors
        1   | null          | null           | 'nullable'     | 'nullable'       | false                    | true
        2   | "Misery"      | "JK"           | "unique"       | "minSize.notmet" | false                    | true
        3   | "The Shining" | "Stephen King" | null           | null             | true                     | false

    }

}