package com.koreait.day2.repository;

import com.koreait.day2.Day2ApplicationTests;
import com.koreait.day2.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = Category.builder()
                .type("가전")
                .title("냉장고")
                .regDate(LocalDateTime.now())
                .build();
        Category newCategory = categoryRepository.save(category);
    }

    @Test
    public void read(){
       Category category = categoryRepository.findLastByTypeOrderByRegDateDesc("자동차");
       if (category != null){
           System.out.println("데이터가 있습니다!");
       }else{
           System.out.println("데이터가 없습니다!");
       }
    }

    @Test
    public void update(){
        Optional<Category> category = categoryRepository.findById(2L);
        category.ifPresent(selectCategory -> {
            selectCategory.setType("가전");
            selectCategory.setTitle("애플 맥북");
            selectCategory.setUpdateDate(LocalDateTime.now());
            categoryRepository.save(selectCategory);
        });
    }

    @Test
    public void delete(){
        Optional<Category> category = categoryRepository.findById(6L);
        category.ifPresent(selectCategory->{
            categoryRepository.delete(selectCategory);
        });
        Optional<Category> delCategory = categoryRepository.findById(6L);
        if (delCategory.isPresent()){
            System.out.println("삭제 실패!");
        }else{
            System.out.println("삭제 성공!");
        }
    }

}
