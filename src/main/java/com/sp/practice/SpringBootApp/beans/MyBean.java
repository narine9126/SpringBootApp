package com.sp.practice.SpringBootApp.beans;

public class MyBean {
    private Long Id;
    private String name;

    public MyBean(){
    }
    public MyBean(Long ID,String name){
        this.Id=ID;
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
