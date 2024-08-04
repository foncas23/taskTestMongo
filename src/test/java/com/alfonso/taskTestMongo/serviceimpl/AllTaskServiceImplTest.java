package com.alfonso.taskTestMongo.serviceimpl;


import com.alfonso.taskTestMongo.domain.entity.Task;
import com.alfonso.taskTestMongo.infraestructure.documents.TaskDocument;
import com.alfonso.taskTestMongo.infraestructure.mapper.TaskRepositoryMapper;
import com.alfonso.taskTestMongo.infraestructure.repository.TaskRepository;
import com.alfonso.taskTestMongo.infraestructure.serviceimpl.AllTaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AllTaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskRepositoryMapper mapper;

    @InjectMocks
    private AllTaskServiceImpl allTaskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetListTask() {
        TaskDocument taskEntity1 = TaskDocument.builder()
                .id(1L)
                .title("Task 1")
                .description("Description 1")
                .startDate("2023-12-09")
                .priority(1)
                .build();

        TaskDocument taskEntity2 = TaskDocument.builder()
                .id(1L)
                .title("Task 2")
                .description("Description 2")
                .startDate("2023-12-09")
                .priority(1)
                .build();

        List<TaskDocument> taskEntities = Arrays.asList(taskEntity1, taskEntity2);

        Task task1 = Task.builder()
                .id(1)
                .title("Task 1")
                .description("Description 1")
                .startDate("2023-01-01")
                .priority(1)
                .build();

        Task task2 = Task.builder()
                .id(2)
                .title("Task 2")
                .description("Description 2")
                .startDate("2023-01-02")
                .priority(2)
                .build();

        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskRepository.findAll()).thenReturn(taskEntities);
        when(mapper.toTaskList(taskEntities)).thenReturn(tasks);

        List<Task> result = allTaskService.getListTask();

        assertEquals(tasks.size(), result.size());
        verify(taskRepository, times(1)).findAll();
    }

}