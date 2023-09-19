package com.example.RestClient.service;

import com.example.RestClient.model.Todo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;
@Service
public class TodoService {
    private RestClient client;
    public TodoService(RestClient client) {
        this.client = client;
    }
    public Todo getTodo(int id) {
        try {
            return client.get()
                    .uri("/todos/{id}", id)
                    .retrieve()
                    .body(Todo.class);
        }catch(Exception e){
            e.printStackTrace(); // Add appropriate logging
        }
        return null;
    }
    public List<Todo> getTodos(){
        return client.get()
                .uri("/todos")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Todo>>() {

                });
    }
    public Todo createPost(Todo todo){
        return client.post()
                .uri("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .body(todo)
                .retrieve()
                .body(Todo.class);
    }
}
