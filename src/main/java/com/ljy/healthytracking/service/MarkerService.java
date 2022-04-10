package com.ljy.healthytracking.service;

import com.ljy.healthytracking.model.Marker;
import com.ljy.healthytracking.repository.MarkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerService {
    private final MarkerRepository markerRepository;
    public MarkerService(MarkerRepository markerRepository) {this.markerRepository = markerRepository;}

    public List<Marker> findByName(String keyword)
    {
        return markerRepository.findByName(keyword);
    }

    public List<Marker> findByRegion(String addr1,String addr2,String addr3)
    {
        if(addr2.equals("전체")) //주소 2 전체 -> 주소 3도 전체
        {
            return markerRepository.findByAddr1(addr1);
        }
        else if(addr3.equals("전체")) //주소3만 전체
        {
            return markerRepository.findByAddr2(addr1,addr2);
        }
        else //전체x
        {
            return markerRepository.findByAddr3(addr1,addr2,addr3);
        }
    }

    public List<Marker> findByNoted()
    {
        return markerRepository.findByNoted();
    }

}
