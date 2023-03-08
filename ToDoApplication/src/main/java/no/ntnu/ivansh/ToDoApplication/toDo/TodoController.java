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

//@Controller
@SessionAttributes("name")
public class TodoController {
    public TodoController(TodoService database) {
        this.database = database;
    }
    private TodoService database ;


    @RequestMapping("list-todos")
    public String getAllTodos(ModelMap model){
        String name = getLoggedinUser(model);
        List<ToDO> list = database.findByUsername(name);
        model.put("list_todos",list);
        return "list-todos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addTodos(ModelMap model){
        ToDO todo = new ToDO(0, getLoggedinUser(model), "", LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "todo-add";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodos(ModelMap model, @ModelAttribute("todo") @Valid ToDO todo, BindingResult result){
        if (result.hasErrors()){
            return "todo-add";
        }else {
            database.addTodo(getLoggedinUser(model), todo.getDescrpition(), todo.getDate(), false);
            return "redirect:list-todos";
        }
    }
    @RequestMapping(value = "delete_todo")
    public String deleteTodo(@RequestParam int id){
        database.deleteTodo(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update_todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        ToDO todo = database.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo-add";
    }
    @RequestMapping(value = "update_todo", method = RequestMethod.POST)
    public String updateTodos(ModelMap model, @ModelAttribute("todo") @Valid ToDO todo, BindingResult result){
        if (result.hasErrors()){
            return "todo-add";
        }else {
            todo.setName(getLoggedinUser(model));
            database.updateToDO(todo);
            return "redirect:list-todos";
        }
    }
    private String getLoggedinUser(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
