package org.lab5.task;

public class HelpTask implements Task {

    @Override
    public void execute() {
        System.out.println("""
                    > help - shows information about commands
                    > info - shows information about collection
                    > add - inserts new element to collection
                    > update [id] - updates element in collection
                    > remove_by_id - removes element by its id
                    > clear - clears the collection
                    > save - saves collection to file
                    > execute_script - executes script in file
                    > exit - stops the program
                    > add_if_min - inserts new element if it is minimal in collection
                    > remove_greater - removes all the elements in collection greater than provided
                    > remove_lower - removes all the elements in collection lower than provided
                    > group_counting_by_to - groups elements by Location.To field and shows size of each
                    > count_greater_than_distance - counts number of elements with distance greater than provided
                    > print_unique_distance - prints all the unique values of distances in collection
                    """);
    }
}
