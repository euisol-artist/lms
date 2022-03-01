package com.example.lms.admin.service;

import com.example.lms.admin.dto.CategoryDto;
import com.example.lms.admin.entity.Category;
import com.example.lms.admin.model.CategoryInput;
import com.example.lms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDto> list();

    /*카테고리 신규 추가*/
    boolean add(String categoryName);
    
    /*카테고리 수정*/
    boolean update(CategoryInput parameter);
    
    /*카테고리 삭제*/
    boolean del(long id);

}
