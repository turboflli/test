package com.teste.ubs.application.control;

import com.teste.ubs.application.model.UbsEntity;
import com.teste.ubs.application.repositories.UbsRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UbsRest {

    @Autowired
    private UbsRepository ubsRepository;

    @RequestMapping( value = "/find_ubs", method = RequestMethod.GET, produces = "application/json")
    public String getUbs(@RequestParam(required = true, value = "query") String coordenates,
                             @RequestParam(required = true) Integer page,
                             @RequestParam(required = false, defaultValue = "10", value = "per_page") Integer pageSize){

        String[] coordenatesSplited = coordenates.split(",");
        Double lon = Double.parseDouble(coordenatesSplited[1]);
        Double lat = Double.parseDouble(coordenatesSplited[0]);
        if (page < 1) {
            page = 1;
        }
        Pageable paging = PageRequest.of(page -1 , pageSize);
        Page<UbsEntity> response = ubsRepository.findByDistance(lon, lat, paging  );
        JSONObject json = this.toJson(response.getContent(),
                response.getPageable(), response.getTotalElements());
        return json.toString();
    }

    private JSONObject toJson(List content, Pageable pageable, long total){
        JSONObject json = new JSONObject();
        json.put("current_page", pageable.getPageNumber() +1);
        json.put("per_page", pageable.getPageSize());
        json.put("total_entries", total);
        JSONArray entries = new JSONArray();
        content.forEach( ubsEntity -> {
            entries.put(new JSONObject(ubsEntity.toString()));
			});
        json.put("entries", new JSONArray(content.toString()));
        return json;
    }

}
