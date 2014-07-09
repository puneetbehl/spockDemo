package com.ig.spockdemo

class PostController {

    def scaffold = "true"

    def index() {
        redirect(action: "list")
    }
}
