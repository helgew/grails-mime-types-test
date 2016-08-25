package com.example

import grails.test.mixin.integration.Integration
import grails.web.mime.MimeType
import grails.web.mime.MimeUtility
import spock.lang.Specification

@Integration
class MimeTypeSpec extends Specification {
    MimeUtility grailsMimeUtility

    void "Test that we can resolve a configured mime-type"() {
        when: "We don't have a plugin with mime-types"
        MimeType type = grailsMimeUtility.getMimeTypeForExtension('foo')


        then: "We can resolve our mime-type"
        type != null && type.name == 'bar'
    }
}
