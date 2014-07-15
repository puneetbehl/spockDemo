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

        when:
        book = new Book()

        then:
        !book.validate()
        book.errors.getFieldError('title').code == 'nullable'
        book.errors.getFieldError('author').code == 'nullable'

    }
}