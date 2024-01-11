package com.cshelper.cshelper.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 사용자가 등록할 때 사용하는 DTO
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentRegisterDto {

  private Integer categoryId;
  private String title;
  private String content;
  private Integer level;


}
