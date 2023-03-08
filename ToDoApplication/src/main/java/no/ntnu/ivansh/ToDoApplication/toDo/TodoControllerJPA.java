package no.ntnu.ivansh.ToDoApplication.toDo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {
    public TodoControllerJPA(TodoService database, TodoRepository repository) {
        this.database = database;
        this.repository=repository;
    }
    private TodoService database ;
    private TodoRepository repository;

    @RequestMapping("list-todos")
    public String getAllTodos(ModelMap model){
        String name = getLoggedinUser( );

        List<ToDO> list = repository.findByName(name);
        model.put("list_todos",list);
        return "list-todos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addTodos(ModelMap model){
        ToDO todo = new ToDO(0, getLoggedinUser(), "", LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "todo-add";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodos(ModelMap model, @ModelAttribute("todo") @Valid ToDO todo, BindingResult result){
        if (result.hasErrors()){
            return "todo-add";
        }else {
            todo.setName(getLoggedinUser());
            repository.save(todo);
            //database.addTodo(getLoggedinUser(model), todo.getDescrpition(), todo.getDate(), todo.isDone());
            return "redirect:list-todos";
        }
    }
    @RequestMapping(value = "delete_todo")
    public String deleteTodo(@RequestParam int id){
        repository.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update_todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        ToDO todo = repository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo-add";
    }
    @RequestMapping(value = "update_todo", method = RequestMethod.POST)
    public String updateTodos(ModelMap model, @ModelAttribute("todo") @Valid ToDO todo, BindingResult result){
        if (result.hasErrors()){
            return "todo-add";
        }else {
            todo.setName(getLoggedinUser());
            repository.save(todo);
            return "redirect:list-todos";
        }
    }
    private String getLoggedinUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
