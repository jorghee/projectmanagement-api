package com.cyacompany.projectmanagement_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "G2M_CARGO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {

  @Id
  @Column(name = "CarCod")
  private Integer id;

  @Column(name = "CarDes", length = 50, nullable = false)
  private String description;

  @Column(name = "CarCosHor", precision = 6, scale = 2)
  private BigDecimal costPerHour;

  @Column(name = "CarEstReg", length = 1, nullable = false)
  private String status;
}
