package com.alfonso.taskTestMongo.config.utils;

import com.alfonso.taskTestMongo.infraestructure.documents.CounterDocument;
import com.alfonso.taskTestMongo.infraestructure.repository.CounterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SequenceGeneratorServiceTest {

    @Mock
    private CounterRepository counterRepository;

    @InjectMocks
    private SequenceGeneratorService sequenceGeneratorService;

    @Test
    @Transactional
    public void testGenerateSequenceWhenCounterExists() {
        String seqName = "testSeq";
        CounterDocument existingCounter = CounterDocument.builder()
                .id(seqName)
                .sequence(5)
                .build();

        when(counterRepository.findById(seqName)).thenReturn(Optional.of(existingCounter));
        long newSequence = sequenceGeneratorService.generateSequence(seqName);

        assertEquals(6, newSequence);
        verify(counterRepository).findById(seqName);
        verify(counterRepository).save(existingCounter);
    }

    @Test
    @Transactional
    public void testGenerateSequenceWhenCounterDoesNotExist() {
        String seqName = "newSeq";
        CounterDocument newCounter = CounterDocument.builder()
                .id(seqName)
                .sequence(0)
                .build();

        when(counterRepository.findById(seqName)).thenReturn(Optional.empty());
        when(counterRepository.save(newCounter)).thenReturn(newCounter);

        long newSequence = sequenceGeneratorService.generateSequence(seqName);

        assertEquals(1, newSequence);
        verify(counterRepository).findById(seqName);
        verify(counterRepository).save(newCounter);
        verify(counterRepository).save(newCounter);
    }

}