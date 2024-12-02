package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoListAppTest {

    private ObservableList<String> tasks;

    @BeforeEach
    public void setUp() {
        tasks = FXCollections.observableArrayList();
    }

    @Test
    public void testAddTask() {
        tasks.add("New Task");
        assertEquals(1, tasks.size());
        assertEquals("New Task", tasks.get(0));
    }

    @Test
    public void testRemoveTask() {
        tasks.add("Task to Remove");
        tasks.remove("Task to Remove");
        assertEquals(0, tasks.size());
    }
}
