package com.avhsek.todo_list_api.service;


import java.util.List;
import java.util.Optional;

import com.avhsek.todo_list_api.model.Task;
import com.avhsek.todo_list_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Update a task
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);
    }

    // Partital update of a task or Patch the task
    public Task patchTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        // check which field are being update and apply them
        if(taskDetails.getTitle() != null){
            task.setTitle(taskDetails.getTitle());
        }

        if(taskDetails.getDescription() != null){
            task.setDescription(taskDetails.getDescription());
        }

        if(taskDetails.isCompleted() != task.isCompleted()){
            task.setCompleted(taskDetails.isCompleted());
        }

        return taskRepository.save(task);
    }

    // Delete a task
    public String deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
        return "Task '" + task.getTitle() + "' deleted successfully!";
    }
}
