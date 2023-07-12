package com.example.Spring_ToDo_Platform;
import org.springframework.security.core.Authentication; 
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    // constructor injection 

    @RequestMapping(value="/", method = RequestMethod.GET)
    public  String goToLoginPage( ModelMap model){
        model.put("name","SaftoDos"); 
    model.put("userName",getLoggedInUserName()); 
        return "home";  
    }

// Bringing up the Login Username (Spring Security featueres)
 private  String getLoggedInUserName(){
    //use the securuty Contex Holder
    Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
    System.out.println("Auth "+auth);
    return auth.getName();
}
}