package org.lab5.task;

import org.lab5.collection.CollectionManager;
import org.lab5.parser.InputManager;

public class AddTask implements Task {

    private final InputManager inputManager;

    public AddTask(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void execute() {
        while (true) {
            var route = Tasks.getRoute(inputManager);
            System.out.println("You are about to add route:");
            System.out.println(route);
            if (Tasks.getApproval("Proceed", inputManager)) {
                CollectionManager.add(route);
                System.out.println("Successfully added element");
                return;
            }
            if (!Tasks.getApproval("Do you want to refill element with another values", inputManager)) {
                return;
            }
        }
    }
}
