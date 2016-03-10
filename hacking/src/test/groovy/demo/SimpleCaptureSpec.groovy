package demo

import org.asciidoctor.Asciidoctor
import spock.lang.Specification

class SimpleCaptureSpec extends Specification {
    def url = SimpleCaptureSpec.classLoader.getResource("sample.html").toString()

    def aDoc = """Capture Test

.freshly captured
capture::${url}[]
"""

    def "ensure macro is working"() {
        given:
          Asciidoctor asciidoctor = Asciidoctor.Factory.create()

        when:
          String html = asciidoctor.convert(aDoc, [:])
          new File('/tmp/aDoc.html').write(html)
          println html

        then:
          html.replaceAll('\n', ' ') =~ /<img src=".*logo.png"/
    }
}
