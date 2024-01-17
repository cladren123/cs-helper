package com.cshelper.cshelper.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// import javax.validation.constraints.NotNull;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "content")
public class Content {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  private Integer categoryId;
  @NotNull
  private String title;
  @NotNull
  private String content;
  @NotNull
  private Integer level;




}
