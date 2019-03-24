/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrieldev.springdev.endpoint;

import com.gabrieldev.springdev.classes.CustomErrorType;
import com.gabrieldev.springdev.classes.Student;
import com.gabrieldev.springdev.interfaces.IStudenty;
import com.gabrieldev.springdev.util.DateUtil;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import javax.xml.ws.Response;
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
public class StudentEndpoint implements IStudenty{
   
    @Autowired
    private DateUtil dateUtil;
    
    @RequestMapping("/")
    @Override
    public String home(){    
        return "Hello World";
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/list")
    @Override
    public ResponseEntity<?> listAll(){
        //System.out.println(dateUtil.formatLocalDateTimeToDBSTYLE(LocalDateTime.now()));
        
        return new ResponseEntity<>(Student.studentList,HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/{id}",produces = "application/json")
    @Override
    public ResponseEntity<?> getbyID(@PathVariable("id") int id){
        //System.out.println(dateUtil.formatLocalDateTimeToDBSTYLE(LocalDateTime.now()));
        Student s = new Student();
        s.setId(id);
        int index = Student.studentList.indexOf(s);
        if (index < 0){
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Student.studentList.get(index),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path="/")
    @Override
    public ResponseEntity<?> addStudenty(@RequestBody Student s) {
        Student.studentList.add(s);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/{id}",produces = "application/json")
    @Override
    public ResponseEntity<?> deletebyID(@PathVariable("id") int id) {
        Student s = new Student();
        s.setId(id);
        int index = Student.studentList.indexOf(s);
        if (index < 0){
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        Student.studentList.remove(s);
        return new ResponseEntity<>("Delete Student with Sucess",HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,path="/{id}",produces = "application/json")
    @Override
    public ResponseEntity<?> updatebyID(@RequestBody Student student, @PathVariable("id") int id) {
        Student s = new Student();
        s.setId(id);
        int index = Student.studentList.indexOf(s);
        if (index < 0){
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }//To change body of generated methods, choose Tools | Templates.
        Student.studentList.remove(student);
        Student.studentList.add(student);
        return new ResponseEntity<>("Update Student with Sucess",HttpStatus.OK);
    }
    
}
