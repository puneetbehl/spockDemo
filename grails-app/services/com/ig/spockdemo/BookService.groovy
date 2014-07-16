package com.ig.spockdemo

class BookService {

    Book save(Book bookInstance) {
        if (!(bookInstance?.validate() && bookInstance?.save(flush: true))) {
            bookInstance = null
        }
        bookInstance
    }
}
