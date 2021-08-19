package com.koreait.day2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

// rombok에서 지원하는 어노테이션
@Data                //자동으로 (내부적으로) getter/setter를 만들어줌
@AllArgsConstructor  //내부적으로 모든 매개변수를 지원하는 생성자를 생성
@NoArgsConstructor//매개변수가 없는 생성자를 생성
@Entity   // 오라클 admin_user 테이블과 연동시켜줌 (_제외하고 이름이 같아야함)
@SequenceGenerator(  // oracle에서 만든 sequence 사용하기 위한 구문
        name="seq_users",  //java에서 사용하는 시퀀스이름으로 oracle 시퀀스이름과 달라도 됨
        sequenceName = "seq_users", // oracle에서 만든 시퀀스 이름
        initialValue = 1,
        allocationSize = 1
)
@Builder
public class AdminUser {
    @Id  //identity의 약자 , 같은 값이 못들어가게 하겟다!, 기본 키 매핑
    // 어노테이션 바로 밑에 있는 구문에만 적용하므로 privare Long id; 에 적용됨
    //generator = 에는 sequenceName 값을 넣음
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")  //값 설정
    private Long id;        //일렬번호
    private String userid;  //아이디
    private String userpw;  //비밀번호
    private String name;    //이름
    private String status;  //상태
    private LocalDateTime lastLoginAt; //마지막 접속시간
    private LocalDateTime regDate;     //가입날짜

}
