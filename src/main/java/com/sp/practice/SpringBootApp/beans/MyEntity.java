package com.sp.practice.SpringBootApp.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_entity",schema = "")
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    public MyEntity(){
    }
    public MyEntity(Long Id,String name){
        this.Id=Id;
        this.name=name;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
