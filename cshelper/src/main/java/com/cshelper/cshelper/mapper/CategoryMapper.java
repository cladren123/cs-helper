package com.cshelper.cshelper.mapper;

import com.cshelper.cshelper.dto.CategoryRegisterDto;
import com.cshelper.cshelper.entity.Category;

public class CategoryMapper {

  // Register Dto -> Category로 반환
  public static Category RegisterDtoToCategory(CategoryRegisterDto dto) {
    return Category.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }
}
