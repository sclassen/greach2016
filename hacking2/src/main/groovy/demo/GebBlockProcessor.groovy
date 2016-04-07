package demo

import geb.Browser
import org.asciidoctor.ast.AbstractBlock
import org.asciidoctor.extension.BlockProcessor
import org.asciidoctor.extension.Reader

/**
 * ...
 */
class GebBlockProcessor extends BlockProcessor {

    GebBlockProcessor(String name, Map<String, Object> config) {
        super(name, [contexts: [':literal']])
    }

    @Override
    Object process(AbstractBlock parent, Reader reader, Map<String, Object> attributes) {
        def gebScript = reader.lines().join("\n")

        def shell = new GroovyShell(new Binding([Browser: Browser]))
        shell.evaluate("Browser.drive{ ${gebScript} }")

        createBlock(parent, "skip", "", [:], [:])
    }
}
