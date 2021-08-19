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
        name = "seq_item",
        sequenceName = "seq_item",
        initialValue = 1,
        allocationSize = 1
)
@Entity
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item")
    private Long id;
    private String name;
    private String status;
    private String title;
    private String content;
    private BigDecimal price;
    private LocalDateTime regDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;
    private Long partnerId;       // foreign key
}
