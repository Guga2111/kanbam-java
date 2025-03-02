package com.example.kanbam.pojo;

import ch.qos.logback.core.status.StatusUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.example.kanbam.pojo.Status;
import com.example.kanbam.pojo.Priority;
import lombok.*;


import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be blank!")
    @NonNull
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Description can't be blank!")
    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @NonNull
    @Column(name = "createDate")
    private LocalDate createDate;

    @NonNull
    @Column(name = "conclusionDate")
    private LocalDate conclusionDate;

}
