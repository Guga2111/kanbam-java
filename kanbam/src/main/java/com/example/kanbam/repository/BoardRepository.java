package com.example.kanbam.repository;

import com.example.kanbam.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
