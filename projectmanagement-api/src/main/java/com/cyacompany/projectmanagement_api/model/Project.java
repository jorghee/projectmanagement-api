package com.cyacompany.projectmanagement_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "G1M_PROYECTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

  @Id
  @Column(name = "ProCod")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ProCliCod", nullable = false)
  private Client client;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ProEstProCod", nullable = false)
  private ProjectStatus projectStatus;

  @Column(name = "ProNom", length = 100, nullable = false)
  private String name;

  @Column(name = "ProFecIni", nullable = false)
  private LocalDate startDate;

  @Column(name = "ProFecFin")
  private LocalDate endDate;

  @Column(name = "ProMonEst", precision = 9, scale = 2)
  private BigDecimal estimatedAmount;

  @Column(name = "ProMonReal", precision = 9, scale = 2)
  private BigDecimal realAmount;

  @Column(name = "ProEstReg", length = 1, nullable = false)
  private String status;
}
