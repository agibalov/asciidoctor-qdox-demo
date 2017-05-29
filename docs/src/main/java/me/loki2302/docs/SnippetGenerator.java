package me.loki2302.docs;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.thoughtworks.qdox.JavaProjectBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SnippetGenerator {
    private final File sourceRoot;

    public SnippetGenerator(File sourceRoot) {
        this.sourceRoot = sourceRoot;
    }

    public String generateClassesSnippet() throws IOException, ScriptException {
        return render("classes.ejs");
    }

    public String generateClassDiagramSnippet() throws IOException, ScriptException {
        return render("class-diagram.ejs");
    }

    private String render(String templateResourcePath) throws IOException, ScriptException {
        String templateString = getResourceAsString(templateResourcePath);

        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        javaProjectBuilder.addSourceTree(sourceRoot);

        return renderEjs(templateString, javaProjectBuilder);
    }

    private static String renderEjs(String templateString, Object model) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
        engine.put("template", templateString);
        engine.put("model", model);
        engine.eval("var modelProxy = Object.bindProperties({}, model)");
        engine.eval("window = {}");
        engine.eval("load('classpath:" +
                "META-INF/resources/webjars/ejs/2.4.1/ejs-v2.4.1/ejs.js')");
        return (String)engine.eval("window.ejs.render(template, modelProxy)");
    }

    private static String getResourceAsString(String resourcePath) {
        try {
            URL templateResourceUrl = Resources.getResource(resourcePath);
            return Resources.toString(templateResourceUrl, Charsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
