package com.avhsek.todo_list_api.repository;

import com.avhsek.todo_list_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
