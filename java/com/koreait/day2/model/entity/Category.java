package com.koreait.day2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq_cate",
        sequenceName = "seq_cate",
        initialValue = 1,
        allocationSize = 1
)
@Entity
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cate")
    private Long id;
    private String type;
    private String title;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;


}
