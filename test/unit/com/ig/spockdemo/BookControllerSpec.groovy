package com.ig.spockdemo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock(Book)
@TestFor(BookController)
class BookControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    void "BookController: save(), Invalid save"() {
        when:
        controller.save()

        then:
        model.bookInstance != null
        view == '/book/create'
    }
}