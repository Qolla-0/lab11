package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoListAppTest {

    private ObservableList<ToDoListApp.Task> tasks;

    @BeforeEach
    public void setUp() {
        tasks = FXCollections.observableArrayList();
    }

    @Test
    public void testAddTask() {
        tasks.add(new ToDoListApp.Task("New Task"));
        assertEquals(1, tasks.size());
        assertEquals("New Task", tasks.get(0).getDescription());
    }

    @Test
    public void testRemoveTask() {
        ToDoListApp.Task task = new ToDoListApp.Task("Task to Remove");
        tasks.add(task);
        tasks.remove(task);
        assertEquals(0, tasks.size());
    }

    @Test
    public void testMarkTaskAsCompleted() {
        ToDoListApp.Task task = new ToDoListApp.Task("Task to Complete");
        tasks.add(task);
        task.setCompleted(true);
        assertTrue(task.isCompleted());
    }
}
