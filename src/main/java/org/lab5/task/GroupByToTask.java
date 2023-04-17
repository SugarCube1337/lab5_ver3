package org.lab5.task;

import org.lab5.collection.CollectionManager;

public class GroupByToTask implements Task {

    @Override
    public void execute() {
        System.out.print(CollectionManager.countByTo());
    }
}
