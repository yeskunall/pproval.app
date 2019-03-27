package com.pproval.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class User extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @NotNull private String username;

  @NotNull private String password;
}
