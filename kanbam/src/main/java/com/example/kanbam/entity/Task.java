package com.example.kanbam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max = 30, message = "Your name must be less than 30 characters")
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;
}
