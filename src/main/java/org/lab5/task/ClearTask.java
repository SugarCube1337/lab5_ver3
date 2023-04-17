package org.lab5.task;

import org.lab5.collection.CollectionManager;

public class ClearTask implements Task {

    @Override
    public void execute() {
        System.out.println("Clearing the collection");
        CollectionManager.clear();
    }
}
