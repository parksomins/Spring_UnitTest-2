package com.koreait.day2.repository;

import com.koreait.day2.Day2ApplicationTests;
import com.koreait.day2.model.entity.OrderDetail;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = OrderDetail.builder()
                .status("결제완료")
                .quantity(1)
                .totalPrice(BigDecimal.valueOf(1200000))
                .regDate(LocalDateTime.now())
                .itemId(3L)
                .orderGroupId(2L)
                .build();
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
    }

    @Test
    public void read(){
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectOrderDetail->{
            System.out.println("status : " + selectOrderDetail.getStatus());
            System.out.println("quantity : " + selectOrderDetail.getQuantity());
            System.out.println("totalPrice : " + selectOrderDetail.getTotalPrice());
            System.out.println("regDate : " + selectOrderDetail.getRegDate());
            System.out.println("itemId : " + selectOrderDetail.getItemId());
            System.out.println("orderGroupId : " + selectOrderDetail.getOrderGroupId());
        });
    }

    @Test
    public void update() {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectOrderDetail->{
            selectOrderDetail.setStatus("미결제");
            selectOrderDetail.setQuantity(2);
            selectOrderDetail.setTotalPrice(BigDecimal.valueOf(1500000));
            selectOrderDetail.setItemId(1L);
            selectOrderDetail.setOrderGroupId(2L);
        });
    }

    public void delete(){
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectOrderDetail->{
            orderDetailRepository.delete(selectOrderDetail);
        });

        Optional<OrderDetail> delOrderDetail = orderDetailRepository.findById(1L);
        if (delOrderDetail.isPresent()){
            System.out.println("삭제 실패!");
        }else{
            System.out.println("삭제 성공!");
        }
    }

}
