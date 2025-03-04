package com.example.kanbam.pojo;

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
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Description can't be blank!")
    @NonNull
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private Priority priority;

    @Column(name = "createDate", updatable = false)
    private LocalDate createDate = LocalDate.now();

    @Column(name = "conclusionDate")
    private LocalDate conclusionDate;

}
