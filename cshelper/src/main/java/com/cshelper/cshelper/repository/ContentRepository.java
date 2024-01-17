package com.cshelper.cshelper.repository;


import com.cshelper.cshelper.dto.ContentDto;
import com.cshelper.cshelper.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

  // content id를 통해 검색, 결과값을 ContentDto로 반환
  @Query("SELECT new com.cshelper.cshelper.dto.ContentDto(cat.name, c.title, c.content, c.level)" +
          "FROM Content c JOIN Category cat ON c.categoryId = cat.id WHERE c.id = :contentId ")
  Optional<ContentDto> findContentDtoById(@Param("contentId") Integer contentId);


}
