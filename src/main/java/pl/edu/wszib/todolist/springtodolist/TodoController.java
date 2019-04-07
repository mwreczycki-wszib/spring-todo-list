package pl.edu.wszib.todolist.springtodolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<TodoDTO> all(){
        return todoService.findAll();
    }

    @GetMapping("/todos/upcomming")
    public List<TodoDTO> upcomming(){
        return todoService.upcomming();
    }

    @GetMapping("/todos/search/{status}")
    public List<TodoDTO> search(@PathVariable Status status){
        return todoService.search(status);
    }

    @GetMapping("/todos/count/{status}")
    public int count(@PathVariable Status status){
        return todoService.count(status);
    }

    @GetMapping("/todo/{id}")
    public TodoDTO get(@PathVariable int id){
        return todoService.find(id);
    }

    @PostMapping("/todo")
    public TodoDTO add(@RequestBody TodoDTO todoDTO){
        return todoService.save(todoDTO);
    }

    @PutMapping("/todo")
    public TodoDTO update(@RequestBody TodoDTO todoDTO){
        return todoService.update(todoDTO);
    }

    @DeleteMapping("/todo/{id}")
    public TodoDTO remove(@PathVariable int id){
        return todoService.remove(id);
    }

}
