package com.example.kanbam.service;

import com.example.kanbam.entity.Board;
import com.example.kanbam.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BoardService {

    BoardRepository boardRepository;

    public List<Board> getBoards() {
        return (List<Board>) boardRepository.findAll();
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).get();
    }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public Board updateBoard(String name, Long id) {
        Board board = boardRepository.findById(id).get();

        board.setName(name);
        return board;
    }
}
