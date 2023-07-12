package com.example.Spring_ToDo_Platform;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP or Database
    
@Bean 
    public InMemoryUserDetailsManager   createUserDetailsManager()  {

        Function <String, String> passwordEncoder = input -> passwordEncoder().encode(input); 

        //user Builder crezates a  new user configuration 
  
        //  try {
        UserDetails  userDetails = User.builder()
                                        .passwordEncoder(passwordEncoder)
                                        .username("ahmed")
                                        .password("safta")
                                        .roles("USER","ADMIN")
                                        .build(); 
                                        
                 InMemoryUserDetailsManager  UserDetailManager = new InMemoryUserDetailsManager(userDetails);  
                  return UserDetailManager ; 
                // }
                // catch(Exception e ){
                //     System.out.println("the Exception being thrown  ********  **** ** ** *"+ e);
                // }
                
      

    } 
    // We'll start by defining the simple BCryptPasswordEncoder as a bean in our configuration:
 

   @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    } 

    
}
