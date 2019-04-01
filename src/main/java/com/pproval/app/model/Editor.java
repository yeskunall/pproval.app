package com.pproval.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Editor extends User {
  private final String type = "Editor";

  @NotNull String username;
  @NotNull String password;
}
