package com.alfonso.taskTestMongo.infraestructure.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@Document(collection = "Task")
public class TaskDocument {

    @Id
    private Long id;

    private String title;

    private String description;

    private String startDate;

    private int priority;


}
