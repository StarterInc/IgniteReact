package com.winterbe.react;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class React {

    private ThreadLocal<NashornScriptEngine> engineHolder = new ThreadLocal<NashornScriptEngine>() {
        @Override
        protected NashornScriptEngine initialValue() {
            NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
            try {
            	System.out.print("Begin React Initializion...");
                nashornScriptEngine.eval(read("static/nashorn-polyfill.js"));
                nashornScriptEngine.eval(read("static/vendor/react.js"));
                nashornScriptEngine.eval(read("static/vendor/jvm-npm.js"));
                nashornScriptEngine.eval(read("static/vendor/showdown.min.js"));
                nashornScriptEngine.eval(read("static/commentBox.js"));
                
                nashornScriptEngine.eval(read("static/vendor/lib/text-field.js"));
                System.out.println("done.");
                
              //  nashornScriptEngine.eval(read("jsx/lib/Button.js"));
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
            return nashornScriptEngine;
        }
    };

    public  String renderCommentBox(List<Comment> comments) {
        try {
            Object html = engineHolder.get().invokeFunction("renderServer", comments);
            return String.valueOf(html);
        }
        catch (Exception e) {
            throw new IllegalStateException("failed to render react component", e);
        }
    }

    private Reader read(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}

