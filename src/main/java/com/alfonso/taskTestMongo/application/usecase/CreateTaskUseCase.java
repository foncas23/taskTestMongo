package com.alfonso.taskTestMongo.application.usecase;


import com.alfonso.taskTestMongo.application.mapper.TaskResponseMapper;
import com.alfonso.taskTestMongo.config.annotation.UseCase;
import com.alfonso.taskTestMongo.domain.iservice.CreateTaskService;
import com.napptilus.openapi.model.TaskDTO;
import lombok.RequiredArgsConstructor;

/**
 * The type Create task use case.
 */
@UseCase
@RequiredArgsConstructor
public class CreateTaskUseCase {

    /**
     * The Create task service.
     */
    private final CreateTaskService createTaskService;

    /**
     * The Mapper.
     */
    private final TaskResponseMapper mapper;

    /**
     * Execute.
     *
     * @param taskDTO the task dto
     */
    public void execute(TaskDTO taskDTO){
        this.createTaskService.createTask(this.mapper.mapToTaskDocument(taskDTO));
    }
}
