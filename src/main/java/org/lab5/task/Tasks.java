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

    /**
     * Requests integer from inputManager
     * @param inputManager handles the input
     * @return provided integer
     * @throws NumberFormatException occurs when the input is incorrect
     */
    public static int getInteger(InputManager inputManager) throws NumberFormatException {
        var line = getString(inputManager);
        return Integer.parseInt(line);
    }


    /**
     * Requests long from inputManager
     * @param inputManager handles the input
     * @return provided long
     * @throws NumberFormatException occurs when the input is incorrect
     */
    public static long getLong(InputManager inputManager) throws NumberFormatException {
        var line = getString(inputManager);
        return Long.parseLong(line);
    }

    /**
     * Requests float from inputManager
     * @param inputManager handles the input
     * @return provided float
     * @throws NumberFormatException occurs when the input is incorrect
     */
    public static float getFloat(InputManager inputManager) throws NumberFormatException {
        var line = getString(inputManager);
        return Float.parseFloat(line);
    }

    /**
     * Requests double from inputManager
     * @param inputManager handles the input
     * @return provided double
     * @throws NumberFormatException occurs when the input is incorrect
     */
    public static double getDouble(InputManager inputManager) throws NumberFormatException {
        var line = getString(inputManager);
        return Double.parseDouble(line);
    }

    /**
     * Requests coordinates using inputManager
     * @param inputManager handles the input
     * @return provided coordinates
     */
    public static Coordinates getCoordinates(InputManager inputManager) {
        Double x = null;
        Integer y = null;
        while (true) {
            try {
                if (x == null) {
                    System.out.print("Specify X value for coordinates (Double): ");
                    x = getDouble(inputManager);
                }
                if (y == null) {
                    System.out.print("Specify Y value for coordinates (Integer): ");
                    y = getInteger(inputManager);
                }
                return new Coordinates(x, y);
            } catch (IllegalFieldException ex) {
                System.out.println(ex.getMessage());
                x = null;
                y = null;
            } catch (IllegalArgumentException ex) {
                System.out.println("Incorrect input format");
            }
        }
    }




