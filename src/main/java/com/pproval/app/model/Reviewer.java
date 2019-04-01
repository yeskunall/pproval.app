package com.pproval.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reviewer extends User {
  private final String type = "Reviewer";

  @NotNull String username;
  @NotNull String password;
}
