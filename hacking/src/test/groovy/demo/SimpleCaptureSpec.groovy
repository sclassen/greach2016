package demo

import org.asciidoctor.Asciidoctor
import spock.lang.Specification

class SimpleCaptureSpec extends Specification {

    def aDoc = """Capture Test XXX"""

    def "ensure asciidoctor is working"() {
        given:
          Asciidoctor asciidoctor = Asciidoctor.Factory.create()

        when:
          String html = asciidoctor.convert(aDoc, [:])
          new File('/tmp/aDoc.html').write(html)
          println html

        then:
          html.contains('<p>Capture Test</p>')
    }
}
