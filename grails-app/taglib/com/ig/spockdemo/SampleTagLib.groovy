package com.ig.spockdemo

class SampleTagLib {

    static namespace = "sample"

    def baseService

    def writeName = {attrs,body->
        def result = baseService.findAttributeValue(attrs.something)

        if(result)
            out << body()
    }

}
