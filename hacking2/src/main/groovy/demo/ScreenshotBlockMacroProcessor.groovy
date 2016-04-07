package demo

import org.asciidoctor.ast.AbstractBlock
import org.asciidoctor.extension.BlockMacroProcessor

/**
 * ...
 */
class ScreenshotBlockMacroProcessor  extends BlockMacroProcessor {

    ScreenshotBlockMacroProcessor(String macroName, Map<String, Object> config) {
        super(macroName, config)
    }

    @Override
    protected Object process(AbstractBlock parent, String target, Map<String, Object> attributes) {

        def imagePath = getClass().classLoader.getResource('logo.png').toString()

        createBlock(parent, "image", "", [
                target: imagePath
        ], [:])    }
}
