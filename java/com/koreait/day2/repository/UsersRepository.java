package com.koreait.day2.repository;

import com.koreait.day2.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    //select * from users where userid=?  //String userid 대신에 안에 글을 쓰면 ?가 채워짐
    Optional<Users> findByUserid(String userid);

    //select * from users where userid=? and userpw=?
    Optional<Users> findByUseridAndUserpw(String userid, String userpw); //순서랑 이름 맞춰주기

    // select * from users where rownum <= 1 order by id desc
    Users findFirstByHpOrderByIdDesc(String hp);  //첫번째 휴대전화를 찾아줘 , id 내림차순 정렬로

}
