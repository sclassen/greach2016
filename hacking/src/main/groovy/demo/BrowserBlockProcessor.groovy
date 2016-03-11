package demo

import org.asciidoctor.ast.AbstractBlock
import org.asciidoctor.extension.BlockProcessor
import org.asciidoctor.extension.Reader

class BrowserBlockProcessor extends BlockProcessor {
    BrowserBlockProcessor(String name, Map<String, Object> config) {
        super(name, [contexts: [':literal']])
    }

    @Override
    Object process(AbstractBlock parent, Reader reader, Map<String, Object> attributes) {
        createBlock(parent, "paragraph", "browser: " + reader.lines().join("\n"), [:], [:])
    }
}
