package com.ig.spockdemo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(SampleTagLib)
class SampleTagLibSpec extends Specification {

    def setup() {
        def baseServiceMock = mockFor(BaseService, true) // loose demand - order of call doesn't matter
        baseServiceMock.demand.findAttributeValue(1..1) { arg1 ->
            return true
        }
        tagLib.baseService = baseServiceMock.createMock()


    }

    def cleanup() {
    }

    void "SampleTagLib: writeName()"() {
        expect: 'should render the name'
        applyTemplate('<sample:writeName>John Doe</sample:writeName>') == 'John Doe'
    }
}