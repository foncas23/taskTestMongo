package com.alfonso.taskTestMongo.serviceimpl;


import com.alfonso.taskTestMongo.config.utils.SequenceGeneratorService;
import com.alfonso.taskTestMongo.domain.entity.Task;
import com.alfonso.taskTestMongo.infraestructure.documents.TaskDocument;
import com.alfonso.taskTestMongo.infraestructure.mapper.TaskRepositoryMapper;
import com.alfonso.taskTestMongo.infraestructure.repository.TaskRepository;
import com.alfonso.taskTestMongo.infraestructure.serviceimpl.CreateTaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateTaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private SequenceGeneratorService sequenceGeneratorService;

    @InjectMocks
    private CreateTaskServiceImpl createTaskServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTaskSuccess() {
        Task task = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2020-06-14")
                .priority(1)
                .build();

        when(sequenceGeneratorService.generateSequence(anyString())).thenReturn(1L);
        when(taskRepository.save(any())).thenReturn(TaskRepositoryMapper.INSTANCE.toTaskJpa(task));

        createTaskServiceImpl.createTask(TaskDocument.builder().build());
        verify(taskRepository, times(1)).save(any());
    }

    @Test
    public void testCreateTaskThrowsRuntimeException() {
        TaskDocument task = TaskDocument.builder()
                .id(1L)
                .title("Task 1")
                .description("Description 1")
                .startDate("2020-06-14")
                .priority(1)
                .build();

        when(sequenceGeneratorService.generateSequence(anyString())).thenReturn(1L);
        doThrow(new RuntimeException("Error al insertar en la BBDD")).when(taskRepository).save(any());

        assertThrows(RuntimeException.class, () -> createTaskServiceImpl.createTask(task));
        verify(taskRepository, times(1)).save(any());
    }

}