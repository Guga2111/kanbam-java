package com.example.kanbam.service;


import com.example.kanbam.entity.Board;
import com.example.kanbam.exception.EnumIncorretFormatException;
import com.example.kanbam.exception.TaskNotFoundException;
import com.example.kanbam.entity.Priority;
import com.example.kanbam.entity.Status;
import com.example.kanbam.entity.Task;
import com.example.kanbam.repository.BoardRepository;
import com.example.kanbam.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskService {

    TaskRepository kanbamRepository;

    BoardRepository boardRepository;

    public List<Task> getTasks() {
        return (List<Task>) kanbamRepository.findAll();
    }

    public Task getTask(Long id) {
        Optional<Task> task = kanbamRepository.findById(id);
        return unwrapTask(task, id);
    }

    //resolver bug nessa funcao
    public Task saveTask(Task task, Long boardId) {
        enumCorrectFormatCheck(task);
        Board board = boardRepository.findById(boardId).get();
        task.setBoard(board);
        return kanbamRepository.save(task);
    }

    public void deleteTask(Long id) {
        kanbamRepository.deleteById(id);
    }

    public Task updateTask(Status status, Priority priority, Long id) {
        Optional<Task> task = kanbamRepository.findById(id);
        Task unwrappedTask = unwrapTask(task, id);

        unwrappedTask.setStatus(status);
        unwrappedTask.setPriority(priority);
        statusDoneCheck(status, unwrappedTask);

        return kanbamRepository.save(unwrappedTask);
    }

    static Task unwrapTask(Optional<Task> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        else throw new TaskNotFoundException(id);
    }

    static void statusDoneCheck(Status status, Task task) {
        if(status.equals(Status.DONE)) task.setConclusionDate(LocalDate.now());
    }

    static void enumCorrectFormatCheck(Task task) {
        List<Status> statusList = Arrays.asList(
                Status.TODO,
                Status.IN_PROGRESS,
                Status.DONE
        );

        List<Priority> priorityList = Arrays.asList(
                Priority.LOW,
                Priority.MEDIUM,
                Priority.HIGH
        );

        if(!statusList.contains(task.getStatus())) throw new EnumIncorretFormatException("Not exist in the pattern pre set");

        if(!priorityList.contains(task.getPriority())) throw new EnumIncorretFormatException("Not exist in the pattern pre set");
    }
}
