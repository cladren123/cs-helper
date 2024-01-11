package com.cshelper.cshelper.service;


import com.cshelper.cshelper.dto.ContentRegisterDto;
import com.cshelper.cshelper.entity.Content;
import com.cshelper.cshelper.mapper.ContentMapper;
import com.cshelper.cshelper.repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ContentService {

  private final ContentRepository contentRepository;

  // 내용 등록
  public void registerContent(ContentRegisterDto contentRegisterDto) {

    Content content = ContentMapper.RegisterDtoToContent(contentRegisterDto);
    contentRepository.save(content);

  }


}
