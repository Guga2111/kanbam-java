package com.example.kanbam;

import com.example.kanbam.entity.Priority;
import com.example.kanbam.entity.Status;
import com.example.kanbam.entity.Task;
import com.example.kanbam.repository.TaskRepository;
import com.example.kanbam.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task();
        task.setId(1L);
        task.setName("TaskTest");
        task.setStatus(Status.IN_PROGRESS);
        task.setPriority(Priority.MEDIUM);
        task.setCreateDate(LocalDate.now());
    }


}
