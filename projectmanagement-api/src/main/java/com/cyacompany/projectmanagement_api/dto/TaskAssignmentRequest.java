package com.cyacompany.projectmanagement_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskAssignmentRequest {
  @NotNull(message = "Project ID cannot be null")
  @Min(1)
  private Integer id; 

  @NotBlank
  @Size(max = 1)
  private String status;

  @NotNull
  private Integer employeeId;

  @NotNull
  private Integer taskId;
}
