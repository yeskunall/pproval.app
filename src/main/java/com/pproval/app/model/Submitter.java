package com.pproval.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Submitter extends User {
  private final String type = "Submitter";

  @NotNull String username;
  @NotNull String password;
}
