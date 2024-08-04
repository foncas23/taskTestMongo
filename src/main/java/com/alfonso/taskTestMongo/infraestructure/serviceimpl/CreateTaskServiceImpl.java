package com.alfonso.taskTestMongo.infraestructure.serviceimpl;

import com.alfonso.taskTestMongo.domain.iservice.CreateTaskService;
import com.alfonso.taskTestMongo.infraestructure.documents.TaskDocument;
import com.alfonso.taskTestMongo.infraestructure.repository.TaskRepository;
import com.alfonso.taskTestMongo.config.utils.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Create task service.
 */
@Service
@RequiredArgsConstructor
public class CreateTaskServiceImpl implements CreateTaskService {

    /**
     * The Task jpa repository.
     */
    private final TaskRepository taskJpaRepository;

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void createTask(TaskDocument task) {
        try {
            task.setId(this.sequenceGeneratorService.generateSequence("tasks"));
            this.taskJpaRepository.save(task);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar en la BBDD");
        }
    }
}
