package no.hvl.dat250.rest.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;

/** Rest-Endpoint for todos. */
@RestController
public class TodoController {

  public static final String TODO_WITH_THE_ID_X_NOT_FOUND = "Todo with the id %s not found!";
  private HashMap<Integer, Todo> todos = new HashMap<>();
  private Long currentId = 0L;

  @PostMapping("/todos")
  public Todo postTodo(@RequestBody Todo todo) {
    todo.setId(currentId++);
    todos.put(todo.getId().intValue(), todo);
    return todo;
  }

  @GetMapping("/todos")
  public Collection<Todo> getTodos() { return todos.values(); }

  @GetMapping("/todos/{id}")
  public Todo getTodo(@PathVariable int id) {
    if (!todos.containsKey(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(TODO_WITH_THE_ID_X_NOT_FOUND, id));
    return todos.get(id);
  }

  @PutMapping("/todos/{id}")
  public void updateTodo(@PathVariable int id, @RequestBody Todo todo) {
    todo.setId((long)id);
    todos.put(id, todo);
  }

  @DeleteMapping("/todos/{id}")
  public void deleteTodo(@PathVariable int id) {
    if (!todos.containsKey(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(TODO_WITH_THE_ID_X_NOT_FOUND, id));
    todos.remove(id);
  }

}