package com.koreait.day2.repository;

import com.koreait.day2.Day2ApplicationTests;
import com.koreait.day2.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Part;
import java.time.LocalDateTime;
import java.util.Optional;

public class PartnerRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){

        Partner partner = Partner.builder()
                .name("현대")
                .status("사용중")
                .address("서울시 역삼구")
                .callCenter("070-2222-2222")
                .businessNumber("222-222-2222")
                .ceoName("이현대")
                .regDate(LocalDateTime.now())
                .categoryId(2L)
                .build();
        Partner newPartner = partnerRepository.save(partner);
    }

    @Test
    public void read(){
        Optional<Partner> partner = partnerRepository.findByNameAndStatus("현대", "사용종료");
        if(partner != null){
            System.out.println("데이터가 있습니다!");
        }else{
            System.out.println("데이터가 없습니다!");
        }
    }

    @Test
    public void update(){
        Optional<Partner> partner = partnerRepository.findById(1L);
        partner.ifPresent(selectPartner-> {
            selectPartner.setName("현대");
            selectPartner.setStatus("사용종료");
            selectPartner.setAddress("서울시 종로구");
            selectPartner.setCallCenter("070-2222-2222");
            selectPartner.setBusinessNumber("222-222-2222");
            selectPartner.setCeoName("이현대");
            selectPartner.setUpdateDate(LocalDateTime.now());
            partnerRepository.save(selectPartner);
        });
    }

    @Test
    public void delete(){
        Optional<Partner> partner = partnerRepository.findById(1L);
        partner.ifPresent(selectPartner-> {
            partnerRepository.delete(selectPartner);
        });

        Optional<Partner> delPartner = partnerRepository.findById(1L);
        if(delPartner.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }
}
