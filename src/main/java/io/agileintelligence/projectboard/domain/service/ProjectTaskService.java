package io.agileintelligence.projectboard.domain.service;

import io.agileintelligence.projectboard.domain.model.Task;
import io.agileintelligence.projectboard.domain.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public List<Task> getAllTask() {
        return projectTaskRepository.findAll();
    };

    public Task getTask(long id) { return projectTaskRepository.findById(id);};

    public Task createTask(Task project) { return  projectTaskRepository.save(project);};

    public Task deleteTask(long id) { return projectTaskRepository.remove(id);};

    public Task editTask(long id) { return projectTaskRepository.findByIdEdit(id);};

    public Task updateTask(long id, Task task) { return projectTaskRepository.update(id, task);};

}