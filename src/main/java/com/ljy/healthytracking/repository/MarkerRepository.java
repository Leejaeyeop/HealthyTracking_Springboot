package com.ljy.healthytracking.repository;


import com.ljy.healthytracking.model.Marker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkerRepository extends JpaRepository<Marker,Integer> {

    @Query(value ="select * from mountains m where m.name like %:name%",nativeQuery = true)
    List<Marker> findByName(@Param("name") String keyword);

    @Query(value ="select * from mountains m where m.addr1 = :addr1",nativeQuery = true)
    List<Marker> findByAddr1(@Param("addr1") String addr1);

    @Query(value ="select * from mountains m where m.addr1 = :addr1 and m.addr2 = :addr2",nativeQuery = true)
    List<Marker> findByAddr2(@Param("addr1") String addr1,@Param("addr2") String addr2);

    @Query(value ="select * from mountains m where m.addr1 = :addr1 and m.addr2 = :addr2 and m.addr3 = :addr3",nativeQuery = true)
    List<Marker> findByAddr3(@Param("addr1") String addr1,@Param("addr2") String addr2,@Param("addr3") String addr3);

    @Query(value = "select * from mountains m where m.noted= 'O'",nativeQuery = true)
    List<Marker> findByNoted();

    @Query(value = "select * from mountains m where m.x <= :Eboundary and m.x>= :Wboundary and m.y <= :Nboundary and m.y>= :Sboundary ",nativeQuery = true)
    List<Marker> findByDistance(@Param("Eboundary") Float east_boundary,@Param("Wboundary") Float west_boundary,@Param("Sboundary") Float southern_boundary,@Param("Nboundary") Float northern_boundary);
}
