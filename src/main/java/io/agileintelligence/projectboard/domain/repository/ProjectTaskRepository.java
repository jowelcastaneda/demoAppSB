package io.agileintelligence.projectboard.domain.repository;

import io.agileintelligence.projectboard.domain.model.Task;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository {

    Task getById(Long id);
    List<Task> findAll();
    Task findById(long id);
    Task findByIdEdit(long id);
    Task save(Task project);
    Task remove(long id);
    Task update(long id, Task task);
    Task execute(String url, HttpMethod method, HttpEntity<Task> entity);
}
