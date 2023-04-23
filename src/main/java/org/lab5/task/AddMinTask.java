package org.lab5.task;

import org.lab5.collection.CollectionManager;
import org.lab5.parser.InputManager;

public class AddMinTask implements Task {
    private final InputManager inputManager;

    public AddMinTask(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void execute() {
        while (true) {
            var route = Tasks.getRoute(inputManager);
            System.out.println("You are about to add minimal route:");
            System.out.println(route);
            if (Tasks.getApproval("Proceed", inputManager)) {
                if (CollectionManager.addIfMin(route)) {
                    System.out.println("Successfully added element");
                } else {
                    System.out.println("Element wasn't added");
                }
                return;
            }
            if (!Tasks.getApproval("Do you want to refill element with another values", inputManager)) {
                return;
            }
        }
    }
}
