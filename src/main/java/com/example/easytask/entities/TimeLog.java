package com.example.easytask.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "time_logs")
public class TimeLog {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(nullable = false)
    private LocalDate logDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private Integer duration; // Duration in minutes

    // Constructors
    public TimeLog() {
    }

    public TimeLog(Task task, LocalDate logDate, LocalTime startTime, LocalTime endTime, Integer duration) {
        this.task = task;
        this.logDate = logDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

}
