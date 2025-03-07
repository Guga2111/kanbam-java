package com.example.kanbam.controller;

import com.example.kanbam.entity.Board;
import com.example.kanbam.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    BoardService boardService;

    @GetMapping("/all")
    public ResponseEntity<List<Board>> getBoards() {
        return new ResponseEntity<>(boardService.getBoards(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Board> saveBoard(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.saveBoard(board), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
