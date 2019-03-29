/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrieldev.springdev.endpoint;

import com.gabrieldev.springdev.classes.CustomErrorType;
import com.gabrieldev.springdev.classes.Student;
import com.gabrieldev.springdev.classes.repositorio.RepositorioStudent;
import com.gabrieldev.springdev.interfaces.IStudenty;
import com.gabrieldev.springdev.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabrieldev
 */

@RestController
@RequestMapping("students")
public class StudentEndpolong implements IStudenty{
   
    private final RepositorioStudent studentyDAO;
    
    @Autowired
    public StudentEndpolong(RepositorioStudent studentyDAO) {
        this.studentyDAO = studentyDAO;
    }
    
    
    @RequestMapping("/")
    @Override
    public String home(){    
        return "Hello World";
    }

    
    
    @RequestMapping(method = RequestMethod.GET, path="/list")
    @Override
    public ResponseEntity<?> listAll(){
        //System.out.println(dateUtil.formatLocalDateTimeToDBSTYLE(LocalDateTime.now()));
        return new ResponseEntity<>(studentyDAO.findAll(),HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/{id}",produces = "application/json")
    @Override
    public ResponseEntity<?> getbyID(@PathVariable("id") long id){
        //System.out.println(dateUtil.formatLocalDateTimeToDBSTYLE(LocalDateTime.now()));
        Student student = studentyDAO.findOne(id);
        if (student == null){
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path="/")
    @Override
    public ResponseEntity<?> addStudenty(@RequestBody Student s) {
        return new ResponseEntity<>(studentyDAO.save(s), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/{id}",produces = "application/json")
    @Override
    public ResponseEntity<?> deletebyID(@RequestBody Student s) {
        studentyDAO.delete(s);
        return new ResponseEntity<>("Delete Student with Sucess",HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,path="/{id}",produces = "application/json")
    @Override
    public ResponseEntity<?> updatebyID(@RequestBody Student student){
        studentyDAO.save(student);
        return new ResponseEntity<>("Update Student with Sucess",HttpStatus.OK);
    }
    
}
