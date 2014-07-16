package com.ig.spockdemo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BookService)
@Mock(Book)
class BookServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll("#sno, Testing BookService: save(Book bookInstance), Book")
    void "BookService: save(Book bookInstance), Book"() {

        setup:
        Book book
        boolean isSaved

        when:
        book = new Book(title: title, author: author)
        isSaved = service.save book

        then:
        isSaved == isBookSaved
        Book.count() == expectedCount

        where:
        sno | title         | author         | isBookSaved | expectedCount
        1   | "The Shining" | "Stephen King" | true        | 1
        2   | "The Shining" | "JK"           | false       | 0
        3   | null          | null           | false       | 0
        4   | ''            | ''             | false       | 0

    }
}
