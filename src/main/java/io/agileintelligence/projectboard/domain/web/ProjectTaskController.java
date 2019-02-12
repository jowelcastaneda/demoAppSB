package io.agileintelligence.projectboard.domain.web;

import io.agileintelligence.projectboard.domain.model.Task;
import io.agileintelligence.projectboard.domain.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;


    @RequestMapping("/")
    public List<Task> index() {
        return projectTaskService.getAllTask();
    }

    @RequestMapping("/plan/{id}")
    public Task getTask(@PathVariable long id) {
        return projectTaskService.getTask(id);
    }
    @RequestMapping(value = "/plan/edit/{id}")
    public Task editTask(@PathVariable long id) {
        return projectTaskService.getTask(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/")
    public Task createTask(@RequestBody Task project) {
        return projectTaskService.createTask(project);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "plan/{id}" )
    public void deleteTask(@PathVariable long id) {
        projectTaskService.deleteTask(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/plan/edit/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task task) {
        return projectTaskService.updateTask(id, task);
    }


}