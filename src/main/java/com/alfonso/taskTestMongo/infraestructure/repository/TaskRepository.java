package com.alfonso.taskTestMongo.infraestructure.repository;

import com.alfonso.taskTestMongo.infraestructure.documents.TaskDocument;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<TaskDocument, Integer> {
}
