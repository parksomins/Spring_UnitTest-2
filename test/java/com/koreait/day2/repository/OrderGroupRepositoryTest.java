package com.koreait.day2.repository;

import com.koreait.day2.Day2ApplicationTests;
import com.koreait.day2.model.entity.OrderGroup;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderGroupRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        OrderGroup orderGroup = OrderGroup.builder()
                .orderType("ALL")  //한번에 배송
                .status("결제완료")
                .revAddress("서울시 서초구 양재동")
                .revName("김사과")  //받는 사람
                .paymentType("카드")  //결제방식
                .totalPrice(BigDecimal.valueOf(2700000))  //총 결제금액
                .totalQuantity(2)  //상품 수
                .regDate(LocalDateTime.now())
                .orderAt(LocalDateTime.now())
                .userid(22L)   //users 테이블 번호와 연결  22번은 banana
                .build();
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
    }

    @Test
    public void read(){
        Optional<OrderGroup> orderGroup = orderGroupRepository.findByRevName("김사과");
        if (orderGroup != null){
            System.out.println("데이터가 있습니다");
        }else{
            System.out.println("데이터가 없습니다");
        }
    }

    @Test
    public void update(){
        Optional<OrderGroup> orderGroup = orderGroupRepository.findByRevName("김사과");
        orderGroup.ifPresent(selectOrderGroup->{
            selectOrderGroup.setStatus("결제완료");
            selectOrderGroup.setRevAddress("평택시 소사동");
            selectOrderGroup.setRevName("반하나");
            selectOrderGroup.setPaymentType("현금");
            selectOrderGroup.setTotalPrice(BigDecimal.valueOf(2700000));
            selectOrderGroup.setTotalQuantity(2);
            selectOrderGroup.setOrderAt(LocalDateTime.now());
            selectOrderGroup.setUserid(22L);
            orderGroupRepository.save(selectOrderGroup);
        });
    }

    @Test
    public void delete(){
        Optional<OrderGroup> orderGroup = orderGroupRepository.findByRevName("반하나");
        orderGroup.ifPresent(selectOrderGroup->{
            orderGroupRepository.delete(selectOrderGroup);
        });

        Optional<OrderGroup> delOrderGroup = orderGroupRepository.findByRevName("반하나");
        if (delOrderGroup.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }
}
