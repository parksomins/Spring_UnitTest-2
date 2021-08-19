package com.koreait.day2.model.entity;

import jdk.jshell.execution.LoaderDelegate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


//상품구입시 구입한 상품 묶어주는 부분
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq_group",
        sequenceName = "seq_group",
        initialValue = 1,
        allocationSize = 1
)
@Entity
@Builder
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_group")
    private Long id;
    private String orderType;
    private String status;
    private String revAddress;
    private String revName;
    private String paymentType;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    private LocalDateTime regDate;
    private Long userid;
}
