package com.cshelper.cshelper.controller;


import com.cshelper.cshelper.dto.ContentRegisterDto;
import com.cshelper.cshelper.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController {

  private final ContentService contentService;

  // 등록
  @PostMapping("register")
  public ResponseEntity<?> registerContent(@RequestBody ContentRegisterDto contentRegisterDto) {
    contentService.registerContent(contentRegisterDto);
    return ResponseEntity.ok("ok");
  }



}
