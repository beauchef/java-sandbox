package com.beauchef.jvm.security;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author beauchef 9/10/2016.
 */
public class SimpleSecurity {

    public static void main(String[] args) throws IOException {
        String version = System.getProperty("java.version");
        System.out.println(version);

        System.setSecurityManager(new SecurityManager());
        try (FileWriter writer = new FileWriter("C:/temp/out.txt")) {
            writer.write("Ok...");
        }
    }
}
