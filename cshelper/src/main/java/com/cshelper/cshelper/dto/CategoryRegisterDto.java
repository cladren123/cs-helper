package com.cshelper.cshelper.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRegisterDto {

  @NotNull(message = "이름을 입력하셔야 합니다.")
  private String name;
  @NotNull(message = "설명을 입력하셔야 합니다.")
  private String description;

}
