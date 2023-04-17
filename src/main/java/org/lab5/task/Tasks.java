package org.lab5.task;


import org.lab5.collection.data.Coordinates;
import org.lab5.collection.data.Location;
import org.lab5.collection.data.Route;
import org.lab5.exception.IllegalFieldException;
import org.lab5.parser.InputManager;

/**
 * Class that contains some util methods for task
 */
public class Tasks {

    private Tasks() {
    }


    /**
     * Requests string from inputManager
     *
     * @param inputManager handles the input
     * @return provided string
     * @throws IllegalArgumentException occurs when the input is incorrect
     */
    public static String getString(InputManager inputManager) throws IllegalArgumentException {
        var response = inputManager.request().trim();
        if (response.isEmpty()) {
            throw new IllegalArgumentException("Input line is empty");
        }
        return response;
    }


