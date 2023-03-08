package no.ntnu.ivansh.ToDoApplication.toDo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<ToDO> todoes = new ArrayList<>();
    private static int counter = 0;

    static {

        todoes.add(new ToDO(++counter,"ivansh","Learn Spring", LocalDate.now().plusYears(1),false));
        todoes.add(new ToDO(++counter,"ivansh","Learn Devops", LocalDate.now().plusYears(3),false));
        todoes.add(new ToDO(++counter,"ivansh","Learn Python", LocalDate.now().plusYears(2),false));
    }

    public static List<ToDO> findByUsername(String username) {
        Predicate<? super ToDO> predicate = toDO -> toDO.getName().equals(username) ;
        return todoes.stream().filter(predicate).toList();
    }
    public void addTodo(String username,String description,LocalDate targetDate, boolean isDone){
        ToDO todo = new ToDO(++counter,username,description,targetDate,isDone);
        todoes.add(todo);
    }
    public void deleteTodo(int id){
        Predicate<? super ToDO> predicate = toDO -> toDO.getId()==id ;
        todoes.removeIf(predicate);
    }
    public ToDO getTodoById(int id){
        Predicate<? super ToDO> predicate = toDO -> toDO.getId()==id ;
        return todoes.stream().filter(predicate).findFirst().get();
    }

    public void updateToDO(@Valid ToDO todo) {
        deleteTodo(todo.getId());
        todoes.add(todo);
    }
}
