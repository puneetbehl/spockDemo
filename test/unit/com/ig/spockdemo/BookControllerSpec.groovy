package com.ig.spockdemo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Book])
@TestFor(BookController)
class BookControllerSpec extends Specification {

    void "BookController: save(), Invalid save"() {
        when:
        controller.save()

        then:
        model.bookInstance != null
        view == '/book/create'
    }

    void "BookController: save(), Valid save"() {
        when:
        params.title = "The Secret"
        params.pages=100
        controller.save()

        then:
        response.redirectedUrl == '/book/show/1'
        flash.message != null
        Book.count() == 1

    }
}