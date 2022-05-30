package com.iress.code.input;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

public class FileInputData extends InputData {

    private final List<String> commands;
    private final Iterator<String> itr;

    public FileInputData(File file) throws IOException {
        commands = FileUtils.readLines(file, Charset.defaultCharset());
        itr = commands.iterator();
    }

    @Override
    public String nextLine() {
        return itr.next().trim();
    }

    @Override
    public boolean hasNextLine() {
        return itr.hasNext();
    }
}
