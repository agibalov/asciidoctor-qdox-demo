package me.loki2302.docs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class SnippetWriter {
    private final Path snippetsDirectoryPath;

    public SnippetWriter(Path snippetsDirectoryPath) {
        this.snippetsDirectoryPath = snippetsDirectoryPath;
    }

    public void writeSnippet(String snippetFileName, String content) {
        try {
            Files.createDirectories(snippetsDirectoryPath);
            Path snippetPath = snippetsDirectoryPath.resolve(snippetFileName);
            Files.write(snippetPath, Collections.singleton(content));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
