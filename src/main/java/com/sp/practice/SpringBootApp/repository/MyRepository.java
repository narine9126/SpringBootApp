package com.sp.practice.SpringBootApp.repository;

import com.sp.practice.SpringBootApp.beans.MyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends CrudRepository<MyEntity,Long> {
}
