package com.avhsek.todo_list_api.service;

import com.avhsek.todo_list_api.model.Task;
import com.avhsek.todo_list_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public Task updateTask(Long id, Task taskDetails){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            Task updateTask = task.get();
            updateTask.setTitle(taskDetails.getTitle());
            updateTask.setDescription(taskDetails.getDescription());
            updateTask.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(updateTask);
        }
        return null;
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}
