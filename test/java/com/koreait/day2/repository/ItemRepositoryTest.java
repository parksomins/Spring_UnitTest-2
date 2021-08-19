package com.koreait.day2.repository;


import com.koreait.day2.Day2ApplicationTests;
import com.koreait.day2.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = Item.builder()
                .name("엘지노트북")
                .status("판매중")
                .title("lg_gram")
                .content("매우 가볍고 좋아요")
                .price(BigDecimal.valueOf(1200000))
                .regDate(LocalDateTime.now())
                .partnerId(3L)
                .build();
        Item newItem = itemRepository.save(item);
    }

    @Test
    public void read(){
        Optional<Item> item = itemRepository.findByNameAndPrice("삼성노트북", "1500000");
        if (item != null){
            System.out.println("데이터가 있습니다!");
        }else {
            System.out.println("데이터가 없습니다!");
        }
    }

    @Test
    public void update(){
        Optional<Item> item = itemRepository.findByName("현대트럭");
        item.ifPresent(selectItem -> {
            selectItem.setStatus("사용중");
            selectItem.setTitle("하얀트럭");
            selectItem.setContent("하얗고 빠르게 달려요!");
            selectItem.setPrice(BigDecimal.valueOf(7000000));
            selectItem.setUpdateDate(LocalDateTime.now());
            selectItem.setPartnerId(4L);
            itemRepository.save(selectItem);
        });
    }

    @Test
    public void delete(){
        Optional<Item> item = itemRepository.findByName("현대트럭");
        item.ifPresent(selectItem -> {
            itemRepository.delete(selectItem);
        });

        Optional<Item> delItem = itemRepository.findByName("현대트럭");
        if (delItem.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }
}
