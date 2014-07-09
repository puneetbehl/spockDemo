package com.ig.spockdemo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Mock([Person])
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

    void "template rendering"() {
        when:
        controller.display()

        then:
        response.text == 'Sample Template' // Content of template
    }

    void "XML rendering"() {
        when:
        controller.renderXml()

        then:
        "<book title='Great'/>" == response.text
        "Great" == response.xml.@title.text()
    }

    void "JSON rendering"() {
        when:
        controller.renderJson()

        then:
        '{"book":"Great"}' == response.text
        "Great" == response.json.book
    }
}