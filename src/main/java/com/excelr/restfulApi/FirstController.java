package com.excelr.restfulApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FirstController {

    @Autowired
    private studentTable student_table;

    @GetMapping("/getUsers")
    public List<Student> getUsers(){
        List<Student> student = new ArrayList<Student>();
        student.addAll(student_table.findAll());
        return student;
    }

    @GetMapping("/getUser/{userId}")
    public Student getUser(@PathVariable("userId") Integer id){
        Optional<Student> student = student_table.findById(id);
        return student.orElseGet(Student::new);
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public Student ProfileCreation( @RequestBody Student student ){
        student_table.save(student);
        return student;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id){
        student_table.deleteById(id);
        return "User id : "+id+" Successfully deleted!";
    }

    @GetMapping("*")
    public String ErrorHandling(){
        return "Page not found! Go back to home page";
    }
}
// body | param | headers | path variable

// PostMan : Application by which you can test any routes
// Create a store :
// get item : /items { product_id: 1, prouct_name:"Washing machine", price:123123 }
// insert item : /item { product_id: 1, prouct_name:"Washing machine", price:123123 }


// TASK : Create a application API, displaying list of all employess name : List [a,b,c,d]
// An api which accepts, ID[index] in params and return the Employee name : 1 ---> b
// An API to add employee to a array



//Spring Rest : RestAPIs using Spring boot framework

//Database to Spring boot