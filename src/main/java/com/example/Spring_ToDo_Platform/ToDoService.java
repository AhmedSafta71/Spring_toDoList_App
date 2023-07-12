package com.example.Spring_ToDo_Platform;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.util.function.Predicate;


@Service
public class ToDoService {
    private static long id=0; 
    private static List<ToDo> toDoList = new ArrayList <ToDo>();
    // static  bloc is used  to initialisze staic variables
    static{
        toDoList.add(new ToDo(++id,"ahmed","Complete ", LocalDate.now(),false )) ; 
        toDoList.add(new ToDo(++id,"Ahmed","Complete REST Project ", LocalDate.now(),false)) ; 
        toDoList.add(new ToDo(++id,"Ahmed","AWS cloud Cerified ", LocalDate.now(),false )) ;
        toDoList.add(new ToDo(++id,"Ahmed","Coimptia Linux+ certified ", LocalDate.now(),false )) ; 
         toDoList.add(new ToDo(++id,"Ahmed Safta","work hard ", LocalDate.now(),false )) ;
    }

    public List<ToDo> getToDoList() {
        return  toDoList; 
    }
    public void createToDo(String userName,
    String description, LocalDate targetDate,  boolean done){
        ToDo newToDo= new ToDo(++id,userName,description,targetDate,done);  
         toDoList.add(newToDo); 
    }

    public void deleteById(long id){
       
        Predicate <? super ToDo> predicate =  todo -> todo.getId() == id; 
        toDoList.removeIf(predicate);    }

    

      public ToDo findById(long id){
        Predicate <? super ToDo> predicate =  todo -> todo.getId() == id; 
        ToDo todo = toDoList.stream().filter(predicate).findFirst().get(); 
        return todo; 
          }
          public List <ToDo> findByUserName(String username){
        Predicate <? super ToDo> predicate =  todo -> todo.getUserName().equalsIgnoreCase(username); 
        //  ToList Method to get a list after filtering
        List <ToDo> filetredList = toDoList.stream().filter(predicate).toList(); 
        return filetredList; 
          }

        public void updateToDo(@Valid ToDo todo){
            deleteById(todo.getId());
            toDoList.add(todo);

        }
    
        }

