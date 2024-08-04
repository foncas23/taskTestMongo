package com.alfonso.taskTestMongo.infraestructure.mapper;


import com.alfonso.taskTestMongo.domain.entity.Task;
import com.alfonso.taskTestMongo.infraestructure.documents.TaskDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * The interface Task jpa mapper.
 */
@Mapper(componentModel = "spring")
public interface TaskRepositoryMapper {

    /**
     * The constant INSTANCE.
     */
    TaskRepositoryMapper INSTANCE = Mappers.getMapper(TaskRepositoryMapper.class);

    /**
     * To task list list.
     *
     * @param taskJpaList the task jpa list
     * @return the list
     */
    List<Task> toTaskList(List<TaskDocument> taskJpaList);

    /**
     * To task jpa task jpa.
     *
     * @param task the task
     * @return the task jpa
     */
    @Mapping(target = "id", ignore = true)
    TaskDocument toTaskJpa(Task task);
}
