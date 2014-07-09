package com.ig.spockdemo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PostController)
class PostControllerSpec extends Specification {

    def "Index action should redirect to list page"() {
        when:
        controller.index()

        then:
        response.redirectedUrl == "/post/list"
    }
}