package com.koreait.day2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq_detail",
        sequenceName = "seq_detail",
        initialValue = 1,
        allocationSize = 1
)
@Entity
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detail")
    private Long id;
    private LocalDateTime arrivalDate;  //도착시간
    private String status;  //물품 상태(판매중)
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime regDate;
    private Long itemId;
    private Long orderGroupId;

}
