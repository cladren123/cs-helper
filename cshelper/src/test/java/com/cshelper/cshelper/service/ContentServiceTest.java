package com.cshelper.cshelper.service;


import com.cshelper.cshelper.dto.ContentDto;
import com.cshelper.cshelper.dto.ContentRegisterDto;
import com.cshelper.cshelper.entity.Content;
import com.cshelper.cshelper.mapper.ContentMapper;
import com.cshelper.cshelper.repository.ContentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

// https://dingdingmin-back-end-developer.tistory.com/entry/Springboot-Test-%EC%BD%94%EB%93%9C-%EC%9E%91%EC%84%B1-1

@ExtendWith(SpringExtension.class)
class ContentServiceTest {

  // Test 주체
  ContentService contentService;

  // Test 협력자
  // @MockBean은 가짜 객체를 만든다. 응답을 정의해야 한다.
  @MockBean
  ContentRepository contentRepository;

  @MockBean
  ContentMapper contentMapper;

  // Test를 실행하기 전마다 ContentService에 가짜 객체를 주입시킨다.
  @BeforeEach
  void setUp() {
    contentService = new ContentService(contentRepository);
  }

  @Test
  @DisplayName("내용 등록 성공")
  void registerContent() {
    // given
    ContentRegisterDto contentRegisterDto = ContentRegisterDto.builder()
            .categoryId(1).title("제목1").content("내용1").level(1)
            .build();

    Content content = new Content();
    content.setId(1);

    // 가짜 객체 응답 정의 (Repository를 의존하지 않음)
    when(contentRepository.save(any(Content.class))).thenReturn(content);

    // when
    Integer result = contentService.registerContent(contentRegisterDto);

    // then
    Integer expect = 1;
    assertEquals(result, expect);
    
  }



  @Test
  void findContent() {
    // given
    Integer id = 1;
    Content content = Content.builder()
            .id(1).title("제목1").content("내용1").level(1)
            .build();
    when(contentRepository.findById(id)).thenReturn(Optional.ofNullable(content));

    // when
    ContentDto result = contentService.findContent(id);

    // then
    assertEquals(result.getTitle(), "제목1");
    assertEquals(result.getContent(), "내용1");
    assertEquals(result.getLevel(), 1);

  }
}