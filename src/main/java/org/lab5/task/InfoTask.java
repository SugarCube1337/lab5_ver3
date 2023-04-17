package org.lab5.task;

import org.lab5.collection.CollectionManager;

public class InfoTask implements Task {

    @Override
    public void execute() {
        System.out.println(CollectionManager.getInfo());
    }
}
