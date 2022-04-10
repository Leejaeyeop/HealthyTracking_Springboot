package com.ljy.healthytracking.api;

import com.ljy.healthytracking.model.Marker;
import com.ljy.healthytracking.service.MarkerService;
import org.apache.tomcat.util.buf.Utf8Decoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/marker/v1")
public class MarkerApiController {

    private final MarkerService markerService;

    public MarkerApiController(MarkerService markerService){this.markerService = markerService;}

    @GetMapping("/name") // marker/v1/name?name=가제산
    public String findByNameApi(@RequestParam HashMap<String,Object> map) throws Exception
    {
        String keyword = (String) map.get("name");
        List<Marker> markers = markerService.findByName(keyword);

        return parseToJSON(markers).toString();
    }

    @GetMapping("/noted") // marker/v1/noted?
    public String findByNotedApi() throws Exception
    {
        List<Marker> markers = markerService.findByNoted();

        return parseToJSON(markers).toString();
    }

    @GetMapping("/region") // marker/v1/region?addr1=...
    public String findByRegionApi(@RequestParam HashMap<String,Object> map) throws Exception
    {
        String addr1 = (String) map.get("addr1");
        String addr2 = (String) map.get("addr2");
        String addr3 = (String) map.get("addr3");

        List<Marker> markers = markerService.findByRegion(addr1,addr2,addr3);

        return parseToJSON(markers).toString();
    }

    public JSONObject parseToJSON(List<Marker> markers) throws JSONException {

        JSONArray ja = new JSONArray(); //어레이
        for(Marker marker:markers)
        {
            JSONObject jo = new JSONObject(); //오브젝트
            jo.put("id",marker.getId());
            jo.put("name",marker.getName());
            jo.put("x",marker.getX());
            jo.put("y",marker.getY());
            jo.put("alt",marker.getAlt());
            ja.put(jo);
        }

        HashMap<String,Object> jsonMap = new HashMap<>();

        jsonMap.put("markers",ja); //다시 오브젝트

        JSONObject jsonObject = new JSONObject(jsonMap);

        return jsonObject;
    }
}
