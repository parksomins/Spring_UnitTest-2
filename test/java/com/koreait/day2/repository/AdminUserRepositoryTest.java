package com.koreait.day2.repository;

import com.koreait.day2.Day2ApplicationTests;
import com.koreait.day2.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends Day2ApplicationTests {

    //Autowired는 spring 기능
    @Autowired  //AdminUserRepository를 전역변수로 가져다 쓸 수 있게 만들어줌
    private AdminUserRepository adminUserRepository;

    @Test
    public void create() {
        AdminUser adminUser = AdminUser.builder()
                .userid("admin")
                .userpw("1234")
                .name("관리자")
                .status("use")
                .regDate(LocalDateTime.now())
                .build();
        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        //AdminUser newAdminUser에 담는 이유는 다음에 쓸 때 편하게 쓰려고 (지금은 굳이 안써도됨 )
        //adminUserRepository.save(adminUser) : adminUserRepository.java에 adminUser를 저장한다는 뜻


    }
}
