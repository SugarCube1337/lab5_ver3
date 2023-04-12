package org.lab5.utility;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collection;

public class Loader<T extends Collection<E>, E> {
    private T resultCollection;

    /**
     * Fill collection with elements from JSON file.
     *
     * @param collection Collection to fill
     * @param filename   JSON filename to read data from
     */
    public void loadFromJSON(T collection, String filename) {
        Gson gson = new Gson();
        try (Scanner scanner = new Scanner(new File(filename))) {
            String json = "";
            while (scanner.hasNextLine()) {
                json += scanner.nextLine();
            }
            E[] elements = gson.fromJson(json, (Class<E[]>) new Object() {
            }.getClass().getEnclosingClass().getDeclaredField("elements").getType());
            for (E element : elements) {
                collection.add(element);
            }
            System.out.println("Расчет окончен");
        } catch (IOException | NoSuchFieldException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

