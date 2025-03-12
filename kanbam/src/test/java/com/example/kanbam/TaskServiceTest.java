package com.example.kanbam;

import com.example.kanbam.entity.*;
import com.example.kanbam.repository.BoardRepository;
import com.example.kanbam.repository.TaskRepository;
import com.example.kanbam.service.BoardService;
import com.example.kanbam.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    private Task task;

    private Board board;

    @BeforeEach
    void setUp1() {
        board = new Board();
        board.setName("KanbamTestBoard");
        board.setId(1L);
        board.setUser(new User());
    }

    @BeforeEach
    void setUp2() {
        task = new Task();
        task.setId(1L);
        task.setName("TaskTest");
        task.setDescription("DescriptionTest");
        task.setStatus(Status.IN_PROGRESS);
        task.setPriority(Priority.MEDIUM);
        task.setCreateDate(LocalDate.now());
    }

    @Test
    public void getTasksFromRepoTest() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task));

        List<Task> result = taskService.getTasks();

        assertEquals("TaskTest", result.get(0).getName());
        assertEquals("DescriptionTest", result.get(0).getDescription());
        assertEquals(Status.IN_PROGRESS, result.get(0).getStatus());
        assertEquals(Priority.MEDIUM, result.get(0).getPriority());
    }

    @Test
    public void getTaskFromRepoTest() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task result = taskService.getTask(1L);

        assertEquals("TaskTest", result.getName());
        assertEquals("DescriptionTest", result.getDescription());
        assertEquals(Status.IN_PROGRESS, result.getStatus());
        assertEquals(Priority.MEDIUM, result.getPriority());
    }

    @Test
    public void saveTaskFromRepoTest() {
        when(taskRepository.save(task)).thenReturn(task);
        when(boardRepository.findById(1L)).thenReturn(Optional.of(board));

        Board boardResult = boardService.getBoard(1L);
        Task result = taskService.saveTask(task, boardResult.getId());

        verify(taskRepository, times(1)).save(result);
    }

    @Test
    public void deleteTaskFromRepoTest() {
        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    public void updateTaskFromRepoTest() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.updateTask(Status.TODO, Priority.HIGH, 1L);

        assertEquals(Status.TODO, result.getStatus());
        assertEquals(Priority.HIGH, result.getPriority());
        verify(taskRepository, times(1)).save(result);
    }
}
