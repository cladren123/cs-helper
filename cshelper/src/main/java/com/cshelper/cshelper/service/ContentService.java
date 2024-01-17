package com.cshelper.cshelper.service;


import com.cshelper.cshelper.dto.ContentDto;
import com.cshelper.cshelper.dto.ContentRegisterDto;
import com.cshelper.cshelper.entity.Content;
import com.cshelper.cshelper.exception.ContentNotFoundException;
import com.cshelper.cshelper.mapper.ContentMapper;
import com.cshelper.cshelper.repository.ContentRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeTypeAnnos;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// import javax.validation.Valid;

@Service
@Transactional
@AllArgsConstructor
public class ContentService {

  private final ContentRepository contentRepository;

  // 내용 등록
  // @Valid를 사용해야 Dto에서 사용한 어노테이션을 적용할 수 있다.
  public Integer registerContent(ContentRegisterDto contentRegisterDto) {

    // contentRegisterDto에서 content 변환 매핑
    Content content = ContentMapper.RegisterDtoToContent(contentRegisterDto);

    // content의 DB 저장
    Content save = contentRepository.save(content);
    return save.getLevel();
  }
  
  // 내용 조회
  public ContentDto findContent(Integer id) {
    return contentRepository
            .findContentDtoById(id)
            .orElseThrow(() -> new ContentNotFoundException("없는 아이디 입니다."));
  }



}
