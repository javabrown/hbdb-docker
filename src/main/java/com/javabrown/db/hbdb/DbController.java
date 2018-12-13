package com.javabrown.db.hbdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/student")
public class DbController {
    @Autowired
    private Repository repository;
    
    @GetMapping(path="/add")
    public @ResponseBody String addNewStudent(@RequestParam String name) {
        Student s = new Student();
        s.setName(name);
        
        this.repository.save(s);
        return "Saved";
    }
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getStudents() {
        return this.repository.findAll();
    }
    
    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Student> getStudent(@PathVariable Integer id){
        return this.repository.findById(id);
    }
}


interface Repository extends CrudRepository<Student, Integer> {
}

@Entity
class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    public Integer getId(){
        return this.id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}

