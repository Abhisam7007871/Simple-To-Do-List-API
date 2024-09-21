package com.avhsek.todo_list_api.service;

import com.avhsek.todo_list_api.model.Task;
import com.avhsek.todo_list_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
}
