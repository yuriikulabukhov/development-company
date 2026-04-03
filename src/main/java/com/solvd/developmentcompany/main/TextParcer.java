package com.solvd.developmentcompany.main;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextParcer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextParcer.class);

    public static void run() throws IOException {

        String content = FileUtils.readFileToString(
                new File("src/main/recources/input.txt"), "UTF-8");
        LOGGER.info("File read. Characters: " + content.length());
        String[] words = StringUtils.split(content.toLowerCase());
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        LOGGER.info("Total words: " + words.length);
        LOGGER.info("Unique words: " + uniqueWords.size());
        String result = "Total words:  " + words.length + "\n"
                + "Unique words: " + uniqueWords.size() + "\n\n";
        FileUtils.writeStringToFile(
                new File("src/main/recources/output.txt"), result, "UTF-8");
    }
}
