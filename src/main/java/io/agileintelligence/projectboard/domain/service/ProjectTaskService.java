package io.agileintelligence.projectboard.domain.service;

import io.agileintelligence.projectboard.domain.ProjectTask;
import io.agileintelligence.projectboard.domain.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask createProjectTask(ProjectTask projectTask){

        if(projectTask.getTitle()==null || projectTask.getTitle()==""){
            projectTask.setTitle("TITLE NEEDED!");
        }

        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll(){
        return projectTaskRepository.findAll();
    }

    public ProjectTask findById(Long id){
        return projectTaskRepository.getById(id);
    }

}