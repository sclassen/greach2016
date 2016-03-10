package demo

import org.asciidoctor.ast.AbstractBlock
import org.asciidoctor.extension.BlockMacroProcessor

class CaptureBlockMacroProcessor extends BlockMacroProcessor {
    CaptureBlockMacroProcessor(String macroName, Map<String, Object> config) {
        super(macroName, config)
    }

    @Override
    protected Object process(AbstractBlock parent, String target, Map<String, Object> attributes) {
        createBlock(parent, "paragraph", "Greach 2016", [:], [:])
    }
}
