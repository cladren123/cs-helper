package com.cshelper.cshelper.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;

/**
 * 사용자가 등록할 때 사용하는 DTO
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentRegisterDto {

  @NotNull(message = "카테고리를 선택하셔야 합니다. ")
  private Integer categoryId;
  @NotNull(message = "제목을 입력하셔야 합니다.")
  private String title;
  @NotNull(message = "내용을 입력하셔야 합니다.")
  private String content;
  @NotNull(message = "레벨을 설정하셔야 합니다.")
  private Integer level;


}
