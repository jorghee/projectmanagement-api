package com.cyacompany.projectmanagement_api.service;

import com.cyacompany.projectmanagement_api.exception.BusinessLogicException;
import com.cyacompany.projectmanagement_api.exception.ResourceNotFoundException;
import com.cyacompany.projectmanagement_api.model.TimeFactor;
import com.cyacompany.projectmanagement_api.repository.TimeFactorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class TimeFactorService {

  private final TimeFactorRepository repository;

  public TimeFactorService(TimeFactorRepository repository) {
    this.repository = repository;
  }

  public List<TimeFactor> getAll() {
    return repository.findAllByOrderByIdAsc();
  }

  public TimeFactor getById(Integer id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TimeFactor not found with id: " + id));
  }

  @Transactional
  public TimeFactor create(TimeFactor timeFactor) {
    if (repository.existsById(timeFactor.getId())) {
      throw new BusinessLogicException("Cannot create TimeFactor. ID " + timeFactor.getId() + " already exists.");
    }
    return repository.save(timeFactor);
  }

  @Transactional
  public TimeFactor update(Integer id, TimeFactor timeFactorDetails) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("TimeFactor not found with id: " + id);
    }
    timeFactorDetails.setId(id);
    return repository.save(timeFactorDetails);
  }

  @Transactional
  public void deleteById(Integer id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("TimeFactor not found with id: " + id);
    }
    repository.deleteById(id);
  }
}
