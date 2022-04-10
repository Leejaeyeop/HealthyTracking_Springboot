package com.ljy.healthytracking.repository;

import com.ljy.healthytracking.model.Addr2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Addr2Repository extends JpaRepository<Addr2,Integer> {

    @Query(value ="select distinct addr2 from mountains m where m.addr1 = :addr1",nativeQuery = true)
    List<Addr2> getDistinctAddr2(@Param("addr1") String addr1);

}


