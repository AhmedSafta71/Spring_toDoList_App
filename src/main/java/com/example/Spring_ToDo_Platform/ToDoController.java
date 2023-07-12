package com.example.Spring_ToDo_Platform;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class ToDoController {
    // service to implement
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(value = "toDo", method = RequestMethod.GET)
    public String displayToDo(ModelMap model) {
        model.addAttribute("toDoList", toDoService.getToDoList());
        // findByUserName((String)model.get("userName")));
        // System.out.println("the userName is  ******* "+ (String)model.get("userName"));
        return "toDo";
    }

    @RequestMapping(value="add-todo", method=RequestMethod.GET)
    public String displatAddTodo(ModelMap model){
        ToDo todo= new ToDo(0,(String)model.get("userName"), "",LocalDate.now().plusWeeks(1),false);
        model.put("todo",todo); 
        return "add-todo"; }

    @RequestMapping(value="add-todo", method=RequestMethod.POST)
    public String createToDo(ModelMap model, @Valid ToDo todo, BindingResult  result){
        if (result.hasErrors()){
            return "add-todo"; 
        }
       String userName =(String)model.get("name"); 
  
         toDoService.createToDo(userName,todo.getDescription(),LocalDate.now().plusDays(2),false); 
        //  redirect is used not to repeat sending the same propreties
        return "redirect:toDo"; 
    }
   @RequestMapping(value="delete-toDo")
     public  String deleteTodo(@RequestParam long id){ 
        toDoService.deleteById(id); 
        return "redirect:toDo"; 
     }
    //  update-toDo
     @RequestMapping(value="update-toDo", method = RequestMethod.GET)
     public  String updateTodo(@RequestParam long id ,ModelMap model){
            ToDo todo= toDoService.findById(id); 
        model.addAttribute("todo",todo); 
        return "add-todo"; 
     }
     //update a toDo
         @RequestMapping(value="update-toDo", method=RequestMethod.POST)
    public String updateToDo (ModelMap model, @Valid ToDo todo, BindingResult  result){
        try{
        if (result.hasErrors()){
            return "add-todo"; 
        }}
        catch(Exception e ){
            System.out.println("handle error ");
        }
        toDoService.updateToDo(todo); 
        return "redirect:toDo"; 
    }
}