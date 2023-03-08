package no.ntnu.ivansh.ToDoApplication.toDo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDO, Integer> {
    public List<ToDO> findByName(String name);
}
