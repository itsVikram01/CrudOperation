package org.crudtask.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crudtask.dao.TaskDAO;
import org.crudtask.entity.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskDAO taskDAO;

    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskDAO.getTaskById(id);
    }

    public Task saveOrUpdateTask(Task task) {
        taskDAO.saveOrUpdateTask(task);
        return task;
    }

    public void deleteTask(Long id) {
        taskDAO.deleteTask(id);
    }
}
