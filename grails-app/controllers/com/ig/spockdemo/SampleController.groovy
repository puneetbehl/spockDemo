package com.ig.spockdemo

class SampleController {

    def index() {
        def data = ["Hello": "World"]
        request.withFormat {
            xml {render data as grails.converters.XML}
            json {render data as grails.converters.JSON}
            html {render data}
        }

    }
}
