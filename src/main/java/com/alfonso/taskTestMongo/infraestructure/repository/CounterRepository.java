package com.alfonso.taskTestMongo.infraestructure.repository;

import com.alfonso.taskTestMongo.infraestructure.documents.CounterDocument;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface CounterRepository extends MongoRepository<CounterDocument, String> {
}
