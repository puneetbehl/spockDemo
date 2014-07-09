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
        assert response.text == 'hello'
    }
}