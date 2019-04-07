package pl.edu.wszib.todolist.springtodolist.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.model.Todo;

import java.util.List;

@Repository
public interface TodoDao extends CrudRepository<Todo, Integer> {

    @Override
    List<Todo> findAll();

    List<Todo> findTop5ByStatusNotOrderByDueDateAsc(Status status);
    List<Todo> findAllByStatus(Status status);
    int countAllByStatus(Status status);

}
