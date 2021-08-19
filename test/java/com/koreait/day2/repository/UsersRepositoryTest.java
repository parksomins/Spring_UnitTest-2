package com.koreait.day2.repository;

import com.koreait.day2.Day2ApplicationTests;
import com.koreait.day2.model.entity.Users;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UsersRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private UsersRepository userRepository;

    @Test
    public void create() {
//        Users user = new Users();
//        user.setUserid("banana");
//        user.setUserpw("1212");
//        user.setHp("010-0000-0000");
//        user.setEmail("bana@bana.com");
//        user.setRegDate(LocalDateTime.now());
//        Users newUser = userRepository.save(user);

        Users user = Users.builder()
                .userid("somin")
                .userpw("1212")
                .hp("010-0202-0202")
                .email("somin@somin.com")
                .regDate(LocalDateTime.now())
                .build();
        Users newUser = userRepository.save(user);
        // Users newUser에 담는 이유는 다음에 쓸 때 편하게 쓰려고 (지금은 굳이 안써도됨 )
        // userRepository.save(user) : UsersRepository.java에 user를 저장한다는 뜻
    }

    @Test
    public void read(){
        //select * from users where userid=?
//        Optional<Users> user = userRepository.findByUserid("somin");
//        user.ifPresent(selectUser ->{
//            System.out.println("users : " + selectUser);
//            System.out.println("userid : " + selectUser.getUserid());
//            System.out.println("userpw : " + selectUser.getUserpw());
//            System.out.println("hp : " + selectUser.getHp());
//            System.out.println("email : " + selectUser.getEmail());
//        });

        //users : Users(id=5, userid=somin, userpw=1212, hp=010-0202-0202, email=somin@somin.com, regDate=2021-08-18T23:44:43, updateDate=null)
        //userid : somin
        //userpw : 1212
        //hp : 010-0202-0202
        //email : somin@somin.com

        Users user = userRepository.findFirstByHpOrderByIdDesc("010-0202-0202");
        if(user != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다!");
        }
        //데이터가 존재합니다!
    }

    @Test
    public void update(){
        Optional<Users> user = userRepository.findByUserid("somin");   //somin을 찾아라
        user.ifPresent(selectUser -> {       //selectUser는 이름 맘대로 지어줘도 됨
            selectUser.setEmail("somin@naver.com");
            selectUser.setHp("010-9999-9999");
            selectUser.setUpdateDate(LocalDateTime.now());  //업데이트된 시간 나오게함
            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete(){
        Optional<Users> user = userRepository.findByUserid("banana");

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<Users> deleteUser = userRepository.findByUserid("banana");
        if(deleteUser.isPresent()){    //isPresent는 true, false로 데이터가 삭제되었는지 아닌지 확인
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }

        //삭제성공!
    }
}
