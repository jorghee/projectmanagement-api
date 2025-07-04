package com.cyacompany.projectmanagement_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "G4M_FACTOR_UTILIDAD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtilityFactor {

  @Id
  @Column(name = "FacUtiCod")
  private Integer id;

  @Column(name = "FacUtiDes", length = 50, nullable = false)
  private String description;

  @Column(name = "FacUtiVal", precision = 4, scale = 2)
  private BigDecimal value;

  @Column(name = "FacEstReg", length = 1, nullable = false)
  private String status;
}
