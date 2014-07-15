package com.ig.spockdemo

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestMixin(DomainClassUnitTestMixin)
@TestFor(BookController)
class BookControllerSpec extends Specification {

    void setup() {
        mockDomain(Book)
    }

    void "BookController: save(), Invalid save"() {
        when:
        controller.save()

        then:
        model.bookInstance != null
        view == '/book/create'
    }

    void "BookController: save(), Valid save"() {
        when:
        params.title = "The Stand"
        params.pages=500
        controller.save()

        then:
        response.redirectedUrl == '/book/show/1'
        flash.message != null
        Book.count() == 1

    }
}