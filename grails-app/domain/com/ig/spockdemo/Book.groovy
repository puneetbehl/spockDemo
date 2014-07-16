package com.ig.spockdemo

class Book {

    String title
    String author

    static constraints = {
        title blank: false, unique: true
        author blank: false, minSize:5
    }
}
