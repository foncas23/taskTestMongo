package com.alfonso.taskTestMongo.infraestructure.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "Counter")
public class CounterDocument {

    @Id
    private String id;
    private long sequence;
}
