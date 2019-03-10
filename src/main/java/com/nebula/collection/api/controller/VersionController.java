package com.nebula.collection.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author yangsen
 * git commit 版本接口
 */
@RestController
public class VersionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VersionController.class);


    @RequestMapping(value = "/version", method = GET)
    public String versionInformation() {
        return readGitProperties();
    }

    private String readGitProperties() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("git.properties");
            return readFromInputStream(inputStream);
        } catch (IOException e) {
            LOGGER.error("readGitProperties error", e);
            return "Version information could not be retrieved";
        }
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
