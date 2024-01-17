package com.cshelper.cshelper.service;


import com.cshelper.cshelper.dto.CategoryRegisterDto;
import com.cshelper.cshelper.entity.Category;
import com.cshelper.cshelper.mapper.CategoryMapper;
import com.cshelper.cshelper.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  // 카테고리 등록
  public Integer registerCategory(CategoryRegisterDto dto) {
    Category category = CategoryMapper.registerDtoToCategory(dto);
    Category save = categoryRepository.save(category);
    return save.getId();
  }

}
