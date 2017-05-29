package me.loki2302.sampleapp;

import me.loki2302.docs.SnippetGenerator;
import me.loki2302.docs.SnippetWriter;
import org.junit.Test;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class DocTest {
    private final SnippetGenerator snippetGenerator =
            new SnippetGenerator(new File(System.getProperty("sourceDir")));

    private final SnippetWriter snippetWriter =
            new SnippetWriter(Paths.get(System.getProperty("snippetsDir")));

    @Test
    public void documentClasses() throws ScriptException, IOException {
        String snippet = snippetGenerator.generateClassesSnippet();
        snippetWriter.writeSnippet("classes.adoc", snippet);
    }

    @Test
    public void documentClassDiagram() throws ScriptException, IOException {
        String snippet = snippetGenerator.generateClassDiagramSnippet();
        snippetWriter.writeSnippet("class-diagram.adoc", snippet);
    }
}
