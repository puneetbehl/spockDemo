package com.ig.spockdemo

class BookController {

    def index() {}

    def save() {
        Book book = new Book(params)
        if (book.save(flush: true)) {
            flash.message = message(
                    code: 'default.created.message',
                    args: [message(code: 'book.label',
                            default: 'Book'), book.id]
            )
            redirect action: "show", id: book.id
        } else {
            render view: 'create', model: [bookInstance: book]
        }
    }
}
