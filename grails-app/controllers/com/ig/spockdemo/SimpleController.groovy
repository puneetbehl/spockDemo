package com.ig.spockdemo

class SimpleController {

    def hello() {
        render "hello"
    }

    def index() {
        redirect action: 'hello'
    }

    def list() {
        List<Person> persons = Person.list(params)
        [persons: persons]
    }
}
