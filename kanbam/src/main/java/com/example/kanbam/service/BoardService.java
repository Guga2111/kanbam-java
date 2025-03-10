package com.example.kanbam.service;

import com.example.kanbam.entity.Board;
import com.example.kanbam.exception.BoardNotFoundException;
import com.example.kanbam.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardService {

    BoardRepository boardRepository;

    public List<Board> getBoards() {
        return (List<Board>) boardRepository.findAll();
    }

    public Board getBoard(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return unwrapBoard(board, id);
    }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public Board updateBoard(String name, Long id) {
        Optional<Board> board = boardRepository.findById(id);
        Board unwrapBoard = unwrapBoard(board, id);
        unwrapBoard.setName(name);
        return unwrapBoard;
    }

    static Board unwrapBoard(Optional<Board> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        else throw new BoardNotFoundException(id);
    }
}
