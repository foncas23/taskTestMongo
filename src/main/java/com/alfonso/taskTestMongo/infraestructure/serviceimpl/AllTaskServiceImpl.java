package com.alfonso.taskTestMongo.infraestructure.serviceimpl;


import com.alfonso.taskTestMongo.domain.entity.Task;
import com.alfonso.taskTestMongo.domain.iservice.AllTaskService;
import com.alfonso.taskTestMongo.infraestructure.mapper.TaskRepositoryMapper;
import com.alfonso.taskTestMongo.infraestructure.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type All task service.
 */
@Service
@RequiredArgsConstructor
public class AllTaskServiceImpl implements AllTaskService {

    /**
     * The Task jpa repository.
     */
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getListTask() {
        return TaskRepositoryMapper.INSTANCE.toTaskList(this.taskRepository.findAll());
    }
}
