/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrieldev.springdev.classes.repositorio;

import com.gabrieldev.springdev.classes.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author gabrieldev
 */
public interface RepositorioStudent extends CrudRepository<Student, Long>{
    List<Student> findByname(String name); 
    
    public Student findOne(long id);    
}
