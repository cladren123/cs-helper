package com.cshelper.cshelper.mapper;

import com.cshelper.cshelper.dto.ContentDto;
import com.cshelper.cshelper.dto.ContentRegisterDto;
import com.cshelper.cshelper.entity.Content;

public class ContentMapper {

  // Register -> Content 변환
  public static Content RegisterDtoToContent(ContentRegisterDto contentRegisterDto) {
    return Content.builder()
            .title(contentRegisterDto.getTitle())
            .content(contentRegisterDto.getContent())
            .level(contentRegisterDto.getLevel())
            .build();
  }

  // Content -> ContentDto 변환
  public static ContentDto contentToContentDto(Content content) {
    return ContentDto.builder()
            .title(content.getTitle())
            .content(content.getTitle())
            .level(content.getLevel())
            .build();
  }

}
