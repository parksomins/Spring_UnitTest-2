package com.koreait.day2.repository;

import com.koreait.day2.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.servlet.http.Part;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Optional<Partner> findByNameAndStatus(String name, String status);
}
