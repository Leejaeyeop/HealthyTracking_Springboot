package com.ljy.healthytracking.api;

import com.ljy.healthytracking.model.Addr2;
import com.ljy.healthytracking.model.Addr3;
import com.ljy.healthytracking.repository.Addr2Repository;
import com.ljy.healthytracking.repository.Addr3Repository;
import net.bytebuddy.description.type.TypeList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value ="/addr/v1")
public class AddrApiController {
    private final Addr2Repository addr2Repository;
    private final Addr3Repository addr3Repository;
    public AddrApiController(Addr2Repository addr2Repository,Addr3Repository addr3Repository) {this.addr2Repository = addr2Repository; this.addr3Repository=addr3Repository;}

    @GetMapping("/addr") // marker/v1/addr?addr1=&addr2=
    public String addrApi(@RequestParam HashMap<String,Object> map) throws Exception
    {
        String addr1 = (String) map.get("addr1");
        String addr2 = (String) map.get("addr2");

        JSONArray ja = new JSONArray(); //어레이
        if(addr2.length()==0) //addr2 가져오기
        {
            List<Addr2> addrs = addr2Repository.getDistinctAddr2(addr1);
            for(Addr2 addr:addrs)
            {
                JSONObject jo = new JSONObject(); //오브젝트
                jo.put("addr",addr.getAddr2());
                ja.put(jo);
            }
        }
        else //addr3 가져오기
        {
            List<Addr3> addrs = addr3Repository.getDistinctAddr3(addr1,addr2);
            for(Addr3 addr:addrs)
            {
                JSONObject jo = new JSONObject(); //오브젝트
                jo.put("addr",addr.getAddr3());
                ja.put(jo);
            }
        }

        HashMap<String,Object> jsonMap = new HashMap<>();

        jsonMap.put("addrs",ja); //다시 오브젝트

        JSONObject jsonObject = new JSONObject(jsonMap);

        return jsonObject.toString();
    }


}
