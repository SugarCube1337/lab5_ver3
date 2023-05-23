package org.lab5.task;

import org.lab5.parser.CommandParser;
import org.lab5.parser.InputManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecuteTask implements Task {

    private final CommandParser parser;
    private final String filepath;
    private final InputManager inputManager;

    public ExecuteTask(CommandParser parser, String filepath, InputManager inputManager) {
        this.parser = parser;
        this.filepath = filepath;
        this.inputManager = inputManager;
    }

    @Override
    public void execute() {
        Set<String> used = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(filepath))) {
            processScript(scanner, used);
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Error while reading the file");
        }
    }

    private void processScript(Scanner scanner, Set<String> used) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            if (line.startsWith("execute_script")) {
                String match = line.substring("execute_script".length()).trim();
                if (used.contains(match)) {
                    System.out.println("Recursion detected: " + match);
                    continue; // Skip the current command and move on to the next one
                }
                used.add(match);
                try (Scanner scriptScanner = new Scanner(new File(match))) {
                    processScript(scriptScanner, used);
                } catch (FileNotFoundException e) {
                    System.err.println("Error while reading the file: " + e.getMessage());
                }
            } else {
                parser.parse(line, inputManager);
            }
        }
    }
}


