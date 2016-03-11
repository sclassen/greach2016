package demo

import org.asciidoctor.Asciidoctor
import spock.lang.Specification

class SimpleCaptureSpec extends Specification {
    def url = SimpleCaptureSpec.classLoader.getResource("sample.html").toString()

    def aDoc = """Capture Test

[browser]
....
go "${url}"
\$("input").value("Greach 2016")
....

.freshly captured
capture::[]
"""

    def "ensure macro is working"() {
        given:
          Asciidoctor asciidoctor = Asciidoctor.Factory.create()

        when:
          String html = asciidoctor.convert(aDoc, [:])
          new File('/tmp/aDoc.html').write(html)
          println html

        then:
          ! html.contains('go')
    }
}
