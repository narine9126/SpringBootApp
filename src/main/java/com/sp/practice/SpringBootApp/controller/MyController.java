package com.sp.practice.SpringBootApp.controller;

import com.sp.practice.SpringBootApp.beans.MyBean;
import com.sp.practice.SpringBootApp.beans.MyEntity;
import com.sp.practice.SpringBootApp.service.MyService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class MyController {

    MyService myService;
    //uses constructor DI, @Autowired annotation optional in Spring 4.x version
    public MyController(MyService myService){
        this.myService=myService;
    }

    //Notice that id in {id} must match the name = "id" in @PathVariable.
    @GetMapping("/mybeans/{id}")
    public ResponseEntity<MyBean> getData(@PathVariable(required = true,name = "id") Long beanId){//
        MyEntity entity= myService.getEntity(beanId);
        MyBean bean= new MyBean(entity.getId(),entity.getName());
        return ResponseEntity.ok(bean);
    }

    @PostMapping("/mybeans/save")
    public ResponseEntity<MyBean> saveBean(@Validated @RequestBody MyBean bean){
        //save bean
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping("/mybeans/delete")
    public ResponseEntity<String> removeBean(@RequestParam String beanId){
        return ResponseEntity.ok("Bean deleted for Id: "+beanId);
    }

    @Transactional // This annotation ensures any changes to original bean will be automatically updated in DB using Dirty checking.
    @PutMapping("/mybeans/fullupdate")
    public ResponseEntity<MyBean> fullyUpdateBean(@Validated @RequestBody MyBean bean){ //request should have all fields mandatory.
        MyEntity entity= myService.getEntity(bean.getId());
        MyBean myBean= new MyBean(entity.getId(),entity.getName());
        myBean.setName(bean.getName());
        //myBean.setSalary(bean.getSalary());
        //myBean.setDepartment(bean.getDepartment());
        //return new ResponseEntity<>(myBean, HttpStatus.OK);
        return ResponseEntity.ok(myBean);
    }
    @Transactional // This annotation ensures any changes to original bean will be automatically updated in DB using Dirty checking.
    @PatchMapping("/mybean/update")
    public ResponseEntity<MyBean> updateBean(@RequestBody MyBean bean){//request can have only required fields
        MyEntity entity= myService.getEntity(bean.getId());
        entity.setName(bean.getName());
        MyBean myBean= new MyBean(entity.getId(),entity.getName());
        //save bean
        return ResponseEntity.ok(myBean);
    }
}
