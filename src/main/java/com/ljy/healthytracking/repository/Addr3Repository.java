package com.ljy.healthytracking.repository;

import com.ljy.healthytracking.model.Addr3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Addr3Repository extends JpaRepository<Addr3,Integer> {

    @Query(value ="select distinct addr3 from mountains m where m.addr1 = :addr1 and m.addr2 =:addr2",nativeQuery = true)
    List<Addr3> getDistinctAddr3(@Param("addr1") String addr1, @Param("addr2") String addr2);
}
