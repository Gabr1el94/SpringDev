package com.gabrieldev.springdev.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabrieldev
 * 
 */

@XmlRootElement
@Entity
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String nome;
   private String sobrenome;
   public static List<Student> studentList;

   static{
       studentRepository();
   }

   public Student(long id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    
    private static void studentRepository(){
        studentList = new ArrayList<>(Arrays.asList(new Student(1, "Gabriel", "Soares"),new Student(2, "Kátia", "Cilene")));
    }

    public Student() {
    }
   
    public void setId(Long id) {
        this.id = id;
    }
    
     public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    

   
}
