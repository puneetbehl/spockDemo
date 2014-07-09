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

    def home() {
        render view: "homePage", model: [title: "Hello World"]
    }

    def display() {
        render template:"snippet"
    }

    def renderXml() {
        render(contentType:"text/xml") {
            book(title:"Great")
        }
    }

    def renderJson() {
        render(contentType:"text/json") {
            book = "Great"
        }
    }
}
