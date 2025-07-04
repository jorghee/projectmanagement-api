package com.cyacompany.projectmanagement_api.service;

import com.cyacompany.projectmanagement_api.exception.BusinessLogicException;
import com.cyacompany.projectmanagement_api.exception.ResourceNotFoundException;
import com.cyacompany.projectmanagement_api.model.TaskType;
import com.cyacompany.projectmanagement_api.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskTypeService {

  private final TaskTypeRepository repository;

  public TaskTypeService(TaskTypeRepository repository) {
    this.repository = repository;
  }

  public List<TaskType> getAll() {
    return repository.findAllByOrderByIdAsc();
  }

  public TaskType getById(Integer id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TaskType not found with id: " + id));
  }

  @Transactional
  public TaskType create(TaskType taskType) {
    if (repository.existsById(taskType.getId())) {
      throw new BusinessLogicException("Cannot create TaskType. ID " + taskType.getId() + " already exists.");
    }
    return repository.save(taskType);
  }

  @Transactional
  public TaskType update(Integer id, TaskType taskTypeDetails) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("TaskType not found with id: " + id);
    }
    taskTypeDetails.setId(id);
    return repository.save(taskTypeDetails);
  }

  @Transactional
  public void deleteById(Integer id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("TaskType not found with id: " + id);
    }
    repository.deleteById(id);
  }
}
