package com.ig.spockdemo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SimpleController)
class SimpleControllerSpec extends Specification {

    void "test hello"() {
        when:
        controller.hello()

        then:
        response.text == 'hello'
    }

    void "test index action redirect"() {
        when:
        controller.index()

        then:
        response.redirectedUrl == '/simple/hello'
    }

    void "associating params"() {
        setup:
        def model

        when:
        params.sort = "name"
        params.max = 20
        params.offset = 0
        model = controller.list()

        then:
        model.persons.size() == 20

    }


    void "view rendering"() {
        when:
        controller.home()

        then:
        view == "/simple/homePage"
        model.title == "Hello World"
    }
}