package com.ig.spockdemo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SampleController)
class SampleControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "SampleController: MIME type handling example"() {
        when:
        request.contentType = 'application/xml'
        controller.index()

        then:
//        response.text == '<xml version="1.0" encoding="UTF-8"?><map><entry key="Hello">World</entry></map>'
        response.text == '<?xml version="1.0" encoding="UTF-8"?><map><entry key="Hello">World</entry></map>'
    }
}