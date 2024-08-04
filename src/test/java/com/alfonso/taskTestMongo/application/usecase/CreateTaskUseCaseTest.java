package com.alfonso.taskTestMongo.application.usecase;


import com.alfonso.taskTestMongo.application.mapper.TaskResponseMapper;
import com.alfonso.taskTestMongo.domain.entity.Task;
import com.alfonso.taskTestMongo.domain.iservice.CreateTaskService;
import com.alfonso.taskTestMongo.infraestructure.documents.TaskDocument;
import com.napptilus.openapi.model.TaskDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateTaskUseCaseTest {

    @InjectMocks
    private CreateTaskUseCase createTaskUseCase;

    @Mock
    private CreateTaskService createTaskService;

    @Mock
    private TaskResponseMapper mapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeTest(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(1);
        taskDTO.setTitle("Task 1");
        taskDTO.setDescription("Description 1");
        taskDTO.setStartDate("2024-06-14");
        taskDTO.setPriority(1);

        TaskDocument taskDocument = TaskDocument.builder()
                .id(1L)
                .title("Task 1")
                .description("Description 1")
                .startDate("2020-06-14")
                .priority(1)
                .build();

        when(mapper.mapToTaskDocument(taskDTO)).thenReturn(taskDocument);
        createTaskUseCase.execute(taskDTO);
        verify(createTaskService).createTask(taskDocument);
    }


}