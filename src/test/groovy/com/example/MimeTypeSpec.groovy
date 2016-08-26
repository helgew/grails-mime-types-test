package com.example

import grails.core.GrailsApplication
import grails.test.mixin.integration.Integration
import grails.web.mime.MimeType
import grails.web.mime.MimeUtility
import spock.lang.Specification

@Integration
class MimeTypeSpec extends Specification {
    MimeUtility grailsMimeUtility
    GrailsApplication grailsApplication

    void "Test that we can resolve a configured mime-type"() {
        when: "We have a plugin with mime-types"
        MimeType type = grailsMimeUtility.getMimeTypeForExtension('foo')


        then: "We should be able to resolve our mime-type"
        type != null && type.name == 'bar'

        and: "the config is still there"
        grailsApplication.config.grails.mime.types.foo == 'bar'
    }
}
