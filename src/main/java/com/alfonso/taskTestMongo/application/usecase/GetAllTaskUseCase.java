package com.alfonso.taskTestMongo.application.usecase;


import com.alfonso.taskTestMongo.application.mapper.TaskResponseMapper;
import com.alfonso.taskTestMongo.config.annotation.UseCase;
import com.alfonso.taskTestMongo.domain.iservice.AllTaskService;
import com.napptilus.openapi.model.TaskDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * The type Get all task use case.
 */
@UseCase
@RequiredArgsConstructor
public class GetAllTaskUseCase {

    /**
     * The All task service.
     */
    private final AllTaskService allTaskService;

    /**
     * The Mapper.
     */
    private final TaskResponseMapper mapper;

    /**
     * Execute list.
     *
     * @return the list
     */
    public List<TaskDTO> execute(){
        return this.mapper.maptoListTaskDto(this.allTaskService.getListTask());
    }


}
