package com.alfonso.taskTestMongo.config.utils;

import com.alfonso.taskTestMongo.infraestructure.documents.CounterDocument;
import com.alfonso.taskTestMongo.infraestructure.repository.CounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {


    private final CounterRepository counterRepository;

    @Transactional
    public long generateSequence(String seqName) {
        CounterDocument counter = this.counterRepository.findById(seqName)
                .orElseGet(() -> {
                    CounterDocument newCounter = CounterDocument.builder()
                            .id(seqName)
                            .sequence(0)
                            .build();
                    return this.counterRepository.save(newCounter);
                });

        long newValue = counter.getSequence() + 1;
        counter.setSequence(newValue);
        this.counterRepository.save(counter);
        return newValue;
    }
}
