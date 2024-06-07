package org.crudtask.dao;

import org.crudtask.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDAO {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task saveOrUpdateTask(Task task);
    void deleteTask(Long id);
}
