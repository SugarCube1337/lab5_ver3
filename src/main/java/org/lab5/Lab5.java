package org.lab5;


import org.lab5.collection.CollectionManager;
import org.lab5.exception.AbortException;
import org.lab5.exception.IllegalFieldException;
import org.lab5.parser.BaseCommandParser;
import org.lab5.parser.CommandParser;
import org.lab5.parser.ConsoleInputManager;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

/**
 * Main class for lab 5
 */

public class Lab5 {

    private static final String DEFAULT_PATH = "data.json";
    private static String path = DEFAULT_PATH;

    /**
     * Entry point for the project
     * @param args contains information about collection's data
     */
    public static void main(String[] args) {

        if (args.length > 0) {
            path = args[0];
        } else {
            System.err.println("Path to data is not provided, using default: " + DEFAULT_PATH);
        }

        try {
            try {
                CollectionManager.load(path);
            } catch (JsonMappingException ex) {
                if (ex.getMessage().contains("No content to map due to end-of-input")) {
                    System.err.println("Error: JSON file is empty or incomplete");
                } else {
                    throw ex;
                }
            }
        } catch (IOException | IllegalFieldException ex) {
            System.err.println("Unable to load collection: " + ex.getMessage());
        } catch (Throwable ex) {
            System.err.println("Critical error");
            ex.printStackTrace();
        }

        final CommandParser PARSER = new BaseCommandParser();
        try (ConsoleInputManager inputManager = new ConsoleInputManager(PARSER)) {
            inputManager.start();
        } catch (AbortException ex) {
            System.out.println("Operation aborted, stopping the program");
        } catch (Throwable ex) {
            System.err.println("Critical error");
            ex.printStackTrace();
        }
    }

    /**
     * Returns path to file where data is located
     * @return path to file with data
     */
    public static String getPath() {
        return path;
    }
}



