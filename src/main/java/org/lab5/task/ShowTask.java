package org.lab5.task;

import org.lab5.collection.CollectionManager;

public class ShowTask implements Task {

    @Override
    public void execute() {
        System.out.println(CollectionManager.getElements());
    }
}
