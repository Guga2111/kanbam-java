package com.example.kanbam;

import com.example.kanbam.entity.Board;
import com.example.kanbam.entity.User;
import com.example.kanbam.repository.BoardRepository;
import com.example.kanbam.service.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTests {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.setName("KanbamTestBoard");
        board.setId(1L);
        board.setUser(new User());
    }

    @Test
    public void getBoardsFromRepoTest() {
        when(boardRepository.findAll()).thenReturn(Arrays.asList(board));

        List<Board> result = boardService.getBoards();

        assertEquals("KanbamTestBoard", result.get(0).getName());
    }

    @Test
    public void getBoardFromRepoTest() {
        when(boardRepository.findById(1L)).thenReturn(Optional.of(board));

        Board result = boardService.getBoard(1L);

        assertEquals("KanbamTestBoard", result.getName());
    }

    @Test
    public void saveBoardFromRepoTest() {
        when(boardRepository.save(board)).thenReturn(board);

        Board result = boardService.saveBoard(board);

        verify(boardRepository, times(1)).save(result);
    }

    @Test
    public void updateUserFromRepoTest() {
        Long id = 1L;
        when(boardRepository.findById(id)).thenReturn(Optional.of(board));
        when(boardRepository.save(board)).thenReturn(board);

        Board result = boardService.updateBoard("KanbamTestBoard123", id);

        assertEquals("KanbamTestBoard123", result.getName());
        verify(boardRepository, times(1)).save(board);
    }

    @Test
    public void deleteUserFromRepoTest() {
        Long id = 1L;

        boardService.deleteBoard(id);

        verify(boardRepository, times(1)).deleteById(id);
    }
}
