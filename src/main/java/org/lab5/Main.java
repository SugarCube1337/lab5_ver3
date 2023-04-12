package org.lab5;

import org.lab5.data.Route;
import org.lab5.utility.Loader;

import java.util.HashSet;

public class Main {
    private static HashSet<Route> routes = new HashSet<>();

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Необходимо указать имя файла в формате JSON");
            return;
        }
        String filename = args[0];
        Loader<HashSet<Route>, Route> loader = new Loader<>();

        loader.loadFromJSON(routes, filename);
    }
}

