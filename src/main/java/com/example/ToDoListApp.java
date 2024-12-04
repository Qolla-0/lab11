package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToDoListApp extends Application {

    private ObservableList<Task> tasks;

    @Override
    public void start(Stage stage) {
        tasks = FXCollections.observableArrayList();

        ListView<Task> taskList = new ListView<>(tasks);
        taskList.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                } else {
                    setText((task.isCompleted() ? "[Done] " : "[Pending] ") + task.getDescription());
                }
            }
        });

        TextField taskInput = new TextField();
        Button addButton = new Button("Add Task");
        Button removeButton = new Button("Remove Selected Task");
        Button markAsDoneButton = new Button("Mark as Done");

        addButton.setOnAction(e -> {
            if (!taskInput.getText().isEmpty()) {
                tasks.add(new Task(taskInput.getText()));
                taskInput.clear();
            }
        });

        removeButton.setOnAction(e -> {
            Task selectedTask = taskList.getSelectionModel().getSelectedItem();
            tasks.remove(selectedTask);
        });

        markAsDoneButton.setOnAction(e -> {
            Task selectedTask = taskList.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                selectedTask.setCompleted(true);
                taskList.refresh();
            }
        });

        VBox layout = new VBox(10, taskInput, addButton, removeButton, markAsDoneButton, taskList);
        Scene scene = new Scene(layout, 300, 400);

        stage.setScene(scene);
        stage.setTitle("To Do List");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Task {
        private final String description;
        private boolean completed;

        public Task(String description) {
            this.description = description;
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }
}