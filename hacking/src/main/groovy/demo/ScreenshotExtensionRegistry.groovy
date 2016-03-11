package demo

import org.asciidoctor.Asciidoctor
import org.asciidoctor.extension.spi.ExtensionRegistry

class ScreenshotExtensionRegistry implements ExtensionRegistry {

    @Override
    void register(Asciidoctor asciidoctor) {
        asciidoctor.javaExtensionRegistry().blockMacro 'capture', CaptureBlockMacroProcessor
        asciidoctor.javaExtensionRegistry().block 'browser', BrowserBlockProcessor
    }
}
