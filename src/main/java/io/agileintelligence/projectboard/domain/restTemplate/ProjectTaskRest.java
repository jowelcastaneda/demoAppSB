package io.agileintelligence.projectboard.domain.restTemplate;

import io.agileintelligence.projectboard.domain.model.Task;
import io.agileintelligence.projectboard.domain.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProjectTaskRest implements ProjectTaskRepository {

    @Autowired
    private RestTemplate restTemplate;

    private static String BASE_URI = "http://localhost:3000";

    @Override
    public Task getById(Long id) {
        return execute("/projects" + id, HttpMethod.GET, null);
    }

    public List<Task> findAll() {
        ResponseEntity<List<Task>> response = restTemplate.exchange(
                BASE_URI + "projects",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {
                }
        );
        return response.getBody();
    }

    @Override
    public Task findById(long id) {
        return execute("/projects/" + id, HttpMethod.GET, null);
    }

    @Override
    public Task save(Task project){
        return execute("/projects/", HttpMethod.POST, new HttpEntity<>(project));
    }

    @Override
    public Task remove(long id) {
        return execute("/projects/" + id, HttpMethod.DELETE, null);
    }

    @Override
    public Task update(long id, Task task) {
        return execute("/projects/" + id, HttpMethod.PUT, new HttpEntity<>(task));
    }

    @Override
    public Task findByIdEdit(long id) {
        return execute("/projects/" + id, HttpMethod.GET, null);
    }

    @Override
    public Task execute(String url, HttpMethod method, HttpEntity<Task> entity) {
        ResponseEntity<Task> response = restTemplate.exchange(
                BASE_URI+url,
                method,
                entity,
                Task.class
        );
        return response.getBody();
    }
}
