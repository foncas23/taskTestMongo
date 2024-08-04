package com.alfonso.taskTestMongo.domain.iservice;

import com.alfonso.taskTestMongo.infraestructure.documents.TaskDocument;


/**
 * The interface Create task service.
 */
public interface CreateTaskService {

    /**
     * Create task.
     *
     * @param task the task
     */
    void createTask(TaskDocument task);
}
