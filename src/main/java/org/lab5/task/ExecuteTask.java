package org.lab5.task;

import org.lab5.parser.CommandParser;
import org.lab5.parser.InputManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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
        String test = null;
        try {
            test = checkRecursion(filepath, new HashSet<>());
            if (test != null) {
                System.out.println("Recursion detected: " + test);
                return;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNextLine()) {
                parser.parse(scanner.nextLine(), inputManager);
            }
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Error while reading the file");
        }

    }

    private String checkRecursion(String path, Set<String> used) throws IOException {
        StringBuilder script = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                script.append(scanner.nextLine()).append('\n');
            }
            Matcher matcher = Pattern.compile("execute_script\\s+(.+)\n", Pattern.MULTILINE).matcher(script);
            while (matcher.find()) {
                String match = matcher.group(1);
                if (used.contains(path)) {
                    return path;
                }
                used.add(path);
                System.out.println(match);
                String recursion = checkRecursion(match, new HashSet<>(used));
                if (recursion != null) {
                    return path + " -> " + recursion;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            throw new IOException("Error while reading the file: " + e.getMessage());
        }
    }
}
