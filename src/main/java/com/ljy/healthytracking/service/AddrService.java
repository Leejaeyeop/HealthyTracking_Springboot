package com.ljy.healthytracking.service;

import com.ljy.healthytracking.model.Addr2;
import com.ljy.healthytracking.model.Addr3;
import com.ljy.healthytracking.repository.Addr2Repository;
import com.ljy.healthytracking.repository.Addr3Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddrService {

    private final Addr2Repository addr2Repository;
    private final Addr3Repository addr3Repository;
    public AddrService(Addr2Repository addr2Repository,Addr3Repository addr3Repository) {this.addr2Repository = addr2Repository; this.addr3Repository=addr3Repository;}

}

