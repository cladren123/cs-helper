package com.cshelper.cshelper.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "content")
public class Content {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;


  @NotNull
  private String title;
  @NotNull
  private String content;
  @NotNull
  private Integer level;




}
