package com.example.kanbam.repository;

import com.example.kanbam.pojo.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbamRepository extends CrudRepository<Task, Long> {

}
