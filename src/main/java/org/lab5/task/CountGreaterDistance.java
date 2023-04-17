package org.lab5.task;

import org.lab5.collection.CollectionManager;

public class CountGreaterDistance implements Task {

    private final int distance;

    public CountGreaterDistance(String distance) throws NumberFormatException {
        this.distance = Integer.parseInt(distance);
    }

    @Override
    public void execute() {
        System.out.println("Elements with distance greater than "
                + distance + ": " + CollectionManager.countGreaterDistance(distance));
    }
}
