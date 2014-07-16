package com.ig.spockdemo

class CancellingFilters {

    def filters = {
        all(controller:'simple', action:'list') {
            before = {
                redirect controller: 'book'
                return false
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
