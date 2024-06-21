package com.excelr.restfulApi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

//    @Size(min=5, message="Name should have atleast 5 characters")
    private String name;
    private String email_address;
    private Integer roll_no;

    public Student(){};

    public Student(String name, String email_address, Integer roll_no) {
        this.name = name;
        this.email_address = email_address;
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail_address() {
        return email_address;
    }

    public Integer getRoll_no() {
        return roll_no;
    }
    public String getdetail(){
        return id + name + email_address + roll_no;
    }
}
