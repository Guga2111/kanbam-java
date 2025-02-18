package com.example.kanbam;

import com.example.kanbam.pojo.Priority;
import com.example.kanbam.pojo.Status;
import com.example.kanbam.pojo.Task;
import com.example.kanbam.repository.KanbamRepository;
import com.example.kanbam.service.KanbamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KanbamServiceTest {

    @Mock
    private KanbamRepository kanbamRepository;

    @InjectMocks
    private KanbamService kanbamService;

    @Test
    public void getTasksFromRepoTest() {
        when(kanbamRepository.getTasks()).thenReturn(Arrays.asList(
                new Task("Estudar Java", "preciso estudar java", Status.TODO, Priority.HIGH, LocalDate.now()),
                new Task("Estudar Testes", "unit testing", Status.IN_PROGRESS, Priority.HIGH, LocalDate.now())
        ));

        List<Task> result = kanbamService.getTasks();

        assertEquals("Estudar Java", result.get(0).getName());
        assertEquals("Estudar Testes", result.get(1).getName());
        assertEquals(Status.TODO, result.get(0).getStatus());
        assertEquals(LocalDate.now(), result.get(0).getCreateDate());
    }
}
