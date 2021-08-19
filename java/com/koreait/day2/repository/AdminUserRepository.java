package com.koreait.day2.repository;

import com.koreait.day2.model.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
// 어드민유저가 엔티티가 되고 자료형은 롱형!

}
