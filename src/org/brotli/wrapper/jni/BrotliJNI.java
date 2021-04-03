package org.brotli.wrapper.jni;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.brotli.wrapper.enc.BrotliOutputStream;

public class BrotliJNI {

    // does nothing, just makes sure the static initializer gets executed.
    public static void load() {}

    static {
        String libname = "brotli_jni.so";
        String outname = "/tmp/" + libname;

        InputStream in = BrotliOutputStream.class.getResourceAsStream("/" + libname);

        File outfile = new File(outname);
        outfile.deleteOnExit();

        try {
            Files.copy(in, outfile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write " + outname, e);
        }

        System.load(outname);
    }
}

