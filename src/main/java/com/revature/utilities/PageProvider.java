package com.revature.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PageProvider {

    public static String getPage(String location) {
        try {
            Path loginPath = Paths.get(String.format("src/main/resources/pages/%s.html", location));
            return Files.readString(loginPath, StandardCharsets.UTF_8);
            
        } catch (IOException e) {
            return "An error has occurred";
        }
    }
    
}
