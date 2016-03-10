package demo

import geb.Browser
import geb.report.ScreenshotReporter
import org.asciidoctor.ast.AbstractBlock
import org.asciidoctor.extension.BlockMacroProcessor
import org.openqa.selenium.Dimension

class CaptureBlockMacroProcessor extends BlockMacroProcessor {
    CaptureBlockMacroProcessor(String macroName, Map<String, Object> config) {
        super(macroName, config)
    }

    @Override
    protected Object process(AbstractBlock parent, String target, Map<String, Object> attributes) {
        Browser.drive {
            Browser browser = delegate as Browser
            browser.driver.manage().window().size = new Dimension(800, 600)
            browser.config.reporter = new ScreenshotReporter()
            browser.config.reportsDir = '/tmp' as File

            if (target) {
                go target
            }

            report 'screenshot'
        }


        createBlock(parent, "image", "", [
                target: 'file:/tmp/screenshot.png',
                title : attributes['title']
        ], [:])
    }
}
