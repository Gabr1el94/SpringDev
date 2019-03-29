/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrieldev.springdev.interfaces;

import com.gabrieldev.springdev.classes.Student;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author gabrieldev
 */
public interface IStudenty {
    public String home();
    public ResponseEntity<?> listAll();
    public ResponseEntity<?> getbyID(long id);
    public ResponseEntity<?> deletebyID(Student student);  
    public ResponseEntity<?> updatebyID(Student student);
    public ResponseEntity<?> addStudenty(Student student);
}
