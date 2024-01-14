package com.cshelper.cshelper.controller;


import com.cshelper.cshelper.dto.ContentDto;
import com.cshelper.cshelper.dto.ContentRegisterDto;
import com.cshelper.cshelper.service.ContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController {

  private final ContentService contentService;

  // 등록
  @PostMapping("register")
  public ResponseEntity<?> registerContent(@Valid @RequestBody ContentRegisterDto contentRegisterDto) {
    contentService.registerContent(contentRegisterDto);
    return ResponseEntity.ok("ok");
  }

  // 조회
  @GetMapping("find")
  public ResponseEntity<?> findContent(@RequestParam Integer id) {
    ContentDto contentDto = contentService.findContent(id);
    return ResponseEntity.ok(contentDto);
  }



}
