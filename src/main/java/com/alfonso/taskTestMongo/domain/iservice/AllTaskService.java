package com.alfonso.taskTestMongo.domain.iservice;


import com.alfonso.taskTestMongo.domain.entity.Task;

import java.util.List;

/**
 * The interface All task service.
 */
public interface AllTaskService {

    /**
     * Gets list task.
     *
     * @return the list task
     */
    List<Task> getListTask();
}
