package com.example.kanbam.repository;

import com.example.kanbam.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
