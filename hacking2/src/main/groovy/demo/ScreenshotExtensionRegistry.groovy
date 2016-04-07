package demo

import org.asciidoctor.Asciidoctor
import org.asciidoctor.extension.spi.ExtensionRegistry

class ScreenshotExtensionRegistry implements ExtensionRegistry {

    @Override
    void register(Asciidoctor asciidoctor) {
        asciidoctor.javaExtensionRegistry().blockMacro('screenshot', ScreenshotBlockMacroProcessor)
        asciidoctor.javaExtensionRegistry().block('geb', GebBlockProcessor)
    }
}
