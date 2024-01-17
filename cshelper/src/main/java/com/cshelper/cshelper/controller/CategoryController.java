package com.cshelper.cshelper.controller;


import com.cshelper.cshelper.dto.CategoryRegisterDto;
import com.cshelper.cshelper.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;

  @PostMapping("")
  public ResponseEntity<?> registerCategory(@Valid @RequestBody CategoryRegisterDto dto) {
    categoryService.registerCategory(dto);
    return ResponseEntity.ok("ok");
  }


}
